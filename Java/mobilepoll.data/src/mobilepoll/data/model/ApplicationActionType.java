package mobilepoll.data.model;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

/**
 * Tipos de ação que o usuário pode executar sobre objetos do sistema.
 * 
 * Ex: CREATE, DELETE, UPDATE, etc
 * @author alira
 */
@Entity
@Table(name = "TipoAcaoAplicacao")
public class ApplicationActionType
{
    /** Ações executadas na inicialização do sistema */
    private void DoInit()
    {
        if(this.objectRightTypeList == null)
        {
            this.objectRightTypeList = new ArrayList<ObjectRightType>();
        }
    }
    
    /** Construtor */
    public ApplicationActionType()
    {
        DoInit();
    }
    
    /**
     * Construtor
     * @param name Nome do tipo de ação que pode incidir sobre o tipo de objeto ou entidade do sistema
     */
    public ApplicationActionType(String name)
    {
        DoInit();
        this.name = name;
    }
    
    /**
     * Construtor
     * @param name Nome do tipo de ação que pode incidir sobre o objeto
     * @param objectType Tipo de objeto ou entidade do sistema sobre o qual a ação incide
     */
    public ApplicationActionType(String name, ObjectType objectType)
    {
        DoInit();
        this.name = name;
        this.objectType = objectType;
    }
    
    /**
     * Construtor
     * @param name Nome do tipo de ação que pode incidir sobre o objeto
     * @param objectType Tipo de objeto ou entidade do sistema sobre o qual a ação incide.
     * @param description Comentários e/ou observações pertinentes.
     */
    public ApplicationActionType(String name, ObjectType objectType, String description)
    {
        DoInit();
        this.name = name;
        this.objectType = objectType;
        this.description = description;
    }
    
    /** Identificador único do registro na tabela */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    long id;
    /** GET para o identificador do registro na tabela */
    public long getId() { return id; }
    /** SET para o identificador do registro na tabela */
    public void setId(long id) { this.id = id; }
    
    /** Nome da ação que o usuário pode executar sobre o objeto do sistema */
    @Column(name = "Nome", length = 200, nullable = false, unique = true)
    String name;
    /** GET para o nome da ação que o usuário pode executar sobre o objeto do sistema */
    public String getName() { return name; }
    /** SET para o nome da ação que o usuário pode executar sobre o objeto do sistema */
    public void setName(String name) { this.name = name; }
    
    /** Descritivo da ação */
    @Column(name = "Descricao", columnDefinition = "TEXT", nullable = true)
    String description;
    /** GET para o descritivo da ação */
    public String getDescription() { return description; }
    /** SET para o descritivo da ação */
    public void setDescription(String description) { this.description = description; }
    
    /** Tipo do objeto do sistema sobre o qual a ação incide */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TipoObjeto", nullable = false)
    ObjectType objectType;
    /** GET para o tipo do objeto do sistema sobre o qual a ação incide. */
    public ObjectType getObjectType() { return this.objectType; }
    /** SET para o tipo do objeto do sistema sobre o qual a ação incide. */
    public void setObjectType(ObjectType type) { this.objectType = type; }
    
    /** Data e hora da criação do registro no banco */
    @Column(name = "DataHoraRegistro", columnDefinition = "datetime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date registerDateTime;
    /** GET para a data a hora da criação do registro no banco */
    public Date getRegisterDateTime() { return this.registerDateTime; }
    /** SET para a data e hora da criação do registro no banco */
    public void setRegisterDateTime(Date dateTime) { this.registerDateTime = dateTime; }
    
    /** Permissões que referenciam esta ação */
    @OneToMany(cascade = CascadeType.ALL,
               mappedBy = "applicationActionType",
               targetEntity = ObjectRightType.class,
               fetch = FetchType.LAZY)
    List<ObjectRightType> objectRightTypeList;
    /** GET para as permissões que referenciam esta ação */
    public List<ObjectRightType> getObjectRightTypeList() { return this.objectRightTypeList; }
    /** SET para as permissões que referenciam esta ação */
    public void setObjectRightTypeList(List<ObjectRightType> oList) { this.objectRightTypeList = oList; }
    
    /** Evento de salvamento do objeto no banco */
    @PrePersist
    private void onSave()
    {
        if(this.registerDateTime == null)
        {
            Calendar now = GregorianCalendar.getInstance();
            this.registerDateTime = now.getTime();
        }
    }
}