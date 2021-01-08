package mobilepoll.data.model;

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
 * Classe persistente do hibernate para associação entre fabricante de dispositivos móveis
 * e assistência técnica.
 * 
 * @author alira
 */
@Entity
@Table(name = "AutorizadaFabricante")
public class ManufacturerTechnicalAssistance
{
    /** Construtor */
    public ManufacturerTechnicalAssistance() { }
    
    /** Identificador único do registro no banco */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    long id;
    /** GET para o identificador único do registro no banco */
    public long getId() { return id; }
    /** SET para o identificador único do registro no banco */
    public void setId(long id) { this.id = id; }
    
    /** Assistência técnica que provê suporte ao fabricante em questão */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Autorizada", nullable = false)
    MobileDeviceTechnicalAssistance technicalAssistance;
    /** GET para a a assistência técnica que provê suporte ao fabricante em questão */
    public MobileDeviceTechnicalAssistance getTechnicalAssistance() { return technicalAssistance; }
    /** SET para a assistência técnica que provê suporte ao fabricante em questão */
    public void setTechnicalAssistance(MobileDeviceTechnicalAssistance technicalAssistance) { this.technicalAssistance = technicalAssistance; }
    
    /** Fabricante para o qual a assistência técnica provê suporte */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FabricanteDeDispositivoMovel", nullable = false)
    MobileDeviceManufacturer manufacturer;
    /** GET para o fabricante para o qual a asistência técnica provê suporte */
    public MobileDeviceManufacturer getManufacturer() { return manufacturer; }
    /** SET para o fabricante para o qual a assistência técnica provê suporte */
    public void setManufacturer(MobileDeviceManufacturer manufacturer) { this.manufacturer = manufacturer; }
    
    /** Relação de modelos de dispositivos com os quais a assistência técnica trabalha */
    @Column(name = "Modelostrabalhados", length = 500, nullable = true)
    String workedModels;
    /** GET para a relação de modelos de dispositivos com os quais a assistência técnica trabalha */
    public String getWorkedModels() { return workedModels; }
    /** SET para a relação de modelos com os quais a assistência técnica trabalha */
    public void setWorkedModels(String modelList) { this.workedModels = modelList; }
    
    /** Comentários e observações */
    @Column(name = "Comentarios", columnDefinition = "TEXT", nullable = true)
    String comments;
    /** GET para os comentários e observações */
    public String getComments() { return this.comments; }
    /** SET para os comentários e observações */
    public void setComments(String comments) { this.comments = comments; }
    
    /** Data e hora da criação do registro no banco */
    @Column(name = "DataHoraRegistro", columnDefinition = "datetime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date associationDateTime;
    /** GET para a data e hora da criação do registro no banco */
    public Date getAssociationDateTime() { return associationDateTime; }
    /** SET para a data e hora da criação do registro no banco */
    public void setAssociationDateTime(Date dateTime) { this.associationDateTime = dateTime; }
    
    /** Evento de persistência do objeto para o banco */
    @PrePersist
    private void onSave()
    {
        if(this.associationDateTime == null)
        {
            this.associationDateTime = new Date();
        }
    }
}
