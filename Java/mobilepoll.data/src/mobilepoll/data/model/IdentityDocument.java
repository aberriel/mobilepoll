package mobilepoll.data.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * Documento de identificação
 * @author alira
 */
@Entity
@Table(name = "RG")
public class IdentityDocument
{
    /** Construtor */
    public IdentityDocument() { }
    
    /**
     * Construtor
     * @param owner Dono do documento de identificação
     */
    public IdentityDocument(Persona owner)
    {
        this.persona = owner;
    }
    
    /**
     * Construtor
     * @param number Número do documento de identificação
     */
    public IdentityDocument(String number)
    {
        this.number = number;
    }
    
    /**
     * Construtor
     * @param number Número do documento de identificação
     * @param owner Dono do documento de identificação
     */
    public IdentityDocument(String number, Persona owner)
    {
        this.number = number;
        this.persona = owner;
    }
    
    /**
     * Construtor
     * @param number Número do documento de identidade
     * @param issuingInstitution Nome do órgão expeditor
     */
    public IdentityDocument(String number, String issuingInstitution)
    {
        this.number = number;
        this.issuingInstitution = issuingInstitution;
    }
    
    /**
     * Construtor
     * @param number Número do documento de identidade
     * @param issuingState Unidade federativa onde foi expedido
     */
    public IdentityDocument(String number, FederalUnity issuingState)
    {
        this.number = number;
        this.issuingState = issuingState;
    }
    
    /**
     * Construtor
     * @param number Número do documento de identidade
     * @param issuingInstitution Nome do órgão expeditor
     * @param issuingState Unidade federativa onde foi expedido
     */
    public IdentityDocument(String number, String issuingInstitution, FederalUnity issuingState)
    {
        this.number = number;
        this.issuingInstitution = issuingInstitution;
        this.issuingState = issuingState;
    }
    
    /**
     * Construtor
     * @param number Número do documento de identidade
     * @param issuingInstitution Nome do órgão expeditor
     * @param issuingState Unidade federativa onde foi expedido
     * @param owner Dono do documento de identificação
     */
    public IdentityDocument(String number, String issuingInstitution, FederalUnity issuingState, Persona owner)
    {
        this.number = number;
        this.issuingInstitution = issuingInstitution;
        this.issuingState = issuingState;
        this.persona = owner;
    }
    
    /** Identificador único do registro na tabela */ 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    long id;
    /** GET para o identificador único do registro na tabela */
    public long getId() { return id; }
    /** SET para o identificador único do registro na tabela */
    public void setId(long id) { this.id = id; }
    
    /** Número do documento de identificaçào */
    @Column(name = "Numero", length = 20, nullable = false)
    String number;
    /** GET para o número do documento de identificação */
    public String getNumber() { return number; }
    /** SET para o número do documento de identificação */
    public void setNumber(String number) { this.number = number; }
    
    /** Órgão expeditor */
    @Column(name = "OrgaoExpeditor", length = 120, nullable = false)
    String issuingInstitution;
    /** GET para o órgão que expediu o documento */
    public String getIssuingInstitution() { return this.issuingInstitution; }
    /** SET para o órgão que expediu o documento */
    public void setIssuingInstitution(String iit) { this.issuingInstitution = iit; }
    
    /** Unidade federativa onde o documento de identificação foi expeditado. */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EstadoExpeditor", nullable = false)
    FederalUnity issuingState;
    /** GET para a unidade federativa de expedição do documento */
    public FederalUnity getIssuingState() { return issuingState; }
    /** SEt para a unidade federativa de expedição do documento */
    public void setIssuingState(FederalUnity iSt) { this.issuingState = iSt; }
    
    /** Data em que o documento foi expedido */
    @Column(name = "DataExpedicao", nullable = true, columnDefinition = "datetime")
    @Temporal(TemporalType.DATE)
    Date issuingDate;
    /** GET para a data de expedição do documento de identificação */
    public Date getIssuingDate() { return this.issuingDate; }
    /** SET para a data de expedição do documento de identificação */
    public void setIssuingDate(Date date) { this.issuingDate = date; }
    
    /** Pessoa física dona do documento de identificação */
    @OneToOne(fetch = FetchType.EAGER,
              cascade = CascadeType.ALL,
              mappedBy = "identityDocument")
    Persona persona;
    /** GET para a pessoa física dona do documento de identificação */
    public Persona getPersona() { return persona; }
    /** SET para a pessoa física dona do documento de identificação */
    public void setPersona(Persona persona) { this.persona = persona; }
}