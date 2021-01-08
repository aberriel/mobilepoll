package mobilepoll.data.repo;

import java.util.*;
import mobilepoll.data.model.*;
import org.hibernate.Session;

/**
 * Camada de acesso a dados para telefones de pessoas
 * @author anselmolira
 */
public class TelephoneRepo extends GenericRepo
{
    public TelephoneRepo() throws Exception { super(); }
    
    public TelephoneRepo(Session session) throws Exception { super(session); }
    
    public Telephone create(Telephone phone)
    {
        this.session.save(phone);
        return phone;
    }
    
    public List<Telephone> getAll()
    {
        List<Telephone> phoneList = this.session.createQuery("from Telephone").list();
        
        return phoneList;
    }
    
    public Telephone getById(long phoneId)
    {
        return this.session.byId(Telephone.class).load(phoneId);
    }
    
    public List<Telephone> getByPerson(Persona persona)
    {
        List<Telephone> phoneList = this.session.createQuery("from Telephone "
                                                           + "where persona.id = :pId", Telephone.class)
                                                .setParameter("pId", persona.getId())
                                                .getResultList();
        
        return phoneList;
    }
    
    public List<Telephone> getByType(TelephoneType type)
    {
        List<Telephone> phoneList = this.session.createQuery("from Telephone "
                                                           + "where type.id = :tId", Telephone.class)
                                                .setParameter("tId", type.getId())
                                                .getResultList();
        
        return phoneList;
    }
    
    public List<Telephone> getByPersonAndType(Persona persona, TelephoneType type)
    {
        List<Telephone> phoneList = this.session.createQuery("from Telephone "
                                                           + "where persona.id = :pId "
                                                                 + "and type.id = :tId", Telephone.class)
                                                .setParameter("pId", persona.getId())
                                                .setParameter("tId", type.getId())
                                                .getResultList();
        
        return phoneList;
    }
    
    public void update(Telephone phone)
    {
        this.session.update(phone);
    }
    
    public void delete(Telephone phone)
    {
        this.session.delete(phone);
    }
    
    public void delete(long phoneId) throws Exception
    {
        Telephone phone = this.getById(phoneId);
        
        if(phone != null)
        {
            this.session.delete(phone);
        }
        else
        {
            throw new Exception("Impossível excluir telefone inexistente: " + Long.toString(phoneId));
        }
    }
}
