package mobilepoll.data.repo;

import org.hibernate.*;

/**
 * Repositório de dados para modelos de dispositvos móveis
 * @author alira
 */
public class MobileDeviceModelRepo extends GenericRepo
{
    public MobileDeviceModelRepo() throws Exception { super(); }
    
    public MobileDeviceModelRepo(Session session) throws Exception { super(session); }
}