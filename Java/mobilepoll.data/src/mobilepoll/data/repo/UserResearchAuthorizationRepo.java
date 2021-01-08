package mobilepoll.data.repo;

import org.hibernate.*;

/**
 *
 * @author anselmolira
 */
public class UserResearchAuthorizationRepo extends GenericRepo
{
    public UserResearchAuthorizationRepo() throws Exception { super(); }
    
    public UserResearchAuthorizationRepo(Session session) throws Exception { super(session); }
}