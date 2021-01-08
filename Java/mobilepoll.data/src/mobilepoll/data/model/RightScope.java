package mobilepoll.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "EscopoPermissao")
public class RightScope
{
    /** Construtor */
    public RightScope() { }
    
    public RightScope(String name)
    {
        this.name = name;
    }
    
    public RightScope(String name, String description)
    {
        this.name = name;
        this.description = description;
    }
    
    /** Identificador único do registro no banco */
    @Id
    @Column(name = "Id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Id;
    /** GET para o identificador único do registro no banco */
    public long getId() { return this.Id; }
    /** SET para o identificador único do registro no banco */
    public void setId(long id) { this.Id = id; }
    
    @Column(name = "Nome", length = 200, nullable = false)
    String name;
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
    
    @Column(name = "Descricao", columnDefinition = "TEXT", nullable = true)
    String description;
    public String getDescription() { return this.description; }
    public void setDescription(String desc) { this.description = desc; }
}