/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mobilepoll.utils.model;

/**
 * Provê a estrutura de dados necessária para armazenar a mensagem de e-mail a ser enviada
 * @author anselmoberriel
 */
public class EmailMessage
{
    /** Construtor */
    public EmailMessage() { }
    
    /** Remetente da mensagem de e-mail */
    String from;
    /** GET para o remetente da mensagem de e-mail */
    public String getFrom() { return from; }
    /** SET para o remetente da mensagem de e-mail */
    public void setFrom(String from) { this.from = from; }
    
    /** Destinatário da mensagem de e-mail */
    String to;
    /** GET para o destinatário da mensagem de e-mail */
    public String getTo() { return to; }
    /** SET para o destinatário da mensagem de e-mail */
    public void setTo(String to) { this.to = to; }
    
    /** Assunto da mensagem */
    String subject;
    /** GET para o assunto da mensagem */
    public String getSubject() { return subject; }
    /** SET para o assunto da mensagem */
    public void setSubject(String subject) { this.subject = subject; }
    
    /** Mensagem propriamente dita */
    String message;
    /** GET para a mensagem propriamente dita */
    public String getMessaqe() { return message; }
    /** SET para a mensagem propriamente dita */
    public void setMessage(String message) { this.message = message; }
    
    /** Flag indicador de mensagem no formato html */
    boolean htmlMessage;
    /** GET para o flag indicador de formato HTML */
    public boolean isHtmlMessage() { return htmlMessage; }
    /** SET para o flag indicador de formato HTML */
    public void setHtmlMessage(boolean isHtml) { this.htmlMessage = isHtml; }
    
    /** Validação da mensagem de e-mail a ser enviada. */
    public boolean isValid()
    {
        return from.isEmpty() || from == null ||
               to.isEmpty() || to == null ||
               subject.isEmpty() || subject == null ||
               message.isEmpty() || message == null;
    }
}