package ufrj.mobilepoll.model;

import java.util.Date;

/**
 * Classe do modelo de dados para documento de identificação de pessoa física (o vulgo RG)
 * Created by alira on 08/10/15.
 */
public class RG
{
    /** Construtor */
    public RG() { }

    /** Identificador único do registro no banco */
    private long id;
    /** GET para o id do registro no banco */
    public long getId() { return id; }
    /** SET para o id do registro no banco */
    public void setId(long id) { this.id = id; }

    /** Número do documento de identificação */
    private String number;
    /** GET para o número do documento de identificação (RG) */
    public String getNumber() { return number; }
    /** SET para o número do documento de identificação (RG) */
    public void setNumber(String number) { this.number = number; }

    /** Nome do órgão responsável pela emissão do documento de identificação */
    private String issuingInstitution;
    /** GET para o nome do órgão emissor */
    public String getIssuingInstitution() { return issuingInstitution; }
    /** SET para o nome do órgão emissor */
    public void setIssuingInstitution(String institutionName) { this.issuingInstitution = institutionName; }

    /** Data da emissão do documento */
    private Date issueDate;
    /** GET para a data da emissão do documento */
    public Date getIssueDate() { return issueDate; }
    /** SET para a data da emissão do documento */
    public void setIssueDate(Date issueDate) { this.issueDate = issueDate; }

    /** Id da unidade federativa onde o documento de identificação foi expedido */
    private Long dispatcherStateId;
    /** GET para o id da unidade federativa de expedição */
    public Long getDispatcherStateId() { return dispatcherStateId; }
    /** SET para o id da unidade federativa de expedição */
    public void setDispatcherStateId(Long id) { this.dispatcherStateId = id; }

    /** Unidade federativa onde o documento de identificação foi expedido */
    private FederalUnity dispatcherState;
    /** GET para a unidade federativa de expedição */
    public FederalUnity getDispatcherState() { return dispatcherState; }
    /** SET para a unidade federativa de expedição */
    public void setDispatcherState(FederalUnity state) { this.dispatcherState = state; }

    /** Pessoa à qual pertence o documento identificador  */
    private Person person;
    /** GET para a pessoa à qual pertence o documento identificador */
    public Person getPerson() { return person; }
    /** SET para a pessoa à qual pertence o documento identificador */
    public void setPerson(Person person) { this.person = person; }
}