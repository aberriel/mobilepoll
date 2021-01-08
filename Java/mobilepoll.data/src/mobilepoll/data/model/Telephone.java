package mobilepoll.data.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * Classe persistente do hibernate para telefones de pessoas
 * @author alira
 */
@Entity
@Table(name = "Telefone")
public class Telephone
{
    /** Construtor */
    public Telephone() { }
    
    /**
     * Construtor
     * @param cityCode Código DDD do novo telefone
     * @param number Número do novo telefone
     */
    public Telephone(String cityCode, String number)
    {
        this.cityCode = cityCode;
        this.number = number;
    }
    
    /**
     * Construtor
     * @param cityCode Código DDD do novo telefone
     * @param number Número do novo telefone
     * @param persona Pessoa dona do telefone
     */
    public Telephone(String cityCode, String number, Persona persona)
    {
        this.cityCode = cityCode;
        this.number = number;
        this.persona = persona;
    }
    
    /** Identificador único do registro do telefone no sistema */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    long id;
    /** GET para o identificador único do registro no sistema */
    public long getId() { return id; }
    /** SET para o identificador único do registro no sistema */
    public void setId(long id) { this.id = id; }
    
    /** Código de discagem do país */
    @Column(name = "DDI", length = 5, nullable = false)
    String countryCode;
    /** GET para o código de discagem do país */
    public String getCountryCode() { return countryCode; }
    /** SET para o código de discagem do país */
    public void setCountryCode(String code) { this.countryCode = code; }
    
    /** Código de discagem da região */
    @Column(name = "DDD", length = 4, nullable = false)
    String cityCode;
    /** GET para o código de discagem da região */
    public String getCityCode() { return cityCode; }
    /** SET para o código de discagem da região */
    public void setCityCode(String code) { this.cityCode = code; }
    
    /** Número do telefone */
    @Column(name = "NumeroTelefone", length = 12, nullable = false)
    String number;
    /** GET para o número do telefone */
    public String getNumber () { return number; }
    /** SET para o número do telefone */
    public void setNumber(String number) { this.number = number; }
    
    /** Ramal */
    @Column(name = "Ramal", length = 6, nullable = true)
    String extension;
    /** GET para o ramal */
    public String getExtension() { return extension; }
    /** SET para o ramal */
    public void setExtension(String extension) { this.extension = extension; }
    
    /** Pessoa dona do telefone */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Pessoa", nullable = true)
    Persona persona;
    /** GET para a pessoa dona do telefone */
    public Persona getPersona() { return persona; }
    /** SET para a pessoa dona do telefone */
    public void setPersona(Persona p) { this.persona = p; }
    
    /** Tipo do telefone */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TipoDeTelefone", nullable = true)
    TelephoneType type;
    /** GET para o tipo do telefone */
    public TelephoneType getType() { return type; }
    /** SET para o tipo do telefone */
    public void setTelephoneType(TelephoneType tType) { this.type = tType; }
    
    /** Data e hora do registro do telefone no sistema */
    @Column(name = "DataHoraRegistro", columnDefinition = "datetime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date registerDateTime;
    /** GET para a data e hora do registro do telefone */
    public Date getRegisterDateTime() { return registerDateTime; }
    /** SET para a data e hora do registro do telefone */
    public void setRegisterDateTime(Date dateTime) { this.registerDateTime = dateTime; }
    
    /** Comentários e/ou observações pertinentes */
    @Column(name = "Comentarios", columnDefinition = "TEXT", nullable = true)
    String comments;
    /** GET para os comentários e/ou observações */
    public String getComments() { return comments; }
    /** SET para os comentários e/ou observações */
    public void setComments(String comments) { this.comments = comments; }
    
    /** Evento de persistência do objeto pro banco */
    @PrePersist
    private void onSave()
    {
        if(this.registerDateTime == null)
        {
            this.registerDateTime = new Date();
        }
    }
}
