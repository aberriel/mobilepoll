package mobilepoll.data.repo;

import org.hibernate.*;

/**
 *
 * @author anselmolira
 */
public class CommunicationControlRepo extends GenericRepo
{
    public CommunicationControlRepo() throws Exception { super(); }
    
    public CommunicationControlRepo(Session session) throws Exception { super(session); }
}