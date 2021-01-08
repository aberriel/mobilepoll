package mobilepoll.data.repo;

import org.hibernate.Session;


public class AlternativeRepo extends GenericRepo
{
    public AlternativeRepo() throws Exception { super(); }
    
    public AlternativeRepo(Session session) throws Exception { super(session); }
}