package mobilepoll.data.repo;

import mobilepoll.data.model.User;
import org.hibernate.Session;

/**
 * Camada de acesso a dados para usuários
 * @author alira
 */
public class UserRepo extends GenericRepo
{
    public UserRepo() throws Exception { super(); }
    
    public UserRepo(Session session) throws Exception { super(session); }
    
    public User create(User user)
    {
        
    }
    
    public void update(User user)
    {
        
    }
    
    public void delete(User user)
    {
        
    }
}
