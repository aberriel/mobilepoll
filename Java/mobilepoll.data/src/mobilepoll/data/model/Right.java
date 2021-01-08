package mobilepoll.data.model;

import java.util.Date;
import mobilepoll.data.model.enums.RightScope_Tp;
import javax.persistence.*;
import org.hibernate.annotations.Type;

/**
 * Classe persistente para permissões de acesso
 * @author alira
 */
@Entity
@Table(name = "Permissao")
public class Right
{
    private void initFields()
    {
        this.rightScope = RightScope_Tp.Nothing;
    }
    
    /** Construtor */
    public Right()
    {
        this.initFields();
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
    
    /**
     * Grupo de usuário ao qual se aplica a permissão.
     * Para permissões aplicadas em massa, diretamente ao grupo
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "GrupoDeUsuario", nullable = true)
    UserGroup userGroup;
    /** GET para o grupo de usuários ao qual se aplica a permissão */
    public UserGroup getUserGroup() { return userGroup; }
    /** SET para o grupo de usuários ao qual se aplica a permissão */
    public void setUserGroup(UserGroup uGroup) { this.userGroup = uGroup; }
    
    /**
     * Usuário ao qual se aplica a permissão.
     * Para permissões aplicadas individualmente.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Usuario", nullable = true)
    User user;
    /** GET para o usuário ao qual se aplica a permissão */
    public User getUser() { return this.user; }
    /** SET para o usuário ao qual se aplica a permissão */
    public void setUser(User user) { this.user = user; }
    
    /** Tipo de objeto sobre o qual incide a permissão */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TipoObjeto", nullable = true)
    ObjectType objectType;
    /** GET para o tipo de objeto sobre o qual incide a permissão */
    public ObjectType getObjectType() { return this.objectType; }
    /** SET para o tipo de objeto sobre o qual incide a permissão */
    public void setObjectType(ObjectType oType) { this.objectType = oType; }
    
    /** Conjunto de dados sobre os quais incide a permissão */
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "Escop Permissao", nullable = false)
    RightScope_Tp rightScope;
    /** GET para a definição de conjunto de dados sobre os quais incide a permissão */
    public RightScope_Tp getRightScope() { return rightScope; }
    /** SET para o conjunto de dados sobre os quais incide a permissão */
    public void setRightScope(RightScope_Tp rScope) { this.rightScope = rScope; }
    
    /** Total de registros que o usuário ou grupo pode manipular */
    @Column(name = "LimiteNumeroRegistro", nullable = false)
    int totalRecordLimit;
    /** GET para o total de registros que o usuário ou grupo pode manipular */
    public int getTotalRecordLimit() { return this.totalRecordLimit; }
    /** SET para o total de registros que o usuário ou grupo pode manipular */
    public void setTotalRecordLimit(int limit) { this.totalRecordLimit = limit; }
    
    @Column(name = "PermissaoDoObjeto", nullable = true)
    Integer objectRight;
    public Integer getObjectRight() { return this.objectRight; }
    public void setObjectRight(Integer oRight) { this.objectRight = oRight; }
    
    /** FLAG indicador se a permissão é válida */
    @Column(name = "Valido", nullable = false, columnDefinition = "TINYINT", length = 1)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    boolean valid;
    /** GET para o flag indicador se a permissão é válida */
    public boolean isValid() { return valid; }
    /** SET para o flag indicador se a permissão é válida */
    public void setValid(boolean valid) { this.valid = valid; }
    
    /** Data e hora da criação do registro no banco */
    @Column(name = "DataHoraRegistro", columnDefinition = "datetime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date registerDateTime;
    /** GET para a data e hora da criação do registro no banco */
    public Date getRegisterDateTime() { return this.registerDateTime; }
    /** SET para a data e hora da criação do registro no banco */
    public void setRegisterDateTime(Date dt) { this.registerDateTime = dt; }
}
