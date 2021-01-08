package ufrj.mobilepoll.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe do modelo de dados para usuários do sistema
 * Created by alira on 09/10/15.
 */
public class User extends Person
{
    /** Inicialização de atributos da classe */
    private void InitializeFields()
    {
        pollList = new ArrayList<Poll>();
    }

    /** Construtor */
    public User()
    {
        super();
        InitializeFields();
    }

    /**
     * Construtor
     * @param login Login do usuário para acesso ao sistema.
     */
    public User(String login)
    {
        super();
        InitializeFields();

        this.login = login;
    }

    /**
     * Construtor
     * @param login Login do usuário, para acesso ao sistema.
     * @param password Senha do usuário criptografada, para acesso ao sistema.
     */
    public User(String login, String password)
    {
        super();
        InitializeFields();

        this.login = login;
        this.password = password;
    }

    /** Login do usuário */
    private String login;
    /** GET para o login do usuário */
    public String getLogin() { return login; }
    /** SET para o login do usuário */
    public void setLogin(String login) { this.login = login; }

    /** Senha do usuário */
    private String password;
    /** GET para a senha do usuário */
    public String getPassword() { return password; }
    /** SET para a senha do usuário */
    public void setPassword(String password) { this.password = password; }

    /** Coleção de enquetes realizadas por este entrevistador. */
    private List<Poll> pollList;
    /** GET para a coleção de pesquisas realizadas por este entrevistador. */
    public List<Poll> getPollList() { return pollList; }
    /** SET para a coleção de pesquisas realizadas por este entrevistador. */
    public void setPollList(List<Poll> list) { this.pollList = list; }
}