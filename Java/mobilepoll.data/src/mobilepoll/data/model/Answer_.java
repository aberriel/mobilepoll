package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(Answer.class)
public class Answer_
{
    public static volatile SingularAttribute<Answer, Long> id;
    public static volatile SingularAttribute<Answer, Poll> poll;
    public static volatile SingularAttribute<Answer, Question> question;
    public static volatile SingularAttribute<Answer, String> textualAnswer;
    public static volatile SingularAttribute<Answer, String> reasonForAnswer;
    public static volatile SingularAttribute<Answer, Date> dateTime;
    public static volatile SingularAttribute<Answer, GpsData> gpsData;
    public static volatile ListAttribute<Answer, Alternative> alternativeList;
}
