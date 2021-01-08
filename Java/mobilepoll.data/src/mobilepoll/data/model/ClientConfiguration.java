package mobilepoll.data.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe persistente para configuraçoes do cliente
 * @author alira
 */
@Entity
@Table(name = "ConfiguracaoCliente")
public class ClientConfiguration
{
    private void doInit()
    {
        this.invalidationDateTime = null;
    }
    
    /** Construtor */
    public ClientConfiguration()
    {
        this.doInit();
    }
    
    /**
     * Construtor
     * @param client Cliente dono da configuração
     */
    public ClientConfiguration(Client client)
    {
        this.client = client;
    }
    
    /**
     * Construtor
     * @param client Cliente dono da configuração
     * @param system Sistema ao qual a configuração se aplica.
     */
    public ClientConfiguration(Client client, System system)
    {
        this.client = client;
        this.system = system;
    }
    
    /** Identificador único do registro no banco */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    long id;
    /** GET para o id do registro no banco */
    public long getId() { return id; }
    /** SET para o id do registro no banco */
    public void setId(long id) { this.id = id; }
    
    /** Sistema ou aplicação ao qual a configuração se aplica */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Sistema", nullable = false)
    System system;
    /** GET para o sistema alvo da configuração */
    public System getSystem() { return system; }
    /** SET para o sistema alvo da configuração */
    public void setSystem(System system) { this.system = system; }
    
    /** Cliente dono da configuraçao */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Cliente", nullable = false)
    Client client;
    /** GET para o cliente dono da configuração */
    public Client getClient() { return client; }
    /** SET para o cliente dono de configuração */
    public void setClient(Client client) { this.client = client; }
    
    /** Data e hora de inserção do registro no banco */
    @Column(name = "DataHoraRegistro", columnDefinition = "datetime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date registerDateTime;
    /** GET para a data e hora da inserção do registro no banco */
    public Date getRegisterDateTime() { return registerDateTime; }
    /** SET para a data e hora da inserção do registro no banco */
    public void setRegisterDateTime(Date dateTime) { this.registerDateTime = dateTime; }
    
    /**
     * Data e hora da invalidação da configuração do cliente.
     * A invalidação ocorre na criação de uma configuração nova, que passa a ser válida
     */
    @Column(name = "DataHoraInvalidacao", columnDefinition = "datetime", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    Date invalidationDateTime;
    /** GET para a data e hora da invalidação da configuração */
    public Date getInvalidationDateTime() { return this.invalidationDateTime; }
    /** SET para a data e hora da invalidação da configuração */
    public void setInvalidationDateTime(Date dateTime) { this.invalidationDateTime = dateTime; }
    
    /** Prazo de validade da senha de usuário do cliente */
    @Column(name = "PeriodoTrocaPeriodicaSenha", columnDefinition = "timestamp", nullable = true)
    @Temporal(TemporalType.TIME)
    Date passwordExpirationPeriod;
    /** GET para o prazo de troca da senha do usuário do cliente */
    public Date getPasswordExpirationPeriod() { return this.passwordExpirationPeriod; }
    /** SET para o prazo de troca da senha do usuário do cliente */
    public void setPasswordExpirationPeriod(Date time) { this.passwordExpirationPeriod = time; }
    
    /** Tempo máximo para responder uma enquete */
    @Column(name = "ToleranciaParaResponderEnquete", columnDefinition = "timestamp", nullable = true)
    @Temporal(TemporalType.TIME)
    Date toleranceToResponsePoll;
    /** GET para o tempo máximo para responder uma enquete */
    public Date getToleranceToResponsePoll() { return this.toleranceToResponsePoll; }
    /** SET para o tempo máximo para responder uma enquete */
    public void setToleranceToResponsePoll(Date tolerance) { this.toleranceToResponsePoll = tolerance; }
    
    /** Tempo máximo que o usuário pode ficar sem gerar ação no sistema */
    @Column(name = "ToleranciaSemMovimentacao", columnDefinition = "timestamp", nullable = true)
    @Temporal(TemporalType.TIME)
    Date toleranceWithoutMovement;
    /** GET para o tempo sem movimentação até finalizar a sessão */
    public Date getToleranceWithoutMovement() { return this.toleranceWithoutMovement; }
    /** SET para o tempo sem movimentação até finalizar a sessão */
    public void setToleranceWithoutMovement(Date tolerance) { this.toleranceWithoutMovement = tolerance; }
    
    @PrePersist
    private void onSave()
    {
        if(this.registerDateTime == null)
        {
            this.registerDateTime = new Date();
        }
    }
}