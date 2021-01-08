package ufrj.mobilepoll.model;

import java.util.Date;

/**
 * Classe do modelo de dados de gerenciamento de comunicação entre dispositivo móvel e servidor
 * Created by alira on 12/10/15.
 */
public class CommunicationControl
{
    /** Construtor */
    public CommunicationControl() { }

    /** Identificador único do registro no banco */
    private long id;
    /** GET para o identificador único do registro no banco */
    public long getId() { return id; }
    /** SET para o identificador único do registro no banco */
    public void setId(long id) { this.id = id; }

    /** Conteúdo da mensagem */
    private String packageContent;
    /** GET para o conteúdo da mensagem */
    public String getPackageContent() { return packageContent; }
    /** SET para o conteúdo da mensagem */
    public void setPackageContent(String content) { this.packageContent = content; }

    /** Operação requerida no servidor */
    private int operation;
    /** GET para a operação requerida no servidor */
    public int getOperation() { return operation; }
    /** SET para a operação requerida no servidor */
    public void setOperation(int operation) { this.operation = operation; }

    /** Data e hora do envio da mensagem */
    private Date sendDateTime;
    /** GET para a data e hora de envio da mensagem */
    public Date getSendDateTime() { return sendDateTime; }
    /** SET para a data e hora de envio da mensagem */
    public void setSendDateTime(Date dateTime) { this.sendDateTime = dateTime; }

    /** Data e hora do recebimento da mensagem */
    private Date receiveDateTime;
    /** GET para a data e hora de recebimento da mensagem */
    public Date getReceiveDateTime() { return receiveDateTime; }
    /** SET para a data e hora de recebimento da mensagem */
    public void setReceiveDateTime(Date dateTime) { this.receiveDateTime = dateTime; }

    private boolean requireFeedback;
    public boolean isRequireFeedback() { return requireFeedback; }
    public void setRequireFeedback(boolean require) { this.requireFeedback = require; }

    private boolean requireImmediateFeedback;
    public boolean isRequireImmediateFeedback() { return requireImmediateFeedback; }
    public void setRequireImmediateFeedback(boolean requireImmediate) { this.requireImmediateFeedback = requireImmediate; }

    /** Flag indicador de processamento da requisição */
    private boolean processed;
    /** GET para o flag indicador de processamento da requisição. */
    public boolean isProcessed() { return processed; }
    /** SET para o flag indicador de processamento da requisição. */
    public void setProcessed(boolean processed) { this.processed = processed; }

    /** Conteúdo da mensagem de retorno, para comunicações que exigem retorno */
    private String communicationResponse;
    /** GET para o conteúdo da mensagem de retorno */
    public String getCommunicationResponse() { return communicationResponse; }
    /** SET para o conteúdo da mensagem de retorno */
    public void setCommunicationResponse(String response) { this.communicationResponse = response; }

    /** Sentido da comunicação (servidor -> dispositivo móvel ou inverso) */
    private int communicationDirection;
    /** GET para o sentido da comunicação */
    public int getCommunicationDirection() { return communicationDirection; }
    /** SET para o sentido da comunicação */
    public void setCommunicationDirection(int direction) { this.communicationDirection = direction; }

    /** Mensagem de erro devido a problemas ocorridos na transmissão ou processamento da mensagem */
    private String errorMessage;
    /** GET para a mensagem de erros de transmissão ou processamento */
    public String getErrorMessage() { return errorMessage; }
    /** SET para a mensagem de erros de transmissão ou processamento */
    public void setErrorMessage(String message) { this.errorMessage = message; }
}