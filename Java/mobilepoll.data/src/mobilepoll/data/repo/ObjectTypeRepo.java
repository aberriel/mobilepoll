package mobilepoll.data.repo;

import org.hibernate.*;

/**
 *
 * @author anselmolira
 */
public class ObjectTypeRepo extends GenericRepo
{
    public ObjectTypeRepo() throws Exception { super(); }
    
    public ObjectTypeRepo(Session session) throws Exception { super(session); }
}