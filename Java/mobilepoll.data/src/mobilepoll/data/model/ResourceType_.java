package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(ResourceType.class)
public class ResourceType_
{
    public static volatile SingularAttribute<ResourceType, Long> id;
    public static volatile SingularAttribute<ResourceType, String> name;
    public static volatile SingularAttribute<ResourceType, String> description;
    public static volatile SingularAttribute<ResourceType, Date> registerDateTime;
    public static volatile ListAttribute<ResourceType, Resource> resourceList;
}