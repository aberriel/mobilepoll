package mobilepoll.data.repo;

import org.hibernate.*;

/**
 *
 * @author anselmolira
 */
public class ResourceTypeRepo extends GenericRepo
{
    public ResourceTypeRepo() throws Exception { super(); }
    
    public ResourceTypeRepo(Session session) throws Exception { super(session); }
}