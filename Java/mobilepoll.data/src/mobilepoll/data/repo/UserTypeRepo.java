package mobilepoll.data.repo;

import java.util.*;
import mobilepoll.data.model.*;
import org.hibernate.*;

/**
 *
 * @author anselmolira
 */
public class UserTypeRepo extends GenericRepo
{
    public UserTypeRepo() throws Exception { super(); }
    
    public UserTypeRepo(Session session) throws Exception { super(session); }
    
    public UserType create(UserType userType)
    {
        this.session.save(userType);
        return userType;
    }
    
    public List<UserType> getAll()
    {
        List userTypeList = this.session.createQuery("from UserType", UserType.class).list();
        return userTypeList;
    }
    
    public UserType getById(long userTypeId)
    {
        return this.session.byId(UserType.class).load(userTypeId);
    }
    
    public UserType getByName(String typeName)
    {
        List userTypeList = this.session.createQuery("from UserType "
                                                   + "where name = :name", UserType.class)
                                        .setParameter("name", typeName)
                                        .getResultList();
        
        UserType uType = null;
        if(userTypeList != null && userTypeList.size() > 0)
        {
            uType = (UserType)userTypeList.get(0);
        }
        
        return uType;
    }
    
    public void update(UserType uType)
    {
        this.session.update(uType);
    }
    
    public void delete(UserType uType)
    {
        this.session.delete(uType);
    }
}