package mobilepoll.data.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * Classe persistente para modelos de dispositivos móveis
 * @author alira
 */
@Entity
@Table(name = "Modelo")
public class Model
{
    private void DoInit()
    {
        if(this.mobileDeviceList == null)
        {
            this.mobileDeviceList = new ArrayList<MobileDevice>();
        }
    }
    
    /** Construtor */
    public Model()
    {
        this.DoInit();
    }
    
    /**
     * Contrutor
     * @param name Nome do modelo de dispositivo móvel
     */
    public Model(String name)
    {
        this.DoInit();
        this.name = name;
    }
    
    /**
     * Construtor
     * @param name Nome do modelo de dispositivo móvel
     * @param brand Marca à qual o modelo pertence
     */
    public Model(String name, MobileDeviceBrand brand)
    {
        this.DoInit();
        this.name = name;
        this.mobileDeviceBrand = brand;
    }
    
    /** Identificador único deste registro */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    long id;
    /** GET para o identificador único deste registro */
    public long getId() { return id; }
    /** SET para o identificador único deste registro */
    public void setId(long id) { this.id = id; }
    
    /** Nome do modelo de dispositivo móvel */
    @Column(name = "Nome", length = 200, nullable = false, unique = true)
    String name;
    /** GET para o nome do modelo de dispositivo móvel */
    public String getName() { return name; }
    /** SET para o nome do modelo de dispositivo móvel */
    public void setName(String name) { this.name = name; }
    
    /** Marca à qual este modelo pertence */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MarcaDeDispositivoMovel", nullable = false)
    MobileDeviceBrand mobileDeviceBrand;
    /** GET para a marca à qual este modelo pertence */
    public MobileDeviceBrand getMobileDeviceBrand() { return mobileDeviceBrand; }
    /** SET para a marca à qual este modelo pertence */
    public void setMobileDeviceBrand(MobileDeviceBrand brand) { this.mobileDeviceBrand = brand; }
    
    /** Especificações técnicas dos dispositivos deste modelo */
    @Column(name = "EspecificacoesTecnicas", columnDefinition = "text", nullable = true)
    String technicalSpecifications;
    /** GET para as especificaçoes técnicas dos dispositivos deste modelo */
    public String getTechnicalSpecifications() { return this.technicalSpecifications; }
    /** SET para as especificações técnicas dos dispositivos deste modelo */
    public void setTechnicalSpecifications(String specifications) { this.technicalSpecifications = specifications; }
    
    /** Redes de comunicação suportadas pelos dispositivos deste modelo */
    @Column(name = "RedesSuportadas", length = 500, nullable = true)
    String supportedNetworkList;
    /** GET para as redes de comunicação suportadas pelos dispositivos deste modelo */
    public String getSupportedNetworkList() { return supportedNetworkList; }
    /** SET para as redes de comunicação suportadas pelos dispositivos móveis deste modelo */
    public void setSupportedNetworkList(String snList) { this.supportedNetworkList = snList; }
    
    /** Página web correspondente a este modelo de dispositivo móvel */
    @Column(name = "PaginaWeb", length = 300, nullable = true)
    String webPage;
    /** GET para a página web deste modelo */
    public String getWebPage() { return webPage; }
    /** SET para a página web deste modelo */
    public void setWebPage(String wPage) { this.webPage = wPage; }
    
    /** Comentários e/ou observações pertinentes */
    @Column(name = "Comentarios", columnDefinition = "TEXT", nullable = true)
    String comments;
    /** GET para os comentários e/ou observações pertinentes */
    public String getComments() { return comments; }
    /** SET para os comentários e/ou observações pertinentes. */
    public void setComments(String comments) { this.comments = comments; }
    
    /** Data e hora da criação do registro no banco */
    @Column(name = "DataHoraRegistro", columnDefinition = "datetime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date registerDateTime;
    /** GET para a data e hora da criação do registro no banco */
    public Date getRegisterDateTime() { return this.registerDateTime; }
    /** SET para a data e hora da criação do registro no banco */
    public void setRegisterDateTime(Date dt) { this.registerDateTime = dt; }
    
    /** Dispositivos móveis desse modelo */
    @OneToMany(fetch = FetchType.LAZY,
               cascade = CascadeType.ALL,
               mappedBy = "mobileDeviceModel",
               targetEntity = MobileDevice.class)
    List<MobileDevice> mobileDeviceList;
    /** GET para a listagem de dispositivos móveis desse modelo */
    public List<MobileDevice> getMobileDeviceList() { return mobileDeviceList; }
    /** SET para a listagem de dispositivos móveis desse modelo */
    public void setMobileDeviceList(List<MobileDevice> mdList) { this.mobileDeviceList = mdList; }
    
    @PrePersist
    private void onSave()
    {
        if(this.registerDateTime == null)
        {
            this.registerDateTime = new Date();
        }
    }
}