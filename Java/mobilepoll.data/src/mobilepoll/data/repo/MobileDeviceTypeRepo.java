package mobilepoll.data.repo;

import org.hibernate.*;

/**
 *
 * @author anselmolira
 */
public class MobileDeviceTypeRepo extends GenericRepo
{
    public MobileDeviceTypeRepo() throws Exception { super(); }
    
    public MobileDeviceTypeRepo(Session session) throws Exception { super(session); }
}