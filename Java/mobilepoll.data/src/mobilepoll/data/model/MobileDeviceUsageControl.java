package mobilepoll.data.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * Core do gerenciamento de utilização dos dispositivos
 * @author alira
 */
@Entity
@Table(name = "ControleUsoDM")
public class MobileDeviceUsageControl
{
    private void doInit()
    {
        if(this.remoteUseHistory == null)
        {
            this.remoteUseHistory = new ArrayList<MobileDeviceRemoteUse>();
        }
    }
    
    /** Construtor */
    public MobileDeviceUsageControl()
    {
        this.doInit();
    }
    
    /**
     * Construtor
     * @param device Dispositivo móvel cujo uso está sendo registrado
     */
    public MobileDeviceUsageControl(MobileDevice device)
    {
        this.doInit();
        this.mobileDevice = device;
    }
    
    /**
     * Construtor
     * @param device Dispositivo móvel cujo uso está sendo registradp
     * @param type Tipo do uso empregado
     */
    public MobileDeviceUsageControl(MobileDevice device, MobileDeviceUsageType type)
    {
        this.doInit();
        this.mobileDevice = device;
        this.usageType = type;
    }
    
    /**
     * Construtor - para o registro de auditoria
     * @param device Dispositivo móvel auditado
     * @param usageData Dados da auditoria realizada
     */
    public MobileDeviceUsageControl(MobileDevice device, AuditingData usageData)
    {
        this.doInit();
        this.mobileDevice = device;
        this.outletDataForAuditing = usageData;
    }
    
    /**
     * Construtor - para o registro de retirada para manutenção
     * @param device Dispositivo móvel retirado para manutenção e/ou reparo
     * @param usageData Dados da manutenção feita
     */
    public MobileDeviceUsageControl(MobileDevice device, MaintenanceData usageData)
    {
        this.doInit();
        this.mobileDevice = device;
        this.outletDataForMaintenance = usageData;
    }
    
    /**
     * Construtor - para o caso de registro de saída para enquete
     * @param device Dispositivo móvel que foi retirado para a realização de enquete
     * @param usageData Dados da retirada (funcionário responsável, etc)
     */
    public MobileDeviceUsageControl(MobileDevice device, OutForPollData usageData)
    {
        this.doInit();
        this.mobileDevice = device;
        this.outletDataForPoll = usageData;
    }
    
    /**
     * Construtor - para o caso de registro de remoção de dispositivo
     * @param device Dispositivo móvel que está sendo desativado por
     *               perda ou roubo
     * @param usageData Dados da causa da desativação do dispositivo
     */
    public MobileDeviceUsageControl(MobileDevice device, RemovalData usageData)
    {
        this.doInit();
        this.mobileDevice = device;
        this.outletDataForRemoval = usageData;
    }
    
