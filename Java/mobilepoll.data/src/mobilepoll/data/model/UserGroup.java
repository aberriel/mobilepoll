package mobilepoll.data.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.Type;

/**
 * Grupos ou perfis de usuários
 * @author alira
 */
@Entity
@Table(name = "GrupoUsuario")
public class UserGroup
{
    private void DoInit()
    {
        if(this.userList == null)
        {
            this.userList = new ArrayList<User>();
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
    public UserGroup()
    {
        this.DoInit();
    }
    
    /** Identificador único do registro no banco */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    long id;
    /** GET para o identificador único do registro no banco */
    public long getId() { return id; }
    /** SET para o identificador único do registro do banco */
    public void setId(long id) { this.id = id; }
    
    /** Nome do grupo ou perfil de usuário */
    @Column(name = "Nome", length = 200, nullable = false)
    String name;
    /** GET para o nome do grupo ou perfil de usuário */
    public String getName() { return name; }
    /** SET para o nome do grupo ou perfil de usuário */
    public void setName(String name) { this.name = name; }
    
    /** Descritivo do grupo ou perfil do usuário */
    @Column(name = "Descricao", columnDefinition = "TEXT", nullable = true)
    String description;
    /** GET para o descritivo do grupo ou perfil de usuário */
    public String getDescription() { return description; }
    /** SET para o descritivo do grupo ou perfil do usuário */
    public void setDescription(String description) { this.description = description; }
    
    /** Flag indicador de grupo ou perfil específico de administrador do sistema */
    @Column(name = "GrupoDoSistema", nullable = false, columnDefinition = "TINYINT", length = 1)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    boolean systemGroup;
    /** GET para flag indicador de grupo ou perfil específico de administrador do sistema */
    public boolean isSystemGroup() { return systemGroup; }
    /** SET para flag indicador de grupo ou perfil específico de administrador do sistema */
    public void setSystemGroup(boolean systemGroup) { this.systemGroup = systemGroup; }
    
    /** Data e hora da criação do registro no banco */
    @Column(name = "DataHoraRegistro", columnDefinition = "datetime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date registerDateTime;
    /** GET para a data e hora da criação do registro no sistema */
    public Date getRegisterDateTime() { return registerDateTime; }
    /** SET para a data e hora da criação do registro no banco */
    public void setRegisterDateTime(Date registerDateTime) { this.registerDateTime = registerDateTime; }
    
    /** Data e hora para a última atualização realizada no registro */
    @Column(name = "DataHoraUltimaAtualizacao", columnDefinition = "datetime", nullable = false)
    Date lastActionDateTime;
    /** GET para a data e hora para a última atualização realizada no registro */
    public Date getLastActionDateTime() { return lastActionDateTime; }
    /** SET para a última atualização realizada no registro */
    public void setLastActionDateTime(Date lastActionDateTime) { this.lastActionDateTime = lastActionDateTime; }
    
    /** Lista de usuários associados a este grupo */
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "Usuario_GrupoUsuario",
               joinColumns =
               {
                   @JoinColumn(name = "GrupoDeUsuario", nullable = false, updatable = false)
               },
               inverseJoinColumns = 
               {
                   @JoinColumn(name = "Usuario", nullable = false, updatable = false)
               })
    List<User> userList;
    /** GET para a listagem de usuários associados a este grupo */
    public List<User> getUserList() { return userList; }
    /** SET para a listagem de usuários associados a este grupo */
    public void setUserList(List<User> uList) { this.userList = uList; }
    
    /** Permissões aplicadas a este grupo de usuário */
    @OneToMany(cascade = CascadeType.ALL,
               targetEntity = Right.class,
               mappedBy = "userGroup",
               fetch = FetchType.LAZY)
    List<Right> rightList;
    /** GET para as permissões aplicadas a este grupo de usuário */
    public List<Right> getRightList() { return rightList; }
    /** SET para as permissões aplicadas a este grupo de usuário */
    public void setRightList(List<Right> rList) { this.rightList = rList; }
    
    /** Evento de persistência do objeto para o banco */
    @PrePersist
    private void onSave()
    {
        if(this.registerDateTime == null)
        {
            this.registerDateTime = new Date();
        }
        
        this.lastActionDateTime = new Date();
    }
}
