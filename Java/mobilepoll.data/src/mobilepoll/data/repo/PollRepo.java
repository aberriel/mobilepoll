package mobilepoll.data.repo;

import org.hibernate.Session;


public class PollRepo extends GenericRepo
{
    public PollRepo() throws Exception { super(); }
    
    public PollRepo(Session session) throws Exception { super(session); }
}