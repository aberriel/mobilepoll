package mobilepoll.data.model;

import mobilepoll.data.model.enums.Gender_Tp;
import mobilepoll.data.model.enums.PersonType_Tp;
import mobilepoll.data.model.enums.MaritalStatus_Tp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.*;
import org.hibernate.annotations.Type;

/**
 * Classe persistente do hibernate para pessoas
 * @author alira
 */
@Entity
@Table(name = "Pessoa", uniqueConstraints = {
                @UniqueConstraint(columnNames = "EmailPrincipal")})
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona
{
    private void DoInit()
    {
        if(this.addresses == null)
        {
            addresses = new ArrayList<Address>();
        }
        
        if(this.telephones == null)
        {
            telephones = new ArrayList<Telephone>();
        }
        
        if(this.retiredDevices == null)
        {
            this.retiredDevices = new ArrayList<MaintenanceData>();
        }
        
        if(this.returnedDevices == null)
        {
            this.returnedDevices = new ArrayList<MaintenanceData>();
        }
        
        if(this.repairedDevices == null)
        {
            this.repairedDevices = new ArrayList<MaintenanceData>();
        }
        
        if(this.performedAudits == null)
        {
            this.performedAudits = new ArrayList<AuditingData>();
        }
        
        this.activationDate = null;
        this.personType = PersonType_Tp.None;
    }
    
    /** Construtor */
    public Persona()
    {
        DoInit();
    }
    
    /**
     * Construtor
     * @param name Nome completo da pessoa (pessoa física)
     */
    public Persona(String name)
    {
        this.DoInit();
        this.name = name;
    }
    
    /**
     * Construtor
     * @param name Nome fantasia da pessoa jurídica
     * @param corporateName Razão social da pessoa jurídica
     */
    public Persona(String name, String corporateName)
    {
        this.DoInit();
        this.corporateName = corporateName;
        this.name = name;
    }
    
    /**
     * Construtor
     * @param documentNumber Número do documento identificador da pessoa (CPF ou CNPJ)
     * @param personType Tipo da pessoa (se física ou jurídica)
     * @throws Exception Exceção por tipo inválido ou ausente de pessoa
     */
    public Persona(String documentNumber, PersonType_Tp personType) throws Exception
    {
        this.DoInit();
        
        if(personType == PersonType_Tp.PhysicalPerson)
        {
            this.cpf = documentNumber;
        }
        else if(personType == PersonType_Tp.JuridicalPerson)
        {
            this.cnpj = documentNumber;
        }
        else
        {
            throw new Exception("Favor fornecer um tipo válido para a pessoa.");
        }
    }
    
    /**
     * Construtor
     * @param documentNumber Número do documento identificador da pessoa (CPF ou CNPJ)
     * @param personType Tipo da pessoa
     * @param realPersonName Nome da pessoa (para pessoa física, o nome completo; para pessoa jurídica, a razão social)
     * 
     * @throws Exception Exceção por tipo inválido ou ausente de pessoa
     */
    public Persona(String documentNumber, PersonType_Tp personType, String realPersonName) throws Exception
    {
        this.DoInit();
        
        if(personType == PersonType_Tp.JuridicalPerson)
        {
            this.cnpj = documentNumber;
            this.corporateName = realPersonName;
        }
        else if(personType == PersonType_Tp.PhysicalPerson)
        {
            this.cpf = documentNumber;
            this.name = realPersonName;
        }
        else
        {
            throw new Exception("Favor fornecer um tipo válido de pessoa.");
        }
    }
    
    /** Identificador único da pessoa no sistema */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    long id;
    /** GET para o ID da pessoa no sistema */
    public long getId() { return id; }
    /** SET para o ID da pessoa no sistema */
    public void setId(long id) { this.id = id; }
    
    /** Nome da pessoa (no caso de pessoa jurídica, será o nome fantasia) */
    @Column(name = "Nome", length = 200, nullable = false)
    String name;
    /** GET para o nome da pessoa (no caso de pessoa jurídica, o nome fantasia) */
    public String getName() { return name; }
    /** SET para o nome da pessoa (no caso de pessoa jurídica, o nome fantasia) */
    public void setName(String name) { this.name = name; }
    
    /** Nome abreviado (simplificado) da pessoa */
    @Column(name = "NomeAbreviado", length = 120, nullable = true)
    String shortName;
    /** GET para o nome abreviado (simplificado) da pessoa */
    public String getShortName() { return shortName; }
    /** SET para o nome abreviado (simplificado) da pessoa */
    public void setShortName(String shortName) { this.shortName = shortName; }
    
    /** Endereço de e-mail principal da pessoa */
    @Column(name = "EmailPrincipal", length = 120, nullable = true)
    String primaryEmail;
    /** GET para o endereço de e-mail principal da pessoa */
    public String getPrimaryEmail() { return primaryEmail; }
    /** SET para o endereço de e-mail principal da pessoa */
    public void setPrimaryEmail(String emailAddress) { this.primaryEmail = emailAddress; }
    
    /** Endereço de e-mail secundário ou alternativo da pesso */
    @Column(name = "EmailSecundario", length = 120, nullable = true)
    String secondaryEmail;
    /** GET para o endereço de e-mail secundário ou alternativo da pessoa */
    public String getSecondaryEmail() { return secondaryEmail; }
    /** SET para o endereço de e-mail secundário ou alternativo da pesao */
    public void setSecondaryEmail(String emailAddress) { this.secondaryEmail = emailAddress; }
    
    /** Documento identificador da pessoa física */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RG", nullable = true)
    IdentityDocument identityDocument;
    /** GET para o documento identificador da pessoa física */
    public IdentityDocument getIdentityDocument() { return identityDocument; }
    /** SET para o documento identificador da pessoa física */
    public void setIdentityDocument(IdentityDocument id) { this.identityDocument = id; }
    
    /** Número do documento identificador de pessoa física (CPF) */
    @Column(name = "CPF", length = 14, nullable = true)
    String cpf;
    /** GET para o número do CPF */
    public String getCpf() { return cpf; }
    /** SET para o número do CPF */
    public void setCpf(String cpf) { this.cpf = cpf; }
    
    /** Número do documento identificador de pessoa jurídica (CNPJ) */
    @Column(name = "CNPJ", length = 32, nullable = true)
    String cnpj;
    /** GET para o número do CNPJ */
    public String getCnpj() { return cnpj; }
    /** SET para o número do CNPJ */
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
    
    /** Razão social da pessoa jurídica */
    @Column(name = "RazaoSocial", length = 200, nullable = true)
    String corporateName;
    /** GET para a razão social da pessoa jurídica */
    public String getCorporateName() { return corporateName; }
    /** SET para a razão social da pessoa jurídica */
    public void setCorporateName(String name) { this.corporateName = name; }
    
    /** Número da inscrição estadual da pessoa jurídica */
    @Column(name = "InscricaoEstadual", length = 50, nullable = true)
    String stateInscription;
    /** GET para o número da inscrição estadual da pessoa jurídica */
    public String getStateInscription() { return stateInscription; }
    /** SET para o número da inscrição estadual da pessoa jurídica */
    public void setStateInscription(String inscriptionNumber) { this.stateInscription = inscriptionNumber; }
    
    /** Número da inscrição municipal da pessoa jurídica */
    @Column(name = "InscricaoMunicipal", length = 50, nullable = true)
    String municipalInscription;
    /** GET para o número da inscrição municipal da pessoa jurídica */
    public String getMunicipalInscription() { return municipalInscription; }
    /** SET para o número da inscrição municipal da pessoa jurídica */
    public void setMunicipalInscription(String inscriptionNumber) { this.municipalInscription = inscriptionNumber; }
    
    /** Título eleitoral da pessoa, para pessoas físicas */
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "TituloEleitoral", nullable = true)
    BallotTitle ballotTitle;
    /** GET para o título eleitoral da pessoa */
    public BallotTitle getBallotTitle() { return ballotTitle; }
    /** SET para o título eleitoral da pessoa */
    public void setBalootTitle(BallotTitle ballotTitle) { this.ballotTitle = ballotTitle; }
    
    /** Sexo da pessoa, para pessoas físicas */
    @Column(name = "Sexo", nullable = true)
    @Enumerated(EnumType.ORDINAL)
    Gender_Tp gender;
    /** GET para o sexo da pessoa */
    public Gender_Tp getGender() { return gender; }
    /** SET para o sexo da pessoa */
    public void setGender(Gender_Tp gender) { this.gender = gender; }
    
    /** Estado civil da pessoa, para pessoas físicas */
    @Column(name = "EstadoCivil", nullable = true)
    @Enumerated(EnumType.ORDINAL)
    MaritalStatus_Tp maritalStatus;
    /** GET para o estado civil da pessoa */
    public MaritalStatus_Tp getMaritalStatus() { return maritalStatus; }
    /** SET para o estado civil da pessoa */
    public void setMaritalStatus(MaritalStatus_Tp status) { this.maritalStatus = status; }
    
    /** Data de nascimento da pessoa, pasa pessoas físicas */
    @Column(name = "DataDeNascimento", nullable = true, columnDefinition = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    Date birthday;
    /** GET para a data de nascimento da pessoa */
    public Date getBirthday() { return birthday; }
    /** SET para a data de nascimento da pessoa */
    public void setBirthday() { this.birthday = birthday; }
    
    /** Tipo da pessoa */
    @Column(name = "TipoPessoa", nullable = true)
    @Enumerated(EnumType.ORDINAL)
    PersonType_Tp personType;
    /** GET para o tipo da pessoa */
    public PersonType_Tp getPersonType() { return personType; }
    /** SET para o tipo da pessoa */
    public void setPersonType(PersonType_Tp type) { this.personType = type; }
    
    /** Chave pública identificadora da pessoa */
    @Column(name = "ChavePessoa", length = 64, nullable = false, unique = true)
    String personKey;
    /** GET para a chave pública identificadora da pessoa */
    public String getPersonKey() { return personKey; }
    /** SET para a chave pública identificadora da pessoa */
    public void setPersonKey(String key) { this.personKey = key; }
    
    /** Flag indicador de registro válido */
    @Column(name = "Valido", nullable = false, columnDefinition = "TINYINT", length = 1)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    boolean isValid;
    /** GET para o flag indicador de registro válido */
    public boolean getIsValid() { return isValid; }
    /** SET para o flag indicador de registro válido */
    public void setIsValid(boolean valid) { this.isValid = valid; }
    
    /** Chave de ativação que a pessoa deve fornecer para ativação da conta */
    @Column(name = "ChaveAtivacao", length = 40, nullable = true)
    String activationKey;
    /** GET para o código de ativação da conta da pessoa */
    public String getActivationKey() { return activationKey; }
    /** SET para o código de ativação da conta da pessoa */
    public void setActivationKey(String ak) { this.activationKey = ak; }
    
    /** Data de ativação da conta da pessoa */
    @Column(name = "DataAtivacao", nullable = true, columnDefinition = "datetime")
    @Temporal(TemporalType.DATE)
    Date activationDate;
    /** GET para a data de ativação da conta da pessoa */
    public Date getActivationDate() { return activationDate; }
    /** SET para a data de ativação da conta da pessoa  */
    public void setActivationDate(Date date) { this.activationDate = date; }
    
    /** Data e hora de registro na pessoa no banco */
    @Column(name = "DataHoraRegistro", nullable = false, columnDefinition = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    Date registerDateTime;
    /** GET para a data e hora de registro da pessoa no banco */
    public Date getRegisterDateTime() { return registerDateTime; }
    /** SET para a data e hora de registro da pessoa no banco */
    public void setRegisterDateTime(Date dateTime) { this.registerDateTime = dateTime; }
    
    /** Data e hora da última atualização do registro no banco */
    @Column(name = "DataHoraUltimaAtualizacao", nullable = false, columnDefinition = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    Date lastUpdateDateTime;
    /** GET para a data e hora da última atualização do registro no banco */
    public Date getLastUpdateDateTime() { return this.lastUpdateDateTime; }
    /** SET para a data e hora da última atualização do registro no banco */
    public void setLastUpdateDateTime(Date dateTime) { this.lastUpdateDateTime = dateTime; }
    
    @Column(name = "DataHoraExclusao", columnDefinition = "datetime", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    Date deleteDateTime;
    public Date getDeleteDateTime() { return this.deleteDateTime; }
    public void setDeleteDateTime(Date dt) { this.deleteDateTime = dt; }
    
    @Column(name = "ChaveExclusao", length = 64, nullable = true)
    String deleteKey;
    public String getDeleteKey() { return this.deleteKey; }
    public void setDeleteKey(String dKey) { this.deleteKey = dKey; }
    
    /** Número de registro da pessoa na empresa (número de matrícula) */
    @Column(name = "NumeroDeRegistro", length = 64, nullable = true)
    String registerNumber;
    /** GET para o n[umero de registro da pessoa na empresa */
    public String getRegisterNumber() { return registerNumber; }
    /** SET para o número de registro da pessoa na empresa (número de matrícula) */
    public void setRegisterNumber(String number) { this.registerNumber = number; }
    
    /** Comentários e/ou observações pertinentes */
    @Column(name = "Comentarios", columnDefinition = "TEXT", nullable = true)
    String comments;
    /** GET para os comentários e/oui observações */
    public String getComments() { return comments; }
    /** SET para os comentários e/ou observações */
    public void setComments(String comments) { this.comments = comments; }
    
    /** Endereços pertencentes à pessoa */
    @OneToMany(cascade = CascadeType.ALL,
               mappedBy = "persona",
               targetEntity = Persona.class,
               fetch = FetchType.LAZY)
    List<Address> addresses;
    /** GET para a listagem de endereços pertencentes à pessoa */
    public List<Address> getAddresses() { return addresses; }
    /** SET para a listagem de endereços pertencentes à pessoa */
    public void setAddresses(List<Address> addressList) { this.addresses = addressList; }
    
    /** Telefones pertencentes à pessoa */
    @OneToMany(cascade = CascadeType.ALL,
               mappedBy = "persona",
               targetEntity = Telephone.class,
               fetch = FetchType.LAZY)
    List<Telephone> telephones;
    /** GET para a listagem de telefones pertencentes à pessoa */
    public List<Telephone> getTelephones() { return telephones; }
    /** SET para a listagem de telefones pertencentes à pessoa */
    public void setTelephones(List<Telephone> telephoneList) { this.telephones = telephoneList; }
    
    /** Dispositivos que esta pessoa retirou para manutenção ou reparo. */
    @OneToMany(cascade = CascadeType.ALL,
               fetch = FetchType.LAZY,
               mappedBy = "personResponsibleForRemoval",
               targetEntity = MaintenanceData.class)
    List<MaintenanceData> retiredDevices;
    /** GET para os dispositivos que esta pessoa retirou para manutenção ou reparo */
    public List<MaintenanceData> getRetiredDevices() { return retiredDevices; }
    /** SET para os dispositivos que esta pessoa retirou para manutenção ou reparo */
    public void setRetiredDevices(List<MaintenanceData> rdList) { this.retiredDevices = rdList; }
    
    /** Dispositivos que esta pessoa devolveu após manutenção e reparo */
    @OneToMany(cascade = CascadeType.ALL,
               fetch = FetchType.LAZY,
               mappedBy = "personResponsibleForReturning",
               targetEntity = MaintenanceData.class)
    List<MaintenanceData> returnedDevices;
    /** GET para os dispositivos que esta pessoa devolveu após manutenção ou reparo. */
    public List<MaintenanceData> getReturnedDevices() { return returnedDevices; }
    /** SET para os dispositivos que esta pessoa devolveu após manutenção e reparo */
    public void setReturnedDevices(List<MaintenanceData> rdList) { this.returnedDevices = rdList; }
    
    /** Serviços de reparo que esta pessoa fez como técnico. */
    @OneToMany(cascade = CascadeType.ALL,
               fetch = FetchType.LAZY,
               mappedBy = "personResponsibleForRepair")
    List<MaintenanceData> repairedDevices;
    /** GET para os serviços que esta pessoa fez como técnico */
    public List<MaintenanceData> getRepairedDevices() { return repairedDevices; }
    /** SET para os serviços que esta pessoa fez como técnico */
    public void setRepairedDevices(List<MaintenanceData> rdList) { this.repairedDevices = rdList; }
    
    /** Auditorias realizadas por esta pessoa em dispositivos móveis */
    @OneToMany(cascade = CascadeType.ALL,
               fetch = FetchType.LAZY,
               mappedBy = "auditor")
    List<AuditingData> performedAudits;
    /** GET para a lista de auditorias realizadas por esta pessoa em dispositivos móveis */
    public List<AuditingData> getPerformedAudits() { return this.performedAudits; }
    /** SET para a lista de auditorias realizadas por esta pessoa em dispositivos móveis */
    public void setPerformedAudits(List<AuditingData> audits) { this.performedAudits = audits; }
    
    /** Tarefas a serem executadas imediatamente antes da persistencia dos dados pro banco */
    @PrePersist
    private void onSave()
    {
        this.lastUpdateDateTime = new Date();
        if(this.registerDateTime == null)
        {
            this.registerDateTime = new Date();
        }
        
        if(this.personKey == null || this.personKey.isEmpty())
        {
            this.personKey = UUID.randomUUID().toString();
        }
        
        if(this.activationDate == null && (this.activationKey == null || this.activationKey.isEmpty()))
        {
            this.activationKey = UUID.randomUUID().toString();
            this.activationDate = new Date();
        }
        
        // O ID só será 0 (zero) se for a criação do registro no banco
        if(this.id == 0)
        {
            this.isValid = false;
        }
    }
}
