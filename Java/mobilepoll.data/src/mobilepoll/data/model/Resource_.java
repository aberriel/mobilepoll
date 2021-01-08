package mobilepoll.data.model;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(Resource.class)
public class Resource_
{
    public static volatile SingularAttribute<Resource, Long> id;
    public static volatile SingularAttribute<Resource, String> name;
    public static volatile SingularAttribute<Resource, String> comments;
    public static volatile SingularAttribute<Resource, System> system;
    public static volatile SingularAttribute<Resource, ResourceType> resourceType;
    public static volatile SingularAttribute<Resource, String> locality;
    public static volatile SingularAttribute<Resource, Boolean> administrativeItem;
    public static volatile ListAttribute<Resource, ObjectTypeResource> objectTypeResourceList;
}