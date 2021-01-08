package mobilepoll.data.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * Classe persistente do Hibernate para padrão de formato de endereço de host
 * de servidor SMTP.
 * @author alira
 */
@Entity
@Table(name = "TipoEndereçoServidor")
public class ServerAddressType
{
    private void DoInit()
    {
        if(this.emailConfigurationDataList == null)
        {
            this.emailConfigurationDataList = new ArrayList<EmailData>();
        }
    }
    
    /** Construtor */
    public ServerAddressType()
    {
        this.DoInit();
    }
    
    /**
     * Construtor
     * @param name Nome do tipo de endereço de servidor
     */
    public ServerAddressType(String name)
    {
        this.DoInit();
        this.name = name;
    }
    
    /**
     * Construtor
     * @param name Nome do tipo de endereço do servidor
     * @param format Formato do endereço (máscara)
     */
    public ServerAddressType(String name, String format)
    {
        this.DoInit();
        this.name = name;
        this.format = format;
    }
    
    /**
     * Construtor
     * @param name Nome do tipo de endereço do servidor
     * @param owner Usuário responsável pelo registro do tipo de endereço de servidor
     */
    public ServerAddressType(String name, User owner)
    {
        this.DoInit();
        this.name = name;
        this.owner = owner;
    }
    
    /**
     * Construtor
     * @param name Nome do tipo de endereço de servidor
     * @param format Formato do endereço (mascara)
     * @param owner Usuário responsável pelo registro do tipo de endereço do servidor
     */
    public ServerAddressType(String name, String format, User owner)
    {
        this.DoInit();
        this.name = name;
        this.format = format;
        this.owner = owner;
    }
    
    public ServerAddressType(String name, User owner, String description)
    {
        this.DoInit();
        this.name = name;
        this.description = description;
        this.owner = owner;
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
    
    /** Nome do padrão de endereço de servidor registrado */
    @Column(name = "Nome", length = 200, nullable = false)
    String name;
    /** GET para o nome do padrão de endereço de servidor registrado */
    public String getName() { return name; }
    /** SET para o nome do padrão de endereço de servidor registrado */
    public void setName(String name) { this.name = name; }
    
    /** Descritivo do padrão de endereço registrado */
    @Column(name = "Descricao", columnDefinition = "TEXT", nullable = true)
    String description;
    /** GET para o descritivo do padrão de endereço registrado */
    public String getDescription() { return description; }
    /** SET para o descritivo do padrão de endereço registrado */
    public void setDescription(String description) { this.description = description; }
    
    /** Formato do endereço do servidor */
    @Column(name = "FormatoString", length = 40, nullable = true)
    String format;
    /** GET para o formato do endereço do servidor */
    public String getFormat() { return this.format; }
    /** SET para o formato do endereço do servidor */
    public void setFormat(String mask) { this.format = mask; }
    
    /** Data e hora da criação do registro no banco. */
    @Column(name = "DataHoraRegistro", columnDefinition = "datetime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date registerDateTime;
    /** GET para a data e hora da criação do registro no banco */
    public Date getRegisterDateTime() { return this.registerDateTime; }
    /** SET para a data e hora da criação do registro no banco */
    public void setRegisterDateTime(Date dateTime) { this.registerDateTime = dateTime; }
    
    /** Usuário que criou o registro no banco */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UsuarioResponsavelPeloRegistro", nullable = false)
    User owner;
    /** GET para o usuário que criou o registro no banco */
    public User getOwner() { return owner; }
    /** SET para o usuário que criou o registro no banco */
    public void setOwner(User owner) { this.owner = owner; }
    
    @OneToMany(fetch = FetchType.LAZY,
               cascade = CascadeType.ALL,
               mappedBy = "smtpServerAddressType",
               targetEntity = EmailData.class)
    List<EmailData> emailConfigurationDataList;
    public List<EmailData> getEmailConfigurationDataList() { return this.emailConfigurationDataList; }
    public void setEmailConfigurationDataList(List<EmailData> eList) { this.emailConfigurationDataList = eList; }
    
    @PrePersist
    private void onSave()
    {
        if(this.registerDateTime == null)
        {
            this.registerDateTime = new Date();
        }
    }
}