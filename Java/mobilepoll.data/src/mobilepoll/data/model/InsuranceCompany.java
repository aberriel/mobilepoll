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
 * Registro de companhias de seguro
 * @author anselmoberriel
 */
@Entity
@Table(name = "SeguradoraDispositivoMovel")
@PrimaryKeyJoinColumn(name = "Id")
public class InsuranceCompany extends Persona
{
    private void initFields()
    {
        if(this.insuranceContractList == null)
        {
            this.insuranceContractList = new ArrayList<InsuranceContract>();
        }
    }
    
    /** Construtor */
    public InsuranceCompany()
    {
        super();
        this.initFields();
    }
    
    /** Número de registro da seguradora em órgão competente */
    @Column(name = "NumeroDeRegistro", length = 50)
    String registerNumber;
    /** GET para o número de registro da seguradora em órgão competente */
    public String getRegisterNumber() { return this.registerNumber; }
    /** SET para o número de registro da seguradora em órgão competente */
    public void setRegisterNumber(String rNumber) { this.registerNumber = rNumber; }
    
    /** Cliente que registrou a seguradora */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Cliente")
    Client client;
    /** GET para o cliente que registrou a seguradora */
    public Client getClient() { return client; }
    /** SET para o cliente que registrou a seguradora */
    public void setClient(Client client) { this.client = client; }
    
    /** Página web da seguradora */
    @Column(name = "PaginaWeb", length = 300)
    String webPage;
    /** GET para a página web da seguradora */
    public String getWebPage() { return this.webPage; }
    /** SET para a página web da seguradora */
    public void setWebPage(String page) { this.webPage = page; }
    
    /** Coleção de contratos de seguro adquiridos para esta operadora. */
    @OneToMany(cascade = CascadeType.ALL,
               fetch = FetchType.LAZY,
               mappedBy = "insuranceCompany")
    List<InsuranceContract> insuranceContractList;
    /** GET para a coleção de contratos de seguro adquiridos para esta operadora */
    public List<InsuranceContract> getInsuranceContractList() { return this.insuranceContractList; }
    /** SET para a coleção de contratos de seguro adquiridos para esta operadora */
    public void setInsuranceContractList(List<InsuranceContract> icList) { this.insuranceContractList = icList; }
}
