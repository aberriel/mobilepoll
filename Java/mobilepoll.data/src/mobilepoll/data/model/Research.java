package mobilepoll.data.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.*;
import org.hibernate.annotations.Type;

/**
 * Classe persistente para pesquisas dos clientes
 * @author alira
 */
@Entity
@Table(name = "Pesquisa")
public class Research
{
    private void DoInit()
    {
        if(this.mobileDevices == null)
        {
            this.mobileDevices = new ArrayList<MobileDevice>();
        }
        
        if(this.allowedUsers == null)
        {
            this.allowedUsers = new ArrayList<User>();
        }
        
        if(this.questionList == null)
        {
            this.questionList = new ArrayList<Question>();
        }
        
        if(this.pollList == null)
        {
            this.pollList = new ArrayList<Poll>();
        }
        
        if(this.userAuthorizationHistory == null)
        {
            this.userAuthorizationHistory = new ArrayList<UserResearchAuthorization>();
        }
    }
    
    /** Construtor */
    public Research()
    {
        this.DoInit();
    }
    
    /** Identificador do registro no banco */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    long id;
    /** GET para o identificador do registro no banco */
    public long getId() { return id; }
    /** SET para o identificador do registro no banco */
    public void setId(long id) { this.id = id; }
    
    /** Nome da pesquisa */
    @Column(name = "Nome", length = 200, nullable = false)
    String name;
    /** GET para o nome da pesquisa */
    public String getName() { return name; }
    /** SET para o nome da pesquisa */
    public void setName(String name) { this.name = name; }
    
    /** Descritivo da pesquisa */
    @Column(name = "Descricao", columnDefinition = "TEXT", nullable = true)
    String description;
    /** GET para o descritivo da pesquisa */
    public String getDescription() { return description; }
    /** SET para o descritivo da pesquisa */
    public void setDescription(String description) { this.description = description; }
    
    @Column(name = "Key", length = 64, nullable = false)
    String key;
    public String getKey() { return this.key; }
    public void setKey(String key) { this.key = key; }
    
