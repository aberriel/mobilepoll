package mobilepoll.data.repo;

import org.hibernate.*;

/**
 *
 * @author anselmolira
 */
public class MessageSubjectRepo extends GenericRepo
{
    public MessageSubjectRepo() throws Exception { super(); }
    
    public MessageSubjectRepo(Session session) throws Exception { super(session); }
}