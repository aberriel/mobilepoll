package ufrj.mobilepoll.model;

import java.util.Date;

/**
 * Classe do modelo de dados para pessoas (usuários, entrevistados, etc)
 * Created by alira on 08/10/15.
 */
public class Person
{
    /** Construtor */
    public Person() { }

    /** Identificador único do registro na tabela */
    private long id;
    /** GET para o identificador único do registro na tabela */
    public long getId() { return id; }
    /** SET para o identificador único do registro na tabela */
    public void setId(long id) { this.id = id; }

    /** Nome da pessoa */
    private String name;
    /** GET para o nome da pessoa */
    public String getName() { return name; }
    /** SET para o nome da pessoa */
    public void setName(String name) { this.name = name; }

    private String description;
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    /** E-mail principal */
    private String primaryEmail;
    /** GET para o e-mail principal da pessoa */
    public String getPrimaryEmail() { return primaryEmail; }
    /** SET para o e-mail principal da pessoa */
    public void setPrimaryEmail(String email) { this.primaryEmail = email; }

    /** E-mail secundário ou alternativo */
    private String secondaryEmail;
    /** GET para o e-mail secundário */
    public String getSecondaryEmail() { return secondaryEmail; }
    /** SET para o e-mail secundário */
    public void setSecondaryEmail(String email) { this.secondaryEmail = email; }

    /** Data de nascimento da pessoa */
    private Date birthday;
    /** GET para a data de nascimento da pessoa */
    public Date getBirthday() { return birthday; }
    /** SET para a data de nascimento da pessoa */
    public void setBirthday(Date birthday) { this.birthday = birthday; }

    /** Telefone principal da pessoa */
    private String primaryTelephone;
    /** GET para o telefone principal */
    public String getPrimaryTelephone() { return primaryTelephone; }
    /** SET para o telefone principal */
    public void setPrimaryTelephone(String telephoneNumber) { this.primaryTelephone = telephoneNumber; }

    /** Telefone secundário ou alternativo da pessoa */
    private String secondaryTelephone;
    /** GET para o telefone secundário */
    public String getSecondaryTelephone() { return secondaryTelephone; }
    /** SET para o telefone secundário */
    public void setSecondaryTelephone(String telephoneNumber) { this.secondaryTelephone = telephoneNumber; }

    private String street;
    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    private String streetNumber;
    public String getStreetNumber() { return streetNumber; }
    public void setStreetNumber(String number) { this.streetNumber = number; }

    /** Complemento do endereço de residência da pessoa (bloco, apto, etc) */
    private String complement;
    /** GET para o complemento do endereço de residência da pessoa */
    public String getComplement() { return complement; }
    /** SET para o complemento do endereço residência da pessoa */
    public void setComplement(String complement) { this.complement = complement; }

    /** Bairro do endereço de residência da pessoa */
    private String neighborhood;
    /** GET para o bairro do endereço de residência da pessoa */
    public String getNeighborhood() { return neighborhood; }
    /** SET para o bairro do endereço de residência da pessoa */
    public void setNeighborhood(String neighborhood) { this.neighborhood = neighborhood; }

    /** Id da cidade de residência da pessoa */
    private Long cityId;
    /** GET para o id da cidade de residência da pessoa */
    public Long getCityId() { return cityId; }
    /** SET para o id da cidade de residência da pessoa */
    public void setCityId(Long cityId) { }

    /** Cidade de residência da pessoa */
    private City city;
    /** GET para a cidade de residência da pessoa */
    public City getCity() { return city; }
    /** SET para a cidade de residência da pessoa */
    public void setCity(City city) { this.city = city; }

    /** CEP do endereço de residência da pessoa */
    private String postalCode;
    /** GET para o CEP do endereço de residencia da pessoa */
    public String getPostalCode() { return postalCode; }
    /** SET para o CEP do endereço de residência da pessoa */
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

    /** Id da cidade de nascimento da pessoa */
    private Long birthCityId;
    /** GET para o id da cidade de nascimento da pessoa */
    public Long getBirthCityId() { return birthCityId; }
    /** SET para o id da cidade de nascimento da pessoa */
    public void setBirthCityId(Long cityId) { this.birthCityId = cityId; }

    /** Cidade de nascimento da pessoa */
    private City birthCity;
    /** GET para a cidade de nascimento da pessoa */
    public City getBirthCity() { return birthCity; }
    /** SET para a cidade de nascimento da pessoa */
    public void setBirthCity(City birthCity) { this.birthCity = birthCity; }

    private Long identifierDocumentId;
    public Long getIdentifiedDocumentId() { return this.identifierDocumentId; }
    public void setIdentifierDocumentId(Long idRG) { this.identifierDocumentId = idRG; }

    /** Documento de identidade da pessoa */
    private RG identifierDocument;
    /** GET para o documento de identidade da pessoa */
    public RG getIdentifierDocument() { return this.identifierDocument; }
    /** SET para o documento de identidade da pessoa */
    public void setIdentifierDocument(RG document) { this.identifierDocument = document; }

    /** CPF */
    private String cpf;
    /** GET para o CPF da pessoa */
    public String getCPF() { return cpf; }
    /** SET para o CPF da pessoa */
    public void setCPF(String cpf) { this.cpf = cpf; }
}