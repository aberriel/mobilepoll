package mobilepoll.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author alira
 */
@Entity
@Table(name = "MotivoTerminoPesquisa")
public class ResearchFinishReasonType
{
    public ResearchFinishReasonType() { }
    
    @Id
    @Column(name = "Id", nullable = false, unique = true)
    int id;
    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }
    
    @Column(name = "Nome", length = 200, nullable = false, unique = true)
    String name;
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
    
    @Column(name = "Descricao", columnDefinition = "TEXT", nullable = true)
    String description;
    public String getDescription() { return this.description; }
    public void setDescription(String desc) { this.description = desc; }
}
