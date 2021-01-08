package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(ActivityArea.class)
public class ActivityArea_
{
    public static volatile SingularAttribute<ActivityArea, Long> id;
    public static volatile SingularAttribute<ActivityArea, String> name;
    public static volatile SingularAttribute<ActivityArea, String> comments;
    public static volatile SingularAttribute<ActivityArea, ActivityArea> parentActivityArea;
    public static volatile SingularAttribute<ActivityArea, Date> registerDateTime;
    public static volatile ListAttribute<ActivityArea, ActivityArea> inheritedActivityAreaList;
    public static volatile ListAttribute<ActivityArea, Activity> activityList;
}