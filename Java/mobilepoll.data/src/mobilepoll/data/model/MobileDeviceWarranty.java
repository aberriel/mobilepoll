package mobilepoll.data.model;

import mobilepoll.data.model.enums.WarrantyOriginType_Tp;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe persistente do hibernate para garantias de dispositivos móveis.
 * 
 * A garantia, aqui, é entendida como um contrato de serviço, onde podem haver vários dispositivos
 * cobertos.
 * @author anselmoberriel
 */
@Entity
@Table(name = "GarantiaDispositivoMovel")
public class MobileDeviceWarranty
{
    private void DoInit()
    {
        if(this.associatedMobileDeviceList == null)
        {
            this.associatedMobileDeviceList = new ArrayList<MobileDeviceInvoice>();
        }
        
        this.warrantyOriginType = WarrantyOriginType_Tp.None;
    }
    
    /** Construtor */
    public MobileDeviceWarranty()
    {
        this.DoInit();
    }
    
    public MobileDeviceWarranty(String contractNumber)
    {
        this.DoInit();
        this.warrantyContractNumber = contractNumber;
    }
    
    public MobileDeviceWarranty(MobileDevice mobileDevice)
    {
        this.DoInit();
        this.mobileDevice = mobileDevice;
    }
    
    public MobileDeviceWarranty(MobileDevice device, String contractNumber)
    {
        this.DoInit();
        this.mobileDevice = device;
        this.warrantyContractNumber = contractNumber;
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
    
    /** Número do contrato de aquisição da garantia, para garantia adquirida separadamente */
    @Column(name = "NumeroContratoGarantia", length = 50, nullable = true)
    String warrantyContractNumber;
    /** GET para o número do contrato de aquisição da garantia, para garantia adquirida separadamente */
    public String getWarrantyContractNumber() { return warrantyContractNumber; }
    /** SET para o número do contrato de aquisição da garantia, para garantia adquirida separadamente */
    public void setWarrantyContractNumber(String number) { this.warrantyContractNumber = number; }
    
    /** Origem da garantia */
    @Column(name = "TipoDeOrigemDeGarantia", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    WarrantyOriginType_Tp warrantyOriginType;
    /** GET para o tipo de origem da garantia */
    public WarrantyOriginType_Tp getWarrantyOriginType() { return warrantyOriginType; }
    /** SET para o tipo de origem da garantia */
    public void setWarrantyOriginType(WarrantyOriginType_Tp type) { this.warrantyOriginType = type; }
    
    /** Dispositivo móvel ao qual se aplica a garantia */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DispositivoMovel", nullable = false)
    MobileDevice mobileDevice;
    /** GET para o dispositivo móvel ao qual se aplica a garantia */
    public MobileDevice getMobileDevice() { return mobileDevice; }
    /** SET para o dispositivo móvel ao qual se aplica a garantia */
    public void setMobileDevice(MobileDevice mDevice) { this.mobileDevice = mDevice; }
    
    /**
     * Contrato de seguro do qual se origina a garantia (para garantia adquirida
     * por intermédio de seguro
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ContratoDeSeguro", nullable = true)
    InsuranceContract insuranceContract;
    /** GET para o contrato de seguro do qual se origina a garantia */
    public InsuranceContract getInsuranceContract() { return this.insuranceContract; }
    /** SET para o contrato de seguro do qual se origina a garantia */
    public void setInsuranceContract(InsuranceContract ic) { this.insuranceContract = ic; }
    
    /** Data e hora do início da vigência da garantia */
    @Column(name = "DataHoraInicio", columnDefinition = "datetime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date initDateTime;
    /** GET para a data e hora do início da vigência da garantia */
    public Date getInitDateTime() { return initDateTime; }
    /** SET para a data e hora do início da vigência da garantia */
    public void setInitDateTime(Date dt) { this.initDateTime = dt; }
    
    /** Data e hora do término da vigência prevista */
    @Column(name = "DataHoraTerminoPrevisto", columnDefinition = "datetime", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    Date expectedFinishDateTime;
    /** GET para a data e hora do término da vigencia prevista */
    public Date getExpectedFinishDateTime() { return this.expectedFinishDateTime; }
    /** SET para a data e hora do término da vigência prevista */
    public void setExpectedFinishDateTime(Date dt) { this.expectedFinishDateTime = dt; }
    
    /** Data e hora do término real da garantia */
    @Column(name = "DataHoraTerminoReal", columnDefinition = "datetime", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    Date realFinishDateTime;
    /** GET para a data e hora do término real da garantia */
    public Date getRealFinishDateTime() { return this.realFinishDateTime; }
    /** SET para a data e hora do término real da garantia */
    public void setRealFinishDateTime(Date dt) { this.realFinishDateTime = dt; }
    
    /** Descritivo do motivo do término da garantia */
    @Column(name = "MotivoTermino", columnDefinition = "text", nullable = true)
    String finishReason;
    /** GET para o descritivo do término da garantia */
    public String getFinishReason() { return this.finishReason; }
    /** SET para o descritivo do término da garantia */
    public void setFinishReason(String reason) { this.finishReason = reason; }
    
    /** Valor da garantia, para o caso de contratada à parte */
    @Column(name = "Valor", columnDefinition = "decimal(15,2)", nullable = true)
    Double value;
    /** GET para o valor da garantia */
    public Double getValue() { return value; }
    /** SET para o valor da garantia */
    public void setValue(Double value) { this.value = value; }
    
    /** Lista de dispositivos móveis associados a esta garantia via nota fiscal de compra. */
    @OneToMany(cascade = CascadeType.ALL,
               fetch = FetchType.LAZY,
               mappedBy = "warranty")
    List<MobileDeviceInvoice> associatedMobileDeviceList;
    /** GET para a lista de dispositivos associados a esta garantia via nota fiscal de compra. */
    public List<MobileDeviceInvoice> getAssociatedMobileDeviceList() { return associatedMobileDeviceList; }
    /** SET para a lista de dispositivos associados a esta garantia via nota fiscal de compra. */
    public void setAssociatedMobileDeviceList(List<MobileDeviceInvoice> amdList) { this.associatedMobileDeviceList = amdList; }
}
