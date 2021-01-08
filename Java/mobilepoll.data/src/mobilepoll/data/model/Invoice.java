package mobilepoll.data.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe persistente do hibernate para notas fiscais de dispositivos móveis
 * @author alira
 */
@Entity
@Table(name = "NotaFiscal")
public class Invoice
{
    private void DoInit()
    {
        if(this.associatedMobileDeviceList == null)
        {
            this.associatedMobileDeviceList = new ArrayList<MobileDeviceInvoice>();
        }
        
        if(this.dateTime == null)
        {
            this.dateTime = new Date();
        }
    }
    
    /** Construtor */
    public Invoice()
    {
        this.DoInit();
    }
    
    /**
     * Construtor
     * @param client Cliente para o qual a nota foi emitida (quem realizou a compra)
     */
    public Invoice(Client client)
    {
        this.DoInit();
        this.client = client;
    }
    
    /**
     * Construtor
     * @param provider Empresa que emitiu a nota (onde a compra foi realizada)
     */
    public Invoice(MobileDeviceProvider provider)
    {
        this.DoInit();
        this.provider = provider;
    }
    
    /**
     * Construtor
     * @param client Cliente para o qual a nota foi emitida (quem realizou a compra)
     * @param provider Empresa que emitiu a nota (onde a compra foi realizada)
     */
    public Invoice(Client client, MobileDeviceProvider provider)
    {
        this.DoInit();
        this.client = client;
        this.provider = provider;
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
    
    /** Cliente que adquiriu o(s) dispositivo(s) móvel(is) */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Cliente", nullable = false)
    Client client;
    /** GET para o cliente que adquiriu o(s) dispositivo(s) móvel(is) */
    public Client getClient() { return client; }
    /** SET para o cliente que adquiriu o(s) dispositivo(s) móvel(is) */
    public void setClient(Client client) { this.client = client; }
    
    /** Empresa que emitiu a nota (onde ocorreu a compra) */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FornecedorDeDispositivoMovel", nullable = false)
    MobileDeviceProvider provider;
    /** GET para a empresa que emitiu a nota (onde ocorreu a compra) */
    public MobileDeviceProvider getProvider() { return provider; }
    /** SET para a empresa que emitiu a nota (onde ocorreu a compra) */
    public void setProvider(MobileDeviceProvider provider) { this.provider = provider; }
    
    /** Número da nota fiscal */
    @Column(name = "Numero", length = 40, nullable = false)
    String invoiceNumber;
    /** GET para o número da nota fiscal */
    public String getInvoiceNumber() { return this.invoiceNumber; }
    /** SET para o número da nota fiscal */
    public void setInvoiceNumber(String number) { this.invoiceNumber = number; }
    
    /** Código de autorização para emissão de nota pelo fornecedor */
    @Column(name = "ProtocoloAutorizacaoUso", length = 40, nullable = true)
    String usageAuthorizationProtocol;
    /** GET para o código de autorização para emissão de nota pelo fornecedor */
    public String getUsageAuthorizationProtocol() { return this.usageAuthorizationProtocol; }
    /** SET para o código de autorização para emissão de nota pelo fornecedor */
    public void setUsageAuthorizationProtocol(String protocolNumber) { this.usageAuthorizationProtocol = protocolNumber; }
    
    /** Data e hora da emissão da nota */
    @Column(name = "DataHora", nullable = false, columnDefinition = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    Date dateTime;
    /** GET para a data e hora da emissão da nota */
    public Date getDateTime() { return dateTime; }
    /** SET para a data e hora da emissão da nota */
    public void setDateTime(Date dateTime) { this.dateTime = dateTime; }
    
    /** Listagem de dispositivos móveis nesta nota */
    @OneToMany(cascade = CascadeType.ALL,
               fetch = FetchType.LAZY,
               mappedBy = "invoice",
               targetEntity = MobileDeviceInvoice.class)
    List<MobileDeviceInvoice> associatedMobileDeviceList;
    /** GET para a listagem de dispositivos móveis nesta nota */
    public List<MobileDeviceInvoice> getAssociatedMobileDeviceList() { return associatedMobileDeviceList; }
    /** SET para a listagem de dispositivos móveis nesta nota */
    public void setAssociatedMobileDeviceList(List<MobileDeviceInvoice> amdList) { this.associatedMobileDeviceList = amdList; }
    
    /** Evento de salvamento do objeto no banco */
    @PrePersist
    private void onSave() throws Exception
    {
        if(this.client == null)
        {
            throw new Exception("Não foi possível salvar a nota fiscal, pois um cliente não foi fornecido.");
        }
    }
}
