package mobilepoll.data.repo;

import org.hibernate.*;

/**
 *
 * @author anselmolira
 */
public class MobileDeviceBrandRepo extends GenericRepo
{
    public MobileDeviceBrandRepo() throws Exception { super(); }
    
    public MobileDeviceBrandRepo(Session session) throws Exception { super(session); }
}