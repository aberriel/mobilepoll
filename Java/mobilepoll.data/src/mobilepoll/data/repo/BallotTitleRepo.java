package mobilepoll.data.repo;

import org.hibernate.*;

/**
 *
 * @author anselmolira
 */
public class BallotTitleRepo extends GenericRepo
{
    public BallotTitleRepo() throws Exception { super(); }
    
    public BallotTitleRepo(Session session) throws Exception { super(session); }
}