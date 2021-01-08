/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mobilepoll.utils.model;

/**
 * Provê a estrutura de dados necessária para armazenar informações de servidor SMTP
 * @author anselmoberriel
 */
public class SmtpServer
{
    /** Construtor */
    public SmtpServer() { }
    
    /** URL para servidor SMTP */
    String host;
    /** GET para a url do servidor SMTP */
    public String getHost() { return host; }
    /** SET para a url do servidor SMTP */
    public void setHost(String host) { this.host = host; }
    
    /** Número da porta do serviço SMTP no host fornecido */
    String port;
    /** GET para a porta do servidor SMTP no host fornecido */
    public String getPort() { return port; }
    /** SET para a porta do servidor SMTP no host fornecido */
    public void setPort(String port) { this.port = port; }
    
    /** Login no servidor SMTP */
    String userName;
    /** GET para o login no servidor SMTP */
    public String getUserName() { return userName; }
    /** SET para o login no servidor SMTP */
    public void setUserName(String userName) { this.userName = userName; }
    
    /** Senha para autenticação no servidor SMTP */
    String password;
    /** GET para a senha para a autenticação no servidor SMTP */
    public String getPassword() { return password; }
    /** SET para a senha para a autenticação no servidor SMTP */
    public void setPassword(String password) { this.password = password; }
    
    boolean sslEnabled;
    public boolean isSslEnabled() { return sslEnabled; }
    public void setSslEnabled(boolean enabled) { this.sslEnabled = enabled; }
    public String getSslEnabledStr()
    {
        if(sslEnabled)
        {
            return "true";
        }
        
        return "false";
    }
    
    /** Validação dos dados do servidor SMTP para envio de mensagem de e-mail */
    public boolean isValid()
    {
        return host.isEmpty() || host == null ||
               port.isEmpty() || port == null ||
               userName.isEmpty() || userName == null ||
               password.isEmpty() || password == null;
    }
}