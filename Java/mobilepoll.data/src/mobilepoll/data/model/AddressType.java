package mobilepoll.data.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * Classe persistente para tipos de endereço de pessoa
 * @author anselmo.lira
 */
@Entity
@Table(name = "TipoEndereco")
public class AddressType
{
    private void DoInit()
    {
        if(this.addressList == null)
        {
            this.addressList = new ArrayList<Address>();
        }
    }
    
    /** Construtor */
    public AddressType()
    {
        DoInit();
    }
    
    /** Identificador único do tipo de endereço no sistema */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    long id;
    /** GET para o ID do tipo de endereço */
    public long getId() { return id; }
    /** SET para o ID do tipo de endereço */
    public void setId(long id) { this.id = id; }
    
    /** Nome do tipo de endereço */
    @Column(name = "Nome", length = 200, nullable = false, unique = true)
    String name;
    /** GET para o nome do tipo de endereço */
    public String getName() { return name; }
    /** SET para o ID do tipo de endereço */
    public void setName(String name) { this.name = name; }
    
    /** Caminho para arquivo de ícone no sistema de arquivos */
    @Column(name = "CaminhoCompletoIcone", length = 300, nullable = true)
    String fullIconPath;
    /** GET para o caminho para o arquivo de ícone no sistema de arquivos */
    public String getFullIconPath() { return fullIconPath; }
    /** SET para o caminho para o arquivo de ícone no sistema de arquivos */
    public void setFullIconPath(String path) { this.fullIconPath = path; }
    
    /** Comentários e/ou observações pertientes */
    @Column(name = "Comentarios", columnDefinition = "TEXT", nullable = true)
    String comments;
    /** GET para os comentários ou observaçòes pertientes */
    public String getComments() { return comments; }
    /** SET para os comentários ou observaçòes pertinentes */
    public void setComments(String comments) { this.comments = comments; }
    
    /** Data e hora da criação do registro na tabela */
    @Column(name = "DataHoraRegistro", nullable = false, columnDefinition = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    Date registerDateTime;
    /** GET para a data e hora da criação do registro na tabela */
    public Date getRegisterDateTime() { return registerDateTime; }
    /** SET para a data e hora da criação do registro na tabela */
    public void setRegisterDateTime(Date dateTime) { this.registerDateTime = dateTime; }
    
    /** Endereços que pertencem a este tipo. */
    @OneToMany(cascade = CascadeType.ALL,
               mappedBy = "addressType",
               targetEntity = Address.class,
               fetch = FetchType.LAZY)
    List<Address> addressList;
    /** GET para a listagem de endereços que pertencem a este tipo */
    public List<Address> getAddressList() { return addressList; }
    /** SET para a listagem de endereços que pertencem a este tipo */
    public void setAddressList(List<Address> list) { this.addressList = list; }
    
    /** Evento de salvamento do objeto no banco */
    @PrePersist
    private void onSave()
    {
        if(this.registerDateTime == null)
        {
            this.registerDateTime = new Date();
        }
    }
}
