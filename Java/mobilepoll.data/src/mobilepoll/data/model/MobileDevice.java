package mobilepoll.data.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.*;
import mobilepoll.data.model.CommunicationControl;
import mobilepoll.data.model.GpsData;
import mobilepoll.data.model.MobileDeviceInsurance;
import mobilepoll.data.model.MobileDeviceInvoice;
import mobilepoll.data.model.MobileDeviceType;
import mobilepoll.data.model.MobileDeviceWarranty;
import mobilepoll.data.model.Model;
import mobilepoll.utils.CollectionUtils;

/**
 * Classe persistente para registro de dispositivos mõveis dos clientes
 * @author alira
 */
@Entity
@Table(name = "DispositivoMovel")
public class MobileDevice
{
    /** Inicialização dos campos da classe */
    private void DoInit()
    {
        if(this.communicationControlList == null)
        {
            this.communicationControlList = new ArrayList<CommunicationControl>();
        }
        
        if(this.gpsDataList == null)
        {
            this.gpsDataList = new ArrayList<GpsData>();
        }
        
        if(this.researchs == null)
        {
            this.researchs = new ArrayList<Research>();
        }
        
        if(this.warrantyList == null)
        {
            this.warrantyList = new ArrayList<MobileDeviceWarranty>();
        }
        
        if(this.mobileDeviceInsuranceList == null)
        {
            this.mobileDeviceInsuranceList = new ArrayList<MobileDeviceInsurance>();
        }
    }
    
    /** Construtor */
    public MobileDevice()
    {
        this.DoInit();
    }
    
    /**
     * Construtor
     * @param client Cliente dono do dispositivo móvel
     */
    public MobileDevice(Client client)
    {
        this.DoInit();
        this.client = client;
    }
    
    /**
     * Construtor
     * @param model Modelo do dispositivo móvel
     */
    public MobileDevice(Model model)
    {
        this.DoInit();
        this.mobileDeviceModel = model;
    }
    
    /** Id da tabela */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    long id;
    /** GET para o id da tabela */
    public long getId() { return id; }
    /** SET para o id da tabela */
    public void setId(long id) { this.id = id; }
    
    /** Chave pública identificadora do dispositivo móvel */
    @Column(name = "ChaveDispositivoMovel", length = 50, nullable = false, unique = true)
    String key;
    /** GET para a a chave pública identificadora do dispositivo móvel */
    public String getKey() { return key; }
    /** SET para a chave pública identificadora do dispositiov móvel */
    public void setKey(String key) { this.key = key; }
    
    /** Cliente dono do dispositivo móvel */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Cliente", nullable = false)
    Client client;
    /** GET para o cliente dono do dispositivo móvel */
    public Client getClient() { return client; }
    /** SET para o cliente dono do dispositivo móvel */
    public void setClient(Client client) { this.client = client; }
    
    /** Modelo do dispositivo móvel */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ModeloDeDispositivoMovel", nullable = true)
    Model mobileDeviceModel;
    /** GET para o modelo do dispositivo móvel */
    public Model getMobileDeviceModel() { return this.mobileDeviceModel; }
    /** SET para o modelo do dispositivo móvel */
    public void setMobileDeviceModel(Model model) { this.mobileDeviceModel = model; }
    
    /** Tipo do dispositivo móvel */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TipoDispositivoMovel", nullable = false)
    MobileDeviceType mobileDeviceType;
    /** GET para o tipo do dispositivo móvel */
    public MobileDeviceType getMobileDeviceType() { return this.mobileDeviceType; }
    /** SET para o tipo do dispositivo móvel */
    public void setMobileDeviceType(MobileDeviceType mType) { this.mobileDeviceType = mType; }
    
    /** Número da nota fiscal de compra do dispositivo móvel */
    @Column(name = "NumeroNotaFiscal", length = 50, nullable = true)
    String taxInvoiceNumber;
    /** GET para o número da nota fiscal de compra do dispositivo móvel */
    public String getTaxInvoiceNumber() { return this.taxInvoiceNumber; }
    /** SET para o número da nota fiscal de compra do dispositivo móvel */
    public void setTaxInvoiceNumber(String number) { this.taxInvoiceNumber = number; }
    
    /**
     * Número de série do dispositivo móvel
     * 
     * IMEI = International Mobile Equipment Identity
     */
    @Column(name = "IMEI", length = 20, nullable = true)
    String imei;
    /** GET para o número de série do dispositivo móvel */
    public String getImei() { return imei; }
    /** SET para o número de série do dispositivo móvel */
    public void setImei(String imei) { this.imei = imei; }
    
    /** Tipos de rede de comunicação suportadas */
    @Column(name = "RedesSuportadas", length = 200, nullable = true)
    String supportedNetworkList;
    /** GET para os tipos de rede de comunicação suprotados */
    public String getSupportedNetworkList() { return this.supportedNetworkList; }
    /** SET para os tipos de rede de comunicação suportados */
    public void setSupportedNetworkList(String snList) { this.supportedNetworkList = snList; }
    
    /** Usuário responsável pelo registro do dispositivo móvel */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UsuarioResponsavelPeloRegistro", nullable = false)
    User owner;
    /** GET para o usuário responsável pelo registro do dispositivo móvel */
    public User getOwner() { return owner; }
    /** SET para o usuário responsável pelo registro do dispositivo móvel */
    public void setOwner(User owner) { this.owner = owner; }
    
