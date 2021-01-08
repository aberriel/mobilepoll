package mobilepoll.data.model;

import mobilepoll.data.model.enums.PersonType_Tp;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * Clientes do EnqueteMobile, isto é, empresas ou pessoas assinantes do serviço
 * @author alira
 */
@Entity
@Table(name = "Cliente")
@PrimaryKeyJoinColumn(name = "Id")
public class Client extends Persona
{
    public void DoInit()
    {
        if(this.userList == null)
        {
            this.userList = new ArrayList<User>();
        }
        
        if(this.interviewerClientMailMessageList == null)
        {
            this.interviewerClientMailMessageList = new ArrayList<InterviewerClientMail>();
        }
        
        if(this.configurationList == null)
        {
            this.configurationList = new ArrayList<ClientConfiguration>();
        }
        
        if(this.mobileDeviceList == null)
        {
            this.mobileDeviceList = new ArrayList<MobileDevice>();
        }
        
        if(this.mobileDeviceProviderList == null)
        {
            this.mobileDeviceProviderList = new ArrayList<MobileDeviceProvider>();
        }
        
        if(this.technicalAssistanceList == null)
        {
            this.technicalAssistanceList = new ArrayList<MobileDeviceTechnicalAssistance>();
        }
        
        if(this.invoiceList == null)
        {
            this.invoiceList = new ArrayList<Invoice>();
        }
        
        if(this.insuranceCompanyList == null)
        {
            this.insuranceCompanyList = new ArrayList<InsuranceCompany>();
        }
        
        if(this.clientInsuranceContractList == null)
        {
            this.clientInsuranceContractList = new ArrayList<InsuranceContract>();
        }
        
        if(this.simCardList == null)
        {
            this.simCardList = new ArrayList<SimCard>();
        }
        
        if(this.researchCategoryList == null)
        {
            this.researchCategoryList = new ArrayList<ResearchCategory>();
        }
        
        if(this.researchList == null)
        {
            this.researchList = new ArrayList<Research>();
        }
    }
    
    /** Construtor */
    public Client()
    {
        super();
        this.DoInit();
    }
    
    /**
     * Construtor
     * @param documentNumber Número do documento identificador da pessoa (CPF ou CNPJ)
     * @param personType Tipo da pessoa (se física ou jurídica)
     * @throws Exception Exceção por tipo de pessoa não fornecido ou inválido.
     */
    public Client(String documentNumber, PersonType_Tp personType) throws Exception
    {
        super();
        this.DoInit();
        
        if(personType == PersonType_Tp.JuridicalPerson)
        {
            this.cnpj = documentNumber;
        }
        else if(personType == PersonType_Tp.PhysicalPerson)
        {
            this.cpf = documentNumber;
        }
        else
        {
            throw new Exception("Por favor indique um tipo de pessoa válido.");
        }
    }
    
    /** Nome do contato no cliente */
    @Column(name = "Contato", length = 120, nullable = true )
    String contact;
    /** GET para o nome do contato no cliente */
    public String getContact() { return contact; }
    /** SET para o nome do contato no cliente */
    public void setContact(String c) { this.contact = c; }
    
    /** Usuário gerenciado da conta to cliente */
    @OneToOne(fetch = FetchType.LAZY,
              cascade = CascadeType.ALL,
              optional = false,
              orphanRemoval = false)
    @JoinColumn(name = "Gerente", nullable = false)
    User manager;
    /** GET para o usuário gerenciador da conta do cliente */
    public User getManager() { return manager; }
    /** SET para o usuário gerenciador da conta do cliente */
    public void setManager(User manager) { this.manager = manager; }
    
    /** Usuários do cliente */
    @OneToMany(cascade = CascadeType.ALL,
               mappedBy = "client",
               targetEntity = User.class,
               fetch = FetchType.LAZY)
    List<User> userList;
    /** GET para a lista de usuários do cliente */
    public List<User> getUserList() { return userList; }
    /** SET para a lista de usuários do cliente */
    public void setUserList(List<User> userList) { this.userList = userList; }
    
    /** Histórico de configurações do cliente */
    @OneToMany(cascade = CascadeType.ALL,
               mappedBy = "client",
               targetEntity = ClientConfiguration.class,
               fetch = FetchType.LAZY)
    List<ClientConfiguration> configurationList;
    /** GET para o histórico de configurações do cliente */
    public List<ClientConfiguration> getConfigurationList() { return this.configurationList; }
    /** SET para o histórico de configurações do cliente  */
    public void setConfigurationList(List<ClientConfiguration> cList) { this.configurationList = cList; }
    
    @OneToMany(cascade = CascadeType.ALL,
               fetch = FetchType.LAZY,
               mappedBy = "client",
               targetEntity = InterviewerClientMail.class)
    List<InterviewerClientMail> interviewerClientMailMessageList;
    public List<InterviewerClientMail> getInterviewerClientMailMessageList() { return this.interviewerClientMailMessageList; }
    public void setInterviewerClientMailMessageList(List<InterviewerClientMail> icmmList) { this.interviewerClientMailMessageList = icmmList; }
    
    /** Listagem de dispositivos móveis pertencentes ao cliente */
    @OneToMany(cascade = CascadeType.ALL,
               fetch = FetchType.LAZY,
               mappedBy = "client",
               targetEntity = MobileDevice.class)
    List<MobileDevice> mobileDeviceList;
    /** GET para a listagem de dispositivos móveis pertencentes ao cliente */
    public List<MobileDevice> getMobileDeviceList() { return mobileDeviceList; }
    /** SET para a listagem de dispositivos móveis pertencentes ao cliente */
    public void setMobileDeviceList(List<MobileDevice> mdList) { this.mobileDeviceList = mdList; }
    
