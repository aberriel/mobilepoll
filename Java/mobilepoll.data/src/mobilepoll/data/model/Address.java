package mobilepoll.data.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.Type;

/**
 * Endereços físicos de pessoas
 * @author anselmo.lira
 */
@Entity
@Table(name = "Endereco")
public class Address
{
    private void DoInit()
    {
        this.mainAddress = false;
        if(this.registerDateTime == null)
        {
            this.registerDateTime = new Date();
        }
    }
    
    /** Construtor */
    public Address()
    {
        DoInit();
    }
    
    /**
     * Construtor
     * @param city Nome do município onde se encontra o endereço
     */
    public Address(City city)
    {
        this.DoInit();
        this.city = city;
    }
    
    /**
     * Construtor
     * @param street Nome do logradouro
     */
    public Address(String street)
    {
        this.DoInit();
        this.street = street;
    }
    
    /**
     * Construtor
     * @param street Nome do logradouro
     * @param city Nome da cidade onde se localiza o endereço
     */
    public Address(String street, City city)
    {
        this.DoInit();
        this.street = street;
        this.city = city;
    }
    
    /**
     * Construtor
     * @param city Nome da cidade onde se localiza o endereço
     * @param persona Pessoa dona do endereço
     */
    public Address(City city, Persona persona)
    {
        this.DoInit();
        this.city = city;
        this.persona = persona;
    }
    
    /**
     * Construtor
     * @param street Nome do logradouro
     * @param persona Pessoa dona do endereço
     */
    public Address(String street, Persona persona)
    {
        this.DoInit();
        this.street = street;
        this.persona = persona;
    }
    
    /**
     * Construtor
     * @param street Nome do logradouro
     * @param city Cidade onde se localiza o logradouro
     * @param persona Dono do endereço
     */
    public Address(String street, City city, Persona persona)
    {
        this.DoInit();
        this.street = street;
        this.city = city;
        this.persona = persona;
    }
    
    /**
     * Construtor
     * @param street Nome do logradouro
     * @param number Número do imóvel no logradouro
     * @param city Cidade onde fica o endereço
     */
    public Address(String street, String number, City city)
    {
        this.DoInit();
        this.street = street;
        this.number = number;
        this.city = city;
    }
    
    /** Identificador único do endereço no sistema */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    long id;
    /** GET para o ID do endereço */
    public long getId() { return id; }
    /** SET para o ID do endereço */
    public void setId(long id) { this.id = id; }
    
    /** Tipo do endereço */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TipoDeEndereco", nullable = true)
    AddressType addressType;
    /** GET para o tipo do endereço */
    public AddressType getAddressType() { return addressType; }
    /** SET para o tipo do endereço */
    public void setAddressType(AddressType type) { this.addressType = type; }
    
    /** Logradouro */
    @Column(name = "Logradouro", nullable = false, length = 300)
    String street;
    /** GET para o logradouro */
    public String getStreet() { return street; }
    /** SET para o logradouro */
    public void setStreet(String street) { this.street = street; }
    
    /** Número do imóvel no logradouro */
    @Column(name = "NumeroEndereco", length = 10, nullable = true)
    String number;
    /** GET para o número do imóvel no logradouro */
    public String getNumber() { return number; }
    /** SET para o número do imóvel no logradouro */
    public void setNumber(String number) { this.number = number; }
    
    /** Complemento do endereço (sala, bloco, apto, etc) */
    @Column(name = "Complemento", length = 120, nullable = true)
    String complement;
    /** GET para o complemento do endereço */
    public String getComplement() { return complement; }
    /** SET para o complemento do endereço */
    public void setComplement(String comp) { this.complement = comp; }
    
    /** Bairro */
    @Column(name = "Bairro", length = 200, nullable = true)
    String neighborhood;
    /** GET para o bairro */
    public String getNeighborhood() { return neighborhood; }
    /** SET para o bairro */
    public void setNeighborhood(String neighborhood) { this.neighborhood = neighborhood; }
    
    /** Cidade onde se localiza o endereço */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Cidade", nullable = false)
    City city;
    /** GET para a cidade */
    public City getCity() { return city; }
    /** SET para a cidade */
    public void setCity(City c) { this.city = c; }
    
    /** CEP */
    @Column(name = "CEP", length = 15, nullable = true)
    String zipCode;
    /** GET para o CEP */
    public String getZipCode() { return zipCode; }
    /** SET para o CEP */
    public void setZipCode(String code) { this.zipCode = code; }
    
    /** Pessoa à qual o endereço pertence */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Pessoa", nullable = true)
    Persona persona;
    /** GET para a pessoa à qual o endereço pertence */
    public Persona getPersona() { return persona; }
    /** SET para a pessoa à qual o endereço pertence */
    public void setPersona(Persona persona) { this.persona = persona; }
    
    /** Comentários e/ou observações pertinentes */
    @Column(name = "Comentarios", columnDefinition = "TEXT", nullable = true)
    String comments;
    /** GET para os comentários e/ou observações */
    public String getComments() { return comments; }
    /** SET para os comentários e/ou observações */
    public void setComments(String comments) { this.comments = comments; }
    
    /** Flag indicador de endereço principal da pessoa */
    @Column(name = "EnderecoPrincipal", columnDefinition = "TINYINT", length = 1, nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    boolean mainAddress;
    /** GET para o flag indicador de endereço principal da pessoa */
    public boolean getMainAddress() { return mainAddress; }
    /** SET para o flag indicador de endereço principal da pessoa */
    public void setMainAddress(boolean main) { this.mainAddress = main; }
    
    /** Data e hora do registro do endereço no sistema */
    @Column(name = "DataHoraRegistro", columnDefinition = "datetime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date registerDateTime;
    /** GET para a data e hora do registro do endereço */
    public Date getRegisterDateTime() { return registerDateTime; }
    /** SET para a data e hora do registro do endereço */
    public void setRegisterDateTime(Date dt) { this.registerDateTime = dt; }
    
    @PrePersist
    private void onSave()
    {
        if(this.registerDateTime == null)
        {
            this.registerDateTime = new Date();
        }
    }
}
