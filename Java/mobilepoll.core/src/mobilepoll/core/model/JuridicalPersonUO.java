/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobilepoll.core.model;

/**
 * Dados de pessoa jurídica
 * @author alira
 */
public class JuridicalPersonUO
{
    /** Construtor */
    public JuridicalPersonUO() { }
    
    /** Nome fantasia*/
    String fantasyName;
    /** GET para o nome fantasia */
    public String getFantasyName() { return this.fantasyName; }
    /** SET para o nome fantasia */
    public void setFantasyName(String name) { this.fantasyName = name; }
    
    /** Razão Social */
    String juridicalName;
    /** GET para a razão social */
    public String getJuridicalName() { return this.juridicalName ; }
    /** SET para a razão social */
    public void setJuridicalName(String name) { this.juridicalName = name; }
    
    /** Número do CNPJ */
    String cnpj;
    /** GET para o número do CNPJ */
    public String getCnpj() { return cnpj; }
    /** SET para o número do CNPJ */
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
    
    /** Endereço de e-mail principal */
    String email1;
    /** GET para o endereço de e-mail principal */
    public String getEmail1 () { return email1; }
    /** SET para o endereço de e-mail principal */
    public void setEnail1(String emailAddress) { this.email1 = emailAddress; }
    
    /** Endereço de e-mail alternativo (secundário ) */
    String email2;
    /** GET para o endereço de e-mail alternativo (secundário) */
    public String getEmail2() { return email2; }
    /** SET para o endereço de e-mail alternativo (secundário) */
    public void setEmail2(String emailAddress) { this.email2 = emailAddress; }
}