    /** Listagem de fornecedores de dispositivos móveis registradas por este cliente */
    @OneToMany(cascade = CascadeType.ALL,
               fetch = FetchType.LAZY,
               mappedBy = "client",
               targetEntity = MobileDeviceProvider.class)
    List<MobileDeviceProvider> mobileDeviceProviderList;
    /** GET para a listagem de fornecedores de dispositivos móveis registrados por este cliente */
    public List<MobileDeviceProvider> getMobileDeviceProviderList() { return mobileDeviceProviderList; }
    /** SET para a listagem de fornecedores de dispositivos móveis registrados por este cliente */
    public void setMobileDeviceProviderList(List<MobileDeviceProvider> mdpList) { this.mobileDeviceProviderList = mdpList; }
    
    /** Assistências técnicas registradas por este cliente */
    @OneToMany(cascade = CascadeType.ALL,
               fetch = FetchType.LAZY,
               mappedBy = "client",
               targetEntity = MobileDeviceTechnicalAssistance.class)
    List<MobileDeviceTechnicalAssistance> technicalAssistanceList;
    /** GET para a listagem de assistências técnicas registradas por este cliente */
    public List<MobileDeviceTechnicalAssistance> getTechnicalAssistanceList() { return technicalAssistanceList; }
    /** SET para a listagem de assistências técnicas registradas por este cliente */
    public void setTechnicalAssistanceList(List<MobileDeviceTechnicalAssistance> taList) { this.technicalAssistanceList = taList; }
    
    /** Notas fiscais das compras realizadas pelo cliente */
    @OneToMany(cascade = CascadeType.ALL,
               fetch = FetchType.LAZY,
               mappedBy = "client",
               targetEntity = Invoice.class)
    List<Invoice> invoiceList;
    /** GET para as notas fiscais das compras realizadas pelo cliente */
    public List<Invoice> getInvoiceList() { return invoiceList; }
    /** SET para as notas fiscais das compras realizadas pelo cliente */
    public void setInvoiceList(List<Invoice> iList) { this.invoiceList = iList; }
    
    /** Lista de seguradoras registradas pelo cliente */
    @OneToMany(fetch = FetchType.LAZY,
               cascade = CascadeType.ALL,
               mappedBy = "client")
    List<InsuranceCompany> insuranceCompanyList;
    /** GET para a lista de seguradoras registradas pelo cliente */
    public List<InsuranceCompany> getInsuranceCompanyList() { return this.insuranceCompanyList; }
    /** SET para a lista de seguradoras registradas pelo cliente */
    public void setInsuranceCompanyList(List<InsuranceCompany> icList) { this.insuranceCompanyList = icList; }
    
    /** Constratos de aquisição de seguro firmados por este cliente */
    @OneToMany(fetch = FetchType.LAZY,
               cascade = CascadeType.ALL,
               mappedBy = "client")
    List<InsuranceContract> clientInsuranceContractList;
    /** GET para os contratos de aquisição de seguro firmados por este cliente */
    public List<InsuranceContract> getClientInsuranceContractList() { return this.clientInsuranceContractList; }
    /** SET para os contratos de aquisição de seguro firmados por este cliente */
    public void setClientInsuranceContractList(List<InsuranceContract> icList) { this.clientInsuranceContractList = icList; }
    
    /** Chips de telefonia pertencentes ao cliente. */
    @OneToMany(fetch = FetchType.LAZY,
               cascade = CascadeType.ALL,
               mappedBy = "client")
    List<SimCard> simCardList;
    /** GET para a lista de chips de telefonia pertencentes ao cliente */
    public List<SimCard> getSimCardList() { return simCardList; }
    /** SET para a lista de chips de telefonia pertencentes ao cliente */
    public void setSimCardList(List<SimCard> scList) { this.simCardList = scList; }
    
    /** Categorias de pesquisa criadas pelo cliente */
    @OneToMany(fetch = FetchType.LAZY,
               cascade = CascadeType.ALL,
               mappedBy = "client")
    List<ResearchCategory> researchCategoryList;
    /** GET para a lista de categorias de pesquisa criadas pelo cliente */
    public List<ResearchCategory> getResearchCategoryList() { return this.researchCategoryList; }
    /** SET para a lista de categorias de pesquisa criadas pelo cliente */
    public void setResearchCategoryList(List<ResearchCategory> rcList) { this.researchCategoryList = rcList; }
    
    /** Coleção de pesquisas do cliente */
    @OneToMany(fetch = FetchType.LAZY,
               cascade = CascadeType.ALL,
               mappedBy = "client")
    List<Research> researchList;
    /** GET para a coleção de pesquisas do cliente */
    public List<Research> getResearchList() { return researchList; }
    /** SET para a coleção de pesquisas do cliente */
    public void setResearchList(List<Research> rList) { this.researchList = rList; }
    
    /**
     * Adiciona nota fiscal à lista de notas emitidas para o cliente
     * @param invoice Nota fiscal do cliente a ser adicionada (nova)
     */
    public void addInvoice(Invoice invoice)
    {
        if(this.invoiceList == null)
        {
            this.invoiceList = new ArrayList<Invoice>();
        }
        
        this.invoiceList.add(invoice);
    }
    
    @PrePersist
    private void onSave()
    {
        if(this.personType == null)
        {
            this.personType = PersonType_Tp.None;
        }
    }
}
