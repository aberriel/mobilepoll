package mobilepoll.data.repo;

import org.hibernate.*;

/**
 *
 * @author anselmolira
 */
public class IntervieweeRepo extends GenericRepo
{
    public IntervieweeRepo() throws Exception { super(); }
    
    public IntervieweeRepo(Session session) throws Exception { super(session); }
}