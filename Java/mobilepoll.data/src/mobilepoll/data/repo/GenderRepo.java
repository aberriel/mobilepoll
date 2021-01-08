package mobilepoll.data.repo;

import org.hibernate.*;

/**
 * repositório de dados para sexo de pessoa
 * @author anselmolira
 */
public class GenderRepo extends GenericRepo
{
    public GenderRepo() throws Exception { super(); }
    
    public GenderRepo(Session session) throws Exception { super(session); }
}