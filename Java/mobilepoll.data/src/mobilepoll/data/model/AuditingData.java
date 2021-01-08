package mobilepoll.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Controle de retirada de dispositivo para auditoria
 * @author alira
 */
@Entity
@Table(name = "DadosAuditoria")
public class AuditingData
{
    /** Construtor */
    public AuditingData() { }
    
    /**
     * Construtor
     * @param auditor Responsável pela auditoria
     */
    public AuditingData(Persona auditor)
    {
        this.auditor = auditor;
    }
    
    /**
     * Construtor
     * @param auditor Responsável pela auditoria
     * @param result Resultado da auditoria
     */
    public AuditingData(Persona auditor, String result)
    {
        this.auditor = auditor;
        this.auditResult = result;
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
    
    /** Responsável por fazer a auditoria */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ResponsavelPelaAuditoria", nullable = false)
    Persona auditor;
    /** GET para o responsável por realizar a auditoria */
    public Persona getAuditor() { return auditor; }
    /** SET para o responsável por realizar a auditoria */
    public void setAuditor(Persona auditor) { this.auditor = auditor; }
    
    /** Resultado da auditoria */
    @Column(name = "ResultadoAuditoria", length = 1500, nullable = true)
    String auditResult;
    /** GET para o resultado da auditoria */
    public String getAuditResult() { return this.auditResult; }
    /** SET para o resultado da auditoria */
    public void setAuditResult(String result) { this.auditResult = result; }
    
    /** Flag indicador da necessidade de realizar reparo no dispositivo */
    @Column(name = "RequerManutencao", columnDefinition = "TINYINT", nullable = false, length = 1)
    boolean requiresMaintenance;
    /** GET para o flag indicador da necessidade de realizar reparo no dispositivo */
    public boolean isRequiresMaintenance() { return this.requiresMaintenance; }
    /** SET para o flag indicador da necessidade de realizar reparo no dispositivo */
    public void setRequiresMaintenance(boolean requires) { this.requiresMaintenance = requires; }
    
    /** Flag indicador da necessidade de remoção (dispositivo inutilizável) */
    @Column(name = "RequerDescarte", nullable = false, columnDefinition = "TINYINT", length = 1)
    boolean requiresDisposal;
    /** GET para o flag indicador da necessidade de remoção do dispositivo por inutilização do mesmo */
    public boolean isRequiresDisposal() { return this.requiresDisposal; }
    /** SET para o flag indicador da necessidade de remoção do dispositivo por inutilização do mesmo */
    public void setRequiresDisposal(boolean requires) { this.requiresDisposal = requires; }
}
