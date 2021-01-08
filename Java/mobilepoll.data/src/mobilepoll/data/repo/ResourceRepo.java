package mobilepoll.data.repo;

import org.hibernate.*;

/**
 *
 * @author anselmolira
 */
public class ResourceRepo extends GenericRepo
{
    public ResourceRepo() throws Exception { super(); }
    
    public ResourceRepo(Session session) throws Exception { super(session); }
}