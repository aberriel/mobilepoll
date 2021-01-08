package mobilepoll.data.model;

import mobilepoll.data.model.enums.MailMessageStatus_Tp;
import javax.persistence.*;
import org.hibernate.annotations.Type;

/**
 * Classe persistente do hibernate para gerenciamento da troca de mensagens entre cliente
 * (empresa) e entrevistador (funcionário)
 * 
 * @author alira
 */
@Entity
@Table(name = "CorreioClienteEntrevistador")
public class InterviewerClientMail
{
    public void DoInit()
    {
        this.messageStatus = MailMessageStatus_Tp.None;
        this.openConfirmation = false;
    }
    
    /** Construtor */
    public InterviewerClientMail()
    {
        this.DoInit();
    }
    
    /**
     * Construtor
     * @param client Cliente envolvido na comunicação
     * @param interviewer Entrevistado envolvido na comunicação
     */
    public InterviewerClientMail(Client client, User interviewer)
    {
        this.DoInit();
        this.client = client;
        this.interviewer = interviewer;
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
    
    /** Cliente envolvido na mensagem */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Cliente", nullable = false)
    Client client;
    /** GET para o cliente envolvido na mensagem */
    public Client getClient() { return client; }
    /** SET para o cliente envolvido na mensagem */
    public void setClient(Client client) { this.client = client; }
    
    /** Entrevistador envolvido na mensagem */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Entrevistador", nullable = false)
    User interviewer;
    /** GET para o entrevistador envolvido na mensagem */
    public User getInterviewer() { return interviewer; }
    /** SET para o entrevistador envolvido na mensagem */
    public void setInterviewer(User interviewer) { this.interviewer = interviewer; }
    
    /** Conteúdo da mensagem (mensagem propriamente dita) */
    @Column(name = "Mensagem", columnDefinition = "TEXT", nullable = false)
    String message;
    /** GET para o conteúdo da mensagem */
    public String getMessage() { return message; }
    /** SET para o conteúdo da mensagem */
    public void setMessage(String msg) { this.message = msg; }
    
    /** Sentido da comunicação (se cliente -> entrevistador ou entrevistador -> cliente) */
    @Column(name = "SentidoComunicacao", nullable = false)
    int communicationDirection;
    /** GET para o sentido da comunicação (se cliente -> entrevistador ou entrevistador -> cliente) */
    public int getCommunicationDirection() { return communicationDirection; }
    /** SET para o sentido da comunicação (se cliente -> entrevistador ou entrevistador -> cliente) */
    public void setCommunicationDirection(int direction) { this.communicationDirection = direction; }

    /** Registro de controle de comunicação associado */
    @OneToOne(fetch = FetchType.EAGER,
              cascade = CascadeType.ALL)
    @JoinColumn(name = "ControleDeComunicacao", nullable = true)
    CommunicationControl communicationControl;
    /** GET para o registro de controle de comunicação associado */
    public CommunicationControl getCommunicationControl() { return communicationControl; }
    /** SET para o registro de controle de comunicação associado */
    public void setCommunicationControl(CommunicationControl controlData) { this.communicationControl = controlData; }
    
    /** Status do envio ou recebimento da mensagem */
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "StatusMensagemCorreio", nullable = true)
    MailMessageStatus_Tp messageStatus;
    /** GET para o status do envio ou recebimento da mensagem */
    public MailMessageStatus_Tp getMessageStatus() { return messageStatus; }
    /** SET para o status do envio ou recebimento da mensaqgem */    
    public void getMailMessageStatus(MailMessageStatus_Tp status) { this.messageStatus = status; }
    
    /** Flag indicador de necessidade de envio de confirmação de abertura pelo destinatário */
    @Column(name = "ConfirmacaoAbertura", columnDefinition = "TINYINT", length = 1, nullable = true)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    Boolean openConfirmation;
    /** GET para o flag indicador de necessidade de envio de confirmação de abertura pelo destinatário */
    public Boolean getOpenConfirmation() { return this.openConfirmation; }
    /** SET para o flag indicador de necessidade de envio de confirmação de abertura pelo desatinatário */
    public void setOpenConfirmation(Boolean confirmation) { this.openConfirmation = confirmation; }
}
