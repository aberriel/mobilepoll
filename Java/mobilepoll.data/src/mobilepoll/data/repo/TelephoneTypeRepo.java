package mobilepoll.data.repo;

import org.hibernate.*;

/**
 *
 * @author anselmolira
 */
public class TelephoneTypeRepo extends GenericRepo
{
    public TelephoneTypeRepo() throws Exception { super(); }
    
    public TelephoneTypeRepo(Session session) throws Exception { super(session); }
}