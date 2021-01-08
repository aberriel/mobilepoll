package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 *
 * @author alira
 */
@StaticMetamodel(UserResearchAuthorization.class)
public class UserResearchAuthorization_
{
    /** Identificador único do registro na tabela */
    public static volatile SingularAttribute<UserResearchAuthorization, Long> id;
    /** Usuário que está sendo autorizado a acessar a pesquisa */
    public static volatile SingularAttribute<UserResearchAuthorization, User> user;
    public static volatile SingularAttribute<UserResearchAuthorization, Research> research;
    public static volatile SingularAttribute<UserResearchAuthorization, Date> authorizationDatetime;
    public static volatile SingularAttribute<UserResearchAuthorization, Boolean> valid;
    public static volatile SingularAttribute<UserResearchAuthorization, Date> invalidationDateTime;
}
