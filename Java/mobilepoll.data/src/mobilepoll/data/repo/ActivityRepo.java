package mobilepoll.data.repo;

import java.util.*;
import javax.persistence.criteria.*;
import mobilepoll.data.model.*;
import org.hibernate.*;

/**
 *
 * @author anselmolira
 */
public class ActivityRepo extends GenericRepo
{
    public ActivityRepo() throws Exception { super(); }
    
    public ActivityRepo(Session session) throws Exception { super(session); }
    
    public Activity create(Activity activity)
    {
        this.session.save(activity);
        return activity;
    }
    
    public List<Activity> getAll()
    {
        List<Activity> aList = this.session.createQuery("from Activity", Activity.class)
                                           .list();
        return aList;
    }
    
    public Activity getById(long activityId)
    {
        return this.session.byId(Activity.class).load(activityId);
    }
    
    public List<Activity> getByName(String name)
    {
        CriteriaBuilder builder = this.session.getCriteriaBuilder();
        CriteriaQuery<Activity> criteria = builder.createQuery(Activity.class);
        Root<Activity> activityRoot = criteria.from(Activity.class);
        criteria.select(activityRoot);
        criteria.where(builder.like(activityRoot.get(Activity_.name), name));
        
        List resultList = this.session.createQuery(criteria).getResultList();
        return resultList;
    }
    
    public List<Activity> getByActivityArea(ActivityArea aa)
    {
        List<Activity> aList = this.session.createQuery("from Activity "
                                                      + "where activityArea.id = :aArea", Activity.class)
                                           .setParameter("aArea", aa.getId())
                                           .getResultList();
        
        return aList;
    }
    
    public Activity getByActivityAreaAndName(ActivityArea aa, String name) throws Exception
    {
        List<Activity> resultList = this.session.createQuery("from Activity "
                                                           + "where activityArea.id = :aArea "
                                                                 + "and name = :aName", Activity.class)
                                                .setParameter("aArea", aa)
                                                .setParameter("aName", name)
                                                .getResultList();
        
        Activity activity = null;
        if(resultList != null && resultList.size() > 0)
        {
            if(resultList.size() > 1)
            {
                throw new Exception("Há mais de uma atividade de mesmo nome para uma dada área.");
            }
            
            activity = resultList.get(0);
        }
        
        return activity;
    }
    
    public void update(Activity activity)
    {
        this.session.update(activity);
    }
    
    public void delete(Activity activity)
    {
        this.session.delete(activity);
    }
}