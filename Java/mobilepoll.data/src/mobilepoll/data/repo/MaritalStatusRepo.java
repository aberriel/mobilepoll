package mobilepoll.data.repo;

import java.util.*;
import mobilepoll.data.model.*;
import org.hibernate.*;

/**
 * Camada de acesso a dados para estados civis
 * @author anselmolira
 */
public class MaritalStatusRepo extends GenericRepo
{
    public MaritalStatusRepo() throws Exception { super(); }
    
    public MaritalStatusRepo(Session session) throws Exception { super(session); }
    
    public MaritalStatus create(MaritalStatus mStatus)
    {
        this.session.save(mStatus);
        return mStatus;
    }
    
    public List<MaritalStatus> getAll()
    {
        List mStatusList = this.session.createQuery("from MaritalStatus", MaritalStatus.class).list();
        return mStatusList;
    }
    
    public MaritalStatus getById(long msId)
    {
        return this.session.byId(MaritalStatus.class).load(msId);
    }
    
    public MaritalStatus getByName(String name) throws Exception
    {
        List mStatusList = this.session.createQuery("from MaritalStatus "
                                                  + "where name = :name", MaritalStatus.class)
                                       .setParameter("name", name)
                                       .getResultList();
        
        MaritalStatus mStatus = null;
        if(mStatusList != null && mStatusList.size() > 0)
        {
            if(mStatusList.size() > 1)
            {
                throw new Exception("Há mais de um estado civil com o mesmo nome " + name + ". Favor revisar.");
            }
            
            mStatus = (MaritalStatus)mStatusList.get(0);
        }
        
        return mStatus;
    }
    
    public void update(MaritalStatus updatedMStatus)
    {
        this.session.update(updatedMStatus);
    }
    
    public void delete(MaritalStatus mStatus)
    {
        this.session.delete(mStatus);
    }
    
    public void delete(long mStatusId) throws Exception
    {
        MaritalStatus mStatus = this.getById(mStatusId);
        
        if(mStatus != null)
        {
            this.session.delete(mStatus);
        }
        else
        {
            throw new Exception("Impossível excluir estado civil não existente: " + Long.toString(mStatusId));
        }
    }
}