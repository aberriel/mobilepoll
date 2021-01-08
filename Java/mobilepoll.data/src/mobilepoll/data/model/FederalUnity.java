package mobilepoll.data.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * Classe persistente para endereços ou unidades federativas 
 * @author alira
 */
@Entity
@Table(name = "UnidadeFederativa")
public class FederalUnity
{
    private void doInit()
    {
        if(this.cities == null)
        {
            this.cities = new ArrayList<City>();
        }
        
        if(this.identityDocumentList == null)
        {
            this.identityDocumentList = new ArrayList<IdentityDocument>();
        }
        
        if(this.ballotTitleList == null)
        {
            this.ballotTitleList = new ArrayList<BallotTitle>();
        }
    }
    
    /** Construtor */
    public FederalUnity()
    {
        this.doInit();
    }
    
    /**
     * Construtor
     * @param name Nome do estado ou unidade federativa
     * @param abbreviation Sigla do estado
     * @param comments Comentários e/ou observaçòes pertinentes
     */
    public FederalUnity(String name, String abbreviation, String comments)
    {
        this.doInit();
        
        this.name = name;
        this.abbreviation = abbreviation;
        this.comments = comments;
    }
    
    /** Identificador único do registro na tabela */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    long id;
    /** GET para o id do registro na tabela */
    public long getId() { return id; }
    /** SET para o id do registro na tabela */
    public void setId(long id) { this.id = id; }
    
    /** Nome do estado ou unidade federativa */
    @Column(name = "Nome", length = 200, nullable = false, unique = true)
    String name;
    /** GET para o nome da unidade federativa */
    public String getName() { return name; }
    /** SET para o nome da unidade federativa */
    public void setName(String name) { this.name = name; }
    
    /** Sigla */
    @Column(name = "Sigla", length = 3, nullable = false)
    String abbreviation;
    /** GET para s sigla do estado ou unidade federativa */
    public String getAbbreviation() { return abbreviation; }
    /** SET para a sigla do estado ou unidade federativa */
    public void setAbbreviation(String abbreviation) { this.abbreviation = abbreviation; }
    
    /** Comentários e/ou observaçoes pertientes */
    @Column(name = "Comentarios", columnDefinition = "TEXT", nullable = true)
    String comments;
    /** GET para os comentários e/ou observaçòes pertientes */
    public String getComments() { return comments; }
    /** SET para os comentários e/ou observaçòes pertinentes */
    public void setComments(String comments) { this.comments = comments; }
    
    /** Data e hora da criação do registro no banco */
    @Column(name = "DataHoraRegistro", columnDefinition = "datetime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date registerDateTime;
    /** GET para a data e hora da criação do registro no banco */
    public Date getRegisterDateTime() { return this.registerDateTime; }
    /** SET para a data e hora da criação do registro no banco */
    public void setRegisterDateTime(Date dt) { this.registerDateTime = dt; }
    
    /** Cidades pertencentes a este estado */
    @OneToMany(cascade = CascadeType.ALL,
               mappedBy = "federalUnity",
               targetEntity = City.class,
               fetch = FetchType.LAZY)
    List<City> cities;
    /** GET para a listagem de cidades pertencentes a este estado */
    public List<City> getCities() { return cities; }
    /** SET para a listagem de cidades pertencentes a este estado */
    public void setCities(List<City> cityList) { this.cities = cityList; }
    
    /** Documentos de identidade emitidos neste estado */
    @OneToMany(cascade = CascadeType.ALL,
               mappedBy = "issuingState",
               targetEntity = IdentityDocument.class,
               fetch = FetchType.LAZY)
    List<IdentityDocument> identityDocumentList;
    /** GET para a listagem de documentos de identidade emitidos neste estado */
    public List<IdentityDocument> getIdentityDocumentList() { return identityDocumentList; }
    /** SET para a listagem de documentos de identidade emitidos neste estado */
    public void setIdentityDocumentList(List<IdentityDocument> identityDocumentList) { this.identityDocumentList = identityDocumentList; }
    
    /** Títulos eleitorais emitidos neste estado */
    @OneToMany(cascade = CascadeType.ALL,
               mappedBy = "dispatchState",
               targetEntity = BallotTitle.class,
               fetch = FetchType.LAZY)
    List<BallotTitle> ballotTitleList;
    /** GET para a listagem de títulos eleitorais emitidos neste estado */
    public List<BallotTitle> getBallotTitleList() { return ballotTitleList; }
    /** SET para a listagem de títulos eleitorais emitidos neste estado */
    public void setBallotTitleList(List<BallotTitle> ballotTitleList) { this.ballotTitleList = ballotTitleList; }
    
    @PrePersist
    private void onSave()
    {
        if(this.registerDateTime == null)
        {
            this.registerDateTime = new Date();
        }
    }
}