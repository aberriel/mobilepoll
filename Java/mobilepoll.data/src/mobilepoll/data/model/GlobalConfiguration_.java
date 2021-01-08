package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(GlobalConfiguration.class)
public class GlobalConfiguration_
{
    public static volatile SingularAttribute<GlobalConfiguration, Long> id;
    public static volatile SingularAttribute<GlobalConfiguration, System> system;
    public static volatile SingularAttribute<GlobalConfiguration, EmailData> sendMailGlobalConfiguration;
    public static volatile SingularAttribute<GlobalConfiguration, String> masterPassword;
    public static volatile SingularAttribute<GlobalConfiguration, Date> pollAnswerTolerance;
    public static volatile SingularAttribute<GlobalConfiguration, Date> sessionTimeLimit;
    public static volatile SingularAttribute<GlobalConfiguration, Date> maximumToleranceWithoutHandling;
    public static volatile SingularAttribute<GlobalConfiguration, Integer> connectedUserGlobalLimit;
    public static volatile SingularAttribute<GlobalConfiguration, Date> registerDateTime;
    public static volatile SingularAttribute<GlobalConfiguration, Date> invalidationDateTime;
}