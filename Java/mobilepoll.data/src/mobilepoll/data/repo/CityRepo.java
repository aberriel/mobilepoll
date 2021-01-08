package mobilepoll.data.repo;

import java.util.*;
import mobilepoll.data.model.*;
import org.hibernate.Session;


public class CityRepo extends GenericRepo
{
    public CityRepo() throws Exception { super(); }
    
    public CityRepo(Session session) throws Exception { super(session); }
    
    public City create(City city)
    {
        this.session.save(city);
        return city;
    }
    
    public List<City> getAll()
    {
        List cityList = this.session.createQuery("from City").list();
        return cityList;
    }
    
    public City getById(long cityId)
    {
        return this.session.byId(City.class).load(cityId);
    }
    
    public List<City> getByFederalUnity(FederalUnity fUnity)
    {
        List cityList = this.session.createQuery("from City "
                                               + "where federalUnity.id = :fId", City.class)
                                    .setParameter("fId", fUnity.getId())
                                    .getResultList();
        
        return cityList;
    }
    
    public List<City> getByName(String name)
    {
        List cityList = this.session.createQuery("from City "
                                               + "where name = :cName", City.class)
                                    .setParameter("cName", name)
                                    .getResultList();
        
        return cityList;
    }
    
    public City getByFederalUnityAndName(FederalUnity fUnity, String name)
    {
        List cityList = this.session.createQuery("from City "
                                               + "where name = :cName "
                                                     + "and federalUnity = :fUnity", City.class)
                                    .setParameter("cName", name)
                                    .setParameter("fUnity", fUnity.getId())
                                    .getResultList();
        
        City city = null;
        if(cityList != null && cityList.size() > 0)
        {
            city = (City)cityList.get(0);
        }
        
        return city;
    }
    
    public void update(City city)
    {
        this.session.update(city);
    }
    
    public void delete(City city)
    {
        this.delete(city);
    }
    
    public void delete(long cityId) throws Exception
    {
        City city = this.getById(cityId);
        
        if(city == null)
        {
            throw new Exception("Impossível excluir cidade que não existe: " + cityId);
        }
        
        this.session.delete(city);
    }
}
