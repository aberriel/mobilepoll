/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobilepoll.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import mobilepoll.servicecontracts.externalservice.Research;

/**
 *
 * @author anselmo.lira
 */
@WebService(serviceName = "mobilepollservice")
public class mobilepollservice
{

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt)
    {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "ResearchById")
    public Research GetResearchById(@WebParam(name = "researchId") long researchId)
    {
        Research res = new Research();
        res.researchId = 1;
        res.description = "Pesquisa de navegadores.";
        
        return res;
    }
}
