package mobilepoll.data.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import mobilepoll.utils.CollectionUtils;

/**
 * Classe persistente do hibernate para títulos eleitorais
 * @author alira
 */
@Entity
@Table(name = "TituloEleitoral")
public class BallotTitle
{
    /** Construtor */
    public BallotTitle() { }
    
    /**
     * Construtor
     * @param number Número do título eleitoral
     * @param electoralWardNumber Número da zona eleitoral
     * @param pollingPlaceNumber Número da seção de votação
     */
    public BallotTitle(String number, String electoralWardNumber, String pollingPlaceNumber)
    {
        this.btNumber = number;
        this.electoralWard = electoralWardNumber;
        this.pollingPlace = pollingPlaceNumber;
    }
    
    /** Identificadoo único do registro na tabela */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    long id;
    /** GET para o identificador único do registro na tabela */
    public long getId() { return id; }
    /** SET para o identificador único do registro na tabela */
    public void setId(long id) { this.id = id; }
    
    /** Número do título eleitoral */
    @Column(name = "NumeroTE", length = 40, nullable = false)
    String btNumber;
    /** GET para o número do título eleitoral */
    public String getBtNumber() { return btNumber; }
    /** SET para o número do título eleitoral */
    public void setBtNumber(String number) { this.btNumber = number; }
    
    /** Número da zona eleitoral */
    @Column(name = "ZonaTE", length = 8, nullable = false)
    String electoralWard;
    /** GET para o número da zona eleitoral */
    public String getElectoralWard() { return electoralWard; }
    /** SET para o número da zona eleitoral */
    public void setElectoralWard(String wardNumber) { this.electoralWard = wardNumber; }
    
    /** Número da seção de votação */
    @Column(name = "SecaoTE", length = 8, nullable = false)
    String pollingPlace;
    /** GET para o número da seção de votação */
    public String getPollingPlace() { return pollingPlace; }
    /** SET para o número da seção de votação */
    public void setPollingPlace(String placeNumber) { this.pollingPlace = placeNumber; }
    
    /** Data de expedição do título eleitoral */
    @Column(name = "DataExpedicao", nullable = true, columnDefinition = "datetime")
    @Temporal(TemporalType.DATE)
    Date dispatchDate;
    /** GET para a data de expedição do título eleitoral */
    public Date getDispatchDate() { return dispatchDate; }
    /** SET para a data de expedição do título eleitoral */
    public void setDispatchDate(Date date) { this.dispatchDate = date; }
    
    /** Unidade federativa onde o título eleitoral foi expedido */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EstadoExpedicao", nullable = false)
    FederalUnity dispatchState;
    /** GET para o estado de expedição do título eleitoral */
    public FederalUnity getDispatchState() { return dispatchState; }
    /** SET para o estado de expedição do título eleitoral */
    public void setDispatchState(FederalUnity fu) { this.dispatchState = fu; }
    
    /** Pessoa dona do título eleitoral */
    @OneToOne(fetch = FetchType.EAGER,
              cascade = CascadeType.ALL,
              mappedBy = "ballotTitle",
              targetEntity = Persona.class)
    Persona persona;
    /** GET para a pessoa dona do título eleitoral */
    public Persona getPersona() { return persona; }
    /** SET para a pessoa dona do título eleitoral */
    public void setPersona(Persona persona) { this.persona = persona; }
    
    /** Data e hora da criação do registro no banco */
    @Column(name = "DataHoraRegistro", nullable = false, columnDefinition = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    Date registerDateTime;
    /** GET para a data e hora da criação do registro no banco */
    public Date getRegisterDateTime() { return registerDateTime; }
    /** SET para a data e hora da criação do registro no banco */
    public void setRegisterDateTime(Date dateTime) { this.registerDateTime = dateTime; }
    
    /** Evento de salvamento do objeto */
    @PrePersist
    private void onSave() throws Exception
    {
        List<String> errorList = new ArrayList<String>();
        if(this.btNumber == null || this.btNumber.isEmpty())
        {
            errorList.add("O número do título eleitoral é obrigatório.");
        }
        
        if(this.electoralWard == null || this.electoralWard.isEmpty())
        {
            errorList.add("O número da zona eleitoral é obrigatória.");
        }
        
        if(this.pollingPlace == null || this.pollingPlace.isEmpty())
        {
            errorList.add("O número da seção de votação é obrigatório.");
        }
        
        if(errorList.isEmpty() == false)
        {
            throw new Exception("Erros ocorridos no salvamento do título eleitoral: " + CollectionUtils.StringListToString(errorList));
        }
        
        if(this.registerDateTime == null)
        {
            this.registerDateTime = new Date();
        }
    }
}