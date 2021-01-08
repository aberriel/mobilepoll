package mobilepoll.data.model;

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
import org.hibernate.annotations.Type;

/**
 * Dados de controle de saída de dispositivo móvel para reparo e manutenção
 * @author alira
 */
@Entity
@Table(name = "DadosManutencao")
public class MaintenanceData
{
    private void DoInit()
    {
        if(this.initDateTime == null)
        {
            this.initDateTime = new Date();
        }
    }
    
    /** Construtor */
    public MaintenanceData()
    {
        this.DoInit();
    }
    
    /**
     * Construtor
     * 
     * @param initDateTime Data e hora em que se deu início o processo de
     *                     manutenção do dispositivo móvel
     */
    public MaintenanceData(Date initDateTime)
    {
        this.DoInit();
        this.initDateTime = initDateTime;
    }
    
    /** Identificador único do registro no banco */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    long id;
    /** GET para o identidicador único do registro no banco */
    public long getId() { return id; }
    /** SET para o identificador único do registro no banco */
    public void setId(long id) { this.id = id; }
    
    /** Assistência técnica onde se deu o reparo ou manutenção */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Autorizada", nullable = false)
    MobileDeviceTechnicalAssistance technicalAssistance;
    /** GET para a assistência técnica onde se deu o reparo ou manutenção */
    public MobileDeviceTechnicalAssistance getTechnicalAssistance() { return this.technicalAssistance; }
    /** SET para a assistência técnica onde se deu o reparo ou manutenção */
    public void setTechnicalAssistance(MobileDeviceTechnicalAssistance ta) { this.technicalAssistance = ta; }
    
    /** Pessoa responsável pela retirada do dispositivo móvel para manutenção na autorizada */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ResponsavelPelaRetirada", nullable = true)
    Persona personResponsibleForRemoval;
    /** GET para a pessoa responsável pela retirada do dispositivo móvel para manutenção na autorizada */
    public Persona getPersonResponsibleForRemoval() { return this.personResponsibleForRemoval; }
    /** SET para a pessoa responsável pela retirada do dispositivo móvel para manutenção na autorizada */
    public void setPersonResponsibleForRemoval(Persona person) { this.personResponsibleForRemoval = person; }
    
    /**
     * Técnico responsável pela realização do reparo no dispositivo móvel.
     * Para o caso do reparo ser feito dentro da própria empresa
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TecnicoResponsavelPeloReparo", nullable = true)
    Persona personResponsibleForRepair;
    /** GET para a pessoa responsável pela realização do reparo */
    public Persona getPersonResponsibleForRepair() { return this.personResponsibleForRepair; }
    /** SET para a pessoa responsável pela realização do reparo */
    public void setPersonResponsibleForRepair(Persona person) { this.personResponsibleForRepair = person; }
    
    /** Descritivo do serviço realizado */
    @Column(name = "ServicoRealizado", columnDefinition = "datetime", nullable = true)
    String performedService;
    /** GET para o descritivo do serviço realizado */
    public String getPerformedService() { return performedService; }
    /** SET para o descritivo do serviço realizado */
    public void setPErformedService(String pService) { this.performedService = pService; }
    
    /** Pessoa responsável pelo retorno do dispositivo móvel, da assistência técnica à empresa */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ResponsavelPelaDevolucao", nullable = true)
    Persona personResponsibleForReturning;
    /** GET para a pessoa responsável pelo retorno do dispositivo móvel */
    public Persona getPersonResponsibleForReturning() { return this.personResponsibleForReturning; }
    /** SET para a pessoa responsável pelo retorno do dispositivo móvel */
    public void setPersonResponsibleForReturning(Persona person) { this.personResponsibleForReturning = person; }
    
    /** Descritivo do estado de retorno do dispositivo móvel */
    @Column(name = "CondicoesDeRetornoDoDispositivoMovel", columnDefinition = "TEXT", nullable = true)
    String mobileCondition;
    /** GET para o descritivo do estado de retorno do dispositivo móvel */
    public String getMobileCondition() { return mobileCondition; }
    /** SET para o descritivo do estado de retorno do dispositivo móvel */
    public void setMobileCondition(String condition) { this.mobileCondition = condition; }
    
