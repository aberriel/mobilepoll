package mobilepoll.data.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mobilepoll.data.model.enums.MailMessageStatus_Tp;


@StaticMetamodel(InterviewerClientMail.class)
public class InterviewerClientMail_
{
    public static volatile SingularAttribute<InterviewerClientMail, Long> id;
    public static volatile SingularAttribute<InterviewerClientMail, Client> client;
    public static volatile SingularAttribute<InterviewerClientMail, User> interviewer;
    public static volatile SingularAttribute<InterviewerClientMail, String> message;
    public static volatile SingularAttribute<InterviewerClientMail, Integer> communicationDirection;
    public static volatile SingularAttribute<InterviewerClientMail, CommunicationControl> communicationControl;
    public static volatile SingularAttribute<InterviewerClientMail, MailMessageStatus_Tp> messageStatus;
    public static volatile SingularAttribute<InterviewerClientMail, Boolean> openConfirmation;
}