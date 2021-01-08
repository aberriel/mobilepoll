package mobilepoll.data.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * Contrato de aquisição de seguro para dispositivo móvel
 * @author alira
 */
@Entity
@Table(name = "ContratoSeguro")
public class InsuranceContract
{
    private void DoInit()
    {
        if(this.mobileDeviceWarrantyList == null)
        {
            this.mobileDeviceWarrantyList = new ArrayList<MobileDeviceWarranty>();
        }
        
        if(this.deviceList == null)
        {
            this.deviceList = new ArrayList<MobileDeviceInsurance>();
        }
    }
    
    /** Construtor */
    public InsuranceContract()
    {
        this.DoInit();
    }
    
    /**
     * Construtor
     * @param client Cliente que fez o seguro
     */
    public InsuranceContract(Client client)
    {
        this.DoInit();
        this.client = client;
    }
    
    /**
     * Construtor
     * @param iCompany Companhia de seguro com a qual foi feito o contrato
     */
    public InsuranceContract(InsuranceCompany iCompany)
    {
        this.DoInit();
        this.insuranceCompany = iCompany;
    }
    
    /**
     * Construtor
     * @param client Cliente que fez o contrato
     * @param iCompany Companhia de seguro com a qual o contrato foi feito
     */
    public InsuranceContract(Client client, InsuranceCompany iCompany)
    {
        this.DoInit();
        this.client = client;
        this.insuranceCompany = iCompany;
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
    
    /** Cliente que adquiriu o seguro */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente", nullable = false)
    Client client;
    /** GET para o cliente que adquiriu o seguro */
    public Client getClient() { return client; }
    /** SET para o cliente que adquiriu o seguro */
    public void setClient(Client client) { this.client = client; }
    
    /** Companhia de seguro */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Seguradora", nullable = false)
    InsuranceCompany insuranceCompany;
    /** GET para a companhia de seguro */
    public InsuranceCompany getInsuranceCompany() { return this.insuranceCompany; }
    /** SET para a companhia de seguro */
    public void setInsuranceCompany(InsuranceCompany iCompany) { this.insuranceCompany = iCompany; }
    
    /** Número do contrato de seguro */
    @Column(name = "NumeroContrato", length = 50)
    String contractNumber;
    /** GET para o número do contrato de seguro */
    public String getContractNumber() { return this.contractNumber; }
    /** SET para o número do contrato de seguro */
    public void setContractNumber(String cNumber) { this.contractNumber = cNumber; }
    
    /** Sinistros cobertos pelo contrato */
    @Column(name = "SinistrosCobertos", length = 20)
    String lossCoveredByInsurance;
    /** GET para os sinistros cobertos pelo contrato */
    public String getLossCoveredByInsurance() { return this.lossCoveredByInsurance; }
    /** SET para os sinistros cobertos pelo contrato */
    public void setLossCoveredByInsurance(String lossArray) { this.lossCoveredByInsurance = lossArray; }
    
    /** Valor do seguro adquirido */
    @Column(name = "Valor", columnDefinition = "decimal(15,2)", nullable = true)
    double value;
    /** GET para o valor do seguro adquirido */
    public double getValue() { return value; }
    /** SET para o valor do seguro adquirido */
    public void setValue(double value) { this.value = value; }
    
    /** Data e hora da criação do registro no banco */
    @Column(name = "DataHoraRegistro")
    @Temporal(TemporalType.TIMESTAMP)
    Date registerDateTime;
    /** GET para a data e hora da criação do registro no banco */
    public Date getRegisterDateTime() { return this.registerDateTime; }
    /** SET para a data e hora da criação do registro no banco */
    public void setRegisterDateTime(Date dateTime) { this.registerDateTime = dateTime; }
    
    /** Data de início de vigência do contrato */
    @Column(name = "DataHoraContratacao", nullable = true)
    @Temporal(TemporalType.DATE)
    Date hiringDateTime;
    /** GET para a data de início de vigência do contrato */
    public Date getHiringDatetime() { return this.hiringDateTime; }
    /** SET para a data de início de vigência do contrato */
    public void setHiringDateTime(Date dateTime) { this.hiringDateTime = dateTime; }
    
    /** Data e hora do término do contrato previsto */
    @Column(name = "DataHoraTerminoPrevisao", nullable = true)
    @Temporal(TemporalType.DATE)
    Date expectedFinishDateTime;
    /** GET para a data e hora do término do contrato previsto */
    public Date getExpectedFinishDateTime() { return this.expectedFinishDateTime; }
    /** SET para a data e hora do término do contrato previsto */
    public void setExpectedFinishDateTime(Date dateTime) { this.expectedFinishDateTime = dateTime; }
    
    /**
     * Data e hora do término real do contrato.
     * O contrato pode terminar antes por violação de termos contratuais ou por resgate do
     * seguro devido a perda ou roubo.
     */
    @Column(name = "DataHoraTerminoReal", nullable = true)
    @Temporal(TemporalType.DATE)
    Date realFinishDateTime;
    /** GET para a data e hora do término real do contrato */
    public Date getRealFinishDateTime() { return this.realFinishDateTime; }
    /** SET para a data e hora do término real do contrato */
    public void setRealFinishDateTime(Date dateTime) { this.realFinishDateTime = dateTime; }
    
    /** Comentários e/ou observações pertinentes. */
    @Column(name = "Observacoes", length = 3000, nullable = true)
    String comments;
    /** GET para os comentários e/ou observações pertinentes */
    public String getComments() { return comments; }
    /** SET para os comentários e/ou observações pertinentes */
    public void setComments(String comments) { this.comments = comments; }
    
    /** Coleção de garantias adquiridas com esse seguro */
    @OneToMany(fetch = FetchType.LAZY,
               cascade = CascadeType.ALL,
               mappedBy = "insuranceContract")
    List<MobileDeviceWarranty> mobileDeviceWarrantyList;
    /** GET para a coleção de garantias adquiridas com esse seguro */
    public List<MobileDeviceWarranty> getMobileDeviceWarrantyList() { return this.mobileDeviceWarrantyList; }
    /** SET para a coleção de arantias adquiridas com esse seguro */
    public void setMobileDeviceWarrantyList(List<MobileDeviceWarranty> mdwList) { this.mobileDeviceWarrantyList = mdwList; }
    
    /** Dispositivos cobertos por esse contrato */
    @OneToMany(fetch = FetchType.LAZY,
               cascade = CascadeType.ALL,
               mappedBy = "insuranceContract")
    List<MobileDeviceInsurance> deviceList;
    /** GET para a lista de dispositivos cobertos por esse contrato */
    public List<MobileDeviceInsurance> getDeviceList() { return deviceList; }
    /** SET para a lista de dispositivos cobertos por esse contrato */
    public void setDeviceList(List<MobileDeviceInsurance> dList) { this.deviceList = dList; }
    
    @PrePersist
    private void onSave()
    {
        if(this.registerDateTime == null)
        {
            this.registerDateTime = new Date();
        }
    }
}