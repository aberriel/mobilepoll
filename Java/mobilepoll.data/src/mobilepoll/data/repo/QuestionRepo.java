package mobilepoll.data.repo;

import java.util.*;
import mobilepoll.data.model.*;
import org.hibernate.Session;


public class QuestionRepo extends GenericRepo
{
    public QuestionRepo() throws Exception { super(); }
    
    public QuestionRepo(Session session) throws Exception { super(session); }
    
    public Question create(Question question)
    {
        
    }
    
    public List<Question> getAll(boolean onlyValid)
    {
        
    }
    
    public Question getById(long id)
    {
        
    }
    
    public List<Question> getByResearch(Research research, boolean onlyValids)
    {
        
    }
    
    public void update(Question question)
    {
        
    }
    
    public void delete(Question question, boolean purge)
    {
        
    }
    
    public void delete(long questionId, boolean purge)
    {
        
    }
}