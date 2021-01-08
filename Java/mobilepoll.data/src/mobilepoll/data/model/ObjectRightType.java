package mobilepoll.data.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Classe persistente para associação de ações a objetos do sistema.
 * 
 * Cada entidade do sistema (tipo de objeto, como usuário, pesquisa, etc) possuirá
 * ações associadas a ele, cada uma com um identificador próprio.
 * 
 * Na atribuição de permissão, um usuário possuirá permissão para uma ação atribuída a
 * um objeto ou entidade do sistema.
 * 
 * @author alira
 */
@Entity
@Table(name = "TipoObjetoPermissao")
public class ObjectRightType
{
    /** Construtor */
    public ObjectRightType() { }
    
    /**
     * Construtor
     * @param oType Tipo de objeto do sistem ao qual está sendo associada a ação
     * @param aType Ação que está sendo associada ao tipo de objeto do sistema
     */
    public ObjectRightType(ObjectType oType, ApplicationActionType aType)
    {
        this.objectType = oType;
        this.applicationActionType = aType;
    }
    
    /**
     * Construtor
     * @param name Nome da permissão
     * @param oType Tipo de objeto do sistema ao qual está sendo associada a ação
     * @param aType Ação que está sendo associada ao tipo de objeto do sistema.
     */
    public ObjectRightType(String name, ObjectType oType, ApplicationActionType aType)
    {
        this.name = name;
        this.objectType = oType;
        this.applicationActionType = aType;
    }
    
    /** Identificador único do registro no banco */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    long id;
    /** GET para o identificador único do registro no banco */
    public long getId() { return id; }
    /** SET para o identificador único do registro no banco */
    public void setId(long id) { this.id = id; }
    
    /** Nome do tipo de permissão do objeto do sistema */
    @Column(name = "Nome", length = 200, nullable = false)
    String name;
    /** GET para o nome do tipo de permissão do objeto do sistema */
    public String getName() { return name; }
    /** SET para o nome do tipo de permissão do objeto do sistema */
    public void setName(String name) { this.name = name; }
    
    /** Descritivo da permissão */
    @Column(name = "Descricao", columnDefinition = "text", nullable = true)
    String description;
    /** GET para o descritivo da permissão */
    public String getDescription() { return description; }
    /** SET para o descritivo da permissão */
    public void setDescription(String description) { this.description = description; }
    
    /** Tipo de objeto sobre o qual se aplica a ação */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TipoObjeto", nullable = false)
    ObjectType objectType;
    /** GET para o tipo de objeto sobre o qual se aplica a ação */
    public ObjectType getObjectType() { return objectType; }
    /** SET para o tipo de objeto sobre o qual se aplica a ação */
    public void setObjectType(ObjectType type) { this.objectType = type; }
    
    /** Ação associada ao tipo de objeto */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TipoAcaoAplicacao", nullable = false)
    ApplicationActionType applicationActionType;
    /** GET para a ação associada ao tipo de objeto */
    public ApplicationActionType getApplicationActionType() { return this.applicationActionType; }
    /** SET para a ação associada ao tipo de objeto */
    public void setApplicationActionType(ApplicationActionType type) { this.applicationActionType = type; }
    
    /** Identificador numérico para a associação entre ação e tipo de objeto */
    @Column(name = "IdentificadorLiteral", nullable = true)
    Integer literalIdentifier;
    /** GET para o identificador numérico para a associação entre ação e tipo de objeto */
    public Integer getLiteralIdentifier() { return literalIdentifier; }
    /** SET para o identificador numérico para a associação entre ação e tipo de objeto */
    public void setLiteralIdentifier(Integer identifier) { this.literalIdentifier = identifier; }
}