package mobilepoll.data.repo;

import mobilepoll.data.HibernateUtil;
import org.hibernate.Session;


/**
 * Classe base para repositórios de dados.
 * @author anselmoberriel
 */
public class GenericRepo
{
    /** Sessão do hibernate */
    Session session;
    /** GET para sessão do hibernate */
    public Session getSession() { return this.session; }
    /** SET para sessão do hibernate */
    public void setSession(Session session) { this.session = session; }
    
    /** Construtor */
    public GenericRepo() throws Exception
    {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }
    
    /**
     * Construtor.
     * @param session Sessão do hibernate a ser usada
     */
    public GenericRepo(Session session) throws Exception
    {
        if(session == null)
        {
            this.session = HibernateUtil.getSessionFactory().openSession();
        }
        else
        {
            this.session = session;
        }
    }
}