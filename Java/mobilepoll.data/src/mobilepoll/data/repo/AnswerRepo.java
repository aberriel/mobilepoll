package mobilepoll.data.repo;

import org.hibernate.*;

/**
 *
 * @author anselmolira
 */
public class AnswerRepo extends GenericRepo
{
    public AnswerRepo() throws Exception { super(); }
    
    public AnswerRepo(Session session) throws Exception { super(session); }
}