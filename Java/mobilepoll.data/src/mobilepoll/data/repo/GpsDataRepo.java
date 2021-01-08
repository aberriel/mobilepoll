package mobilepoll.data.repo;

import org.hibernate.Session;



public class GpsDataRepo extends GenericRepo
{
    public GpsDataRepo() throws Exception { super(); }
    
    public GpsDataRepo(Session session) throws Exception { super(session); }
}