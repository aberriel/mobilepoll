package mobilepoll.data.repo;

import org.hibernate.*;

/**
 * Camada de acesso a dados para documentos de identificação de pessoas físicas
 * @author anselmolira
 */
public class IdentityDocumentRepo extends GenericRepo
{
    public IdentityDocumentRepo() throws Exception { super(); }
    
    public IdentityDocumentRepo(Session session) throws Exception { super(session); }
}