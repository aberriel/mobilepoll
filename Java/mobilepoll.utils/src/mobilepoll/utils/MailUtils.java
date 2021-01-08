/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobilepoll.utils;

import mobilepoll.utils.model.EmailMessage;
import mobilepoll.utils.model.SmtpServer;
import java.lang.*;
import java.util.Date;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Métodos utilitários relacionados a endereços de e-mail
 * @author alira
 */
public class MailUtils
{
    /** Construtor */
    public MailUtils() { }
    
    /**
     * Valida endereço de e-mail
     * @param emailAddress Endereço de e-mail a ser verificado
     * @return Flag indicando se e-mail fornecido possui formato válido
     */
    public static boolean isValidEmail(String emailAddress)
    {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(emailAddress);
        return m.matches();
    }
    
    /**
     * Envia mensagem de e-mail
     * @param serverDetails Dados do servidor SMTP a ser utilizado para o envio
     * @param message Dados da mensagem a ser enviada
     * @throws IllegalArgumentException Exceção por dados inválidos para envio
     *         da mensagem ou conexão com servidor SMTP.
     * 
     * @throws MessagingException Erro no envio da mensagem pela rede
     */
    public static void sendMail(SmtpServer serverDetails, EmailMessage message) throws Exception
    {
        if(!serverDetails.isValid() || !message.isValid())
        {
            throw new IllegalArgumentException("Dados do servidor SMTP ou da mensagem são inválidos.");
        }
        
        // Definindo os parâmetros da conexão com o servidor de envio
        Properties mailProperties = System.getProperties();
        mailProperties.setProperty("mail.smtp.host", serverDetails.getHost());
        mailProperties.setProperty("mail.smtp.port", serverDetails.getPort());
        mailProperties.setProperty("mail.smtp.socketFactory.port", serverDetails.getPort());
        mailProperties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        mailProperties.setProperty("mail.smtp.auth", "true");
        
        Session session = Session.getDefaultInstance(mailProperties,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication()
                    {
                        return new PasswordAuthentication(serverDetails.getUserName(), serverDetails.getPassword());
                    }
                });
        
        // Ativa o debug para a sessão
        session.setDebug(true);
        
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(message.getFrom()));
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(message.getTo()));
        msg.setSubject(message.getSubject());
        msg.setSentDate(new Date());
            
        if(message.isHtmlMessage())
        {
            msg.setContent(message.getMessaqe(), "text/html");
        }
        else
        {
            msg.setText(message.getMessaqe());
        }
        
        // Transmotindo a mensagem
        Transport.send(msg);
    }
}