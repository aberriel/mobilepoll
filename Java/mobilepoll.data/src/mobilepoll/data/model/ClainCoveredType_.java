package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 *
 * @author alira
 */
@StaticMetamodel(ClainCoveredType.class)
public class ClainCoveredType_
{
    /** Identificador único do registro no banco */
    public static volatile SingularAttribute<ClainCoveredType, Integer> id;
    /** Nome da cobertura do segudo */
    public static volatile SingularAttribute<ClainCoveredType, String> name;
    public static volatile SingularAttribute<ClainCoveredType, String> description;
    public static volatile SingularAttribute<ClainCoveredType, Date> registerDateTime;
}
