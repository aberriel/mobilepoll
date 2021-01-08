package mobilepoll.data.model;

import mobilepoll.data.model.enums.OperationTypeDB_Tp;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * Log das operações no banco, exceto nas tabelas de log
 * @author alira
 */
@Entity
@Table(name = "LogBD")
public class LogDB
{
    private void doInit()
    {
        this.operationTypeInDatabase = OperationTypeDB_Tp.None;
    }
    
    /** Construtor default */
    public LogDB()
    {
        this.doInit();
    }
    
    /**
     * Construtor
     * @param system Sistema a partir do qual foi gerada a ação no banco que está sendo logada
     */
    public LogDB(System system)
    {
        this.doInit();
        this.system = system;
    }
    
    /* Identificador do registro na tabela */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    long id;
    /** GET para o id do registro no banco */
    public long getId() { return id; }
    /** SET para o id do registro no banco */
    public void setId(long id) { this.id = id; }
    
    /** Data e hora em que o registro de log foi inserido no banco */
    @Column(name = "DataHora", columnDefinition = "datetime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date dateTime;
    /** GET para a data e hora de emissao do log */
    public Date getDateTime() { return dateTime; }
    /** SET para a data e hora de emissão do log */
    public void setDateTime(Date dt) { this.dateTime = dt; }
    
    /** Usuário no banco de dados */
    @Column(name = "UsuarioBD", length = 120, nullable = true)
    String dbUser;
    /** GET para o usuário no banco de dados */
    public String getDbUser() { return this.dbUser; }
    /** SET para o usuário no banco de dados */
    public void setDbUser(String user) { this.dbUser = user; }
    
    /** Usuário na aplicação */
    @Column(name = "UsuarioSistema", length = 120, nullable = true)
    String systemUser;
    /** GET para o login do usuário da aplicação */
    public String getSystemUser() { return this.systemUser; }
    /** SET para o login do usuário na aplicação */
    public void setSystemUser(String user) { this.systemUser = user; }
    
    /** Sistema que gerou o log */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Sistema", nullable = false)
    System system;
    /** GET para o sistema que gerou o log */
    public System getSystem() { return system; }
    /** SET para o sistema que gerou o log */
    public void setSystem(System sys) { this.system = sys; }
    
    /** Nome da tabela afetada */
    @Column(name = "NomeTabela", length = 120, nullable = true)
    String tableName;
    /** GET para o nome da tabela afetada */
    public String getTableName() { return this.tableName; }
    /** SET para o nome da tabela afetada */
    public void setTableName(String name) { this.tableName = name; }
    
    /** Id do registro sobre o qual incidiu a ação */
    @Column(name = "IdRegistro", nullable = true)
    Long registerId;
    /** GET para o id do registro sobre o qual incidiu a ação */
    public Long getRegisterId() { return this.registerId; }
    /** SET para o id do registro sobre o qual incidiu a ação */
    public void setRegisterId(Long id) { this.registerId = id; }
    
    /** Registro antigo (antes da ação) */
    @Column(name = "ValoresAntigos", columnDefinition = "TEXT", nullable = true)
    String oldValues;
    /** GET para o registro antigo (antes da ação) */
    public String getOldValues() { return this.oldValues; }
    /** SET para o registro antigo (antes da ação) */
    public void setOldValues(String values) { this.oldValues = values; }
    
    /** Registro novo (depois da ação) */
    @Column(name = "ValoresNovos", columnDefinition = "TEXT", nullable = true)
    String newValues;
    /** GET para o registro novo (depois da ação) */
    public String getNewValues() { return newValues; }
    /** SET para o registro novo (depois da ação) */
    public void setNewValues(String values) { this.newValues = values; }
    
    /** Tipo da operação realizada sobre o registro */
    @Column(name = "TipoDeOperacaoNoBancoDeDados", nullable = true)
    @Enumerated(EnumType.ORDINAL)
    OperationTypeDB_Tp operationTypeInDatabase;
    /** GET para o tipo da operação sobre o registro */
    public OperationTypeDB_Tp getOperationTypeInDatabase() { return this.operationTypeInDatabase; }
    /** SET para o tipo da operação sobre o registro */
    public void setOperationTypeInDatabase(OperationTypeDB_Tp type) { this.operationTypeInDatabase = type; }
    
    @PrePersist
    private void onSave()
    {
        if(this.dateTime == null)
        {
            this.dateTime = new Date();
        }
    }
}
