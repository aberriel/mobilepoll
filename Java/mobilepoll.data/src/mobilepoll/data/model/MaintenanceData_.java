package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(MaintenanceData.class)
public class MaintenanceData_
{
    public static volatile SingularAttribute<MaintenanceData, Long> id;
    public static volatile SingularAttribute<MaintenanceData, MobileDeviceTechnicalAssistance> technicalAssistance;
    public static volatile SingularAttribute<MaintenanceData, Persona> personResponsibleForRemoval;
    public static volatile SingularAttribute<MaintenanceData, Persona> personResponsibleForRepair;
    public static volatile SingularAttribute<MaintenanceData, String> performedRepair;
    public static volatile SingularAttribute<MaintenanceData, Persona> personResponsibleForReturning;
    public static volatile SingularAttribute<MaintenanceData, String> mobileCondition;
    public static volatile SingularAttribute<MaintenanceData, Boolean> warrantyCovers;
    public static volatile SingularAttribute<MaintenanceData, Boolean> requiresDisposal;
    public static volatile SingularAttribute<MaintenanceData, Date> initDateTime;
    public static volatile SingularAttribute<MaintenanceData, Date> finishDateTime;
    public static volatile SingularAttribute<MaintenanceData, Date> technicalAssistanceEntranceDateTime;
    public static volatile SingularAttribute<MaintenanceData, Date> technicalAssistanceOutputDateTime;
    public static volatile SingularAttribute<MaintenanceData, Double> value;
    public static volatile SingularAttribute<MaintenanceData, String> maintenanceReason;
}