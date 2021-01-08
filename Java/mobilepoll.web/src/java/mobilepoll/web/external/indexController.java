package mobilepoll.web.external;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 * Controlador para a página inicial
 * @author alira
 */
@ManagedBean
public class indexController
{
    /** Construtor */
    public indexController() { }
    
    public void SaveMessage()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Sucesso!", "Bem-vindo!!!"));
    }
}
