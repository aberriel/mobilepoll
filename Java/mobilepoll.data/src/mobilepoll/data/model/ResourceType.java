package mobilepoll.data.model;

import java.util.*;
import javax.persistence.*;

/**
 * Tipos de recurso do sistema (se página web, tela de aplicação móvel, etc)
 * @author alira
 */
@Entity
@Table(name = "TipoRecurso")
public class ResourceType
{
    /** Inicialização de atributos e valores da classe */
    private void DoInit()
    {
        if(this.resourceList == null)
        {
            this.resourceList = new ArrayList<Resource>();
        }
    }
    
    /** Construtor */
    public ResourceType()
    {
        this.DoInit();
    }
    
    /**
     * Construtor
     * @param name Nome do tipo de recurso
     */
    public ResourceType(String name)
    {
        this.DoInit();
        this.name = name;
    }
    
    /**
     * Construtor
     * @param name Nome do tipo de recurso
     * @param description Descritivo do tipo de recurso
     */
    public ResourceType(String name, String description)
    {
        this.DoInit();
        this.name = name;
        this.description = description;
    }
    
    /** Identificador único do registro no sistema */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    long id;
    /** GET para o idetificador único do registro no sistema */
    public long getId() { return id; }
    /** SET para o identificador único do registro no sistema */
    public void setId(long id) { this.id = id; }
    
    /** Nome do tipo de recurso */
    @Column(name = "Nome", length = 200, unique = true, nullable = false)
    String name;
    /** GET para o nome do tipo de recurso */
    public String getName() { return name; }
    /** SET para o tipo de recurso */
    public void setName(String name) { this.name = name; }
    
    /** Descritivo do tipo de recurso */
    @Column(name = "Descricao", columnDefinition = "TEXT", nullable = true)
    String description;
    /** GET para o descritivo do tipo de recurso */
    public String getDescription() { return description; }
    /** SET para o descritivo do tipo de recurso */
    public void setDescription(String description) { this.description = description; }
    
    /** Data e hora da criação do registro no sistema */
    @Column(name = "DataHoraRegistro", columnDefinition = "datetime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date registerDateTime;
    /** GET para a data e hora de criação do registro no sistema */
    public Date getRegisterDateTime() { return registerDateTime; }
    /** SET para a data e hora de criação do registro no sistema */
    public void setRegisterDateTime(Date dateTime) { this.registerDateTime = dateTime; }
    
    /** Lista de recursos pertencentes a este tipo */
    @OneToMany(cascade = CascadeType.ALL,
               mappedBy = "resourceType",
               fetch = FetchType.LAZY,
               targetEntity = Resource.class)
    List<Resource> resourceList;
    /** GET para a lista de recursos pertencentes a este tipo */
    public List<Resource> getResourceList() { return resourceList; }
    /** SET para a lista de recursos pertencentes a este tipo */
    public void setResourceList(List<Resource> rList) { this.resourceList = rList; }
    
    /** Evento de persistência do objeto para o banco */
    @PrePersist
    protected void onSave()
    {
        if(this.registerDateTime == null)
        {
            this.registerDateTime = new Date();
        }
    }
}