package mobilepoll.data.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Type;

/**
 * Classe persistente para categorias ou grupos de pesquisas
 * @author alira
 */
@Entity
@Table(name = "CategoriaPesquisa")
public class ResearchCategory
{
    private void doInit()
    {
        if(this.nestedCategoryList == null)
        {
            this.nestedCategoryList = new ArrayList<ResearchCategory>();
        }
        
        if(this.researchList == null)
        {
            this.researchList = new ArrayList<Research>();
        }
    }
    
    /** Construtor */
    public ResearchCategory()
    {
        this.doInit();
    }
    
    /**
     * Construtor
     * @param name Nome da categoria de pesquisa
     */
    public ResearchCategory(String name)
    {
        this.doInit();
        this.name = name;
    }
    
    /**
     * Construtor
     * @param name
     * @param masterCategory 
     */
    public ResearchCategory(String name, ResearchCategory masterCategory)
    {
        this.doInit();
        this.name = name;
        this.masterCategory = masterCategory;
    }
    
    /** Identificador único do registro no banco */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    long id;
    /** GET para o identificador único do registro no banco */
    public long getId() { return id; }
    /** SET para o identificador único do registro no banco */
    public void setId(long id) { this.id = id; }
    
    /** Nome da categoria ou classe de pesquisa */
    @Column(name = "Nome", length = 200, nullable = false)
    String name;
    /** GET para o nome da categoria ou classe de pesquisa */
    public String getName() { return name; }
    /** SET para o nome da categoria ou classe de pesquisa */
    public void setName(String name) { this.name = name; }
    
    /** Descritivo da categoria ou classe de pesquisa */
    @Column(name = "Descricao", nullable = true, columnDefinition = "TEXT")
    String description;
    /** GET para o descritivo da categoria ou classe de pesquisa */
    public String getDescription() { return description; }
    /** SET para o descritivo da categoria ou classe de pesquisa */
    public void setDescription(String description) { this.description = description; }
    
    /** Categoria pai */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "CategoriaMestra", nullable = true)
    ResearchCategory masterCategory;
    /** GET para a categoria pai */
    public ResearchCategory getMasterCategory() { return masterCategory; }
    /** SET para a categoria pai */
    public void setMasterCategory(ResearchCategory category) { this.masterCategory = category; }
    
    /**
     * Indica se podem ser adicionadas pesquisas diretamente a essa categoria.
     * 
     * Há categorias que são intermediárias, isto é, permitem apenas a adição
     * de outras categorias, formando uma árvore de categorias.
     */
    @Column(name = "PodeAdicionarPesquisas", nullable = false, columnDefinition = "TINYINT", length = 1)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    boolean allowAddResearch;
    /** GET para o flag indicador da possibilidade de adição de pesquisa diretamente à categoria */
    public boolean isAllowAddResearch() { return this.allowAddResearch; }
    /** SET para o flag indicador da possibilidade de adição de pesquisa diretamente à categoria */
    public void setAllowAddResearch(boolean allowAdd) { this.allowAddResearch = allowAdd; }
    
    /**
     * Cliente dono ca categoria.
     * 
     * Há 2 tipos de categoria:
     *      1 - as do sistema, que não podem ser editadas pelo cliente
     *      2 - as do cliente, que podem ser editadas pelo mesmo
     * 
     * As categorias do cliente (quando a propriedade <Cliente> estiver
     * preenchida), podem ser vistas somente pelo cliente que as criou.
     */
    @ManyToOne(fetch = FetchType.LAZY,
               cascade = CascadeType.ALL)
    @JoinColumn(name = "Cliente", nullable = true)
    Client client;
    /** GET para o cliente dono da categoria (para categoria criada pelo cliente) */
    public Client getClient() { return client; }
    /** SET para o cliente dono da categoria (para categoria criada pelo cliente) */
    public void setClient(Client client) { this.client = client; }
    
    /** Data e hora da criação do registro no banco */
    @Column(name = "DataHoraRegistro", nullable = false, columnDefinition = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    Date registerDateTime;
    /** GET para a data e hora da criação do registro no banco */
    public Date getRegisterDateTime() { return this.registerDateTime; }
    /** SET para a data e hora da criação do registro no banco */
    public void setRegisterDateTime(Date dt) { this.registerDateTime = dt; }
    
    /** Data e hora da última atualização do registro no banco */
    @Column(name = "DataHoraUltimaAtualizacao", nullable = false, columnDefinition = "datetime")
    Date lastUpdateDateTime;
    /** GET para a data e hora da última atualização do registro no banco */
    public Date getLastUpdateDateTime() { return this.lastUpdateDateTime; }
    /** SET para a data e hora da última atualização do registro no banco */
    public void setLastUpdateDateTime(Date dt) { this.lastUpdateDateTime = dt; }
    
    @Column(name = "DataHoraExclusao", nullable = true, columnDefinition = "datetime")
    Date deleteDateTime;
    public Date getDeleteDateTime() { return this.deleteDateTime; }
    public void setDeleteDateTime(Date dt) { this.deleteDateTime = dt; }
    
    @Column(name = "ChaveExclusao", length = 64, nullable = true)
    String deleteKey;
    public String getDeleteKey() { return this.deleteKey; }
    public void setDeleteKey(String dKey) { this.deleteKey = dKey; }
    
    /** Categorias de pesquisa filhas */
    @OneToMany(fetch = FetchType.LAZY,
               cascade = CascadeType.ALL,
               mappedBy = "masterCategory")
    List<ResearchCategory> nestedCategoryList;
    /** GET para a lista de categorias filhas */
    public List<ResearchCategory> getNestedCategoryList() { return this.nestedCategoryList; }
    /** SET para a lista de categorias filhas */
    public void setNestedCategoryList(List<ResearchCategory> ncList) { this.nestedCategoryList = ncList; }
    
    /** Lista de pesquisas pertencentes a esta categoria */
    @OneToMany(fetch = FetchType.LAZY,
               cascade = CascadeType.ALL,
               mappedBy = "researchCategory")
    List<Research> researchList;
    /** GET para a lista de pesquisas pertencentes a esta categoria */
    public List<Research> getResearchList() { return researchList; }
    /** SET para a lista de pesquisas pertencentes a esta categoria */
    public void setResearchList(List<Research> rList) { this.researchList = rList; }
    
    @PrePersist
    private void onSave()
    {
        if(this.registerDateTime == null)
        {
            this.registerDateTime = new Date();
        }
        
        this.lastUpdateDateTime = new Date();
    }
}
