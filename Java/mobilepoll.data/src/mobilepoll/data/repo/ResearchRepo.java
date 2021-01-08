package mobilepoll.data.repo;

import java.util.*;
import mobilepoll.data.model.*;
import org.hibernate.*;

/**
 *
 * @author alira
 */
public class ResearchRepo extends GenericRepo
{
    public ResearchRepo() throws Exception { super(); }
    
    public ResearchRepo(Session session) throws Exception { super(session); }
    
    public Research create(Research research)
    {
        this.session.save(research);
        return research;
    }
    
    public List<Research> getAll(boolean onlyValids)
    {
        
    }
    
    public Research getById(long researchId)
    {
        
    }
    
    public List<Research> getByName(String name)
    {
        
    }
    
    public List<Research> getByNameAndClient(Client client, String name)
    {
        
    }
    
    public List<Research> getByClient(Client client, boolean onlyValids)
    {
        
    }
    
    public List<Research> getByPeriod(Date initDateTime, Date finishDateTime, boolean onlyValids)
    {
        
    }
    
    public List<Research> getPublics(boolean onlyValids)
    {
        
    }
    
    public List<Research> getPublicsByClient(Client client, boolean onlyValids)
    {
        
    }
    
    public List<Research> getCurrents(boolean onlyValids)
    {
        
    }
    
    public List<Research> getCurrentsByClient(Client client, boolean onlyValids)
    {
        
    }
    
    public List<Research> getCurrentsByName(String name, boolean onlyValids)
    {
        
    }
    
    public List<Research> getCurrentsByNameAndClient(String name, Client client, boolean onlyValids)
    {
        
    }
    
    public List<Research> getByCategory(ResearchCategory category, boolean onlyValids)
    {
        
    }
    
    public List<Research> getByCategoryAndClient(ResearchCategory category, Client client, boolean onlyValids)
    {
        
    }
    
    public List<Research> getByCategoryAndPeriod(ResearchCategory category, Date initDateTime, Date finishDateTime, boolean onlyValids)
    {
        
    }
    
    public List<Research> getByCategoryAndPeriodAndClient(ResearchCategory category, Date initDateTime, Date finishDateTime, boolean onlyValids)
    {
        
    }
    
    public List<Research> getCurrentsByCategory(ResearchCategory category, boolean onlyValids)
    {
        
    }
    
    public List<Research> getCurrentsByCategoryAndClient(ResearchCategory category, Client client, boolean onlyValids)
    {
        
    }
    
    public void update(Research research)
    {
        
    }
    
    public void delete(Research research)
    {
        
    }
    
    public void delete(long researchId)
    {
        
    }
}
