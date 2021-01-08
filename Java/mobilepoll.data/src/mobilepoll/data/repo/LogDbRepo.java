package mobilepoll.data.repo;

import org.hibernate.*;

/**
 *
 * @author anselmolira
 */
public class LogDbRepo extends GenericRepo
{
    public LogDbRepo() throws Exception { super(); }
    
    public LogDbRepo(Session session) throws Exception { super(session); }
}