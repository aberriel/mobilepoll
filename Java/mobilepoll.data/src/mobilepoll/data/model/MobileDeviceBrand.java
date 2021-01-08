package mobilepoll.data.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * Classe persistente do Hibernate para marcas de dispositivos móveis
 * @author alira
 */
@Entity
@Table(name = "Marca")
public class MobileDeviceBrand
{
    private void DoInit()
    {
        if(this.mobileDeviceModelList == null)
        {
            this.mobileDeviceModelList = new ArrayList<Model>();
        }
    }
    
    /** Construtor */
    public MobileDeviceBrand()
    {
        this.DoInit();
    }
    
    /**
     * Construtor
     * @param name Nome da marca de dispositivo móvel
     */
    public MobileDeviceBrand(String name)
    {
        this.DoInit();
        this.name = name;
    }
    
    /**
     * Construtor
     * @param name Nome da marca de dispositivo móvel
     * @param manufacturer Fabricande dono da marca.
     */
    public MobileDeviceBrand(String name, MobileDeviceManufacturer manufacturer)
    {
        this.DoInit();
        this.name = name;
        this.mobileDeviceManufacturer = manufacturer;
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
    
    /** Nome da marca de dispositivoo móvel */
    @Column(name = "Nome", length = 200, nullable = false)
    String name;
    /** GET para o nome da marca de dispositivo móvel */
    public String getName() { return name; }
    /** SET para o nome da marca de dispositivo móvel */
    public void setName(String name) { this.name = name; }
    
    /** Fabricante responsável pela MARCA */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FabricanteDeDispositivoMovel", nullable = false)
    MobileDeviceManufacturer mobileDeviceManufacturer;
    /** GET para o fabricante responsável pela marca */
    public MobileDeviceManufacturer getMobileDeviceManufacturer() { return mobileDeviceManufacturer; }
    /** SET para o fabricante responsável pela marca */
    public void setMobileDeviceManufacturer(MobileDeviceManufacturer manufacturer) { this.mobileDeviceManufacturer = manufacturer; }
    
    /** Comentários e/ou observações pertinentes */
    @Column(name = "Comentarios", columnDefinition = "TEXT", nullable = true)
    String comments;
    /** GET para os comentários e/ou observações pertinentes */
    public String getComments() { return comments; }
    /** SET para os comentários e/ou observações pertinentes */
    public void setComments(String comments) { this.comments = comments; }
    
    /** Data e hora da criação do registro no banco */
    @Column(name = "DataHoraRegistro", columnDefinition = "datetime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date registerDateTime;
    /** GET para a data e hora da criação do registro no banco */
    public Date getRegisterDateTime() { return registerDateTime; }
    /** SET para a data e hora da criação do registro no banco */
    public void setRegisterDateTime(Date dateTime) { this.registerDateTime = dateTime; }
    
    /** Modelos desta marca */
    @OneToMany(fetch = FetchType.LAZY,
               cascade = CascadeType.ALL,
               mappedBy = "mobileDeviceBrand",
               targetEntity = Model.class)
    List<Model> mobileDeviceModelList;
    /** GET para a listagem de modelos de dispositivos móveis desta marca */
    public List<Model> getMobileDeviceModelList() { return mobileDeviceModelList; }
    /** SET para a listagem de modelos de dispositivos móveis desta marca */
    public void setMobileDeviceModelList(List<Model> mdmList) { this.mobileDeviceModelList = mdmList; }
    
    /** Evento de salvamento do registro no banco */
    @PrePersist
    private void onSave()
    {
        if(this.registerDateTime == null)
        {
            this.registerDateTime = new Date();
        }
    }
}
