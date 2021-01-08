package mobilepoll.data.repo;

import org.hibernate.Session;


public class UserGroupRepo extends GenericRepo
{
    public UserGroupRepo() throws Exception { super(); }
    
    public UserGroupRepo(Session session) throws Exception { super(session); }
}