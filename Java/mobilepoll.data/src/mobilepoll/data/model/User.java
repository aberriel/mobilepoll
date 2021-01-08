package mobilepoll.data.model;

import mobilepoll.data.model.enums.UserType_Tp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Type;

/**
 * Classe persistente do Hibernate para tabela de usuários
 * @author alira
 */
@Entity
@Table(name = "Usuario")
@PrimaryKeyJoinColumn(name = "Id")
public class User extends Persona
{
    private void DoInit()
    {
        if(this.assignedResearchs == null)
        {
            this.assignedResearchs = new ArrayList<Research>();
        }
        
        if(this.rightList == null)
        {
            this.rightList = new ArrayList<Right>();
        }
        
        if(this.userGroupList == null)
        {
            this.userGroupList = new ArrayList<UserGroup>();
        }
        
        if(this.researchAuthorizationHistory == null)
        {
            this.researchAuthorizationHistory = new ArrayList<UserResearchAuthorization>();
        }
        
        if(this.mailBoxWithClient == null)
        {
            this.mailBoxWithClient = new ArrayList<InterviewerClientMail>();
        }
    }
    
    /** Construtor */
    public User()
    {
        super();
        this.DoInit();
    }
    
    /**
     * Construtor
     * @param client Cliente dono do sistema (para usuários de cliente)
     */
    public User(Client client)
    {
        super();
        this.DoInit();
        
        this.client = client;
    }
    
    /**
     * Construtor
     * @param login Login do usuário para autenticação no sistema
     */
    public User(String login)
    {
        super();
        this.DoInit();
        
        this.login = login;
    }
    
    public User(String login, String name)
    {
        super(name);
        this.DoInit();
        
        this.login = login;
    }
    
    /**
     * Construtor
     * @param client Cliente dono do usuário (para usuários de cliente)
     * @param login Login do usuário para autenticação no sistema
     */
    public User(Client client, String login)
    {
        super();
        this.DoInit();
        
        this.client = client;
        this.login = login;
    }
    
    /**
     * Construtor
     * @param login Login do usuário para autenticação no sistema
     * @param password Senha do usuário no sistema.
     */
    public User(String name, String login, String password)
    {
        super(name);
        this.DoInit();
        
        this.login = login;
        this.password = password;
    }
    
    /**
     * Construtor
     * @param client Cliente dono do usuário (para usuários de cliente)
     * @param login Login do usuário para autenticação no sistema
     * @param password Senha do usuário no sistema
     */
    public User(Client client, String login, String password)
    {
        super();
        this.DoInit();
        
        this.login = login;
        this.password = password;
        this.client = client;
    }
    
    /** Login do usuário no sisteka */
    @Column(name = "ApelidoUsuario", length = 50, nullable = false)
    String login;
    /** GET para o login do usuário no sistema */
    public String getLogin() { return login; }
    /** SET para o login do usuário no sistema */
    public void setLogin(String login) { this.login = login; }
    
    /** Senha do usuário no sistema */
    @Column(name = "Senha", length = 64, nullable = true)
    String password;
    /** GET para a senha do usuário no sistema */
    public String getPassword() { return password; }
    /** SET para a senha do usuário no sistema */
    public void setPassword(String passwd) { this.password = passwd; }
    
