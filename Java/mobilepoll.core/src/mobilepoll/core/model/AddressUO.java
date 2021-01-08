/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobilepoll.core.model;

import java.io.Serializable;

/**
 * Dados de endereço de pessoa
 * @author alira
 */
public class AddressUO implements Serializable
{
    /** Construtor */
    public AddressUO() { }
    
    /** Nome do logradouro */
    String street;
    /** GET para o nome do logradouro */
    public String getStreet() { return street; }
    /** SET para o nome do logradouro */
    public void setStreet(String street) { this.street = street; }
    
    /** Número do imóvel no logradouro */
    String number;
    /** GET para o número do imóvel no logradouro */
    public String getNumber() { return number; }
    /** SET para o número do imóvel no logradouro */
    public void setNumber(String number) { this.number = number; }
    
    /** Complemento do endereço (sala, apto, bloco, etc) */
    String complement;
    /** GET para o complemento do endereço (sala, apto, bloco, etc) */
    public String getComplement() { return complement; }
    /** SET para o complemento do endereço (sala, apto, bloco, etc) */
    public void setComplement(String complement) { this.complement = complement; }
    
    /** Bairro */
    String neighborhood;
    /** GET para o bairro */
    public String getNeighborhood() { return this.neighborhood; }
    /** SET para o bairro */
    public void setNeighborhood(String neighborhood) { this.neighborhood = neighborhood; }
    
    /** Id da tabela da cidade à qual pertence o endereço */
    long cityId;
    /** GET para o id da tabela da cidade do endereço */
    public long getCityId() { return cityId; }
    /** SET para o id da tabela da cidade do endereço */
    public void setCityId(long id) { this.cityId = id; }
    
    /** Nome da cidade */
    String cityName;
    /** GET para o nome da cidade */
    public String getCityName() { return cityName; }
    /** SET para o nome da cidade */
    public void setCityName(String name) { this.cityName = name; }
    
    /** GET para o id do estado ao qual pertence o endereço */
    long stateId;
    /** GET para o id do estado ao qual pertence o endereço */
    public long getStateId() { return stateId; }
    /** SET para o id do estado ao qual pertence o endereço */
    public void setStateId(long id) { this.stateId = id; }
    
    /** Nome da unidade federativa do endereço */
    String stateName;
    public String getStateName() { return stateName; }
    public void setStateName(String name) { this.stateName = name; }
    
    /** Código postal (CEP) */
    String postalCode;
    /** GET para o código postal (CEP) */
    public String getPostalCode() { return postalCode; }
    /** SET para o código postal (CEP) */
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }
    
    boolean defaultAddress;
    public boolean isDefaultAddress() { return this.defaultAddress; }
    public void setDefaultAddress(boolean isDefault) { this.defaultAddress = isDefault; }
    
    /** Tipo do endereço (residencial, comercial, etc) */
    int type;
    /** GET para o tipo do endereço */
    public int getType() { return type; }
    /** SET para o tipo do endereço */
    public void setType(int type) { this.type = type; }
}
