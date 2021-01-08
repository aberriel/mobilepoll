package mobilepoll.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TipoOrigemGarantia")
public class WarrantyOriginType
{
    /** Construtor */
    public WarrantyOriginType() { }
    
    /** Identificador único do registro no banco */
    @Id
    @Column(name = "Id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    /** GET para o identificador único do registro no banco */
    public int getId() { return this.id; }
    /** SET para o identificador único do registro no banco */
    public void setId(int id) { this.id = id; }
    
    /** Nome do tipo de origem de garantia de dispositivo */
    @Column(name = "Nome", length = 200, nullable = false)
    String name;
    /** GET para o nome do tipo de origem de garantia de dispositivo */
    public String getName() { return this.name; }
    /** SET para o nome do tipo de origem de garantia de dispositivo */
    public void setName(String name) { this.name = name; }
    
    @Column(name = "Descricao", columnDefinition = "TEXT", nullable = true)
    String description;
    public String getDescription() { return this.description; }
    public void setDescription(String desc) { this.description = desc; }
}