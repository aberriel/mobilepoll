package mobilepoll.data.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.*;

/**
 * Classe persistente para a tabela de gerenciamento de sessões do usuário
 * @author alira
 */
@Entity
@Table(name = "GerenciadorSessao")
public class SessionManager
{
    /** Construtor */
    public SessionManager() { }
    
    /** Identificador único do registro no sistema */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    long id;
    /** GET para o identificador único do registro no sistema */
    public long getId() { return id; }
    /** SET para o identificador único do registro no sistema */
    public void setId(long id) { this.id = id; }
    
    /** Sistema onde o usuário autenticou */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OrigemSessao", nullable = false)
    System sessionOrigin;
    /** GET para o sistema onde o usuário autenticou */
    public System getSessionOrigin() { return sessionOrigin; }
    /** SET para o sistema onde o usuário autenticou */
    public void setSessionIrigin(System origin) { this.sessionOrigin = origin; }
    
    /** Chave pública identificadora da sessão */
    @Column(name = "ChaveSessao", length = 50, nullable = false)
    String sessionKey;
    /** GET para a chave pública identificadora da sessão */
    public String getSessionKey() { return sessionKey; }
    /** SET para a chave pública identificadora da sessão */
    public void setSessionKey(String key) { this.sessionKey = key; }
    
    /** Chave pública identificadora do sistema onde o usuário autenticou */
    @Column(name = "ChaveSistema", length = 50, nullable = false)
    String systemKey;
    /** GET para a chave pública identificadora do sistema onde o usuário autenticou */
    public String getSystemKey() { return systemKey; }
    /** SET para a chave pública identificadora do sistema onde o usuário autenticou */
    public void setSystemKey(String key) { this.systemKey = key; }
    
    /** Identificador do usuário autenticado */
    @Column(name = "IdUsuarioAutenticado", nullable = true)
    Long authenticatedUserId;
    /** GET para o identificador do usuário autenticado */
    public Long getAuthenticatedUserId() { return authenticatedUserId; }
    /** SET para o identificador do usuário autenticado */
    public void setAuthenticatedUserId(Long id) { this.authenticatedUserId = id; }
    
    /** Data e hora do início da sessão */
    @Column(name = "DataHoraInicio", columnDefinition = "datetime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)            
    Date initDateTime;
    /** GET para a data e hora do início da sessão */
    public Date getInitDateTime() { return initDateTime; }
    /** SET para a data e hora do início da sessão */
    public void setInitDateTime(Date dateTime) { this.initDateTime = dateTime; }
    
    /** Data e hora da última ação executada pelo usuário */
    @Column(name = "DataHoraUltimaMovimentacao", columnDefinition = "datetime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date lastActionDateTime;
    /** GET para a data e hora da última ação executada pelo usuário */
    public Date getLastActionDateTime() { return lastActionDateTime; }
    /** SET para a data e hora da última ação executada pelo usuário */
    public void setLastActionDateTime(Date dateTime) { this.lastActionDateTime = dateTime; }
    
    /** Data e hora em que a sessão expirou */
    @Column(name = "DataHoraExpiracao", columnDefinition = "datetime", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    Date expirationDateTime;
    /** GET para a data e hora em que a sessão expirou */
    public Date getExpirationDateTime() { return expirationDateTime; }
    /** SET para a data e hora em que a sessão expirou */
    public void setExpirationDateTime(Date dateTime) { this.expirationDateTime = dateTime; }
    
    /** Motivo do fim da sessão */
    @Column(name = "MotivoTermino", columnDefinition = "TEXT", nullable = true)
    String finishReason;
    /** GET para o motivo do fim da sessão */
    public String getfinishReason() { return finishReason; }
    /** SET para o motivo do fim da sessão */
    public void setFinishReason(String reason) { this.finishReason = reason; }
    
    /** Evento de persistência do objeto pro banco */
    @PrePersist
    private void onSave() throws Exception
    {
        if(this.sessionKey == null || this.sessionKey.isEmpty())
        {
            this.sessionKey = UUID.randomUUID().toString();
        }
        
        if(this.initDateTime == null)
        {
            // Setando a data e hora de início da sessão
            this.initDateTime = new Date();
        }
        
        this.lastActionDateTime = new Date();
        
        if(this.sessionOrigin != null)
        {
            this.systemKey = this.sessionOrigin.systemKey;
        }
        
        if(this.authenticatedUserId < 1)
        {
            throw new Exception("Usuário autenticado inválido.");
        }
    }
}