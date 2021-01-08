package mobilepoll.data.model;

import mobilepoll.data.model.enums.MobileDeviceState_Tp;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Tipos ou formas de uso que podem ser aplicadas a um dispositivo móvel
 * @author alira
 */
@Entity
@Table(name = "TipoUsoDispositivoMovel")
public class MobileDeviceUsageType
{
    private void doInit()
    {
        if(this.mobileDeviceUsageControlList == null)
        {
            this.mobileDeviceUsageControlList = new ArrayList<MobileDeviceUsageControl>();
        }
        
        this.tolerance = null;
    }
    
    /** Construtor */
    public MobileDeviceUsageType()
    {
        this.doInit();
    }
    
    /**
     * Construtor
     * @param name Nome do tipo de uso
     */
    public MobileDeviceUsageType(String name)
    {
        this.doInit();
        this.name = name;
    }
    
    /**
     * Construtor
     * 
     * @param name Nome do tipo de uso que pode ser dado ao dispositivo
     * @param tolerance Tolerância em dias
     */
    public MobileDeviceUsageType(String name, Date tolerance)
    {
        this.doInit();
        this.name = name;
        this.tolerance = tolerance;
    }
    
    /** Identificador único do registro no banco */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    /** GET para o identificador único do registro no banco */
    public long getId() { return id; }
    /** SET para o identificador único do registro no banco */
    public void setId(long id) { this.id = id; }
    
    /** Nome do tipo de uso do dispositivo móvel */
    @Column(name = "Nome", length = 200, nullable = false, unique = true)
    String name;
    /** GET para o nome do tipo de uso do dispositivo móvel */
    public String getName() { return name; }
    /** SET para o nome do tipo de uso do dispositivo móvel */
    public void setName(String name) { this.name = name; }
    
    /** Descritivo do tipo de uso em questão */
    @Column(name = "descricao", length = 3000)
    String description;
    /** GET para o descritivo do tipo de uso em questão */
    public String getDescription() { return description; }
    /** SET para o descritivo do tipo de uso em questão */
    public void setDescription(String description) { this.description = description; }
    
    /**
     * Tempo máximo que o dispositivo pode permanecer com a pessoa para este tipo de uso
     * NULL = sem limite de tempo
     */
    @Column(name = "toleranciamaxima")
    @Temporal(TemporalType.TIME)
    Date tolerance;
    /** GET para o tempo máximo que o dispositivo pode permanecer com a pessoa para este tipo de uso */
    public Date getTolerance() { return tolerance; }
    /** SET para o tempo máximo que o dispositivo pode permanecer com a pessoa para este tipo de uso */
    public void setTolerance(Date tolerance) { this.tolerance = tolerance; }
    
    /**
     * Estado do dispositivo associado ao tipo de uso.
     * Por exemplo: descarte, aquisição, enquete externa, etc
     */
    @Column(name = "EstadoDoDispositivoMovelAssociado")
    @Enumerated(EnumType.ORDINAL)
    MobileDeviceState_Tp associatedMobileDeviceState;
    /** GET para o estado do dispositivo associado ao tipo de uso */
    public MobileDeviceState_Tp getAssociatedMobileDeviceState() { return this.associatedMobileDeviceState; }
    /** SET para o estado do dispositivo associado ao tipo de uso */
    public void setAssociatedMobileDeviceState(MobileDeviceState_Tp state) { this.associatedMobileDeviceState = state; }
    
    /** Listagem de registros de controle de uso deste tipo */
    @OneToMany(fetch = FetchType.LAZY,
               cascade = CascadeType.ALL,
               mappedBy = "usageType")
    List<MobileDeviceUsageControl> mobileDeviceUsageControlList;
    /** GET para a listagem de registros de controle de uso deste tipo */
    public List<MobileDeviceUsageControl> getMobileDeviceUsageControlList() { return this.mobileDeviceUsageControlList; }
    /** SET para a listagem de registros de controle de uso deste tipo */
    public void setMobileDeviceUsageControlList(List<MobileDeviceUsageControl> mducList) { this.mobileDeviceUsageControlList = mducList; }
}