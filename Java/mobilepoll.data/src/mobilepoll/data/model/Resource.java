package mobilepoll.data.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.Type;

/**
 * Classe persistente para registro de recursos do sistema (páginas,
 * janelas, métodos de web service) que podem ser manipulados pelo usuário.
 * @author alira
 */
@Entity
@Table(name = "Recurso")
public class Resource
{
    private void DoInit()
    {
        if(this.objectTypeResourceList == null)
        {
            this.objectTypeResourceList = new ArrayList<ObjectTypeResource>();
        }
        
        this.administrativeItem = false;
    }
    
    /** Construtor */
    public Resource()
    {
        this.DoInit();
    }
    
    /**
     * Construtor
     * @param name Nome do recurso do sistema 
     */
    public Resource(String name)
    {
        this.DoInit();
        this.name = name;
    }
    
    /**
     * Construtor
     * @param name Nome do recurso do sistema
     * @param system Sistema ao qual pertence o recurso
     */
    public Resource(String name, System system)
    {
        this.DoInit();
        this.name = name;
        this.system = system;
    }
    
    /**
     * Construtor
     * @param name Nome do recurso do sistema
     * @param system Sistema ao qual pertence o recurso
     * @param locality Localização do recurso
     */
    public Resource(String name, System system, String locality)
    {
        this.DoInit();
        this.name = name;
        this.system = system;
        this.locality = locality;
    }
    
    /**
     * Construtor
     * @param name Nome do recurso do sistema
     * @param system Sistema ao qual pertence o recurso
     * @param locality Localização do recurso
     * @param type Tipo do recurso (se página web, se tela de aplicação móvel, etc)
     */
    public Resource(String name,
                    System system,
                    String locality,
                    ResourceType type)
    {
        this.DoInit();
        this.name = name;
        this.system = system;
        this.locality = locality;
        this.resourceType = type;
    }
    
    /** Identificador único do registro no banco */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    long id;
    /** GET para o identificador único do registro no banco */
    public long getId() { return id; }
    /** SET para o identificador único do registro no banco */
    public void setId(long id) { this.id = id; }
    
    /** Nome do recurso do sistema */
    @Column(name = "Nome", length = 200, unique = true, nullable = false)
    String name;
    /** GET para o nome do recurso do sistema */
    public String getName() { return name; }
    /** SET para o nome do recurso do sistema */
    public void setName(String name) { this.name = name; }
    
    /** Comentários e/ou observações */
    @Column(name = "Comentarios", columnDefinition = "TEXT", nullable = true)
    String comments;
    /** GET para os comentários e/ou observações */
    public String getComments() { return comments; }
    /** SET para os comentários e/ou observações */
    public void setComments(String comments) { this.comments = comments; }
    
    /** Sistema ao qual pertence o recurso */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Sistema", nullable = false)
    System system;
    /** GET para o sistema ao qual pertence o recurso */
    public System getSystem() { return system; }
    /** SET para o sistema ao qual pertence o recurso */
    public void setSystem(System system) { this.system = system; }
    
    /** Tipo do recurso (se página web, tela de aplicação móvel, etc) */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TipoRecurso", nullable = false)
    ResourceType resourceType;
    /** GET para o tipo do recurso (se página web, tela de aplicação móvel, etc) */
    public ResourceType getResourceType() { return this.resourceType; }
    /** SET para o tipo do recurso (se página web, tela de aplicação móvel, etc) */
    public void setResourceType(ResourceType type) { this.resourceType = type; }
    
    /** Localização do recurso */
    @Column(name = "Localizacao", length = 1000, nullable = true)
    String locality;
    /** GET para a localização do recurso */
    public String getLocality() { return locality; }
    /** SET para a localização do recurso */
    public void setLocality(String locality) { this.locality = locality; }
    
    /** Flag indicador de recurso exclusivo do administrador do sistema */
    @Column(name = "ItemAdministrativo", nullable = false, columnDefinition = "TINYINT", length = 1)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    boolean administrativeItem;
    /** GET para o flag indicador de recurso exclusivo do administrador do sistema */
    public boolean getAdministrativeItem() { return this.administrativeItem; }
    /** SET para o flag indicador de recurso exclusivo do administrador do sistema */
    public void setAdministrativeItem(boolean isAdminItem) { this.administrativeItem = isAdminItem; }
    
    @OneToMany(cascade = CascadeType.ALL,
               mappedBy = "resourceItem",
               targetEntity = Resource.class,
               fetch = FetchType.LAZY)
    List<ObjectTypeResource> objectTypeResourceList;
    public List<ObjectTypeResource> getObjectTypeResourceList() { return objectTypeResourceList; }
    public void setObjectTypeResourceList(List<ObjectTypeResource> otrList) { this.objectTypeResourceList = otrList; }
}