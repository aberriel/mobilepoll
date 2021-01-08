package mobilepoll.data.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * Tipos de objeto (ou entidades do sistema).
 * 
 * Exemplo: Usuário, pesquisa, categoria de pesquisa, etc.
 * 
 * Os tipos de objeto do sistema fazem parte do sistema de permissionamento, onde o bloqueio
 * ou liberação de recursos não é feito com base em páginas ou forms e sim em conteúdo.
 * 
 * Neste caso, se um usuário não possui acesso a um tipo de objeto do sistema, todas as 
 * páginas relacionadas a este tipo de objeto estarão bloqueadas para ele.
 * @author alira
 */
@Entity
@Table(name = "TipoObjeto")
public class ObjectType
{
    /** Inicialização dos atributos da classe */
    private void DoInit()
    {
        if(this.actionTypeList == null)
        {
            this.actionTypeList = new ArrayList<ApplicationActionType>();
        }
        
        if(this.objectRightTypeList == null)
        {
            this.objectRightTypeList = new ArrayList<ObjectRightType>();
        }
        
        if(this.rightList == null)
        {
            this.rightList = new ArrayList<Right>();
        }
        
        if(this.registerDateTime == null)
        {
            this.registerDateTime = new Date();
        }
    }
    
    /** Construtor */
    public ObjectType()
    {
        this.DoInit();
    }
    
    /**
     * Construtor
     * @param name Nome do tipo de objeto ou entidade do sistema
     */
    public ObjectType(String name)
    {
        this.DoInit();
        this.name = name;
    }
    
    /**
     * Construtor
     * @param name Nome do tipo de objeto ou entidade do sistema
     * @param description Comentários e/ou observações pertinentes
     */
    public ObjectType(String name, String description)
    {
        this.DoInit();
        this.name = name;
        this.description = description;
    }
    
    /**
     * Construtor
     * @param name Nome do tipo de objeto ou entidade do sistema
     * @param description Comentários e/ou observações pertinentes
     * @param literalIdentifier Identificador literal da ação
     */
    public ObjectType(String name, String description, int literalIdentifier)
    {
        this.DoInit();
        this.name = name;
        this.description = description;
        this.literalIdentifier = literalIdentifier;
    }
    
    /** Identificador único do registro na tabela */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    long id;
    /** GET para o id do registro na tabela */
    public long getId() { return id; }
    /** SET para o id do registro na tabela */
    public void setId(long id) { this.id = id; }
    
    /** Nome do tipo de objeto */
    @Column(name = "Nome", length = 200, nullable = false)
    String name;
    /** GET para o nome do tipo de objeto ou entidade do sistema */
    public String getName() { return name; }
    /** SET para o nome do tipo de objeto ou entidade do sistema */
    public void setName(String name) { this.name = name; }
    
    /** Descritivo do tipo de objeto ou entidade do sistema */
    @Column(name = "Descricao", columnDefinition = "TEXT", nullable = true)
    String description;
    /** GET para o descritivo do tipo de objeto ou entidade do sistema */
    public String getDescription() { return description; }
    /** SET para o descritivo do tipo de objeto ou entidade */
    public void setDescription(String description) { this.description = description; }
    
    /**
     * Identificador numérico do tipo de objeto.
     * 
     * Esse identificador numérico serve para o sistema de permissionamento,
     * onde as permissões podem ser identificadas por um código numérico contendo,
     * essenciamentoe, o tipo de objeto, e a ação.
     */
    @Column(name = "IdentificadorLiteral", nullable = true)
    Integer literalIdentifier;
    /** GET para o identificador numérico do tipo de objeto */
    public Integer getLiteralIdentifier() { return this.literalIdentifier; }
    /** SET para o identificador numérico do tipo de objeto */
    public void setLiteralIdentifier(Integer identifier) { this.literalIdentifier = identifier; }
    
    /** Data e hora da criação do registro no banco */
    @Column(name = "DataHoraRegistro", columnDefinition = "datetime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date registerDateTime;
    /** GET para a data e hora da criação do registro no banco */
    public Date getRegiterDateTime() { return this.registerDateTime; }
    /** SET para a data e hora da criação do registro no banco */
    public void setRegisterDateTime(Date dt) { this.registerDateTime = dt; }
    
    /** Listagem de ações incidentes sobre este tipo de objeto ou entidade */
    @OneToMany(cascade = CascadeType.ALL,
               mappedBy = "objectType",
               targetEntity = ApplicationActionType.class,
               fetch = FetchType.LAZY)
    List<ApplicationActionType> actionTypeList;
    /** GET para a listagem de ações incidentes sobre este tipo de objeto ou entidade */
    public List<ApplicationActionType> getActionTypeList() { return this.actionTypeList; }
    /** SET para a listagem de ações incidentes sobre este tipo de objeto ou entidade do sistema */
    public void setActionTypeList(List<ApplicationActionType> typeList) { this.actionTypeList = typeList; }
    
    /** Tipos de permissão deste objeto */
    @OneToMany(cascade = CascadeType.ALL,
               mappedBy = "objectType",
               targetEntity = ObjectRightType.class,
               fetch = FetchType.LAZY)
    List<ObjectRightType> objectRightTypeList;
    /** GET para os tipos de permissão deste objeto */
    public List<ObjectRightType> getObjectRightTypeList() { return objectRightTypeList; }
    /** SET para os tipos de permissão deste objeto */
    public void setObjectRightTypeList(List<ObjectRightType> oList) { this.objectRightTypeList = oList; }
    
    /** Lista de permissões de usuário/grupo incidentes sobre este tipo de objeto */
    @OneToMany(cascade = CascadeType.ALL,
               fetch = FetchType.LAZY,
               mappedBy = "objectType")
    List<Right> rightList;
    /** GET para a lista de permissões de usuário/grupo incidentes sobre este tipo de objeto */
    public List<Right> getRightList() { return rightList; }
    /** SET para a lista de permissões de usupario/grupo incidentes sobre este tipo de objeto */
    public void setRightList(List<Right> rList) { this.rightList = rList; }
}
