package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(AnswerType.class)
public class AnswerType_
{
    public static volatile SingularAttribute<AnswerType, Long> id;
    public static volatile SingularAttribute<AnswerType, String> name;
    public static volatile SingularAttribute<AnswerType, String> comments;
    public static volatile SingularAttribute<AnswerType, Boolean> allowMultipleAnswers;
    public static volatile SingularAttribute<AnswerType, String> htmlObject;
    public static volatile SingularAttribute<AnswerType, Date> regiserDateTime;
}
