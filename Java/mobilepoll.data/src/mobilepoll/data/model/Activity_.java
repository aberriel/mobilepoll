package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(Activity.class)
public class Activity_
{
    /** Identificador único do registro no banco */
    public static volatile SingularAttribute<Activity, Long> id;
    /** Nome da área de atuação profissional */
    public static volatile SingularAttribute<Activity, String> name;
    /** Comentários e/ou observações pertinentes */
    public static volatile SingularAttribute<Activity, String> comments;
    public static volatile SingularAttribute<Activity, ActivityArea> activityArea;
    /** Data e hora da criação do registro no banco */
    public static volatile SingularAttribute<Activity, Date> registerDateTime;
}