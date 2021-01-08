package mobilepoll.data.repo;

import org.hibernate.*;

/**
 *
 * @author anselmolira
 */
public class ApplicationActionTypeRepo extends GenericRepo
{
    public ApplicationActionTypeRepo() throws Exception { super(); }
    
    public ApplicationActionTypeRepo(Session session) throws Exception { super(session); }
}