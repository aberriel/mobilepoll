package mobilepoll.data.model;

import mobilepoll.data.model.enums.PersonType_Tp;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Classe persistente do hibernate para assistências técnicas autorizadas de dispositivos móveis
 * @author alira
 */
@Entity
@Table(name = "AutorizadaDispositivoMovel")
@PrimaryKeyJoinColumn(name = "Id")
public class MobileDeviceTechnicalAssistance extends Persona
{
    private void initFields()
    {
        if(this.associatedManufacturerList == null)
        {
            this.associatedManufacturerList = new ArrayList<ManufacturerTechnicalAssistance>();
        }
        
        if(this.maintenanceDataList == null)
        {
            this.maintenanceDataList = new ArrayList<MaintenanceData>();
        }
    }
    
    /** Construtor */
    public MobileDeviceTechnicalAssistance()
    {
        super();
        this.initFields();
    }
    
    /**
     * Construtor
     * @param client Cliente que registrou a assistência técnica
     */
    public MobileDeviceTechnicalAssistance(Client client)
    {
        super();
        this.initFields();
        this.client = client;
    }
    
    /**
     * Construtor
     * @param cnpj Número do CNPJ da assistência técnica
     */
    public MobileDeviceTechnicalAssistance(String cnpj) throws Exception
    {
        super(cnpj, PersonType_Tp.JuridicalPerson);
        this.initFields();
    }
    
    /**
     * Construtor
     * @param cnpj Número do CNPJ da assistência técnica
     * @param client Cliente que registrou a assistência técnica
     */
    public MobileDeviceTechnicalAssistance(String cnpj, Client client) throws Exception
    {
        super(cnpj, PersonType_Tp.JuridicalPerson);
        this.initFields();
        this.client = client;
    }
    
    /** Cliente que registrou a autorizada */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Cliente", nullable = false)
    Client client;
    /** GET para o cliente que registrou a autorizada */
    public Client getClient() { return client; }
    /** SET para o cliente que registrou a autorizada */
    public void setClient(Client client) { this.client = client; }
    
    /** Fabricantes para os quais esta assistência técnica presta serviço. */
    @OneToMany(cascade = CascadeType.ALL,
               fetch = FetchType.LAZY,
               mappedBy = "technicalAssistance",
               targetEntity = ManufacturerTechnicalAssistance.class)
    List<ManufacturerTechnicalAssistance> associatedManufacturerList;
    /** GET para a listagem de fabricantes para os quais esta assistência técnica presta serviços */
    public List<ManufacturerTechnicalAssistance> getAssociatedManufacturerList() { return associatedManufacturerList; }
    /** SET para a listagem de fabricantes para os quais esta assistência técnica prespa servico. */
    public void setAssociatedManufacturerList(List<ManufacturerTechnicalAssistance> ataList) { this.associatedManufacturerList = ataList; }
    
    /** Listagem de serviços de manutenção e reparo feitos por esta assistência técnica. */
    @OneToMany(cascade = CascadeType.ALL,
               fetch = FetchType.LAZY,
               mappedBy = "tecnicalAssistance",
               targetEntity = MaintenanceData.class)
    List<MaintenanceData> maintenanceDataList;
    /** GET para a lista de serviços de manutenção e reparo feitos por esta assistência técnica */
    public List<MaintenanceData> getMaintenanceDataList() { return maintenanceDataList; }
    /** SET para a lista de serviços de manutenção e reparo feitos por esta assistência técnica */
    public void setMaintenanceDataList(List<MaintenanceData> mdList) { this.maintenanceDataList = mdList; }
}
