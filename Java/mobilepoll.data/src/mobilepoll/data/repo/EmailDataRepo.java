package mobilepoll.data.repo;

import org.hibernate.Session;


public class EmailDataRepo extends GenericRepo
{
    public EmailDataRepo() throws Exception { super(); }
    
    public EmailDataRepo(Session session) throws Exception { super(session); }
}