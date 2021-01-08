package mobilepoll.data.model;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Classe persistente para estado civil
 * @author anselmolira
 */
@Entity
@Table(name = "EstadoCivil")
public class MaritalStatus
{
    /** Construtor */
    public MaritalStatus() { }
    
    /** Identificador único do registro no banco */
    @Id
    @Column(name = "Id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    /** GET para o identificador único do registro no banco */
    public int getId() { return this.id; }
    /** SET para o identificador único do registro no banco */
    public void setId(int id) { this.id = id; }
    
    /** Nome do estado civil */
    @Column(name = "Nome", length = 80, nullable = false)
    String name;
    /** GET para o nome do estado civil */
    public String getName() { return this.name; }
    /** SET para o nome do estado civil */
    public void setName(String name) { this.name = name; }
    
    /** Descritivo e comentários adicionais */
    @Column(name = "Descritivo", columnDefinition = "TEXT", nullable = true)
    String description;
    /** GET para o descritivo e comentários adicionais */
    public String getDescription() { return this.description; }
    /** SET para o descritivo e comentários adicionais */
    public void setDescription(String desc) { this.description = desc; }
}