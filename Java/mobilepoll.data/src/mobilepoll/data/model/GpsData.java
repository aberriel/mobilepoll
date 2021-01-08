package mobilepoll.data.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * Dados GPS
 * @author alira
 */
@Entity
@Table(name = "GPS_Data")
public class GpsData
{
    /** Construtor */
    public GpsData(){ }
    
    /**
     * Construtor
     * @param latitude Valor da latitude
     * @param longitude Valor da longitude
     */
    public GpsData(float latitude, float longitude)
    {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    /** Identificador único do registro no sistema */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    long id;
    /** GET para o id do registro */
    public long getId() { return id; }
    /** SET para o id do registro */
    public void setId(long id) { this.id = id; }
    
    /** Id do registro de localização no dispositivo mõvel */
    @Column(name = "IdRemoto", nullable = false)
    long remoteId;
    /** GET para o id do registro de localização no dispositivo móvel */
    public long getRemoteId() { return remoteId; }
    /** SET para o id do registro de localização no dispositivo móvel */
    public void setRemoteId(long idRemoto) { this.remoteId = idRemoto; }
    
    /** Valor da latitude */
    @Column(name = "Latitude", nullable = false)
    float latitude;
    /** GET para o valor da latitude */
    public float getLatitude() { return latitude; }
    /** SET para o valor da latitude */
    public void setLatitude(float latitude) { this.latitude = latitude; }
    
    /** Valor da longitude */
    @Column(name = "Longitude", nullable = false)
    float longitude;
    /** GET para o valor da longitude */
    public float getLongitude() { return longitude; }
    /** SET para o valor da longitude */
    public void setLongitude(float longitude) { this.longitude = longitude; }
    
    /** Dispositivo móvel a partir do qual foi coletada a localização */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DispositivoMovel", nullable = false)
    MobileDevice mobileDevice;
    /** GET para o dispositivo móvel a partir do qual foi coletada a localização */
    public MobileDevice getMobileDevice() { return mobileDevice; }
    /** SET para o dispositivo móvel a partir do qual foi coletada a localização */
    public void setMobileDevice(MobileDevice md) { this.mobileDevice = md; }
    
    /** Data e hora da criação do registro no banco */
    @Column(name = "DataHoraRegistro", nullable = false, columnDefinition = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    Date registerDateTime;
    /** GET para a data e hora de criação do registro no banco */
    public Date getRegisterDateTime() { return registerDateTime; }
    /** SET para a data e hora de criação do registro no banco */
    public void setRegisterDateTime(Date dateTime) { this.registerDateTime = dateTime; }
    
    /** Data e hora da coleta das coordenadas GPS */
    @Column(name = "DataHoraColetaDado", nullable = true, columnDefinition = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    Date dataGatheringDateTime;
    /** GET para a data e hora da coleta das coordenadas GPS */
    public Date getDataGatheringDateTime() { return this.dataGatheringDateTime; }
    /** SET para a data e hora da coleta das coordenadas GPS */
    public void setDataGatheringDateTime(Date dateTime) { this.dataGatheringDateTime = dateTime; }
    
    /** Evento de persistência do objeto para o banco */
    @PrePersist
    private void onSave() throws Exception
    {
        if(this.registerDateTime == null)
        {
            this.registerDateTime = new Date();
        }
        
        if(this.latitude < 0)
        {
            throw new Exception("A latitude não pode ser negativa.");
        }
        
        if(this.longitude < 0)
        {
            throw new Exception("A longitude não pode ser negativa.");
        }
    }
}