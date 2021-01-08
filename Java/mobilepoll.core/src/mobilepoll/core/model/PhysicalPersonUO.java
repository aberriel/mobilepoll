/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobilepoll.core.model;

import java.util.Date;

/**
 * Dados de pessoa física
 * @author alira
 */
public class PhysicalPersonUO
{
    /** Construtor */
    public PhysicalPersonUO() { }
    
    /** Nome completo da pessoa */
    String name;
    /** GET para o nome completo da pessoa */
    public String getName() { return name; }
    /** SET para o nome completo da pessoa */
    public void setName(String name) { this.name = name; }
    
    /** Endereço de e-mail principal da pessoa */
    String email1;
    /** GET para o endereço de e-mail principal da pessoa */
    public String getEmail1() { return this.email1; }
    /** SET para o endereço de e-mail principal da pessoa */
    public void setEmail1(String emailAddress) { this.email1 = emailAddress; }
    
    /** Endereço de e-mail secundário ou alternativo da pessoa */
    String email2;
    /** GET para o endereço de e-mail secundário ou alternativo */
    public String getEmail2() { return email2; }
    /** SET para o endereço de e-mail secundário ou alternativo */
    public void setEmail2(String emailAddress) { this.email2 = emailAddress; }
    
    /** Data de nascimento para a pesoa física */
    Date birthday;
    /** GET para a data de nascimento */
    public Date getBirthday() { return birthday; }
    /** SET para a data de nascimento */
    public void setBirthdat(Date birthday) { this.birthday = birthday; }
    
    /** Número do CPF */
    String cpf;
    /** GET para o número do CPF */
    public String getCPF() { return cpf; }
    /** SET para o número do CPF */
    public void setCPF(String cpf) { this.cpf = cpf; }
    
    /** Número do documento de identidade (RG) */
    String rg;
    /** GET para o número do documento de identidade */
    public String getRG() { return rg; }
    /** SET para o número do documento de identidade */
    public void setRG(String rg) { this.rg = rg; }
    
    /** Id do sexo da pessoa */
    int gender;
    /** GET para o id do sexo da pessoa */
    public int getGender() { return gender; }
    /** SET para o id do sexo da pessoa */
    public void setGender(int gender) { this.gender = gender; }
    
    /** Id do estado civil da pessoa */
    int maritalStatus;
    /** GET para o id do estado civil da pessoa */
    public int getMaritalStatus() { return maritalStatus; }
    /** SET para o id do estado civil da pessoa */
    public void setMaritalStatus(int status) { this.maritalStatus = status; }
}
