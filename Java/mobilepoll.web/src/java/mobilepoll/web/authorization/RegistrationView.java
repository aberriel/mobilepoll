/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobilepoll.web.authorization;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import mobilepoll.database.repository.model.User;
import org.primefaces.event.FlowEvent;

/**
 * Controlador para a tela de registro de usuários
 * @author alira
 */
@ManagedBean
public class RegistrationView
{
    /** Tipo da pessoa a ser registrada */
    private String registerType;
    /** GET para o tipo da pessoa a ser registrada, obtida da combo */
    public String getRegisterType() { return registerType; }
    /** SET para o tipo da pessoa a ser registrada, obtida da combo */
    public void setRegisterType (String registerType) { this.registerType = registerType; }
    
    /** Define se o assistente de registro de pessoa física deverá ser exibido */
    public boolean getPhysicalPersonRegisterType()
    {
        return this.registerType == "physical";
    }
    
    /** Define se o assistente de registro de pessoa jurídica deverá ser exibido */
    public boolean getJuridicalPersonRegisterType()
    {
        return this.registerType == "juridical";
    }
    
    /** Dados do usuário autenticado */
    private User userData;
    /** GET para os dados do usuário autenticado */
    public User getUserData() { return userData; }
    /** SET para os dados do usuário autenticado */
    public void setUserData(User user) { this.userData = user; }
    
    @PostConstruct
    public void Init()
    {
    }
    
    /**
     * Flag para controle de processo de registro.
     * Se "true", indica que o usuário solicitou saltar o processo de registro para o final
     */
    private boolean skip;
    public boolean isSkip() { return skip; }
    public void setSkip(boolean skip) { this.skip = skip; }
    
    public String onFlowProcess(FlowEvent event)
    {
        if(skip)
        {
            skip = false;
            return "confirm";
        }
        else
        {
            return event.getNewStep();
        }
    }
    
    /** Inicia o processo de registro, de acordo com o tipo selecionado. Ou exibe mensagem de erro. */
    public void initRegistrationWizard()
    {
        String errorMessage = "";
        if(this.registerType != null)
        {
            if(this.registerType.equals("physical") || this.registerType.equals("juridical"))
            {
                //String url = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + "/Authentication/register.xhtml?faces-redirect=true   ";
                String url = "faces/Authentication/register.xhtml";
                
                try
                {
                    FacesContext.getCurrentInstance().getExternalContext().redirect(url);
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }
            else
            {
                errorMessage = "Por favor, selecione um tipo de registro.";
            }
        }
        else
        {
            errorMessage = "Ocorreu um erro. Tente novamente mais tarde.";
        }
        
        if(errorMessage.isEmpty() == false)
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Erro!", "Detalhes: " + errorMessage));
        }
    }
}
