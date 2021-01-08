package mobilepoll.data.repo;

import java.util.*;
import javax.persistence.criteria.*;
import mobilepoll.data.model.*;
import org.hibernate.*;

/**
 * Camada de acesso a dados para endereços de pessoas
 * @author anselmolira
 */
public class AddressRepo extends GenericRepo
{
    public AddressRepo() throws Exception { super(); }
    
    public AddressRepo(Session session) throws Exception { super(session); }
    
    public Address create(Address address)
    {
        this.session.save(address);
        return address;
    }
    
    public List<Address> getAll()
    {
        List<Address> addrList = this.session.createQuery("from Address").list();
        return addrList;
    }
    
    public List<Address> getByPerson(long personId)
    {
        List<Address> addrList = this.session.createQuery("from Address "
                                                        + "where persona.id = :pId", Address.class)
                                             .setParameter("pId", personId)
                                             .getResultList();
        
        return addrList;
    }
    
    public Address getById(long addressId)
    {
        return this.session.byId(Address.class).load(addressId);
    }
    
    public List<Address> getByCity(City city)
    {
        List<Address> addrList = this.session.createQuery("from Address "
                                                        + "where city.id = :cId", Address.class)
                                             .setParameter("cId", city.getId())
                                             .getResultList();
        
        return addrList;
    }
    
    public List<Address> getByCityAndPerson(City city, Persona persona)
    {
        List<Address> addrList = this.session.createQuery("from Address "
                                                        + "where city.id = :cId "
                                                              + "and persona.id = :pId", Address.class)
                                             .setParameter("cId", city.getId())
                                             .setParameter("pId", persona.getId())
                                             .getResultList();
        
        return addrList;
    }
    
    public Address getDefaultByPerson(long personId)
    {
        Address address = null;
        
        try
        {
            CriteriaBuilder builder = this.session.getCriteriaBuilder();
            CriteriaQuery<Address> criteria = builder.createQuery(Address.class);
            Root<Address> bcRoot = criteria.from(Address.class);
            criteria.select(bcRoot);
            criteria.where(builder.isTrue(bcRoot.get(Address_.mainAddress)));
            
            address = this.session.createQuery(criteria).getSingleResult();
        }
        catch(Exception ex)
        {
            address = null;
        }
        
        return address;
    }
    
    public void update(Address addr)
    {
        this.session.update(addr);
    }
    
    public void delete(Address addr)
    {
        this.session.delete(addr);
    }
    
    public void delete(long addressId) throws Exception
    {
        Address address = this.getById(addressId);
        
        if(address != null)
        {
            this.session.delete(address);
        }
        else
        {
            throw new Exception("Impossível excluir endereço inexistente: " + Long.toString(addressId));
        }
    }
}