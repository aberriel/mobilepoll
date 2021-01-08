package mobilepoll.data.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * Log de ações executadas na aplicação
 * @author alira
 */
@Entity
@Table(name = "LogApp")
public class LogApp
{
    /** Construtor */
    public LogApp() { }
    
    /**
     * Construtor
     * @param system Sistema ou aplicação que gerou o registro de log
     */
    public LogApp(System system)
    {
        this.system = system;
    }
    
    /** Identificador do registro na tabela */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    long id;
    /** GET para o identificador do registor na tabela */
    public long getId() { return id; }
    /** SET para o identificador do registor na tabela */
    public void setId(long id) { this.id = id; }
    
    /** Descritivo da ação executada */
    @Column(name = "Descricao", columnDefinition = "TEXT", nullable = true)
    String description;
    /** GET para o descritivo da ação executada */
    public String getDescription() { return description; }
    /** SET para o descritivo da ação executada */
    public void setDescription(String description) { this.description = description; }
    
    /** Sistema onde a ação foi executada */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Sistema", nullable = false)
    System system;
    /** GET para o sistema onde a ação foi executada */
    public System getSystem() { return system; }
    /** SET para o sistema onde a ação foi executada */
    public void setSystem(System system) { this.system = system; }
    
    /** Endereço IP da máquina utilizada pelo usuário para executar a ação */
    @Column(name = "IP", length = 15, nullable = true, insertable = true, updatable = false)
    String ip;
    /** GET para o IP a partir do qual o usuário executou a ação */
    public String getIp() { return this.ip; }
    /** SET para o IP a partir do qual o usuário executou a ação */
    public void setIp(String ipAddress) { this.ip = ipAddress; }
    
