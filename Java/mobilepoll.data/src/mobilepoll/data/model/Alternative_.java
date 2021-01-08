package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(Alternative.class)
public class Alternative_
{
    public static volatile SingularAttribute<Alternative, Long> id;
    public static volatile SingularAttribute<Alternative, String> publicKey;
    public static volatile SingularAttribute<Alternative, Question> question;
    public static volatile SingularAttribute<Alternative, Integer> number;
    public static volatile SingularAttribute<Alternative, String> value;
    public static volatile SingularAttribute<Alternative, Question> nextQuestion;
    public static volatile SingularAttribute<Alternative, Boolean> reasonRequired;
    public static volatile SingularAttribute<Alternative, Integer> pendantOperationId;
    public static volatile SingularAttribute<Alternative, Date> registerDateTime;
    public static volatile SingularAttribute<Alternative, Date> lastUpdateDateTime;
    public static volatile SingularAttribute<Alternative, Boolean> valid;
    public static volatile ListAttribute<Alternative, Answer> answerList;
}
