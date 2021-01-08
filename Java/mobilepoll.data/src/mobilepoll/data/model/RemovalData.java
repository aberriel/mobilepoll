package mobilepoll.data.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Dados de controle relativo à remoção do dispositivo móvel do sistema.
 * @author alira
 */
@Entity
@Table(name = "DadosRemocao")
public class RemovalData
{
    /** Construtor */
    public RemovalData() { }
    
    /**
     * Construtor
     * @param reason Causa da remoção do dispositivo
     */
    public RemovalData(String reason)
    {
        this.removalReason = reason;
    }
    
    /**
     * Construtor
     * @param reason Causa da remoção do dispositivo
     * @param destination  Destino dado ao dispositivo, no caso da empresa ainda o possuir
     */
    public RemovalData(String reason, String destination)
    {
        this.removalReason = reason;
        this.destination = destination;
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
    
    /** Dados do boletim de ocorrência feito, para o caso de perda ou roubo */
    @Column(name = "DadosBoletimOcorrencia", nullable = true, length = 1500)
    String accidentReportData;
    /** GET para os dados do boletim de ocorrência feito, para o caso de perda ou roubo */
    public String getAccidentReportData() { return accidentReportData; }
    /** SET para os dados do boletim de ocorrência feito, para o caso de perda ou roubo */
    public void setAccidentReportData(String data) { this.accidentReportData = data; }
    
    /** Descritivo da causa da remoção do dispositivo móvel do sistema */
    @Column(name = "MotivoRemocaoDispositivoMovel", length = 1000, nullable = true)
    String removalReason;
    /** GET para o descritivo da causa da remoção do dispositivo móvel do sistema */
    public String getRemovalReason() { return removalReason; }
    /** SET para o descritivo da causa da remoção do dispositivo móvel do sistema */
    public void setRemovalReason(String reason) { this.removalReason = reason; }
    
    /** Descritivo do destino dado ao dispositivo, caso a empresa ainda o possua */
    @Column(name = "Destino", length = 1000, nullable = true)
    String destination;
    /** GET para o descritivo do destino dado ao dispositivo, caso a empresa ainda o possua */
    public String getDestination() { return destination; }
    /** SET para o descritivo do destino dado ao dispositivo, caso a empresa ainda o possua */
    public void setDestination(String destination) { this.destination = destination; }
}
