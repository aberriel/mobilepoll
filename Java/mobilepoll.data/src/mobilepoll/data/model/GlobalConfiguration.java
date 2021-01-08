package mobilepoll.data.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * Classe persistente do hibernate para as configurações globais do sistema.
 * @author alira
 */
@Entity
@Table(name = "ConfiguracaoGlobal")
public class GlobalConfiguration
{
    private void doInit()
    {
        this.invalidationDateTime = null;
        this.connectedUserGlobalLimit = 0;
        this.connectedUserPerClientLimit = 0;
    }
    
    /** Construtor */
    public GlobalConfiguration()
    {
        this.doInit();
    }
    
    /**
     * Construtor
     * @param system Sistema ou aplicação ao qual a configuração se aplica
     */
    public GlobalConfiguration(System system)
    {
        this.doInit();
        this.system = system;
    }
    
    /** Identificador único do registro no sistema. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    long id;
    /** GET para o identificador único do registro no sistema. */
    public long getId() { return id; }
    /** Set para o identificador único do registro no sistema. */
    public void setId(long id) { this.id = id; }
    
    /** Sistema ao qual se aplica a configuração. */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Sistema", nullable = false)
    System system;
    /** GET para o sistema ao qual se aplica a configuração. */
    public System getSystem() { return system; }
    /** SET para o sistema ao qual se aplica a configuração. */
    public void setSystem(System system) { this.system = system; }
    
    /** Definições do SMTP para envio de e-mail */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ConfiguracaoEnvioCorreioEletronicoGlobal", nullable = true)
    EmailData sendMailGlobalConfiguration;
    /** GET para as definições de SMTP para envio de e-mail */
    public EmailData getSendMailGlobalConfiguration() { return this.sendMailGlobalConfiguration; }
    /** SET para as definições de SMTP para envio de e-mail */
    public void setSendMailGlobalConfiguration(EmailData globalMailConfiguration) { this.sendMailGlobalConfiguration = globalMailConfiguration; }
    
    /**
     * Senha mestra.
     * 
     * A senha mestra consiste em uma estratégia para suporte e manutenção do sistema, pois
     * permite que qualquer usuário administrativo acesse o perfil de qualquer cliente desde
     * que forneça a senha mestra.
     */
    @Column(name = "SenhaMestra", length = 64, nullable = true)
    String masterPassword;
    /** GET para a senha mestra. */
    public String getMasterPassword() { return masterPassword; }
    /** SET para a senha mestra. */
    public void setMasterPassword(String password) { this.masterPassword = password; }
    
    /**
     * Tempo máximo permitido para respoder enquete, aplicável a todos os clientes.
     * 
     * Salvo se o cliente definir o seu tempo, este será o limite aplicável.
     * No caso de tempo ilimitado, basta definir o tempo zero (00:00).
     */
    @Column(name = "ToleranciaParaResponderEnquete", columnDefinition = "time", nullable = true)
    @Temporal(TemporalType.TIME)
    Date pollAnswerTolerance;
    /** GET para o tempo máximo permitido para responder enquete. */
    public Date getPollAnswerTolerance() { return this.pollAnswerTolerance; }
    /** SET para o tempo máximo permitido para responder enquete. */
    public void setPollAnswerTolerance(Date tolerance) { this.pollAnswerTolerance = tolerance; }
    
    /**
     * Tempo limite para sessão do usuário.
     * 
     * Se definido, após esse tempo, o usuário será deslogado automaticamente.
     * Para não definir o limite, basta manter nulo ou zero (00:00).
     */
    @Column(name = "TempoLimiteSessao", columnDefinition = "time", nullable = true)
    @Temporal(TemporalType.TIME)
    Date sessionTimeLimit;
    /** GET para o tempo limite da sessão do usuário. */
    public Date getSessionTimeLimit() { return this.sessionTimeLimit; }
    /** SET para o tempo limite da sessão do usuário */
    public void setSessionTimeLimit(Date limit) { this.sessionTimeLimit = limit; }
    
    /**
     * Tempo limite sem atividade.
     * 
     * Caso o usuário permaneça por tempo igual ou superior ao definido, será
     * desautenticado automaticamente, tendo que entrar novamente.
     * Para impedir que o bloqueio por flata de movimentação ocorra, basta
     * definir o tempo zero (00:00) ou manter sem valor (nulo).
     */
    @Column(name = "ToleranciaSemMovimentacao", nullable = true, columnDefinition = "time")
    @Temporal(TemporalType.TIME)
    Date maximumToleranceWithoutHandling;
    /** GET para o tempo limite sem atividade. */
    public Date getMaximumToleranceWithoutHandling() { return this.maximumToleranceWithoutHandling; }
    /** SET para o tempo limite sem atividade. */
    public void setMaximumToleranceWithoutHandling(Date tolerance) { this.maximumToleranceWithoutHandling = tolerance; }
    
    /** Limite de usuários conectados ao mesmo tempo */
    @Column(name = "MaximoUsuariosConectadosGlobal", nullable = false)
    int connectedUserGlobalLimit;
    /** GET para o limite de usuários conectados ao mesmo tempo */
    public int getConnectedUsetGlobalLimit() { return this.connectedUserGlobalLimit; }
    /** SET para o limite de usuários conectados ao mesmo tempo */
    public void setConnectetUserGlobalLimit(int limit) { this.connectedUserGlobalLimit = limit; }
    
    /** Limite de usuários conectados ao mesmo tempo por cliente */
    @Column(name = "MaximoUsuariosConectadosPorCliente", nullable = false)
    int connectedUserPerClientLimit;
    /** GET para o limite de usuários conectados ao mesmo tempo por cliente */
    public int getConnectedUserPerClientLimnit() { return this.connectedUserGlobalLimit; }
    /** SET para o limite de usuários conectados ao mesmo tempo por cliente */
    public void setConnectedUserPerClientLimit(int limit) { this.connectedUserPerClientLimit = limit; }
    
    /** Data e hora do registro da configuraão */
    @Column(name = "DataHoraRegistro", columnDefinition = "datetime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date registerDateTime;
    /** Data e hora do registro da configuração. */
    public Date getRegisterDateTime() { return registerDateTime; }
    /** SET para a data e hora do registro da configuração. */
    public void setRegisterDateTime(Date dateTime) { this.registerDateTime = dateTime; }
    
    /**
     * Data e hora da invalidação da configuraão.
     * 
     * A configuração é mantida no banco por questões de histórico mas passa
     * para o estado inválido.
     */
    @Column(name = "DataHoraInvalidacao", columnDefinition = "datetime", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    Date invalidationDateTime;
    /** GET para a data e hora da invalidação da configuração. */
    public Date getInvalidationDateTime() { return this.invalidationDateTime; }
    /** SET para a data e hora da invalidação da configuração. */
    public void setInvalidationDateTime(Date dateTime) { this.invalidationDateTime = dateTime; }
    
    @PrePersist
    private void onSave() throws Exception
    {
        if(this.registerDateTime == null)
        {
            this.registerDateTime = new Date();
        }
        
        if(this.connectedUserGlobalLimit < 0)
        {
            throw new Exception("O valor do limite de usuários conectados globalmente deve ser igual ou maior que zero.");
        }
        
        if(this.connectedUserPerClientLimit < 0)
        {
            throw new Exception("O valor do limite de usuários conectados por cliente deve ser igual ou maior que zero.");
        }
    }
}