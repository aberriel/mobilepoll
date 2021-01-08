package mobilepoll.data.repo;

import java.util.List;
import mobilepoll.data.model.FederalUnity;
import org.hibernate.Session;

/**
 * Repositório de dados para unidades federativas
 * @author alira
 */
public class FederalUnityRepo extends GenericRepo
{
    public FederalUnityRepo() throws Exception { super(); }
    
    public FederalUnityRepo(Session s) throws Exception { super(s); }
    
    public FederalUnity create(FederalUnity fUnity)
    {
        this.session.save(fUnity);
        return fUnity;
    }
    
    public void update(FederalUnity fUnity)
    {
        this.session.update(fUnity);
    }
    
    public void delete(FederalUnity fUnity)
    {
        this.session.delete(fUnity);
    }
    
    public FederalUnity getById(long id)
    {
        return this.session.byId(FederalUnity.class).load(id);
    }
    
    public FederalUnity getByName(String fUnityName)
    {
        List resultList = this.session.createQuery("from FederalUnity "
                                                 + "where name = :fName", FederalUnity.class)
                                      .setParameter("fName", fUnityName)
                                      .getResultList();
        
        FederalUnity fUnity = null;
        if(resultList != null && resultList.size() > 0)
        {
            fUnity = (FederalUnity) resultList.get(0);
        }
        
        return fUnity;
    }
    
    public List<FederalUnity> getAll()
    {
        List fUnityList = this.session.createQuery("from FederalUnity", FederalUnity.class).getResultList();
        return fUnityList;
    }
}
