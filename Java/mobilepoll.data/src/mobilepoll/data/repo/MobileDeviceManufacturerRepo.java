package mobilepoll.data.repo;

import org.hibernate.*;

/**
 *
 * @author alira
 */
public class MobileDeviceManufacturerRepo extends GenericRepo
{
    public MobileDeviceManufacturerRepo() throws Exception { super(); }
    
    public MobileDeviceManufacturerRepo(Session session) throws Exception { super(session); }
}