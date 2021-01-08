package mobilepoll.data.repo;

import java.util.*;
import mobilepoll.data.model.*;
import org.hibernate.*;

/**
 *
 * @author anselmolira
 */
public class ActivityAreaRepo extends GenericRepo
{
    public ActivityAreaRepo() throws Exception { super(); }
    
    public ActivityAreaRepo(Session session) throws Exception { super(session); }
    
    public ActivityArea create(ActivityArea aa)
    {
        this.session.save(aa);
        return aa;
    }
    
    public List<ActivityArea> getAll()
    {
        List resultList = this.session.createQuery("from ActivityArea").list();
        return resultList;
    }
    
    public ActivityArea getById(long activityAreaId)
    {
        return this.session.byId(ActivityArea.class).load(activityAreaId);
    }
    
    public List<ActivityArea> getByName(String name)
    {
        List activityList = this.session.createQuery("from ActivityArea "
                                                   + "where name = :name", ActivityArea.class)
                                        .setParameter("name", name)
                                        .getResultList();
        return activityList;
    }
    
    public List<ActivityArea> getRootAreas()
    {
        List rootActivityAreaList = this.session.createQuery("from ActivityArea "
                                                           + "where parentActivityArea is null", ActivityArea.class)
                                                .getResultList();
        
        return rootActivityAreaList;
    }
    
    public void update(ActivityArea aa)
    {
        this.session.update(aa);
    }
    
    public void delete(ActivityArea aa)
    {
        this.session.delete(aa);
    }
}