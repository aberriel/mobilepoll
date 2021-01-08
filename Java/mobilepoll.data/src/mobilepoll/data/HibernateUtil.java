package mobilepoll.data;

import java.io.*;
import java.util.*;
import mobilepoll.data.model.*;
import mobilepoll.utils.log.LoggingCapsule;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

/**
 * Gerenciamento de sessões do hibernate para o banco de dados.
 * @author anselmoberriel
 */
public class HibernateUtil
{
    /** Construtor. */
    public HibernateUtil() { }
    
    /** Pool de sessões do hibernate */
    private static SessionFactory sessionFactory = buildSessionFactory();
    
    /** Gera um pool de sessões do hibernate */
    public static SessionFactory buildSessionFactory()
    {
        SessionFactory sf = null;
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Configuration config = new Configuration();
            config.addAnnotatedClass(Activity.class);
            config.addAnnotatedClass(ActivityArea.class);
            config.addAnnotatedClass(Address.class);
            config.addAnnotatedClass(AddressType.class);
            config.addAnnotatedClass(Alternative.class);
            config.addAnnotatedClass(Answer.class);
            config.addAnnotatedClass(AnswerType.class);
            config.addAnnotatedClass(ApplicationActionType.class);
            config.addAnnotatedClass(AuditingData.class);
            config.addAnnotatedClass(BallotTitle.class);
            config.addAnnotatedClass(City.class);
            config.addAnnotatedClass(ClainCoveredType.class);
            config.addAnnotatedClass(Client.class);
            config.addAnnotatedClass(ClientConfiguration.class);
            config.addAnnotatedClass(CommunicationControl.class);
            config.addAnnotatedClass(DbOperationType.class);
            config.addAnnotatedClass(EmailData.class);
            config.addAnnotatedClass(FederalUnity.class);
            config.addAnnotatedClass(Gender.class);
            config.addAnnotatedClass(GlobalConfiguration.class);
            config.addAnnotatedClass(GpsData.class);
            config.addAnnotatedClass(IdentityDocument.class);
            config.addAnnotatedClass(InsuranceCompany.class);
            config.addAnnotatedClass(InsuranceContract.class);
            config.addAnnotatedClass(Interviewee.class);
            config.addAnnotatedClass(InterviewerClientMail.class);
            config.addAnnotatedClass(Invoice.class);
            config.addAnnotatedClass(InvoiceSourceType.class);
            config.addAnnotatedClass(LogApp.class);
            config.addAnnotatedClass(LogDB.class);
            config.addAnnotatedClass(MaintenanceData.class);
            config.addAnnotatedClass(ManufacturerProvider.class);
            config.addAnnotatedClass(ManufacturerTechnicalAssistance.class);
            config.addAnnotatedClass(MaritalStatus.class);
            config.addAnnotatedClass(MessageSubject.class);
            config.addAnnotatedClass(MobileDevice.class);
            config.addAnnotatedClass(MobileDeviceBrand.class);
            config.addAnnotatedClass(MobileDeviceInsurance.class);
            config.addAnnotatedClass(MobileDeviceInvoice.class);
            config.addAnnotatedClass(MobileDeviceManufacturer.class);
            config.addAnnotatedClass(MobileDeviceProvider.class);
            config.addAnnotatedClass(MobileDeviceRemoteUse.class);
            config.addAnnotatedClass(MobileDeviceTechnicalAssistance.class);
            config.addAnnotatedClass(MobileDeviceType.class);
            config.addAnnotatedClass(MobileDeviceUsageControl.class);
            config.addAnnotatedClass(MobileDeviceUsageType.class);
            config.addAnnotatedClass(MobileDeviceWarranty.class);
            config.addAnnotatedClass(Model.class);
            config.addAnnotatedClass(ObjectRightType.class);
            config.addAnnotatedClass(ObjectType.class);
            config.addAnnotatedClass(ObjectTypeResource.class);
            config.addAnnotatedClass(OutForPollData.class);
            config.addAnnotatedClass(ObjectType.class);
            config.addAnnotatedClass(PersonType.class);
            config.addAnnotatedClass(PhoneCompany.class);
            config.addAnnotatedClass(Poll.class);
            config.addAnnotatedClass(Question.class);
            config.addAnnotatedClass(RemovalData.class);
            config.addAnnotatedClass(Research.class);
            config.addAnnotatedClass(ResearchCategory.class);
            config.addAnnotatedClass(Resource.class);
            config.addAnnotatedClass(ResourceType.class);
            config.addAnnotatedClass(Right.class);
            config.addAnnotatedClass(RightScope.class);
            config.addAnnotatedClass(ServerAddressType.class);
            config.addAnnotatedClass(SessionManager.class);
            config.addAnnotatedClass(SimCard.class);
            config.addAnnotatedClass(SurveyFinishReason.class);
            config.addAnnotatedClass(mobilepoll.data.model.System.class);
            config.addAnnotatedClass(Telephone.class);
            config.addAnnotatedClass(TelephoneType.class);
            config.addAnnotatedClass(User.class);
            config.addAnnotatedClass(UserGroup.class);
            config.addAnnotatedClass(UserResearchAuthorization.class);
            config.addAnnotatedClass(UserType.class);
            config.addAnnotatedClass(WarrantyOriginType.class);

            //sessionFactory = config.configure().buildSessionFactory();

            String filePath = "/opt/anselmo/mobilepoll/hibernate.cfg.xml";
            File configFile = new File(filePath);
            sf = config.configure(configFile).buildSessionFactory();
        }
        catch(Throwable ex)
        {
            LoggingCapsule.fatal("MobilePoll >> error to create connection with database.", ex);
            throw new ExceptionInInitializerError(ex);
        }

        return sf;
    }
    
    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
    
    public static void releaseConnection()
    {
        if(sessionFactory != null && !sessionFactory.isClosed())
        {
            sessionFactory.close();
        }
    }
    
    public static Properties getHibernateConfigs()
    {
        throw new UnsupportedOperationException();
    }
}
