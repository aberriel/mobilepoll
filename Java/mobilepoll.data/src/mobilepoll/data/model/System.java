package mobilepoll.data.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.*;
import org.hibernate.annotations.Type;

/**
 * Classe persistente de sistemas ou aplicações que podem utilizar o enquete mobile
 * @author alira
 */
@Entity
@Table(name = "Sistema")
public class System
{
    /** Inicialização dos campos da classe */
    private void DoInit()
    {
        if(this.applicationLogList == null)
        {
            this.applicationLogList = new ArrayList<LogApp>();
        }
        
        if(this.sessionList == null)
        {
            this.sessionList = new ArrayList<SessionManager>();
        }
        
        if(this.resourceList == null)
        {
            this.resourceList = new ArrayList<Resource>();
        }
        
        if(this.mobileDeviceTypeList == null)
        {
            this.mobileDeviceTypeList = new ArrayList<MobileDeviceType>();
        }
        
        if(this.globalConfigurationList == null)
        {
            this.globalConfigurationList = new ArrayList<GlobalConfiguration>();
        }
        
        if(this.clientConfigurationList == null)
        {
            this.clientConfigurationList = new ArrayList<ClientConfiguration>();
        }
        
        if(this.databaseLogList == null)
        {
            this.databaseLogList = new ArrayList<LogDB>();
        }
        
        if(this.applicationLogList == null)
        {
            this.applicationLogList = new ArrayList<LogApp>();
        }
        
        this.mobile = false;
    }
    
    /** Construtor */
    public System()
    {
        this.DoInit();
    }
    
    /**
     * Construtor
     * @param name Nome do sistema ou aplicação
     */
    public System(String name)
    {
        this.DoInit();
        this.name = name;
    }
    
    /**
     * Construtor
     * @param name Nome do sistema ou aplicação
     * @param mobile Flag indicador de 
     */
    public System(String name, boolean mobile)
    {
        this.DoInit();
        
        this.name = name;
        this.mobile = mobile;
    }
    
    /**
     * Construtor
     * @param name Nome do sistema ou aplicação
     * @param mobile Flag indicador de sistema ou aplicação exclusiva de dispositivo móvel
     * @param fullPathToIconFile Caminho completo para arquivo de ícone representativo do sistema ou aplicação
     */
    public System(String name, boolean mobile, String fullPathToIconFile)
    {
        this.DoInit();
        
        this.name = name;
        this.mobile = mobile;
        this.fullIconPath = fullPathToIconFile;
    }
    
    /** Identificador único do registro no banco */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    long id;
    /** GET para o identificador único do registro no banco */
    public long getId() { return id; }
    /** SET para o identificador único do registro no banco */
    public void setId(long id) { this.id = id; }
    
    /** Nome do sistema ou aplicação (deve ser único) */
    @Column(name = "Nome", length = 200, nullable = false, unique = true)
    String name;
    /** GET para o nome do sistema ou aplicação */
    public String getName() { return name; }
    /** SET para o nome do sistema ou aplicação */
    public void setName(String name) { this.name = name; }
    
    /** Comentários e/ou observações pertinentes */
    @Column(name = "Descricao", columnDefinition = "text", nullable = true)
    String description;
    /** GET para os comentários e/ou observações pertinentes */
    public String getDescription() { return description; }
    /** SET para os comentários e/ou observações pertinentes */
    public void setDescription(String description) { this.description = description; }
    
    /** Flag indicador de aplicação executada em dispositivo móvel */
    @Column(name = "movel", nullable = false, columnDefinition = "TINYINT", length = 1)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    boolean mobile;
    /** GET para o flag indicador de aplicação móvel */
    public boolean isMobile() { return mobile; }
    /** SET para o flag indicador de aplicação móvel */
    public void setMobile(boolean mobile) { this.mobile = mobile; }
    
    /**
     * Chave pública identificadora do sistema ou aplicação.
     * Para ocultar o id da tabela do banco, a chave pública identificadora (geralmente
     * um GUID) terá por fim garantir que somente aplicações registradas acessem o sistema
     * via web service.
     */
    @Column(name = "ChaveSistema", length = 100, nullable = true)
    String systemKey;
    /** GET para a chave pública identificadora do sistema ou aplicação. */
    public String getSystemKey() { return systemKey; }
    /** SET para a chave pública identificadora do sistema ou aplicação */
    public void setSystemKey(String key) { this.systemKey = key; }
    
    /** Caminho completo, no sistema de arquivos, para ícone identificador do sistema ou aplicação */
    @Column(name = "CaminhoCompletoIcone", length = 300, nullable = true)
    String fullIconPath;
    /** GET para caminho, no sistema de arquivos, de ícone identificador do sistema */
    public String getFullIconPath() { return this.fullIconPath; }
    /** SET para caminho, no sistema de arquivos, de ícone identificador do sistema */
    public void setFullIconPath(String path) { this.fullIconPath = path; }
    
