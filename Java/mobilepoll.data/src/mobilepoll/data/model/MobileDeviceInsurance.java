package mobilepoll.data.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe associativa, que atribui dispositivos a contratos de seguro
 * que cobrem danos e/ou perdas dos mesmos
 * 
 * @author anselmoberriel
 */
@Entity
@Table(name = "SeguroDispositivoMovel")
public class MobileDeviceInsurance
{
    private void doInit() { }
    
    /** Construtor */
    public MobileDeviceInsurance()
    {
        this.doInit();
    }
    
    /**
     * Construtor
     * @param mDevice Dispositivo móvel associado ao contrato de seguro
     */
    public MobileDeviceInsurance(MobileDevice mDevice)
    {
        this.doInit();
        this.mobileDevice = mDevice;
    }
    
    /**
     * Construtor
     * @param iContract Contrato de seguro ao qual o dispositivo móvel foi adicionado
     */
    public MobileDeviceInsurance(InsuranceContract iContract)
    {
        this.doInit();
        this.insuranceContract = iContract;
    }
    
    /**
     * Construtor
     * @param mDevice Dispositivo móvel associado ao contrato de seguro
     * @param iContract Contrato de segudo que é aplicado ao dispositivo móvel
     */
    public MobileDeviceInsurance(MobileDevice mDevice, InsuranceContract iContract)
    {
        this.doInit();
        this.mobileDevice = mDevice;
        this.insuranceContract = iContract;
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
    
    /** Dispositivo móvel associado ao contrato de seguro */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DispositivoMovel", nullable = false)
    MobileDevice mobileDevice;
    /** GET para o dispositivo móvel associado ao contrato de seguro */
    public MobileDevice getMobileDevice() { return mobileDevice; }
    /** SET para o dispositivo móvel associado ao contrato de seguro */
    public void setMobileDevice(MobileDevice mDevice) { this.mobileDevice = mDevice; }
    
    /** Contrato de seguro ao qual o dispositivo foi associado */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ContratoDeSeguro", nullable = false)
    InsuranceContract insuranceContract;
    /** GET para o contrato de seguro ao qual o dispositivo foi associado */
    public InsuranceContract getInsuranceContract() { return this.insuranceContract; }
    /** SET para o contrato de seguro ao qual o dispositivo foi associado */
    public void setInsuranceContract(InsuranceContract iContract) { this.insuranceContract = iContract; }
    
    /** Valor pago pelo dispositivo no seguro */
    @Column(name = "ValorPeloDispositivo", columnDefinition = "decimal(15,2)")
    double valuePerDevice;
    /** GET para o valor pago pelo dispositivo no seguro */
    public double getValuePerDevice() { return this.valuePerDevice; }
    /** SET para o valor pago pelo dispositivo no seguro */
    public void setValuePerDevice(double value) { this.valuePerDevice = value; }
    
    /** Data de início da validade do seguro para o dispositivo */
    @Column(name = "DataHoraInicio", nullable = true)
    @Temporal(TemporalType.DATE)
    Date initDateTime;
    /** GET para a data de início da validade do seguro para o dispositivo */
    public Date getInitDateTime() { return initDateTime; }
    /** SEt para a data de início da validade do seguro para o dispositivo */
    public void setInitDateTime(Date dateTime) { this.initDateTime = dateTime; }
    
    /** Data de término da validade do seguro para o dispositivo */
    @Column(name = "DataHoraTermino", nullable = true)
    @Temporal(TemporalType.DATE)
    Date finishDateTime;
    /** GET para a data de término da validade do seguro para o dispositivo */
    public Date getFinishDateTime() { return finishDateTime; }
    /** SET para a data de término da validade do seguro para o dispositivo */
    public void setFinishDateTime(Date dateTime) { this.finishDateTime = dateTime; }
    
    /** Motivo do término da validade do seguro para o dispositivo */
    @Column(name = "MotivoTermino", length = 1000, nullable = true)
    String finishReason;
    /** GET para o motivo do término da validade do seguro para o dispositivo */
    public String getFinishReason() { return finishReason; }
    /** SET para o motivo do término da validade do seguro para o dispositivo */
    public void setFinishReason(String reason) { this.finishReason = reason; }
}