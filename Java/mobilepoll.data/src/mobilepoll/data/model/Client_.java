package mobilepoll.data.model;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(Client.class)
public class Client_
{
    public static volatile SingularAttribute<Client, String> contact;
    public static volatile SingularAttribute<Client, User> manager;
    public static volatile ListAttribute<Client, User> userList;
    public static volatile ListAttribute<Client, ClientConfiguration> configurationList;
    public static volatile ListAttribute<Client, InterviewerClientMail> interviewerClientMailMessageList;
    public static volatile ListAttribute<Client, MobileDevice> mobileDeviceList;
    public static volatile ListAttribute<Client, MobileDeviceProvider> mobileDeviceProviderList;
    public static volatile ListAttribute<Client, MobileDeviceTechnicalAssistance> technicalAssistanceList;
    public static volatile ListAttribute<Client, Invoice> invoiceList;
    public static volatile ListAttribute<Client, InsuranceCompany> insuranceCompanyList;
    public static volatile ListAttribute<Client, InsuranceContract> clientInsuranceContractList;
    public static volatile ListAttribute<Client, SimCard> simCardList;
    public static volatile ListAttribute<Client, ResearchCategory> researchCategoryList;
    public static volatile ListAttribute<Client, Research> researchList;
}