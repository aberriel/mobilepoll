package mobilepoll.data.repo;

import java.util.*;
import mobilepoll.data.model.*;
import org.hibernate.*;

/**
 *
 * @author anselmolira
 */
public class ResearchCategoryRepo extends GenericRepo
{
    public ResearchCategoryRepo() throws Exception { super(); }
    
    public ResearchCategoryRepo(Session session) throws Exception { super(session); }
    
    public ResearchCategory create(ResearchCategory category)
    {
        
    }
    
    public List<ResearchCategory> getAll(boolean onlyValids)
    {
        
    }
    
    public ResearchCategory getById(long categoryId)
    {
        
    }
    
    public List<ResearchCategory> getByClient(boolean onlyValids)
    {
        
    }
    
    public List<ResearchCategory> getByName(String name, boolean onlyValids)
    {
        
    }
    
    public ResearchCategory getByNameAndClient(String name, Client client)
    {
        
    }
}