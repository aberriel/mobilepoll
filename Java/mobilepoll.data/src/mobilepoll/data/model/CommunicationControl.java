package mobilepoll.data.model;

import java.util.Date;
import java.util.UUID;
import javax.persistence.*;
import org.hibernate.annotations.Type;

/**
 * Gerenciamento das comunicações entre o servidor e os dispositivos mõveis
 * @author alira
 '*/
@Entity
@Table(name = "ControleComunicacao")
public class CommunicationControl
{
    /** Construtor */
    public CommunicationControl() { }
    
    /** Identificador único do registro no sistema */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    long id;
    /** GET para o identificador único do registro no sistema */
    public long getId() { return id; }
    /** SET para o identificador único do registro no sistema */
    public void setId(long id) { this.id = id; }
    
    /** Identificador do registro remoto de comunicação */
    @Column(name = "IdRemoto", nullable = true)
    Long remoteId;
    /** GET para o identificador do registro remoto de comunicação */
    public Long getRemoteId() { return remoteId; }
    /** SET para o identificador do registro remoto de comunicação */
    public void setRemoteId(Long rId) { this.remoteId = rId; }
    
    /** Identificador da operação a ser realizada */
    @Column(name = "IdOperacao", nullable = true)
    Integer operationId;
    /** GET para o identificador da operação a ser realizada */
    public Integer getOperationId() { return operationId; }
    /** SET para o identificador da operação a ser realizada */
    public void setOperationId(Integer oId) { this.operationId = oId; }
    
    /** Dispositivo móvel com o qual houve a comunicação */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DispositivoMovel", nullable = false)
    MobileDevice mobileDevice;
    /** GET para o dispositivo móvel com o qual houve a comunicação */
    public MobileDevice getMobileDevice() { return mobileDevice; }
    /** SET para o dispoaitivo móvel com o qual houve a comunicação */
    public void setMobileDevice(MobileDevice mobileDevice) { this.mobileDevice = mobileDevice; }
    
    /** Data e hora do envio do pacote */
    @Column(name = "DataHoraSaida", columnDefinition = "datetime", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    Date departureDateTime;
    /** GET para a data e hora do envio do pacote */
    public Date getDepartureDateTime() { return departureDateTime; }
    /** SET para a data e hora do envio do pacote */
    public void setDepartureDateTime(Date dateTime) { this.departureDateTime = dateTime; }
    
    /** Data e hora do recebimento do pacote */
    @Column(name = "DataHoraEntrada", columnDefinition = "datetime", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    Date incomingDateTime;
    /** GET para a data e hora do recebimento do pacote */
    public Date getIncomingDateTime() { return incomingDateTime; }
    /** SET para a data e hora do recebimento do pacote */
    public void setIncomingDateTime(Date dateTime) { this.incomingDateTime = dateTime; }
    
    /** Conteúdo do pacote de envio/saída */
    @Column(name = "ConteudoPacoteSaida", columnDefinition = "TEXT", nullable = true)
    String departurePackageContent;
    /** GET para o conteúdo do pacote de envio/saída */
    public String getDeparturePackageContent() { return departurePackageContent; }
    /** SET para o conteúdo do pacote de envio/saída */
    public void setDeparturePackageContent(String content) { this.departurePackageContent = content; }
    
    /** Conteúdo do pacote de retorno/entrada */
    @Column(name = "ConteudoPacoteEntrada", columnDefinition = "TEXT", nullable = true)
    String incomingPackageContent;
    /** GET para o conteúdo do pacote de retorno/entrada */
    public String getIncomingPackageContent() { return incomingPackageContent; }
    /** SET para o conteúdo do pacote de retorno/entrada */
    public void setIncomingPackageContent(String content) { this.incomingPackageContent = content; }
    
    /** Flag indicador de retorno requerido */
    @Column(name = "PossuiRetorno", nullable = false, columnDefinition = "TINYINT", length = 1)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    boolean hasReturn;
    /** GET para o flag indicador de retorno requerido */
    public boolean getHasReturn() { return hasReturn; }
    /** SET para o flag indicador de retorno requerido */
    public void setHasReturn(boolean hR) { this.hasReturn = hR; }
    
    /** Chave pública identificadora do usuário que realizou a requisição */
    @Column(name = "ChaveUsuario", length = 50, nullable = true)
    String userKey;
    /** GET para a chave pública identificadora do usuário que realizou a requisição */
    public String getUserKey() { return userKey; }
    /** SET para a chave pública identificadora do usuário que realizou a requisição */
    public void setUserKey(String key) { this.userKey = key; }
    
    /**
     * Sentido da comunicação:
     * 
     *      1 - Servidor -> Dispositivo móvel
     *          >> Mensagem inicial enviada
     *          >> Flag de necessidade de retorno indicando o aguardo na resposta do dispositivo móvel
     * 
     *      2 - Dispositivo Móvel -> Servidor
     *          >> Mensagem inicial recebida
     *          >> Flag de necessidade de retorno indicando que ao fim do processamento,
     *             deverá ser enviada uma resposta ao dispositivo móvel
     *          >> Neste caso, quem aguarda é o dispositivo móvel
     */
    @Column(name = "SentidoComunicacao", nullable = false)
    int communicationDirection;
    /** GET para o sentido da comunicação */
    public int getCommunicationDirection() { return this.communicationDirection; }
    /** SET para o sentido da comunicação */
    public void setCommunicationDirection(int direction) { this.communicationDirection = direction; }
    
    /** Status do processamento da comunicação */
    @Column(name = "Processado", nullable = false, columnDefinition = "TINYINT", length = 1)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    boolean processed;
    /** GET para o status do processamento da comunicação */
    public boolean isProcessed() { return processed; }
    /** SET para o status do processamento da comunicação */
    public void setProcessed(boolean processed) { this.processed = processed; }
    
    /** Descritivo do erro ocorrido, quando houver um */
    @Column(name = "MensagemErro", columnDefinition = "TEXT", nullable = true)
    String errorMessage;
    /** GET para o descritivo do erro ocorrido */
    public String getErrorMessage() { return errorMessage; }
    /** SET para o descritivo do eror ocorrido */
    public void setErrorMessage(String message) { this.errorMessage = message; }
    
    /** Chave pública identificadora da comunicação */
    @Column(name = "ChaveComunicacao", length = 50, nullable = true, unique = true)
    String communicationKey;
    /** GET para a chave pública identificadora da comunicação */
    public String getCommunicationKey() { return communicationKey; }
    /** SET para a chave pública identificadora da comunicação */
    public void setCommunicationKey(String key) { this.communicationKey = key; }
    
    /** Evento de salvamento do objeto */
    @PrePersist
    private void onSave()
    {
        if(this.communicationKey == null || this.communicationKey.isEmpty())
        {
            this.communicationKey = UUID.randomUUID().toString();
        }
    }    
}