package mobilepoll.data.repo;

import org.hibernate.*;

/**
 *
 * @author anselmolira
 */
public class ClientConfigurationRepo extends GenericRepo
{
    public ClientConfigurationRepo() throws Exception { super(); }
    
    public ClientConfigurationRepo(Session session) throws Exception { super(session); }
}