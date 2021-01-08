package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Type;

/**
 * Permissionamento de execução da pesquisa através do dispositivo móvel.
 * A liberação da pesquisa se dará pela associação desta ao usuário diretamente, no sistema
 * @author alira
 */
@Entity
@Table(name = "AutorizacaoUsuarioPesquisa")
public class UserResearchAuthorization
{
    public UserResearchAuthorization() { }
    
    public UserResearchAuthorization(User user, Research research)
    {
        this.user = user;
        this.research = research;
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
    
    /** Usuário que possui a permissão para execução da pesquisa no dispositivo móvel */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "Usuario", nullable = false)
    User user;
    /** GET para o usuário que possui a permissão para execução da pesquisa em dispositivos móveis */
    public User getUser() { return user; }
    /** SET para o usuário que possui a permissão para execução da pesquisa em dispositivos móveis */
    public void setUser(User user) { this.user = user; }
    
    /** Pesquisa para a qual o usuário obteve permissão */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "Pesquisa", nullable = false)
    Research research;
    /** GET para a pesquisa para a qual o usuário obteve permissão */
    public Research getResearch() { return research; }
    /** SET para a pesquisa para a qual o usuário obteve permissão */
    public void setResearch(Research research) { this.research = research; }
    
    /** Data e hora da autorização */
    @Column(name = "DataHoraAutorizacao", nullable = false, columnDefinition = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    Date authorizatinDatetime;
    /** GET para a data e hora da autorização */
    public Date getAuthorizationDateTime() { return this.authorizatinDatetime; }
    /** SET para a data e hora da autorização */
    public void setAuthorizationDateTime(Date dateTime) { this.authorizatinDatetime = dateTime; }
    
    /** Status da permissão (válida ou não) */
    @Column(name = "Valido", nullable = false, columnDefinition = "TINYINT", length = 1)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    boolean valid;
    /** GET para o status da permissão (válida ou não) */
    public boolean isValid() { return valid; }
    /** SET para o status da permissão (válida ou não) */
    public void setValid(boolean isValid) { this.valid = isValid; }
    
    /** Data e hora da revogação da permissão. */
    @Column(name = "DataHoraInvalidacao", nullable = true, columnDefinition = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    Date invalidationDateTime;
    /** GET para a data e hora da revogação da permissão */
    public Date getInvalidationDateTime() { return this.invalidationDateTime; }
    /** SET para a data e hora da revogação da permissão */
    public void setInvalidationDateTime(Date dateTime) { this.invalidationDateTime = dateTime; }
}
