package mobilepoll.data.repo;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import mobilepoll.data.model.Client;
import mobilepoll.data.model.Persona;
import mobilepoll.data.model.Persona_;
import mobilepoll.data.model.enums.PersonType_Tp;
import org.hibernate.Session;

/**
 * Repositório de dados para clientes
 * @author anselmolira
 */
public class ClientRepo extends GenericRepo
{
    public ClientRepo() throws Exception { super(); }
    
    public ClientRepo(Session session) throws Exception { super(session); }
    
    public Client create(Client client)
    {
        this.session.save(client);
        return client;
    }
    
    public Client getById(long clientId)
    {
        return this.session.byId(Client.class).load(clientId);
    }
    
    public List<Client> getAll(boolean onlyValids)
    {
        List clientList = null;
        String allQuery = "from Client";
        String allValidsQuery = "from Client "
                              + "where deleteKey is null";
        
        if(onlyValids)
        {
            clientList = this.session.createQuery(allValidsQuery, Client.class)
                                     .getResultList();
        }
        else
        {
            clientList = this.session.createQuery(allQuery, Client.class)
                                     .getResultList();
        }
        
        return clientList;
    }
    
    public Client getByDocument(String docNumber, PersonType_Tp personType) throws Exception
    {
        List resultList = null;
        if(personType == PersonType_Tp.PhysicalPerson)
        {
            resultList = this.session.createQuery("from Client "
                                                + "where cpf = :cpf", Client.class)
                                     .setParameter("cpf", docNumber)
                                     .getResultList();
        }
        else if(personType == PersonType_Tp.JuridicalPerson)
        {
            resultList = this.session.createQuery("from Client "
                                                + "where cnpj = :cnpj", Client.class)
                                     .setParameter("cnpj", docNumber)
                                     .getResultList();
        }
        else
        {
            throw new Exception("Impossível localizar cliente: tipo não definido.");
        }
        
        Client client = null;
        if(resultList != null && resultList.size() > 0)
        {
            client = (Client)resultList.get(0);
        }
        
        return client;
    }
    
    public Client getByEmail(String email)
    {
        List clientList = this.session.createQuery("from Client "
                                                 + "where primaryEmail = :email", Client.class)
                                      .setParameter("email", email)
                                      .getResultList();
        
        Client client = null;
        if(clientList != null && clientList.size() > 0)
        {
            client = (Client)clientList.get(0);
        }
        
        return client;
    }
    
    public Client getByPersonKey(String pKey)
    {
        List clientList = this.session.createQuery("from Client "
                                                 + "where personKey = :pKey", Client.class)
                                      .setParameter("pKey", pKey)
                                      .getResultList();
        
        Client client = null;
        if(clientList != null && clientList.size() > 0)
        {
            client = (Client)clientList.get(0);
        }
        
        return client;
    }
    
    public Client getByActivationKey(String aKey)
    {
        List clientList = this.session.createQuery("from Client "
                                                 + "where activationKey = :aKey", Client.class)
                                      .setParameter("aKey", aKey)
                                      .getResultList();
        
        Client client = null;
        if(clientList != null && clientList.size() > 0)
        {
            client = (Client)clientList.get(0);
        }
        
        return client;
    }
    
    public List<Client> getByName(String name)
    {
        CriteriaBuilder builder = this.session.getCriteriaBuilder();
        CriteriaQuery<Persona> personaQuery = builder.createQuery(Persona.class);
        Root<Persona> personaRoot = personaQuery.from(Persona.class);
        Root<Client> clientRoot = builder.treat(personaRoot, Client.class);
        
        personaQuery.select(personaRoot);
        personaQuery.where(builder.like(personaRoot.get(Persona_.name), name));
        
        List resultList = this.session.createQuery(personaQuery).getResultList();
        
        return resultList;
    }
}
