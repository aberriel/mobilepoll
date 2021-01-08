package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(MessageSubject.class)
public class MessageSubject_
{
    public static volatile SingularAttribute<MessageSubject, Long> id;
    public static volatile SingularAttribute<MessageSubject, String> name;
    public static volatile SingularAttribute<MessageSubject, String> description;
    public static volatile SingularAttribute<MessageSubject, Date> registerDateTime;
}