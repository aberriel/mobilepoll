/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobilepoll.core.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Dados de usuário
 * @author alira
 */
public class UserUO
{
    /** Construtor */
    public UserUO() { }
    
    /** Login do usuário */
    String login;
    /** GET para o login do usuário */
    public String getLogin() { return login; }
    /** SET para o login do usuário */
    public void setLogin(String login) { this.login = login; }
    
    /** Senha do usuário para autenticação no sistema */
    String password;
    /** GET para a senha do usuário */
    public String getPassword() { return password; }
    /** SET para a senha do usuário */
    public void setPassword(String password) { this.password = password; }
    
    /** Confirmação da senha (repetição desta) */
    String passwordConfirm;
    /** GET para a confirmação da senha */
    public String getPasswordConfirm() { return this.passwordConfirm; }
    /** SET para a confirmação da senha */
    public void setPasswordConfirm(String passwordConfirm) { this.passwordConfirm = passwordConfirm; }
    
    /** Pergunta secreta */
    String secretQuestion;
    /** GET para a pergunta secreta */
    public String getSecretQuestion() { return secretQuestion; }
    /** SET para a pergunta secreta */
    public void setSecretQuestion(String question) { this.secretQuestion = question; }
    
    /** Resposta à pergunta secreta */
    String secretAnswer;
    /** GET para a resposta à pergunta secreta */
    public String getSecretAnswer() { return secretAnswer; }
    /** SET para a resposta à pergunta secreta */
    public void setSecretAnswer(String answer) { this.secretAnswer = answer; }
    
    /** PErmissões do usuário */
    Map<String, Integer> rights;
    /** GET para as permissões do usuáeio */
    public Map<String, Integer> getRights() { return rights; }
    /** SET para as permissões do usuário */
    public void setRights(Map<String, Integer> rightList) { this.rights = rightList; }
    
    public void AddRight(String objectName, int rightLevel)
    {
        if(rights == null)
        {
            rights = new HashMap<String, Integer>();
            rights.put(objectName, rightLevel);
        }
    }
}
