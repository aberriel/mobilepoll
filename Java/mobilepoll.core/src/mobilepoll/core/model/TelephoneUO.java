/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobilepoll.core.model;

/**
 * Dados de telefone
 * @author alira
 */
public class TelephoneUO
{
    /** construtor */
    public TelephoneUO() { }
    
    /** Código de discagem local */
    String cityCode;
    /** GET para o código de discagem local */
    public String getCityCode() { return cityCode; }
    /** SET para o código de discagem local */
    public void setCityCode(String code) { this.cityCode = code; }
    
    /** Número do telefone, propriamente dito */
    String number;
    /** GET para o número do telefone, propriamente dito */
    public String getNumber() { return number; }
    /** SET para o número do telefone, propriamente dito */
    public void setNumber(String number) { this.number = number; }
    
    /** Número do ramal */
    String extension;
    /** GET para o número do ramal */
    public String getExtension() { return extension; }
    /** SET para o número do ramal */
    public void setExtension(String extension) { this.extension = extension; }
    
    /** Tipo do telefone. Ex: residencial, comercial, etc */
    int type;
    /** GET para o tipo do telefone */
    public int getType() { return type; }
    /** SET para o tipo do telefone */
    public void setType(int type) { this.type = type; }
}
