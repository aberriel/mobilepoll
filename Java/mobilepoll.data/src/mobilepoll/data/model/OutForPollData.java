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
 * Dados de controle de liberação de dispositivo móvel para enquete externa
 * @author alira
 */
@Entity
@Table(name = "DadosSaidaEnquete")
public class OutForPollData
{
    /** Construtor */
    public OutForPollData() { }
    
    /**
     * Construtor
     * @param sc Chip de telefonia utilizado
     */
    public OutForPollData(SimCard sc)
    {
        this.simCard = sc;
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
    
    /** Flag indicador da necessidade de manutenção no retorno */
    @Column(name = "RequerManutencao", nullable = false, columnDefinition = "TINYINT", length = 1)
    boolean requiresMaintenance;
    /** GET para o flag indicador da necessidade de manutenção no retorno */
    public boolean isRequiresMaintenance() { return this.requiresMaintenance; }
    /** SET para o flag indicador da necessidade de manutenção no retorno */
    public void setRequiresMaintenance(boolean requires) { this.requiresMaintenance = requires; }
    
    /** Flag indicador da necessidade de descarte no retorno (dispositivo inutilizável) */
    @Column(name = "RequerDescarte", nullable = false, columnDefinition = "TINYINT", length = 1)
    boolean requiresDisposal;
    /** GET para o flag indicador da necessidade de descarte no retorno (dispositivo inutilizável) */
    public boolean isRequiresDisposal() { return this.requiresDisposal; }
    /** SET para o flag indicador da necessidade de descarte no retorno (dispositivo inutilizável) */
    public void setRequiresDisposal(boolean requires) { this.requiresDisposal = requires; }
    
    /** Comentários e/ou observações pertinentes */
    @Column(name = "Comentarios", length = 3000, nullable = true)
    String comments;
    /** GET para os comentários e/ou observações pertinentes */
    public String getComments() { return comments; }
    /** SET para os comentários e/ou observações pertinentes */
    public void setComments(String comments) { this.comments = comments; }
    
    /** Chip de telefonia liberado com o dispositivo */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SimCard", nullable = true)
    SimCard simCard;
    /** GET para o chip de telefonia liberado com o dispositivo */
    public SimCard getSimCard() { return simCard; }
    /** SET para o chip de telefonia liberado com o dispositivo */
    public void setSimCard(SimCard card) { this.simCard = card; }
    
    /** Descritivo das condições de retorno do dispositivo */
    @Column(name = "CondicoesDeRetornoDoDispositivoMovel", length = 1500, nullable = true)
    String deviceReturnCondition;
    /** GET para as condições de retorno do dispositivo */
    public String getDeviceReturnCondition() { return this.deviceReturnCondition; }
    /** SET para as condições de retorno do dispositivo */
    public void setDeviceReturnCondition(String conditionDescription) { this.deviceReturnCondition = conditionDescription; }
}