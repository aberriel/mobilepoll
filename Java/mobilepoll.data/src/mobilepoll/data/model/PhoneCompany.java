package mobilepoll.data.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Classe persistente para operadoras de telefonia móvel
 * @author alira
 */
@Entity
@Table(name = "OperadoraTelefonia")
@PrimaryKeyJoinColumn(name = "Id")
public class PhoneCompany extends Persona
{
    private void initFields()
    {
        if(this.simCardList == null)
        {
            this.simCardList = new ArrayList<SimCard>();
        }
    }
    
    /** Construtor */
    public PhoneCompany()
    {
        super();
        this.initFields();
    }
    
    /**
     * Construtor
     * @param juridicalName Razão social da operadora de telefonia
     */
    public PhoneCompany(String juridicalName)
    {
        super();
        this.initFields();
        this.corporateName = juridicalName;
    }
    
    /**
     * Construtor
     * @param juridicalName Razão social da operadora de telefonia
     * @param dialCode Código de discagem específico da operadora de telefonia
     */
    public PhoneCompany(String juridicalName, String dialCode)
    {
        super();
        this.initFields();
        this.corporateName = juridicalName;
        this.dialCode = dialCode;
    }
    
    /** Código de discagem da operadora */
    @Column(name = "CodigoDiscagem", length = 3)
    String dialCode;
    /** GET para o código de discagem da operadora */
    public String getDialCode() { return dialCode; }
    /** SET para o código de discagem da operadora */
    public void setDialCode(String code) { this.dialCode = code; }
    
    /** Chips desta operadora */
    @OneToMany(fetch = FetchType.LAZY,
               cascade = CascadeType.ALL,
               mappedBy = "phoneCompany")
    List<SimCard> simCardList;
    /** GET para a listagem de chips desta operadora */
    public List<SimCard> getSimCardList() { return simCardList; }
    /** SET para a listagem de chips desta operadora */
    public void setSimCardList(List<SimCard> scList) { this.simCardList = scList; }
}