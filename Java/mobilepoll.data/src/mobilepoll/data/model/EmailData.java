package mobilepoll.data.model;

import java.util.*;
import javax.persistence.*;
import org.hibernate.annotations.Type;

/**
 * Classe persistente do hibernate para configurações de SMTP para envio de e-mail
 * @author alira
 */
@Entity
@Table(name = "DadosCorreioEletronico")
public class EmailData
{
    private void doInit()
    {
        this.invalidationDateTime = null;
        this.ssl = false;
        
        if(this.globalConfigurationList == null)
        {
            this.globalConfigurationList = new ArrayList<GlobalConfiguration>();
        }
    }
    
    /** Construtor */
    public EmailData()
    {
        this.doInit();
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
    
    /** Nome da configuração de servidor SMTP */
    @Column(name = "Nome", length = 200, nullable = false, unique = true)
    String name;
    /** GET para o nome da configuração SMTP */
    public String getName() { return name; }
    /** SET para o nome da configuração SMTP */
    public void setName(String name) { this.name = name; }
    
    /** Descritivo da configuração */
    @Column(name = "Descricao", columnDefinition = "text", nullable = true)
    String description;
    /** GET para o descritivo da configuração */
    public String getDescription() { return description; }
    /** SET para o descritivo da configuração */
    public void setDescription(String description) { this.description = description; }
    
    /** Login no servidor SMTP */
    @Column(name = "ApelidoUsuario", length = 50, nullable = false)
    String login;
    /** GET para o login no servidor SMTP */
    public String getLogin() { return login; }
    /** SET para o login no servidor SMTP */
    public void setLogin(String login) { this.login = login; }
    
    /** Senha para o usuário fornecido no servidor SMTP */
    @Column(name = "Senha", length = 50, nullable = false)
    String password;
    /** GET para a senha para o usuário fornecido no servidor SMTP */
    public String getPassword() { return password; }
    /** SET para a senha para o usuário fornecido no servidor SMTP */
    public void setPassword(String password) { this.password = password; }
    
    /** Flag indicador de conexão segura (uso de SSL) */
    @Column(name = "UsarSSL", nullable = false, columnDefinition = "TINYINT", length = 1)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    boolean ssl;
    /** GET para o flag indicador de conexão segura */
    public boolean isSsl() { return ssl; }
    /** SET para o flag indicador de conexão segura */
    public void setSsl(boolean ssl) { this.ssl = ssl; }
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TipoDeEnderecoDoServidorSmtp", nullable = false)
    ServerAddressType smtpServerAddressType;
    public ServerAddressType getSmtpServerAddressType() { return smtpServerAddressType; }
    public void setSmtpServerAddressType(ServerAddressType smtpServerAddressType) { this.smtpServerAddressType = smtpServerAddressType; }
    
    /** Endereço do servidor SMTP, conforme tipo definido */
    @Column(name = "EnderecoServidorSmtp", length = 200, nullable = false)
    String smtpServerAddress;
    /** GET para o endereço do servidor SMTP */
    public String getSmtpServerAddress() { return smtpServerAddress; }
    /** SET para o endereço do servidor SMTP, segundo o tipo definido */
    public void setSmtpServerAddress(String smtpServerAddress) { this.smtpServerAddress = smtpServerAddress; }
    
    /** Porta da aplicação SMTP no servidor */
    @Column(name = "Porta", length = 8, nullable = true)
    String portNumber;
    /** GET para a porta da aplicação SMTP no servidor */
    public String getPortNumber() { return portNumber; }
    /** SET para a porta da aplicação SMTP no servidor */
    public void setPortNumber(String portNumber) { this.portNumber = portNumber; }
    
    /** Data e hora da criação do registro no banco */
    @Column(name = "DataHoraRegistro", columnDefinition = "datetime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date registerDateTime;
    /** GET para a data e hora da criação do registro no banco */
    public Date getRegisterDateTime() { return registerDateTime; }
    /** SET para a data e hora da criação do registro no banco */
    public void setRegisterDateTime(Date registerDateTime) { this.registerDateTime = registerDateTime; }
    
    /**
     * Data e hora da invalidação da configuração
     * 
     * A invalidação da configuração ocorre quando outra configuração é criada
     * no lugar desta, pois pode existir somente uma ativa em dado momento.
     */
    @Column(name = "DataHoraInvalidacao", columnDefinition = "datetime", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    Date invalidationDateTime;
    /** Data e hora da invalidação da configuração */
    public Date getInvalidationDateTime() { return invalidationDateTime; }
    /** SET para a data e hora da invalidação da configuração */
    public void setInvalidationDateTime(Date invalidationDateTime) { this.invalidationDateTime = invalidationDateTime; }
    
    @OneToMany(fetch = FetchType.LAZY,
               cascade = CascadeType.ALL,
               mappedBy = "sendMailGlobalConfiguration",
               targetEntity = GlobalConfiguration.class)
    List<GlobalConfiguration> globalConfigurationList;
    public List<GlobalConfiguration> getGlobalConfigurationList() { return this.globalConfigurationList; }
    public void setGlobalConfigurationList(List<GlobalConfiguration> gcList) { this.globalConfigurationList = gcList; }
    
    /** Evento de salvamento do objeto */
    @PrePersist
    private void onSave()
    {
        if(this.registerDateTime == null)
        {
            this.registerDateTime = new Date();
        }
    }
}
