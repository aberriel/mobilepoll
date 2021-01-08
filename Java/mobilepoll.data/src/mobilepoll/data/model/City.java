package mobilepoll.data.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import mobilepoll.utils.CollectionUtils;

/**
 * Classe persistente para municípios
 * @author alira
 */
@Entity
@Table(name = "Cidade")
public class City
{
    /** Inicialização de atributos da classe */
    private void InitializeFields()
    {
        if(this.addressList == null)
        {
            this.addressList = new ArrayList<Address>();
        }
    }
    
    /** Construtor */
    public City()
    {
        this.InitializeFields();
    }
    
    /**
     * Construtor
     * @param name Nome da cidade
     * @param federalUnity Unidade federativa à qual a cidade pertence
     * @param comments Comentários
     */
    public City(String name, FederalUnity federalUnity, String comments)
    {
        this.InitializeFields();
        
        this.name = name;
        this.federalUnity = federalUnity;
        this.comments = comments;
    }
    
    /** Identificador único da cidade no sistema */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    long id;
    /** GET para o id da cidade */
    public long getId() { return id; }
    /** SET para o id da cidade */
    public void setId(long id) { this.id = id; }
    
    /** Nome da cidade */
    @Column(name = "Nome", length = 200, nullable = false)
    String name;
    /** GET para o nome da cidade */
    public String getName() { return name; }
    /** SET para o nome da cidade */
    public void setName(String name) { this.name = name; }
    
    /** Unidade federativa (estado) à qual pertence este município */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UnidadeFederativa", nullable = false)
    FederalUnity federalUnity;
    /** GET para a unidade federativa */
    public FederalUnity getFederalUnity() { return federalUnity; }
    /** SET para a unidade federativa */
    public void setFederalUnity(FederalUnity fu) { this.federalUnity = fu; }
    
    /** Comentários e/ou observações pertinentes */
    @Column(name = "Comentarios", columnDefinition = "TEXT", nullable = true)
    String comments;
    /** GET para os comentários e/ou observações */
    public String getComments() { return comments; }
    /** SET para os comentários e/ou observações */
    public void setComments(String comments) { this.comments = comments; }
    
    /** Data e hora da inserção do registro no banco  */
    @Column(name = "DataHoraRegistro", columnDefinition = "datetime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date registerDateTime;
    /** GET para a data e hora da inserção do registro no banco */
    public Date getRegisterDateTime() { return this.registerDateTime; }
    
    /** Listagem de endereços registrados para esta cidade */
    @OneToMany(cascade = CascadeType.ALL,
               mappedBy = "city",
               targetEntity = Address.class,
               fetch = FetchType.LAZY)
    List<Address> addressList;
    /** GET para a lista de endereços registrados para esta cidade */
    public List<Address> getAddressList() { return addressList; }
    /** SET para a lista de endereços registrados para esta cidade */
    public void setAddressList(List<Address> addressList) { this.addressList = addressList; }
    
    /** Evento de salvamento do registro. */
    @PrePersist
    private void onSave() throws Exception
    {
        if(this.registerDateTime == null)
        {
            this.registerDateTime = new Date();
        }
        
        List<String> errorList = new ArrayList<String>();
        if(name == null || name.isEmpty())
        {
            errorList.add("O nome da cidade é obrigatório.");
        }
        
        if(federalUnity == null)
        {
            errorList.add("A unidade federativa deve ser fornecida.");
        }
        
        if(errorList.isEmpty() == false)
        {
            throw new Exception("Erros ocorridos ao salvar a cidade: " + CollectionUtils.StringListToString(errorList));
        }
    }
}
