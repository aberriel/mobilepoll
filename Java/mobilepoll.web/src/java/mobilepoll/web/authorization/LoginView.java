/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobilepoll.web.authorization;

import javax.faces.bean.*;
import mobilepoll.database.repository.model.User;

/**
 *
 * @author alira
 */
@ManagedBean
@RequestScoped
public class LoginView
{
    /** Construtor */
    public LoginView() { }
    
    /** Login do usuário fornecido no formulário de login */
    private String login;
    /** GET para o login do usuário fornecido no formulário de login */
    public String getLogin() { return login; }
    /** SET para o login do usuário, fornecido no formulário de login */
    public void setLogin(String login) { this.login = login; }
    
    private String password;
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
