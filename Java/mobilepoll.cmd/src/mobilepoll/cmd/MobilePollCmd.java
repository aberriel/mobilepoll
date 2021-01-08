/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobilepoll.cmd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import mobilepoll.database.repository.model.City;
import mobilepoll.database.repository.model.FederalUnity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author alira
 */
public class MobilePollCmd
{
    /** Sessão do hibernate com o banco de dados */
    private static Session session;
    
    /**
     * @param args Argumentos de linha de comando
     */
    public static void main(String[] args)
    {
        System.out.println("Teste!!");
        
        FederalUnity f1 = new FederalUnity();
        f1.setName("Rio de Janeiro");
        f1.setAbbreviation("RJ");
        CreateFederalUnity(f1);
        
        City c1 = new City();
        c1.setName("São João de Meriti");
        c1.setFederalUnity(f1);
        CreateCity(c1);
        
        FederalUnity f_rj = findByID(12);
        System.out.println("Federal Unity founded: " + f_rj.getName());
        
        CloseSession();
    }
    
    /**
     * Recupera conexão com o banco de dados
     * 
     * @return Objeto de conexão (sessão) com o banco
     * @throws SQLException 
     */
    public static Connection GetConnection() throws SQLException
    {
        String driver = "com.mysql.jdbc.Driver";
        String url    = "jdbc:mysql://localhost:3306/enquetemobile";
        String username = "root";
        String password = "";
        System.setProperty(driver,"");

        return DriverManager.getConnection(url,username,password);
    }
    
    public static SessionFactory getSessionFactory()
    {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }
    
    /**
     * 
     * @param c
     * @return 
     */
    public static long CreateCity(City c)
    {
        session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(c);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created " + c.getName());
        return c.getId();
    }
    
    public static long CreateFederalUnity(FederalUnity f)
    {
        session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(f);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created " + f.getName());
        return f.getId();
    }
    
    public static List<FederalUnity> read()
    {
        session = getSessionFactory().openSession();
        @SuppressWarnings("unchecked")
        List<FederalUnity> federalUnities = session.createQuery("FROM Employee").list();
        session.close();
        System.out.println("Found " + federalUnities.size() + " federal unities");
        return federalUnities;
    }
    
    public static void update(FederalUnity e)
    {
        session = getSessionFactory().openSession();
        session.beginTransaction();
        
        FederalUnity fu = (FederalUnity) session.load(FederalUnity.class, e.getId());
        fu.setName(e.getName());
        fu.setAbbreviation(e.getAbbreviation());
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated " + e.toString());
    }
    
    public static void delete(Integer id)
    {
        session = getSessionFactory().openSession();
        session.beginTransaction();
        FederalUnity e = findByID(id);
        session.delete(e);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted " + e.toString());
    }
    
    public static FederalUnity findByID(long id)
    {
        session = getSessionFactory().openSession();
        FederalUnity e = (FederalUnity) session.load(FederalUnity.class, id);
        return e;
    }
    
    public static void deleteAll()
    {
        session = getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM UnidadeFederativa ");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all federal unities.");
    }
    
    public static void CloseSession()
    {
        session.close();
    }
}
