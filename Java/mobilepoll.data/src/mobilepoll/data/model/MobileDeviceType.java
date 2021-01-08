package mobilepoll.data.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import mobilepoll.utils.CollectionUtils;

/**
 * Classe persistente para tipos de dispositivo móvel
 * @author alira
 */
@Entity
@Table(name = "TipoDispositivoMovel")
public class MobileDeviceType
{
    private void DoInit()
    {
        if(this.mobileDeviceList == null)
        {
            this.mobileDeviceList = new ArrayList<MobileDevice>();
        }
    }
    
    /** Construtor */
    public MobileDeviceType()
    {
        this.DoInit();
    }
    
    /**
     * Construtor
     * @param name Nome do tipo de dispositivo móvel
     */
    public MobileDeviceType(String name)
    {
        this.DoInit();
        this.name = name;
    }
    
    /**
     * Construtor
     * @param name Nome do tipo de dispositivo móvel
     * @param system Sistem que roda nos dispositivos móveis deste tipo
     */
    public MobileDeviceType(String name, System system)
    {
        this.DoInit();
        this.name = name;
        this.system = system;
    }
    
    /**
     * Construtor
     * @param name Nome do tipo de dispositivo móvel
     * @param system Sistema que roda nos dispositivos móveis deste tipo
     * @param description Descritivo do tipo
     */
    public MobileDeviceType(String name, System system, String description)
    {
        this.DoInit();
        this.name = name;
        this.system = system;
        this.description = description;
    }
    
    /** Id do registro na tabela */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    long id;
    /** GET para o id do registro na tabela */
    public long getId() { return id; }
    /** SET para o id do registro na tabela */
    public void setId(long id) { this.id = id; }
    
    /** Nome do tipo de dispositivo móvel */
    @Column(name = "Nome", length = 200, unique = true, nullable = false)
    String name;
    /** GET para o nome do tipo de dispositivo móvel */
    public String getName() { return name; }
    /** SET para o nome do tipo de dispositivo móvel */
    public void setName(String name) { this.name = name; }
    
    /** Descritivo do tipo de dispositivo móvel */
    @Column(name = "Descricao", nullable = true, columnDefinition = "TEXT")
    String description;
    /** GET para o descritivo do tipo de dispositivo móvel */
    public String getDescription() { return description; }
    /** SET para o descritivo do tipo de dispositivo móvel */
    public void setDescription(String description) { this.description = description; }
    
    /** Sistema que roda nos dispositivos móveis deste tipo */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Sistema", nullable = false)
    System system;
    /** GET para o sistema que roda nos dispositivos móveis deste tipo */
    public System getSystem() { return system; }
    /** SET para o sistema que roda nos dispositivos móveis deste tipo */
    public void setSystem(System sys) { this.system = sys; }
    
    /** Data e hora da inserção do registro no banco */
    @Column(name = "DataHoraRegistro", nullable = false, columnDefinition = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    Date registerDateTime;
    /** GET para a data e hora da inserção do registro no banco */
    public Date getRegisterDateTime() { return registerDateTime; }
    /** SET para a data e hora de inserção do registro no banco */
    public void setRegisterDateTime(Date dateTime) { this.registerDateTime = dateTime; }
    
    /** Coleção de dispositivos móveis que pertencem a este tipo */
    @OneToMany(cascade = CascadeType.ALL,
               mappedBy = "mobileDeviceType",
               targetEntity = MobileDevice.class,
               fetch = FetchType.LAZY)
    List<MobileDevice> mobileDeviceList;
    /** GET para a coleção de dispositivos móveis que pertencem a este tipo */
    public List<MobileDevice> getMobileDeviceList() { return this.mobileDeviceList; }
    /** SET para a coleção de dispositivos móveis que pertencem a este tipo */
    public void setMobileDeviceList(List<MobileDevice> mdList) { this.mobileDeviceList = mdList; }
    
    @PrePersist
    private void onSave() throws Exception
    {
        if(this.registerDateTime == null)
        {
            this.registerDateTime = new Date();
        }
        
        List<String> errorList = new ArrayList<String>();
        
        if(this.name == null || (this.name != null && this.name.isEmpty()))
        {
            errorList.add("O nome do tipo de dispositivo móvel deve ser fornecido.");
        }
        
        if(errorList != null && errorList.isEmpty() == false)
        {
            throw new Exception("Ocorreram erros ao salvar o tipo de dispositivo móvel no banco: " + CollectionUtils.StringListToString(errorList));
        }
    }
}
