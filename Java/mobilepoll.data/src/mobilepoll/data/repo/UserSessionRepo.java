package mobilepoll.data.repo;

import org.hibernate.Session;


public class UserSessionRepo extends GenericRepo
{
    public UserSessionRepo() throws Exception { super(); }
    
    public UserSessionRepo(Session session) throws Exception { super(session); }
}