    /** Tipo do usuário (se administrativo ou do cliente, por hora...) */
    @Column(name = "TipoUsuario", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    UserType_Tp userType;
    /** GET para o tipo do usuário */
    public UserType_Tp getUserType() { return userType; }
    /** SET para o tipo do usuário */
    public void setUserType(UserType_Tp type) { this.userType = type; }
    
    /** Cliente ao qual o usuário pertnece (para usuários do sistema) */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Cliente", nullable = true)
    Client client;
    /** GET para o cliente ao qual o usuário pertence */
    public Client getClient() { return client; }
    /** SET para o cliente ao qual o usuário pertence */
    public void setClient(Client client) { this.client = client; }
    
    /** Pergunta secreta */
    @Column(name = "PerguntaSecreta", length = 200, nullable = true)
    String secretQuestion;
    public String getSecretQuestion() { return secretQuestion; }
    public void setSecretQuestion(String question) { this.secretQuestion = question; }
    
    /** Resposta à pergunta secreta */
    @Column(name = "RespostaSecreta", length = 100, nullable = true)
    String secretAnswer;
    /** GET para a resposta à pergunta secreta */
    public String getSecretAnswer() { return secretAnswer; }
    /** SET para a resposta à pergunta secreta */
    public void setSecretAnswer(String answer) { this.secretAnswer = answer; }
    
    /** Flag de controle para troca de senha ao login */
    @Column(name = "AlterarSenha", nullable=false, columnDefinition = "TINYINT", length = 1)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    boolean changePassword;
    /** GET para o controle da troca de senha ao login */
    public boolean getChangePassword() { return changePassword; }
    /** SET para o controle da troca de senha ao login */
    public void setChangePassword(boolean allowChange) { this.changePassword = allowChange; }
    
    /** Indica usuário root do sistema */
    @Column(name = "UsuarioMestre", nullable = false, columnDefinition = "TINYINT", length = 1)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    boolean masterUser;
    /** GET para o flag indicador de root do sistem */
    public boolean getMasterUser() { return masterUser; }
    /** SET para o flag indicador de root do sistema */
    public void setMasterUser(boolean master) { this.masterUser = master; }
    
    /** Caminho completo no sistema de arquivos para foto do usuário */
    @Column(name = "Foto", length = 300, nullable = true)
    String photo;
    /** GET para o caminho completo para arquivo de foto do usuário */
    public String getPhoto() { return photo; }
    /** SET para caminho completo para arquivo de foto do usuário */
    public void setPhoto(String photoPath) { this.photo = photoPath; }
    
    /** Código da solicitação de redefinição de senha */
    @Column(name = "50", length = 50, nullable = true)
    String passwordResetControl;
    /** GET para o código da solicitação de redefinição de senha */
    public String getPasswordResetControl() { return passwordResetControl; }
    /** SET para o código da solicitação de redefinição de senha */
    public void setPasswordResetControl(String control) { this.passwordResetControl = control; }
    
    /** Data e hora da solicitação de redefinição de senha */
    @Column(name = "DataHoraSolicitacaoRedefinicaoSenha", columnDefinition = "datetime", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    Date passwordResetRequestDateTime;
    /** GET para a data e hora da solicitação de redefinição de senha */
    public Date getPasswordResetRequestDateTime() { return passwordResetRequestDateTime; }
    /** SET para a data e hora da solicitação de redefinição de senha */
    public void setPasswordResetRequestDatetime(Date dateTime) { this.passwordResetRequestDateTime = dateTime; }
    
    /** Entrevistado associado a este usuário */
    @OneToOne(cascade = CascadeType.ALL,
              mappedBy = "user")
    Interviewee interviewee;
    /** GET para o entrevistado associado a este usuário */
    public Interviewee getInterviewee() { return this.interviewee; }
    /** SET para o entrevistado associado a este usuário */
    public void setInterviewee(Interviewee interviewee) { this.interviewee = interviewee; }
    
    /** Pesquisas que o uusário posui permissão de execução */
    @ManyToMany(mappedBy="allowedUsers",
                fetch = FetchType.LAZY)
    List<Research> assignedResearchs;
    /** GET para a lista de pesquisas que o usuário possui permissão de execução */
    public List<Research> getAssignedResearchList() { return assignedResearchs; }
    /** SET para a lista de pesquisas que o usuário possui permissão de execução */
    public void setAssignedResearchList(List<Research> arl) { this.assignedResearchs = arl; }
    
    /** Listagem de grupos aos quais o usuário pertence */
    @ManyToMany(fetch = FetchType.EAGER,
                mappedBy = "userList",
                cascade = CascadeType.ALL)
    List<UserGroup> userGroupList;
    /** GET para a listagem de grupos aos quais o usuário pertence */
    public List<UserGroup> getUserGroupList() { return this.userGroupList; }
    /** SET para a listagem de grupos aos quais o usuário pertence */ 
    public void setUserGroupList(List<UserGroup> ugList) { this.userGroupList = ugList; }
    
    /** Lista de permissões aplicadas a este usuário */
    @OneToMany(cascade = CascadeType.ALL,
               fetch = FetchType.LAZY,
               mappedBy = "user")
    List<Right> rightList;
    /** GET para a lista de permissões aplicadas a este usuário */
    public List<Right> getRightList() { return rightList; }
    /** SET para a lista de permissões aplicadas a este usuário */
    public void setRightList(List<Right> rList) { this.rightList = rList; }
    
    /** Histórico de atribuição de permissão de acesso às pesquisas pelos usuários */
    @OneToMany(fetch = FetchType.LAZY,
               cascade = CascadeType.ALL,
               mappedBy = "user")
    List<UserResearchAuthorization> researchAuthorizationHistory;
    /** GET para o histórico de atribuição de permissão de acesso às pesquisas pelos usuários */
    public List<UserResearchAuthorization> getResearchAuthorizationHistory() { return this.researchAuthorizationHistory; }
    /** SET para o historico de atribuição de permissão de acesso às pesquisas pelos usuários */
    public void setResearchAuthorizationHistory(List<UserResearchAuthorization> raHistory) { this.researchAuthorizationHistory = raHistory; }
    
    @OneToMany(fetch = FetchType.LAZY,
               cascade = CascadeType.ALL,
               mappedBy = "interviewer")
    List<InterviewerClientMail> mailBoxWithClient;
    public List<InterviewerClientMail> getMailBoxWithClient() { return this.mailBoxWithClient; }
    public void setMailBoxWithClient(List<InterviewerClientMail> mailBoxData) { this.mailBoxWithClient = mailBoxData; }
}
