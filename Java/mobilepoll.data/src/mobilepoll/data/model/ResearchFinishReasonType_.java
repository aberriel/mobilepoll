package mobilepoll.data.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(ResearchFinishReasonType.class)
public class ResearchFinishReasonType_
{
    public static volatile SingularAttribute<ResearchFinishReasonType, Integer> id;
    public static volatile SingularAttribute<ResearchFinishReasonType, String> name;
    public static volatile SingularAttribute<ResearchFinishReasonType, String> description;
}
