package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(Research.class)
public class Research_
{
    /** Identificador único do registro no banco */
    public static volatile SingularAttribute<Research, Long> id;
    /** Nome da pesquisa */
    public static volatile SingularAttribute<Research, String> name;
    /** Descritivo da pesquisa */
    public static volatile SingularAttribute<Research, String> description;
    /** Cliente dono da pesquisa */
    public static volatile SingularAttribute<Research, Client> client;
    /** Categoria ou tipo da pesquisa */
    public static volatile SingularAttribute<Research, ResearchCategory> researchCategory;
    public static volatile SingularAttribute<Research, String> requiredIdentifierFieldList;
    public static volatile SingularAttribute<Research, Boolean> answerWithoutAuthentication;
    public static volatile SingularAttribute<Research, Date> initDateTime;
    public static volatile SingularAttribute<Research, Date> finishDateTime;
    public static volatile SingularAttribute<Research, User> userResponsibleForRegistration;
    public static volatile SingularAttribute<Research, User> userResponsibleForLastUpdate;
    public static volatile SingularAttribute<Research, Boolean> publicResearch;
    public static volatile SingularAttribute<Research, Boolean> valid;
    /** Data e hora da criação do registro no banco */
    public static volatile SingularAttribute<Research, Date> registerDateTime;
    public static volatile SingularAttribute<Research, Date> lastUpdateDateTime;
    public static volatile SingularAttribute<Research, Date> deleteDateTime;
    public static volatile SingularAttribute<Research, String> deleteKey;
    public static volatile ListAttribute<Research, MobileDevice> mobileDevices;
    public static volatile ListAttribute<Research, User> allowedUsers;
    public static volatile ListAttribute<Research, Question> questionList;
    public static volatile ListAttribute<Research, Poll> pollList;
    public static volatile ListAttribute<Research, UserResearchAuthorization> userAuthorizationHistory;
}
