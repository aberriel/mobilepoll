package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe associativa entre fabricante de disositivos móveis e fornecedor (distribuidor),
 * onde o mesmo foi adquirido pelo cliente
 * @author alira
 */
@Entity
@Table(name = "Fornecedor_Fabricante")
public class ManufacturerProvider
{
    /** Construtor */
    public ManufacturerProvider() { }
    
    /**
     * Construtor
     * @param manufacturer Fabricante que está sendo associado ao fornecedor de dispositivos móveis
     * @param provider Fornecedor que trabalha com o fabricante de dispositivos móveis registrado
     */
    public ManufacturerProvider(MobileDeviceManufacturer manufacturer, MobileDeviceProvider provider)
    {
        this.mobileDeviceManufacturer = manufacturer;
        this.mobileDeviceProvider = provider;
    }
    
    /** Identificador único do registr no banco */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    long id;
    /** GET para o identificador único do registro no banco */
    public long getId() { return id; }
    /** SET para o identificador único do registro no banco */
    public void setId(long id) { this.id = id; }
    
    /** Fabricante que está sendo associado ao revendedor */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FabricanteDeDispositivoMovel", nullable = false)
    MobileDeviceManufacturer mobileDeviceManufacturer;
    /** GET para o fabricante que está sendo associado ao revendedor */
    public MobileDeviceManufacturer getMobileDeviceManufacturer() { return this.mobileDeviceManufacturer; }
    /** SET para o fabricante que está sendo associado ao revendedor */
    public void setMobileDeviceManufacturer(MobileDeviceManufacturer manufacturer) { this.mobileDeviceManufacturer = manufacturer; }
    
    /** Revendedor que está sendo associado ao fabricante */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FornecedorDeDispositivoMovel", nullable = false)
    MobileDeviceProvider mobileDeviceProvider;
    /** GET para o revendedor que está sendo associado ao fabricante */
    public MobileDeviceProvider getMobileDeviceProvider() { return mobileDeviceProvider; }
    /** SET para o revendedor que está sendo associado ao fabricante */
    public void setMobileDeviceProvider(MobileDeviceProvider provider) { this.mobileDeviceProvider = provider; }
    
    /** Data e hora da criação do registro no banco */
    @Column(name = "DataHoraAssociacao", columnDefinition = "datetime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date associationDateTime;
    /** GET para a data e hora da criação do registro no banco */
    public Date getAssociationDateTime() { return associationDateTime; }
    /** SET para a data e hora da criação do registro no banco */
    public void setAssociationDateTime(Date dateTime) { this.associationDateTime = dateTime; }
    
    /** Tarefas a serem executadas antes da persistencia dos dados */
    @PrePersist
    private void onSave() throws Exception
    {
        if(this.associationDateTime == null)
        {
            this.associationDateTime = new Date();
        }
        
        if(this.mobileDeviceProvider == null)
        {
            throw new Exception("Impossível criar associação entre fabricante e fornecedor: fornecedor nulo.");
        }
        
        if(this.mobileDeviceManufacturer == null)
        {
            throw new Exception("Impossível criar associação entre fabricante e fornecedor: fabricante nulo.");
        }
    }
}