    /** Indicador de cobertura do serviço pela garantia */
    @Column(name = "GarantiaCobriu", nullable = false, columnDefinition = "TINYINT", length = 1)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    boolean warrantyCovers;
    /** GET para o indicador de cobertura do serviço pela garantia */
    public boolean isWarrantyCovers() { return warrantyCovers; }
    /** SET para o indicador de cobertura do serviço pela garantia */
    public void setWarrantyCovers(boolean iwc) { this.warrantyCovers = iwc; }
    
    /** Indicador de descarte do dispositivo móvel (sem reparo) */
    @Column(name = "RequerDescarte", nullable = false, columnDefinition = "TINYINT", length = 1)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    boolean requiresDisposal;
    /** GET para o indicador de descarte do dispositivo móvel (reparo não feito) */
    public boolean isRequiresDisposal() { return requiresDisposal; }
    /** SET para o indicador de descarte do dispositivo móvel (reparo não feito) */
    public void setRequiresDisposal(boolean disposal) { this.requiresDisposal = disposal; }
    
    /** Data e hora de saída do dispositivo móvel para reparo ou manutenção */
    @Column(name = "DataHoraInicio", columnDefinition = "datetime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date initDateTime;
    /** GET para a data e hora de saída do dispositivo móvel para reparo ou manutenção */
    public Date getInitDateTime() { return initDateTime; }
    /** SET para a data e hora de saída do dispositivo móvel para reparo ou manutenção */
    public void setInitDateTime(Date dateTime) { this.initDateTime = dateTime; }
    
    /** Data e hora de retorno do disposito móvel do reparo ou manutenção */
    @Column(name = "DataHoraTermino", columnDefinition = "datetime", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    Date finishDateTime;
    /** GET para a data e hora de retorno do dispositivo móvel do reparou ou manutenção */
    public Date getFinishDateTime() { return finishDateTime; }
    /** SET para a data e hora de retorno do dispositivo móvel do reparo ou manutenção */
    public void setFinishDateTime(Date dateTime) { this.finishDateTime = dateTime; }
    
    /** Data e hora de entrada do dispositivo móvel na autorizada */
    @Column(name = "DataHoraEntradaAutorizada", columnDefinition = "datetime", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    Date technicalAssistanceEntranceDateTime;
    /** GET para a data e hora de entrada do dispositivo móvel na autorizada */
    public Date getTechnicalAssistanceEntranceDateTime() { return technicalAssistanceEntranceDateTime; }
    /** SET para a data e hora de entrada do dispositivo móvel na autorizada */
    public void setTechnicalAssistanceEntranceDateTime(Date dateTime) { this.technicalAssistanceEntranceDateTime = dateTime; }
    
    /** Data e hora de saída do dispositivo móvel da autorizada */
    @Column(name = "DataHoraSaidaAutorizada", columnDefinition = "datetime", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    Date technicalAssistanceOutputDateTime;
    /** GET para a data e hora de saída do dispositivo móvel da autorizada */
    public Date getTechnicalAssistanceOutputDateTime() { return this.technicalAssistanceOutputDateTime; }
    /** SET para a data e hora de saída do dispositivo móvel da autorizada */
    public void setTechnicalAssistanceOutputDateTime(Date dateTime) { this.technicalAssistanceOutputDateTime = dateTime; }
    
    /** Custo do reparo ou manutenção */
    @Column(name = "Valor", columnDefinition = "decimal(15,2)", nullable = true)
    Double value;
    /** GET para o custo do reparo ou manutenção */
    public Double getValue() { return value; }
    /** SET para o custo do reparo ou manutenção */
    public void setValue(Double value) { this.value = value; }
    
    /** Descritivo das causas da manutençã ou reparo */
    @Column(name = "MotivoManutencao", columnDefinition = "TEXT", nullable = true)
    String maintenanceReason;
    /** GET do descritivo das causas da manutenção ou reparo */
    public String getMaintenanceReason() { return maintenanceReason; }
    /** SET do descritivo das causas da manutenção ou reparo */
    public void setMaintenanceReason(String reason) { this.maintenanceReason = reason; }
}
