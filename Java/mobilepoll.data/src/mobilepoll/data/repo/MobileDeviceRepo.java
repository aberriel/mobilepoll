package mobilepoll.data.repo;

import org.hibernate.Session;


public class MobileDeviceRepo extends GenericRepo
{
    public MobileDeviceRepo() throws Exception { super(); }
    
    public MobileDeviceRepo(Session session) throws Exception { super(session); }
}