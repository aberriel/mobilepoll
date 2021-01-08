package ufrj.mobilepoll.model;

/**
 * Classe de modelo de dados para dados de localização coletados durante o uso da aplicação.
 * Created by alira on 09/10/15.
 */
public class GpsData
{
    /** Construtor */
    public GpsData() { }

    /**
     * Construtor
     * @param latitude Coordenada de latitude.
     * @param longitude Coordenada de longitude.
     */
    public GpsData(float latitude, float longitude)
    {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /** Identificador único do registro no banco */
    private long id;
    /** GET para o identificador único do registro no banco */
    public long getId() { return id; }
    /** SET para o identificador único do registro no banco */
    public void setId(long id) { this.id = id; }

    /** Valor da coordenada de longitude */
    private float longitude;
    /** GET para o valor da coordenada de longitude. */
    public float getLongitude() { return longitude; }
    /** SET para o valor da coordenada de longitude */
    public void setLongitude(float longitude) { this.longitude = longitude; }

    /** Valor da coordenada de latitude */
    private float latitude;
    /** GET para o valor da coordenada de latitude */
    public float getLatitude() { return latitude; }
    /** SET para o valor da coordenada de latitude */
    public void setLatitude(float latitude) { this.latitude = latitude; }

    /** Enquete durante a qual a localização foi coletada. */
    private Poll poll;
    /** GET para a enquete durante a qual a localização foi coletada. */
    public Poll getPoll() { return poll; }
    /** SET para a enquete durante a qual a localização foi coletada. */
    public void setPoll(Poll poll) { this.poll = poll; }
}