    /** Data e hora da criação do registro no banco */
    @Column(name = "DataHoraRegistro", columnDefinition = "datetime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date registerDateTime;
    /** GET para a data e hora da criação do registro no banco */
    public Date getRegisterDateTime() { return this.registerDateTime; }
    /** SET para a data e hora da criação do registro no banco */
    public void setRegisterDateTime(Date dt) { this.registerDateTime = dt; }
    
    /** Listagem de registros de log desse sistema ou aplicação */
    @OneToMany(cascade = CascadeType.ALL,
               mappedBy = "system",
               targetEntity = LogApp.class,
               fetch = FetchType.LAZY)
    List<LogApp> applicationLogList;
    /** GET para a listagem de registros de log desse sistema ou aplicação */
    public List<LogApp> getApplicationLogList() { return this.applicationLogList; }
    /** SET para a listagem de registros de log desse sistema ou aplicação */
    public void setApplicationLogList(List<LogApp> logList) { this.applicationLogList = logList; }
    
    /** Listagem de registros de log de acesso ao banco desse sistema ou aplicação */
    @OneToMany(cascade = CascadeType.ALL,
               mappedBy = "system",
               targetEntity = LogDB.class,
               fetch = FetchType.LAZY)
    List<LogDB> databaseLogList;
    /** GET para a listagem de registros de log de acesso ao banco desse sistema ou aplicação */
    public List<LogDB> getDatabaseLogList() { return this.databaseLogList; }
    /** SET para a listagem de registros de log de acesso ao banco desse sistema ou aplicação */
    public void setDatabaseLogList(List<LogDB> logList) { this.databaseLogList = logList; }
    
    /** Configurações globais relativas a este sistema */
    @OneToMany(cascade = CascadeType.ALL,
               mappedBy = "system",
               targetEntity = GlobalConfiguration.class,
               fetch = FetchType.LAZY)
    List<GlobalConfiguration> globalConfigurationList;
    /** GET para a lista de configurações globais relativas a este sistema */
    public List<GlobalConfiguration> getGlobalConfigurationList() { return this.globalConfigurationList; }
    /** SET para a lista de configurações globais relativas a este sistema */
    public void setGlobalConfigurationList(List<GlobalConfiguration> gcList) { this.globalConfigurationList = gcList; }
    
    /** Listagem de configurações do cliente relativos a este sistema */
    @OneToMany(cascade = CascadeType.ALL,
               mappedBy = "system",
               targetEntity = ClientConfiguration.class,
               fetch = FetchType.LAZY)
    List<ClientConfiguration> clientConfigurationList;
    /** GET para a lista de configurações do cliente relativas a este sistema */
    public List<ClientConfiguration> getClientConfigurationList() { return clientConfigurationList; }
    /** SET para a lista de configurações do cliente relativas a esta sistema */
    public void setClientConfigurationList(List<ClientConfiguration> ccList) { this.clientConfigurationList = ccList; }
    
    /** Coleção de tipos de dispositivo móvel que executam este sistema */
    @OneToMany(cascade = CascadeType.ALL,
               mappedBy = "system",
               targetEntity = MobileDeviceType.class,
               fetch = FetchType.LAZY)
    List<MobileDeviceType> mobileDeviceTypeList;
    /** GET para a coleção de tipos de dispositivo móvel que executam este sistema */
    public List<MobileDeviceType> getMobileDeviceTypeList() { return this.mobileDeviceTypeList; }
    /** SET para a coleção de tipos de dispositivo móvel que executam este sistema */
    public void setMobileDeviceTypeList(List<MobileDeviceType> typeList) { this.mobileDeviceTypeList = typeList; }
    
    /** Coleção de recursos pertencentes a este sistema */
    @OneToMany(cascade = CascadeType.ALL,
               mappedBy = "system",
               targetEntity = Resource.class,
               fetch = FetchType.LAZY)
    List<Resource> resourceList;
    /** GET para a coleção de recursos pertencentes a este sistema */
    public List<Resource> getResourceList() { return resourceList; }
    /** SET para a coleção de recursos pertencentes a este sistema */
    public void setResourceList(List<Resource> rList) { this.resourceList = rList; }
    
    @OneToMany(cascade = CascadeType.ALL,
               mappedBy = "sessionOrigin",
               targetEntity = SessionManager.class,
               fetch = FetchType.LAZY)
    List<SessionManager> sessionList;
    public List<SessionManager> getSessionList() { return this.sessionList; }
    public void setSessionList(List<SessionManager> sList) { this.sessionList = sList; }
    
    @OneToMany(cascade = CascadeType.ALL,
               mappedBy = "pollOrigin",
               targetEntity = Poll.class,
               fetch = FetchType.LAZY)
    List<Poll> researchsFromMe;
    public List<Poll> getResearchsToMe() { return this.researchsFromMe; }
    public void setResearchsToMe(List<Poll> pList) { this.researchsFromMe = pList; }
    
    @PrePersist
    private void onSave()
    {
        if(this.systemKey == null || this.systemKey.isEmpty())
        {
            this.systemKey = UUID.randomUUID().toString();
        }
        
        if(this.registerDateTime == null)
        {
            this.registerDateTime = new Date();
        }
    }
}
