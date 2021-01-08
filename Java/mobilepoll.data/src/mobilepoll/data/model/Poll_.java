package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 *
 * @author alira
 */
@StaticMetamodel(Poll.class)
public class Poll_
{
    public static volatile SingularAttribute<Poll, Long> id;
    public static volatile SingularAttribute<Poll, System> pollOrigin;
    public static volatile SingularAttribute<Poll, User> interviewer;
    public static volatile SingularAttribute<Poll, Interviewee> interviewee;
    public static volatile SingularAttribute<Poll, String> intervieweeIp;
    public static volatile SingularAttribute<Poll, Research> research;
    public static volatile SingularAttribute<Poll, Date> initDateTime;
    public static volatile SingularAttribute<Poll, Date> lastActivityDateTime;
    public static volatile SingularAttribute<Poll, Date> finishDateTime;
    public static volatile SingularAttribute<Poll, SurveyFinishReason> finishReason;
    public static volatile SingularAttribute<Poll, String> errorMessage;
    public static volatile SingularAttribute<Poll, GpsData> gps_data;
    public static volatile ListAttribute<Poll, Answer> answerList;
}
