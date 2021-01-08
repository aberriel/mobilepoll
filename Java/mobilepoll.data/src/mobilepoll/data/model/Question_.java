package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(Question.class)
public class Question_
{
    public static volatile SingularAttribute<Question, Long> id;
    public static volatile SingularAttribute<Question, Research> research;
    public static volatile SingularAttribute<Question, String> statement;
    public static volatile SingularAttribute<Question, AnswerType> responseType;
    public static volatile SingularAttribute<Question, Integer> questionNumber;
    public static volatile SingularAttribute<Question, Boolean> required;
    public static volatile SingularAttribute<Question, Boolean> reasonRequired;
    public static volatile SingularAttribute<Question, String> customReasonMessage;
    public static volatile SingularAttribute<Question, Integer> maximumSelectableAlternatives;
    public static volatile SingularAttribute<Question, Alternative> defaultAlternative;
    public static volatile SingularAttribute<Question, Integer> pendingOperationId;
    public static volatile SingularAttribute<Question, Date> registerDateTime;
    public static volatile SingularAttribute<Question, Date> lastUpdateDateTime;
    public static volatile SingularAttribute<Question, Boolean> valid;
    public static volatile ListAttribute<Question, Alternative> alternativeList;
    public static volatile ListAttribute<Question, Answer> answerList;
}