    /** Data e hora da inserção do registro no banco  */
    @Column(name = "DataHoraRegistro", columnDefinition = "datetime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date registerDateTime;
    /** GET para a data e hora da inserção do registro no banco */
    public Date getRegisterDateTime() { return this.registerDateTime; }
    /** SET para a data e hora da inserção do registro no banco */
    public void setRegisterDateTime(Date dateTime) { this.registerDateTime = dateTime; }
    
    @Column(name = "DataHoraExclusao", nullable = true, columnDefinition = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    Date deleteDateTime;
    public Date getDeleteDateTime() { return this.deleteDateTime; }
    public void setDeleteDateTime(Date dt) { this.deleteDateTime = dt; }
    
    /** Chave pública identificadora da ação de exclusão do registro */
    @Column(name = "ChaveExclusao", length = 64, nullable = true)
    String deleteKey;
    /** GET para a chave pública identificadora da ação de exclusão */
    public String getDeleteKey() { return this.deleteKey; }
    /** SET para a chave pública identificadorada ação d
    public void setDeleteKey(String dKey) { this.deleteKey = dKey; }
    
    /** Dados GPS coletados do dispositivo móvel */
    @OneToMany(cascade = CascadeType.ALL,
               mappedBy = "mobileDevice",
               targetEntity = GpsData.class,
               fetch = FetchType.LAZY)
    List<GpsData> gpsDataList;
    /** GET para os dados GPS coletados do dispositivo móvel */
    public List<GpsData> getGpsDataList() { return gpsDataList; }
    /** SET para os dados GPS coletados do dispositivo móvel */
    public void setGpsDataList(List<GpsData> gdl) { this.gpsDataList = gdl; }
    
    /** Listagem de pesquisas na memória deste dispositivo móvel */
    @ManyToMany(fetch = FetchType.LAZY,
                mappedBy = "mobileDevices")
    List<Research> researchs;
    /** GET para a listagem de pesquisas na memória deste dispositivo móvel */
    public List<Research> GetResearchList() { return researchs; }
    /** SET para a listagem de pesquisas na memória desde dispositivo móvel */
    public void setResearchList(List<Research> rl) { this.researchs = rl; }
    
    /** Histórico de comunicações deste dispositivo móvel com o servidor */
    @OneToMany(cascade = CascadeType.ALL,
               fetch = FetchType.LAZY,
               mappedBy = "mobileDevice",
               targetEntity = CommunicationControl.class)
    List<CommunicationControl> communicationControlList;
    /** GET para o histórico de comunicações deste dispositivo com o servicor */
    public List<CommunicationControl> getCommunicationControlList() { return communicationControlList; }
    /** SET para o histórico de comunicações deste dispositivo com o servidor */
    public void setCommunicationControlList(List<CommunicationControl> ccList) { this.communicationControlList = ccList; }
    
    /** Histórico de garantias do dispositivo móvel */
    @OneToMany(cascade = CascadeType.ALL,
               mappedBy = "mobileDevice",
               fetch = FetchType.LAZY,
               targetEntity = MobileDeviceWarranty.class)
    List<MobileDeviceWarranty> warrantyList;
    /** GET para o histórico de garantias do dispositivo móvel */
    public List<MobileDeviceWarranty> getWarrantyList() { return warrantyList; }
    /** SET para o histórico de garantias do dispositivo móvel */
    public void setWarrantyList(List<MobileDeviceWarranty> wL) { this.warrantyList = wL; }
    
    /** Dados da nota de compra deste dispositivo móvel */
    @OneToOne(cascade = CascadeType.ALL,
              mappedBy = "mobileDevice")
    MobileDeviceInvoice invoiceData;
    /** GET para os dados da nota de compra desde dispositivo móvel */
    public MobileDeviceInvoice getInvoiceData() { return invoiceData; }
    /** SET para os dados da nota de compra deste dispositivo móvel */
    public void setInvoiceData(MobileDeviceInvoice iData) { this.invoiceData = iData; }
    
    /** Histórico de seguros contratados para este dispositivo */
    @OneToMany(fetch = FetchType.LAZY,
               cascade = CascadeType.ALL,
               mappedBy = "mobileDevice")
    List<MobileDeviceInsurance> mobileDeviceInsuranceList;
    /** GET para o histórico de seguros contratados para este dispositivo */
    public List<MobileDeviceInsurance> getMobileDeviceInsuranceList() { return this.mobileDeviceInsuranceList; }
    /** SET para o histórico de seguros contratados para este dispositivo */
    public void setMobileDeviceInsuranceList(List<MobileDeviceInsurance> mdiList) { this.mobileDeviceInsuranceList = mdiList; }
    
    /** Evento executado imediatamente antes de persistir os dados pro banco. */
    @PrePersist
    private void prePersist() throws Exception
    {
        if(this.key == null || this.key.isEmpty())
        {
            this.key = UUID.randomUUID().toString();
        }
        
        if(this.registerDateTime == null)
        {
            // Marcando a datya e hora da criação do registro.
            // Se é atualização, esta data e hora não será nula
            this.registerDateTime = new Date();
        }
        
        List<String> errorList = new ArrayList<String>();
        
        if(this.owner == null)
        {
            errorList.add("Erro ao registrar o usuário responsável pelo registro do dispositivo móvel.");
        }
        
        if(this.client == null)
        {
            errorList.add("O cliente dono do dispositivo móvel deve ser fornecido.");
        }
        
        if(errorList.isEmpty() == false)
        {
            throw new Exception("Erros ocorridos ao persistir os dados do dispositivo móvel pro banco: " + CollectionUtils.StringListToString(errorList));
        }
    }
}
