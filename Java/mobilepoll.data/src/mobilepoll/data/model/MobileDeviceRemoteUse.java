package mobilepoll.data.model;

import mobilepoll.data.model.enums.RemoteActionType_Tp;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * Controle de requisições de dispositivos móveis ao servidor
 * @author alira
 */
@Entity
@Table(name = "UsoRemotoDM")
public class MobileDeviceRemoteUse
{
    private void doInit()
    {
        // Por padrão, a requisição será de consulta a dados
        this.remoteActionType = RemoteActionType_Tp.DataQuery;
    }
    
    /** Construtor */
    public MobileDeviceRemoteUse()
    {
        this.doInit();
    }
    
    /**
     * Construtor
     * @param imei Número de série do dispositivo que realizou a requisição
     */
    public MobileDeviceRemoteUse(String imei)
    {
        this.doInit();
        this.imei = imei;
    }
    
    /**
     * Construtor
     * @param imei Número de série do dispositivo que realizou a requisição
     * @param dateTime Data e hora do recebimento da requisição no servidor
     */
    public MobileDeviceRemoteUse(String imei, Date dateTime)
    {
        this.doInit();
        this.imei = imei;
        this.dateTime = dateTime;
    }
    
    /** Identificador único do registro no banco */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    /** GET para o identificador único do registro no banco */
    public long getId() { return id; }
    /** SET para o identificador único do registro no banco */
    public void setId(long id) { this.id = id; }
    
    /** Data e hora em que se deu o envio da requisição do dispositivo para o servidor */
    @Column(name = "DataHora", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date dateTime;
    /** GET para a data e hora em que se deu o envio da requisição do dispositivo para o servidor */
    public Date getDateTime() { return dateTime; }
    /** SET para a data e hora em que se deu o envio da requisição do dispositivo para o servidor */
    public void setDateTime(Date dateTime) { this.dateTime = dateTime; }
    
    /** Uso sob o qual esta operação remota foi realizada */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ControleDeUsoDoDispositivoMovel", nullable = true)
    MobileDeviceUsageControl usageControl;
    /** GET para o uso sob o qual esta operação remota foi realizada */
    public MobileDeviceUsageControl getUsageControl() { return this.usageControl; }
    /** SET para o uso sob o qual esta operação remota foi realizada */
    public void setUsageControl(MobileDeviceUsageControl mduc) { this.usageControl = mduc; }
    
    /** Tipo da ação executada/requisitada */
    @Column(name = "TipoDeAcaoRemota")
    @Enumerated(EnumType.ORDINAL)
    RemoteActionType_Tp remoteActionType;
    /** GET para o tipo da ação executada/requisitada */
    public RemoteActionType_Tp getRemoteActionType() { return this.remoteActionType; }
    /** SET para o tipo da ação executada/requisitada */
    public void setRemoteActionType(RemoteActionType_Tp type) { this.remoteActionType = type; }
    
    /** Endereço ip do dispositivo móvel */
    @Column(name = "ip", length = 15)
    String ip;
    /** GET para o endereço ip do dispositivo móvel */
    public String getIp() { return ip; }
    /** SET para o endereço ip do dispositivo móvel */
    public void setId(String ip) { this.ip = ip; }
    
    /**
     * IMEI do dispositivo móvel.
     * É através desse campo que o dispositivo será identificado
     */
    @Column(name = "imei", length = 20)
    String imei;
    /** GET para o IMEI do dispositivo móvel */
    public String getImei() { return imei; }
    /** SET para o IMEI do dispositivo móvel */
    public void setImei(String imei) { this.imei = imei; }
    
    /**
     * Comentários e/ou observações pertinentes.
     * 
     * Quaisquer informações adicionais serão registradas nesse campo.
     */
    @Column(name = "Comentarios", length = 3000, nullable = true)
    String comments;
    /** GET para as informações adicionais */
    public String getComments() { return comments; }
    /** SET para as informações adicionais */
    public void setComments(String comments) { this.comments = comments; }
    
    /** Dados de localização do dispositivo móvel */
    @OneToOne(fetch = FetchType.LAZY,
              cascade = CascadeType.ALL)
    @JoinColumn(name = "DadosGps", nullable = true)
    GpsData gpsData;
    /** GET para os dados de localização do dispositivo móvel */
    public GpsData getGpsData() { return gpsData; }
    /** SET para os dados de localização do dispositivo móvel */
    public void setGpsData(GpsData data) { this.gpsData = data; }
    
    /** Registro do controle de comunicação correspondente a esta requisição */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ControleDeComunicacao", nullable = true)
    CommunicationControl communicationControl;
    /** GET para o registro do controle de comunicação correspondente a esta comunicação */
    public CommunicationControl getCommunicationControl() { return communicationControl; }
    /** SET para o registro do controle de comunicação correspondente a esta comunicação */
    public void setCommunicationControl(CommunicationControl controlData) { this.communicationControl = controlData; }
    
    @PrePersist
    private void onSave()
    {
        if(this.dateTime == null)
        {
            this.dateTime = new Date();
        }
    }
}