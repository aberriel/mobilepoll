package mobilepoll.data.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * Classe persistente do Hibernate para fabricantes de dispositivos móveis
 * @author alira
 */
@Entity
@Table(name = "FabricanteDispositivoMovel")
@PrimaryKeyJoinColumn(name = "Id")
public class MobileDeviceManufacturer extends Persona
{
    private void initFields()
    {
        if(this.mobileDeviceBrandList == null)
        {
            this.mobileDeviceBrandList = new ArrayList<MobileDeviceBrand>();
        }
        
        if(this.associatedProviderList == null)
        {
            this.associatedProviderList = new ArrayList<ManufacturerProvider>();
        }
        
        if(this.associatedTechnicalAssistanceList == null)
        {
            this.associatedTechnicalAssistanceList = new ArrayList<ManufacturerTechnicalAssistance>();
        }
    }
    
    /** Construtor */
    public MobileDeviceManufacturer()
    {
        super();
        this.initFields();
    }
    
    /**
     * Construtor
     * @param name Nome do fabricante de dispositivos móveis
     */
    public MobileDeviceManufacturer(String name)
    {
        super();
        this.initFields();
        this.name = name;
    }
    
    /** Página web do fabricante de dispositivos móveis */
    @Column(name = "PaginaWeb", length = 300, nullable = true)
    String webPage;
    /** GET para a página web do fabricante de dispositivos móveis */
    public String getWebPage() { return webPage; }
    /** SET para a página web do fabricante de dispositivos móveis */
    public void setWebPage(String webPage) { this.webPage = webPage; }
    
    /** Marcas de dispositivo móvel deste fabricante */
    @OneToMany(fetch = FetchType.LAZY,
               cascade = CascadeType.ALL,
               mappedBy = "mobileDeviceManufacturer",
               targetEntity = MobileDeviceBrand.class)
    List<MobileDeviceBrand> mobileDeviceBrandList;
    /** GET para a lista de marcas de dispositivo móvel deste fabricante */
    public List<MobileDeviceBrand> getMobileDeviceBrandList() { return mobileDeviceBrandList; }
    /** SET para a lista de marcas de dispositivo móvel deste fabricante */
    public void setMobileDeviceBrandList(List<MobileDeviceBrand> brandList) { this.mobileDeviceBrandList = brandList; }
    
    /** Fornecedores de dispositivos móveis que trabalham com este fabricante */ 
    @OneToMany(cascade = CascadeType.ALL,
               fetch = FetchType.LAZY,
               mappedBy = "mobileDeviceManufacturer",
               targetEntity = ManufacturerProvider.class)
    List<ManufacturerProvider> associatedProviderList;
    /** GET para a listagem de fornecedores de dispositivos móveis que trabalham com este fabricante */
    public List<ManufacturerProvider> getAssociatedProviderList() { return associatedProviderList; }
    /** SET para a listagem de fornecedores de dispositivos móveis que trabalham com este fabricante */
    public void setAssociatedProviderList(List<ManufacturerProvider> amList) { this.associatedProviderList = amList; }
    
    /** Assistências técnicas que provêm serviço de manutenção para modelos deste fabricante */
    @OneToMany(cascade = CascadeType.ALL,
               fetch = FetchType.LAZY,
               mappedBy = "manufacturer",
               targetEntity = ManufacturerTechnicalAssistance.class)
    List<ManufacturerTechnicalAssistance> associatedTechnicalAssistanceList;
    /** GET para a listagem de assistências técnicas que realizam serviço de manutenção para modelos deste fabricante */
    public List<ManufacturerTechnicalAssistance> getAssociatedTechnicalAssistanceList() { return associatedTechnicalAssistanceList; }
    /** SET para a listagem de assistências técnicas que realizam serviço de manutenção para modelos deste fabricante */
    public void setAssociatedTechnicalAssistanceList(List<ManufacturerTechnicalAssistance> ataList) { this.associatedTechnicalAssistanceList = ataList; }
}
