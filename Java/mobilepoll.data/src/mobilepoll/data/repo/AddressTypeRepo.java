package mobilepoll.data.repo;

import org.hibernate.Session;

/**
 * Camada de acesso a dados para tipos de endereços de pessoas
 * @author anselmolira
 */
public class AddressTypeRepo extends GenericRepo
{
    public AddressTypeRepo() throws Exception { super(); }
    
    public AddressTypeRepo(Session session) throws Exception { super(session); }
}
