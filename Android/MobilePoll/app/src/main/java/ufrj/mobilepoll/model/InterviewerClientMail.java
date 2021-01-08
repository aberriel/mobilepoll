package ufrj.mobilepoll.model;

/**
 * Classe do modelo de dados de controle de comunicação entre cliente e entrevistador
 * Created by alira on 12/10/15.
 */
public class InterviewerClientMail
{
    /** Construtor */
    public InterviewerClientMail() { }

    /** Identificador único do registro no banco */
    private long id;
    /** GET para o identificador único do registro no banco */
    public long getId() { return id; }
    /** SET para o identificador único do registro no banco */
    public void setId(long id) { this.id = id; }

    /** Status de envio da mensagem */
    private int messageStatus;
    /** GET para o status de envio da mensagem */
    public int getMessageStatus() { return messageStatus; }
    /** SET para o status de envio da mensagem */
    public void setMessageStatus(int status) { this.messageStatus = status; }

    /** Sentido da mensagem (entrevistador -> cliente ou o inverso) */
    private int messageDirection;
    /** GET para o sentido da mensagem */
    public int getMessageDirection() { return messageDirection; }
    /** SET para o sentido da mensagem */
    public void setMessageDirection(int direction) { this.messageDirection = direction; }

    /** Mensagem enviada */
    private String message;
    /** GET para a mensagem enviada */
    public String getMessage() { return message; }
    /** SET para a mensagem enviada */
    public void setMessage(String message) { this.message = message; }

    /** Flag de requisição de confirmação de abertura no destinatário */
    private boolean openConfirmation;
    /** GET para o flag de requisição de confirmação de abertura da mensagem */
    public boolean isOpenConfirmation() { return openConfirmation; }
    /** SET para o flag de requisição de confirmação de abertura da mensagem */
    public void setOpenConfirmation(boolean confirmation) { this.openConfirmation = confirmation; }

    private long communicationControlId;
    public long getCommunicationControlId() { return communicationControlId; }
    public void setCommunicationControlId(long id) { this.communicationControlId = id; }

    private CommunicationControl communicationControl;
    public CommunicationControl getCommunicationControl() { return communicationControl; }
    public void setCommunicationControl(CommunicationControl communicationControl) { this.communicationControl = communicationControl; }
}