    /** Data e hora da inserção do registro no banco */
    @Column(name = "DataHoraRegistroLogApp", columnDefinition = "datetime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date registerDateTime;
    /** GET para a data e hora da inserção do registro no banco */
    public Date getRegisterDateTime() { return registerDateTime; }
    /** SET para a data e hora da inserção do registro no banco */
    public void setRegisterDateTime(Date dateTime) { this.registerDateTime = dateTime; }
    
    /** Login do usuário que executou a ação */
    @Column(name = "LoginDoUsuario", length = 120, nullable = true)
    String userLogin;
    /** GET para o login do usuário que executou a ação */
    public String getUserLogin() { return userLogin; }
    /** SET para o login do usuário que executou a ação */
    public void setUserLogin(String login) { this.userLogin = login; }
    
    /** Nome do módulo ou pacote do sistema onde ocorreu a ação */
    @Column(name = "Modulo", length = 120, nullable = true)
    String module;
    /** GET para o nome do módulo ou pacote do sistema onde ocorreu a ação */
    public String getModule() { return module; }
    /** SET para o nome do módulo ou pacote do sistema onde ocorreu a ação */
    public void setModule(String moduleName) { this.module = moduleName; }
    
    /** Nome da classe onde se encontra o método responsável pela ação */
    @Column(name = "Classe", length = 120, nullable = true)
    String className;
    /** GET para o nome da classe onde se encontra o método responsável pela ação */
    public String getClassName() { return className; }
    /** SET para o nome da classe onde se encontra o método responsável pela ação */
    public void setClassName(String className) { this.className = className; }
    
    /** Nome do método responsável pela ação */
    @Column(name = "Metodo", length = 120, nullable = true)
    String method;
    /** GET para o nome do método responsável pela ação */
    public String getMethod() { return method; }
    /** SET para o nome do método responsável pela ação */
    public void setMethod(String methodName) { this.method = methodName; }
    
    /** Array de parâmetros recebidos pelo método */
    @Column(name = "Parametros", columnDefinition = "TEXT", nullable = true)
    String parameters;
    /** GET para o array de parâmetros recebidos pelo método */
    public String getParameters() { return parameters; }
    /** SET para o array de parâmetros recebidos pelo método */
    public void setParameters(String parameterList) { this.parameters = parameterList; }
    
    /** Caminho completo para arquivo-fonte onde se encontra o método onde ocorreu a ação */
    @Column(name = "UrlArquivoFonte", length = 300, nullable = true)
    String urlSourceFile;
    /** GET para o caminho completo para arquivi-fonte onde se encontra o método onde ocorreu a ação */
    public String getUrlSourceFile() { return urlSourceFile; }
    /** SET para o caminho completo para arquivo-fonte onde se encontra o método onde ocoreu a ação */
    public void setUrlSourceFile(String url) { this.urlSourceFile = url; }
    
    /** Para o caso de erro, número da linha no arquivo-fonte onde foi gerada a exceção */
    @Column(name = "NumeroLinhaCodigoFonte", length = 8, nullable = true)
    String sourceFileLineNumber;
    /** GET para o número da linha, no arquivo-fonte, onde foi gerado o erro */
    public String getSourceFileLineNumber() { return this.sourceFileLineNumber; }
    /** SET para o número da linha, no arquivo-fonte, onde foi gerado o erro */
    public void setSourceFileLineNumber(String lineNumber) { this.sourceFileLineNumber = lineNumber; }
    
    /** Tipo da ação ocorrida */
    @Column(name = "TipoDeAcaoDaAplicacao", nullable = true)
    Long applicationActionType;
    /** GET para o tipo da ação ocorrida */
    public Long getApplicationActionType() { return this.applicationActionType; }
    /** SET para o tipo da ação ocorrida */
    public void setApplicationActionType(Long type) { this.applicationActionType = type; }
    
    /** Código executado no banco, caso haja */
    @Column(name = "SQL_Code", columnDefinition = "TEXT", nullable = true)
    String sqlCode;
    /** GET para o código executado no banco, caso haja */
    public String getSqlCode() { return sqlCode; }
    /** SET para o código executado no banco, caso haja */
    public void setSqlCode(String code) { this.sqlCode = code; }
    
    /** Nome da classe da exceção dispsrada */
    @Column(name = "TipoExcecao", columnDefinition = "TEXT", nullable = true)
    String exceptionType;
    /** GET para o nome da classe de exceção disparada */
    public String getExceptionType() { return this.exceptionType; }
    /** SET para o nome da classe de exceção disparada */
    public void setExceptionType(String exType) { this.exceptionType = exType; }
    
    /** Descritivo da exceção ocorrida */
    @Column(name = "ExcecaoCapturada", columnDefinition = "TEXT", nullable = true)
    String capturedException;
    /** GET para o descritivo da exceção ocorrida */
    public String getCapturedException() { return capturedException; }
    /** SET para o descritivo da exceção ocorrida */
    public void setCapturedException(String exceptionData) { this.capturedException = exceptionData; }
    
    /** Nome do browser utilizado pelo usuário, para o caso da aplicação web */
    @Column(name = "NavegadorWebUsado", length = 100, nullable = true)
    String usedWebBrowser;
    /** GET para o nome do browser utilizado pelo usuário, para o caso da aplicação web */
    public String getUsedWebBrowser() { return this.usedWebBrowser; }
    /** SET para o nome do browser utilizado pelo usuário, para o caso da aplicação web */
    public void setUsedWebBrowser(String webBrowserName) { this.usedWebBrowser = webBrowserName; }
    
    /** Atributo SOURCE da exception */
    @Column(name = "Source", columnDefinition = "TEXT", nullable = true)
    String source;
    /** GET para o atributo SOURCE da exception */
    public String getSource() { return source; }
    /** SET para o atributo SOURCE da exception */
    public void setSource(String source) { this.source = source; }
    
    /** Evento de salvamento do registro */
    @PrePersist
    private void onSave()
    {
        if(this.registerDateTime == null)
        {
            this.registerDateTime = new Date();
        }
    }
}
