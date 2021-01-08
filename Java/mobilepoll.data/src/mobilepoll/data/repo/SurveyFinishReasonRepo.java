package mobilepoll.data.repo;

import org.hibernate.*;

/**
 *
 * @author anselmolira
 */
public class SurveyFinishReasonRepo extends GenericRepo
{
    public SurveyFinishReasonRepo() throws Exception { super(); }
    
    public SurveyFinishReasonRepo(Session session) throws Exception { super(session); }
}