package mobilepoll.data.repo;

import org.hibernate.*;

/**
 *
 * @author anselmolira
 */
public class GlobalConfigurationRepo extends GenericRepo
{
    public GlobalConfigurationRepo() throws Exception { super(); }
    
    public GlobalConfigurationRepo(Session session) throws Exception { super(session); }
}