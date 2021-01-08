package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.*;


@Entity
@Table(name = "TipoOperacaoBD")
public class DbOperationType
{
    /** Construtor */
    public DbOperationType() { }
    
    /** Identificador único do registro no banco */
    @Id
    @Column(name = "Id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    /** GET para o identificador único do registro no banco */
    public int getId() { return this.id; }
    /** SET para o identificador único do registro no banco */
    public void setId(int id) { this.id = id; }
    
    /** Nome do tipo de operação que pode ser efetuada no banco de dados */
    @Column(name = "Nome", length = 120, nullable = false)
    String name;
    /** GET para o nome do tipo de operação que pode ser efetuada no banco de dados */
    public String getName() { return this.name; }
    /** SET para o nome do tipo de operação que pode ser efetuada no banco de dados */
    public void setName(String name) { this.name = name; }
    
    /** Descritivo e comentários adicionais */
    @Column(name = "Descricao", columnDefinition = "TEXT", nullable = true)
    String description;
    /** GET para o descritivo e comentários adicionais */
    public String getDescription() { return this.description; }
    /** SET para o descritivo e comentários adicionais */
    public void setDescription(String desc) { this.description = desc; }
    
    /** Data e hora da criação do registro no banco */
    @Column(name = "DataHoraRegistro", columnDefinition = "datetime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date registerDateTime;
    /** GET para a data e hora da criação do registro no banco */
    public Date getRegisterDateTime() { return this.registerDateTime; }
    /** SET para a data e hora da criação do registro no banco */
    public void setRegisterDateTime(Date dt) { this.registerDateTime = dt; }
    
    @PrePersist
    private void onSave()
    {
        if(this.registerDateTime == null)
        {
            this.registerDateTime = new Date();
        }
    }
}