    /** Identificador único do registro no banco */
    @Id
    @Column(name = "Id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    /** GET para o identificador único do registro no banco */
    public long getId() { return id; }
    /** SET para o identificador único do registro no banco */
    public void setId(long id) { this.id = id; }
    
    /** Comentários e/ou observações pertinentes */
    @Column(name = "Comentarios", length = 3000, nullable = true)
    String comments;
    /** GET para os comentários e/ou observações pertinentes */
    public String getComments() { return comments; }
    /** SET para os comentários e/ou observações pertinentes */
    public void setComments(String comments) { this.comments = comments; }
    
    /** Funcionário responsável pelo dispositivo */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FuncionarioResponsavel", nullable = false)
    User officerResponsibleForDevice;
    /** GET para o funcionário responsável pelo dispositivo */
    public User getOfficerResponsibleForDevice() { return this.officerResponsibleForDevice; }
    /** SET para o funcionário responsável pelo dispositivo */
    public void setOfficerResponsibleForDevice(User responsibleUser) { this.officerResponsibleForDevice = responsibleUser; }
    
    /** Usuário responsável pelo registro da movimentação no sistema */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UsuarioResponsavelPeloRegistro", nullable = false)
    User userResponsibleForRegistration;
    /** GET para o usuário responsável pelo registro da movimentação no sistema */
    public User getUserResponsibleForRegistration() { return this.userResponsibleForRegistration; }
    /** SET para o usuário responsável pelo registro da movimentação no sistema */
    public void setUserResponsibleForRegistration(User responsibleUser) { this.userResponsibleForRegistration = responsibleUser; }
    
    /** Dispositivo móvel ao qual pertence o registro de histórico de uso */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DispositivoMovel", nullable = false)
    MobileDevice mobileDevice;
    /** GET para o dispositivo móvel ao qual pertence o registro de histórico de uso */
    public MobileDevice getMobileDevice() { return this.mobileDevice; }
    /** SET para o dispositivo móvel ao qual pertence o registro de histórico de uso */
    public void setMobileDevice(MobileDevice mobileDevice) { this.mobileDevice = mobileDevice; }
    
    /** Data e hora de retirada do dispositivo para uso */
    @Column(name = "DataHoraSaida_DM")
    @Temporal(TemporalType.TIMESTAMP)
    Date withdrawalDateTime;
    /** GET para a data e hora de retirada do dispositivo para uso */
    public Date getWithdrawalDateTime() { return this.withdrawalDateTime; }
    /** SET para a data e hora de retirada do dispositivo para uso */
    public void setWithdrawalDateTime(Date dateTime) { this.withdrawalDateTime = dateTime; }
    
    /** Data e hora de devolução do dispositivo */
    @Column(name = "DataHoraDevolucao_DM")
    @Temporal(TemporalType.TIMESTAMP)
    Date returnDateTime;
    /** GET para a data e hora de devolução do dispositivo */
    public Date getReturnDateTime() { return this.returnDateTime; }
    /** SET para a data e hora de devolução do dispositivo */
    public void setReturnDateTime(Date dateTime) { this.returnDateTime = dateTime; }
    
    /**
     * Tipo do uso empregado, com os dados associados.
     * Dentre os dados associados, temos a tolerância máxima para devolução.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TipoDeUsoDoDispositivoMovel", nullable = true)
    MobileDeviceUsageType usageType;
    /** GET para o tipo do uso empregado */
    public MobileDeviceUsageType getUsageType() { return this.usageType; }
    /** SET para o tipo do uso empregado */
    public void setUsageType(MobileDeviceUsageType type) { this.usageType = type; }
    
    /** Dados de retirada para a realização de auditoria */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DadosDeSaidaParaAuditoria", nullable = true)
    AuditingData outletDataForAuditing;
    /** GET para os dados de retirada para realização de auditoria */
    public AuditingData getOutletDataForAuditing() { return this.outletDataForAuditing; }
    /** SET para os dados de retirada para realização de auditoria */
    public void setOutletDataForAuditing(AuditingData data) { this.outletDataForAuditing = data; }
    
    /** Dados de retirada para a realização de manutenção */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DadosDeSaidaParaManutencao", nullable = true)
    MaintenanceData outletDataForMaintenance;
    /** GET para os dados de retirada para a realização de manutenção */
    public MaintenanceData getOutletDataForMaintenance() { return this.outletDataForMaintenance; }
    /** SET para os dados de retirada para a realização de manutenção */
    public void setOutletDataForMaintenance(MaintenanceData data) { this.outletDataForMaintenance = data; }
    
    /** Dados de retirada para a realização de enquete externa */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DadosDeSaidaParaEnquete", nullable = true)
    OutForPollData outletDataForPoll;
    /** GET para os dados de retirada para realização de enquete externa */
    public OutForPollData getOutletDataForPoll() { return this.outletDataForPoll; }
    /** SET para os dados de retirada para realização de enquete externa */
    public void setOutletDataForPoll(OutForPollData data) { this.outletDataForPoll = data; }
    
    /** Dados de desativação do dispositivo por perda, roubo ou descarte */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DadosDeSaidaParaRemocao")
    RemovalData outletDataForRemoval;
    /** GET para os dados de desativação do dispositivo por perda, roubou ou descarte */
    public RemovalData getOutletDataForRemoval() { return this.outletDataForRemoval; }
    /** SET para os dados de desativação do dispositivo por perda, roubo ou descarte */
    public void setOutletDataForRemoval(RemovalData data) { this.outletDataForRemoval = data; }
    
    /**
     * Coleção de acessos remotos do dispositivo ao servidor decorrentes do uso em questão
     */
    @OneToMany(fetch = FetchType.LAZY,
               cascade = CascadeType.ALL,
               mappedBy = "usageControl",
               targetEntity = MobileDeviceRemoteUse.class)
    List<MobileDeviceRemoteUse> remoteUseHistory;
    /** GET para a listagem de acessos remotos do dispositivo ao servidor decorrentes do uso em questão */
    public List<MobileDeviceRemoteUse> getRemoteHistory() { return this.remoteUseHistory; }
    /** SET para a listagem de acessos remotos do dispositivo ao servidor decorrentes do uso em questão */
    public void setRemoteHistory(List<MobileDeviceRemoteUse> ruh) { this.remoteUseHistory = ruh; }
    
    @PrePersist
    private void onSave() throws Exception
    {
        if(this.withdrawalDateTime.after(returnDateTime))
        {
            throw new Exception("A data e hora de retirada o dispositivo para uso não pode ser após a data e hora de retorno do dispositivo.");
        }
    }
}