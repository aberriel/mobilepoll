package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;

/**
 *
 * @author anselmolira
 */
public class SessionManager_
{
    /** Identificador único do registro no banco */
    public static volatile SingularAttribute<SessionManager, Long> id;
    /** Sistema a partir do qual foi realizada  aautenticação */
    public static volatile SingularAttribute<SessionManager, System> sessionOrigin;
    /** Chave pública identificadora da sessão */
    public static volatile SingularAttribute<SessionManager, String> sessionKey;
    /** Chave pública identificadora do sistema a partir do qual foi realizada a autenticação */
    public static volatile SingularAttribute<SessionManager, String> systemKey;
    public static volatile SingularAttribute<SessionManager, Long> authenticatedUserId;
    /** Data e hora do início da sessão */
    public static volatile SingularAttribute<SessionManager, Date> initDateTime;
    /** Data e hora da última movimentação na sessão */
    public static volatile SingularAttribute<SessionManager, Date> lastActionDateTime;
    /** Data e hora em que a sessão expirou */
    public static volatile SingularAttribute<SessionManager, Date> expirationDateTime;
    /** Causa do término da sessão */
    public static volatile SingularAttribute<SessionManager, String> finishReason;
}