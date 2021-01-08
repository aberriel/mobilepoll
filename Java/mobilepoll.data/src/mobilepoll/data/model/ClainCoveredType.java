package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author alira
 */
@Entity
@Table(name = "TipoSinistroCoberturaSeguro")
public class ClainCoveredType
{
    public ClainCoveredType() { }
    
    /** Identificador único do registro no banco */
    @Id
    @Column(name = "Id", nullable = false, unique = true)
    int id;
    /** GET para o identificador único do registro no banco */
    public int getId() { return this.id; }
    /** SET para o identificador único do registro no banco */
    public void setId(int id) { this.id = id; }
    
    /** Nome do tipo do sinistro que cobre perda ou roubo. "*/
    @Column(name = "Nome", length = 200, nullable = false)
    String name;
    /** GET para o nome do tipo de sinistro */
    public String getName() { return this.name; }
    /** SET para o nome do tipo de sinistro */
    public void setName(String na) { this.name = na; }
    
    @Column(name = "Descricao", columnDefinition = "TEXT")
    String description;
    public String getDescription() { return this.description; }
    public void setDescription(String desc) { this.description = desc; }
    
    /** Data e hora em que o registro foi inserido no banc0 */
    @Column(name = "DataHoraRegistro", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date registerDateTime;
    /** GET para a data e hora em que o registro foi inserivo */
    public Date getRegisterDateTime() { return this.registerDateTime; }
    /** SET para a data e hora em que o registro foi inserido */
    public void setRegisterDateTime(Date dt) { this.registerDateTime = dt; }
    
    @PrePersist
    public void prePersist()
    {
        if(this.registerDateTime == null)
        {
            this.registerDateTime = new Date();
        }
    }
}
