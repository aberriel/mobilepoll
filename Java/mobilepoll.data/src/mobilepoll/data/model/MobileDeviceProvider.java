package mobilepoll.data.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Classe persistente do hibernate para fornecedores de dispositivos móveis
 * @author alira
 */
@Entity
@Table(name = "FornecedorDispositivoMovel")
@PrimaryKeyJoinColumn(name = "Id")
public class MobileDeviceProvider extends Persona
{
    private void initFields()
    {
        if(this.associatedManufacturerList == null)
        {
            this.associatedManufacturerList = new ArrayList<ManufacturerProvider>();
        }
        
        if(this.invoiceList == null)
        {
            this.invoiceList = new ArrayList<Invoice>();
        }
    }
    
    /** Construtor **/
    public MobileDeviceProvider()
    {
        super();
        this.initFields();
    }
    
    /**
     * Construtor
     * @param client Cliente que registrou o fornecedor de dispositivos móveis
     */
    public MobileDeviceProvider(Client client)
    {
        super();
        this.initFields();
        this.client = client;
    }
    
    /**
     * URL para página web do fornecedor de dispositivos móveis.
     * Pode ser um atacadista ou até mesmo uma loja
     */
    @Column(name = "PaginaWeb", length = 300, nullable = true)
    String webPage;
    /** GET para URL para página web do fornecedor de dispositivos móveis */
    public String getWebPage() { return webPage; }
    /** SET para a URL da página web do fornecedor de dispositivos móveis */
    public void setWebPage(String webPageUrl) { this.webPage = webPageUrl; }
    
    /** Cliente que registrou o fornecedor */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Cliente", nullable = false)
    Client client;
    /** GET para o cliente que registrou o fornecedor de dispositivos móveis */
    public Client getClient() { return client; }
    /** SET para o cliente que registrou o fornecedor de dispositivos móveis */
    public void setClient(Client client) { this.client = client; }
    
    /** Listagem de fornecedores de dispositivo móvel deste fabricante */
    @OneToMany(cascade = CascadeType.ALL,
               fetch = FetchType.LAZY,
               mappedBy = "mobileDeviceProvider",
               targetEntity = ManufacturerProvider.class)
    List<ManufacturerProvider> associatedManufacturerList;
    /** GET para a listagem de fornecedores de dispositivos móveis deste fabricante */
    public List<ManufacturerProvider> getAssociatedManufacturerList() { return associatedManufacturerList; }
    /** SET para a listagem de fornecedores de dispositivo móvel deste fabricante */
    public void setAssociatedManufacturer(List<ManufacturerProvider> amList) { this.associatedManufacturerList = amList; }
    
    /** Notas que o fornecedor emitiu */
    @OneToMany(cascade = CascadeType.ALL,
               fetch = FetchType.LAZY,
               mappedBy = "provider",
               targetEntity = Invoice.class)
    List<Invoice> invoiceList;
    /** GET para as notas que o fornecedor emitiu */
    public List<Invoice> getInvoiceList() { return invoiceList; }
    /** SET para as notas que o fornecedor emitiu */
    public void setInvoiceList(List<Invoice> iList) { this.invoiceList = iList; }
}
