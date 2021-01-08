package mobilepoll.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/** Sexo de pessoas */
@Entity
@Table(name = "Sexo")
public class Gender
{
    /** Construtor */
    public Gender() { }
    
    /** Identificador único do registro no banco */
    @Id
    @Column(name = "Id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    /** GET para o identificador único do registro no banco */
    public int getId() { return this.id; }
    /** SET para o identificador único do registro no banco */
    public void setId(int id) { this.id = id; }
    
    /** Nome do sexo */
    @Column(name = "Nome", length = 200, nullable = false)
    String name;
    /** GET para o nome do sexo */
    public String getName() { return this.name; }
    /** SET para o nome do sexo */
    public void setName(String nm) { this.name = name; }
    
    /** Descritivo e comentários adicionais */
    @Column(name = "Descritivo", columnDefinition = "TEXT", nullable = true)
    String description;
    /** GET para o descritivo e comentários adicionais */
    public String getDescription() { return this.description; }
    /** SET para o descritivo e comentários adicionais */
    public void setDescription(String desc) { this.description = desc; }
}