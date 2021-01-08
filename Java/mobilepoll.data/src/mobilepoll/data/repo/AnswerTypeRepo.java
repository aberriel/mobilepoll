package mobilepoll.data.repo;

import org.hibernate.*;

/**
 * Camada de acesso a dados para tipos de resposta de enquete
 * @author anselmolira
 */
public class AnswerTypeRepo extends GenericRepo
{
    public AnswerTypeRepo() throws Exception { super(); }
    
    public AnswerTypeRepo(Session session) throws Exception { super(session); }
}