    /** Cliente dono da pesquisa */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "Cliente", nullable = false)
    Client client;
    /** GET para o cliente dono da pesquisa */
    public Client getClient() { return client; }
    /** SET para o cliente dono da pesquisa */
    public void setClient(Client client) { this.client = client; }
    
    /** Categoria à qual a pesquisa pertence */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "CategoriaDePesquisa", nullable = true)
    ResearchCategory researchCategory;
    /** GET para a categoria à qual a pesquisa pertence */
    public ResearchCategory getResearchCategory() { return researchCategory; }
    /** SET para a categoria à qual a pesquisa pertence */
    public void setResearchCategory(ResearchCategory category) { this.researchCategory = category; }
    
    /** Campos identificadores obrigatórios do entrevistado */
    @Column(name = "CamposDeIdentificacaoObrigatorios", length = 400, nullable = true)
    String requiredIdentifierFieldList;
    /** GET para a lista de campos identificadores obrigatórios do entrevistado */
    public String getRequiredIdentifierFieldList() { return this.requiredIdentifierFieldList; }
    /** SET  para a lista de campos identificadores obrigatórios do entrevistado */
    public void setRequiredIdentifierFieldList(String rifList) { this.requiredIdentifierFieldList = rifList; }
    
    @Column(name = "RespostaSemAutenticacao", columnDefinition = "TINYINT", length = 1, nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    boolean answerWithoutAuthentication;
    public boolean isAnswerWithoutAuthentication() { return this.answerWithoutAuthentication; }
    public void setAnswerWithoutAuthentication(boolean awa) { this.answerWithoutAuthentication = awa; }
    
    /**
     * Data e hora do início da validade da pesquisa.
     * Para pesquisas válidas por um período de tempo (uma campanha, por exemplo)
     */
    @Column(name = "DataHoraInicio", columnDefinition = "datetime", nullable = true)
    @Temporal(TemporalType.DATE)
    Date initDateTime;
    /** GET para a data e hora do início da validade da pesquisa. */
    public Date getInitDateTime() { return initDateTime; }
    /** SET para a data e hora do início da validade da pesquisa */
    public void setInitDateTime(Date dateTime) { this.initDateTime = dateTime; }
    
    /**
     * Data e hora do término da validade da pesquisa.
     * Para pesquisas válidas por um período de tempo (uma campanha, por exempl
     */
    @Column(name = "DataHoraTermino", columnDefinition = "datetime", nullable = true)
    @Temporal(TemporalType.DATE)
    Date finishDateTime;
    /** GET para a data e hora do término da validade da pesquisa */
    public Date getFinishDateTime() { return finishDateTime; }
    /** SET para a data e hora do término da validade da pesquisa */
    public void setFinishDateTime(Date dateTime) { this.finishDateTime = dateTime; }
    
    /** Usuário responsável pelo registro da pesquisa no sistema */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "UsuarioResponsavelPeloRegistro", nullable = false)
    User userResponsibleForRegistration;
    /** GET para o usuário responsável pelo registro da pesquisa no sistema */
    public User getUserResponsibleForRegistration() { return this.userResponsibleForRegistration; }
    /** SET para o usuário responsável pelo registro da pesquisa no sistema */
    public void setUserResponsibleForRegistration(User user) { this.userResponsibleForRegistration = user; }
    
    /** Usuário responsável pela última atualização no registro de pesquisa no sistema */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "UsuarioResponsavelPelaUltimaAtualizacao", nullable = false)
    User userResponsibleForLastUpdate;
    /** GET para o usuário responsaǘel pela última atualização no registro de pesquisa no sistema */
    public User getUserResponsibleForLastUpdate() { return this.userResponsibleForLastUpdate; }
    /** SET para o usuário responsável pela última atualização no registro de pesquisa no sistema */
    public void setUserResponsibleForLastUpdate(User user) { this.userResponsibleForLastUpdate = user; }
    
    /**
     * Flag indicador de pesquisa pública.
     * 
     * Pesquisa pública pode ser visualizada por usuários de outros
     * clientes no sistema web.
     */
    @Column(name = "Publico", columnDefinition = "TINYINT", length = 1, nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    boolean publicResearch;
    /** GET para o flag indicador de pesquisa pública */
    public boolean isPublicResearch() { return publicResearch; }
    /**
     * SET para o flag indicador de pesquisa pública */
    public void setPublicResearch(boolean isPublic) { this.publicResearch = isPublic; }
    
    /** Flag indicador de pesquisa válida ou ativa */
    @Column(name = "Valido", columnDefinition = "TINYINT", length = 1, nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    boolean valid;
    /** GET para o flag indicador de pesquisa válida @see #valid */
    public boolean isValid() { return valid; }
    /** SET para o flag indicador de pesquisa válida */
    public void setValid(boolean valid) { this.valid = valid; }
    
    /** Data e hora da criação do registro no banco */
    @Column(name = "DataHoraRegistro", columnDefinition = "datetime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date registerDateTime;
    /** GET para a data e hora da criação do registro no banco */
    public Date getRegisterDateTime() { return this.registerDateTime; }
    /** SET para a data e hora da criação do registro no banco */
    public void setRegisterDateTime(Date dateTime) { this.registerDateTime = dateTime; }
    
    /** Data e hora da última atualização no registro */
    @Column(name = "DataHoraUltimaAtualizacao", columnDefinition = "datetime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date lastUpdateDateTime;
    /** GET para a data e hora da última atualização no registro */
    public Date getLastUpdateDateTime() { return this.lastUpdateDateTime; }
    /** SET para a data e hora da última atualização no registro */
    public void setLastUpdateDateTime(Date dateTime) { this.lastUpdateDateTime = dateTime; }
    
    /** Data e hora da exclusão do registro do sistema */
    @Column(name = "DataHoraExclusao", columnDefinition = "datetime", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    Date deleteDateTime;
    /** GET para a data e hora de exclusão do registro do sistema */
    public Date getDeleteDateTime() { return this.deleteDateTime; }
    /** SET para a data e hora de exclusão do registro do sistema */
    public void setDeleteDateTime(Date dt) { this.deleteDateTime = dt; }
    
    /** Chave pública identificadora da ação de exclusão */
    @Column(name = "ChaveExclusao", length = 64, nullable = true)
    String deleteKey;
    /** GET para a chave pública identificadora da ação de exclusão */
    public String getDeleteKey() { return this.deleteKey; }
    /** SET para a chave pública identificadora da ação de exclusão */
    public void setDeleteKey(String key) { this.deleteKey = key; }
    
    /** Dispositivos que possuem esta pesquisa */
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "PesquisaDispositivoMovel",
               catalog = "enquetemobile",
               joinColumns = { @JoinColumn(name = "Pesquisa", nullable = false, updatable = false) },
               inverseJoinColumns = { @JoinColumn(name = "DispositivoMovel",
                                      nullable = false, updatable = false) })
    List<MobileDevice> mobileDevices;
    /** GET para a lista de dispositivos que possuem esta pesquisa */
    public List<MobileDevice> getMobileDeviceList() { return mobileDevices; }
    /** SET para a lista de dispositivos que possuem esta pesquisa */
    public void setMobileDeviceList(List<MobileDevice> mdl) { this.mobileDevices = mdl; }
    
    /** Lista de usuários autorizados a executar esta pesquisa em dispositivos móveis */
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "PesquisaDispositivoMovel",
               catalog = "enquetemobile",
               joinColumns = { @JoinColumn(name = "Pesquisa", nullable = false, updatable = false) },
               inverseJoinColumns = { @JoinColumn(name = "DispositivoMovel",
                                      nullable = false, updatable = false) })
    List<User> allowedUsers;
    /** GET para a listagem de usuários autorizados a executar a pesquisa em dispositivo móvel */
    public List<User> getAllowedUserList() { return allowedUsers; }
    /** SET para a listagem de usuários autorizados a executar a pesquisa em dispositivo móvel */
    public void setAllowedUserList(List<User> aul) { this.allowedUsers = aul; }
    
    /** Questões desta pesquisa */
    @OneToMany(fetch = FetchType.LAZY,
               cascade = CascadeType.ALL,
               mappedBy = "research")
    List<Question> questionList;
    /** GET para a lista de questões desta pesquisa */
    public List<Question> getQuestionList() { return questionList; }
    /** SET para a lista de questões desta pesquisa */
    public void setQuestionList(List<Question> qList) { this.questionList = qList; }
    
    /** Enquetes desta pesquisa */
    @OneToMany(fetch = FetchType.LAZY,
               cascade = CascadeType.ALL,
               mappedBy = "research")
    List<Poll> pollList;
    /** GET para a lista de enquetes desta pesquisa */
    public List<Poll> getPollList() { return pollList; }
    /** SET para a lista de enquetes desta pesquisa */
    public void setPollList(List<Poll> pList) { this.pollList = pList; }
    
    /** Usuários autorizados a acessar esta pesquisa pelo dispositivo móvel */
    @OneToMany(fetch = FetchType.LAZY,
               cascade = CascadeType.ALL,
               mappedBy = "research")
    List<UserResearchAuthorization> userAuthorizationHistory;
    /** GET para a lista de usuários autorizados a acessar esta pesquisa pelo dispositivo móvel */
    public List<UserResearchAuthorization> getUserAuthorizationHistory() { return this.userAuthorizationHistory; }
    /** SET para a lista de usuários autorizados a acessar esta pesquisa pelo dispositivo móvel */
    public void setUserAuthorizationHistory(List<UserResearchAuthorization> uraHistory) { this.userAuthorizationHistory = uraHistory; }
    
    @PrePersist
    private void onSave() throws Exception
    {
        if(this.registerDateTime == null)
        {
            this.registerDateTime = new Date();
        }
        
        this.lastUpdateDateTime = new Date();
        
        if(this.initDateTime != null && this.finishDateTime != null)
        {
            if(this.initDateTime.after(this.finishDateTime))
            {
                throw new Exception("Impossível registrar pesquisa: data de início ("
                                    + this.initDateTime.toString() +
                                    ") é posterior à data de término ("
                                    + this.finishDateTime.toString());
            }
        }
        
        if(this.key == null)
        {
            this.key = UUID.randomUUID().toString();
        }
    }
}
