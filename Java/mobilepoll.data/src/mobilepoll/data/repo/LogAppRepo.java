package mobilepoll.data.repo;

import java.util.*;
import mobilepoll.data.model.*;
import mobilepoll.data.model.System;
import org.hibernate.*;

/**
 * Repositórios de dados para operações na aplicação
 * @author anselmolira
 */
public class LogAppRepo extends GenericRepo
{
    public LogAppRepo() throws Exception { super(); }
    
    public LogAppRepo(Session session) throws Exception { super(session); }
    
    public LogApp create(LogApp logData)
    {
        this.session.save(logData);
        return logData;
    }
    
    public List<LogApp> getAll()
    {
        List logList = this.session.createQuery("from LogApp", LogApp.class).list();
        return logList;
    }
    
    public LogApp getById(long logId)
    {
        return this.session.byId(LogApp.class).load(logId);
    }
    
    public List<LogApp> getBySystem(System system)
    {
        
    }
    
    public List<LogApp> getByPeriod(Date minDateTime, Date maxDateTime)
    {
        
    }
    
    public List<LogApp> getWithError()
    {
        
    }
    
    public List<LogApp> getWithErrorBySystem(System system)
    {
        
    }
    
    public List<LogApp> getWithErrorByPeriod(Date minDateTime, Date maxDateTime)
    {
        
    }
    
    public List<LogApp> getWithErrorByPeriodAndSystem(Date minDatetime, Date maxDateTime, System system)
    {
        
    }
    
    public List<LogApp> getByPeriodAndSystem(Date minDateTime, Date maxDateTime, System system)
    {
        
    }
}