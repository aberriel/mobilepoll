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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Chips de telefonia disponíveis para uso em enquetes
 * @author alira
 */
@Entity
@Table(name = "SimCard")
public class SimCard
{
    private void DoInit()
    {
        if(this.usageHistory == null)
        {
            this.usageHistory = new ArrayList<OutForPollData>();
        }
        
        if(this.registerDateTime == null)
        {
            this.registerDateTime = new Date();
        }
    }
    
    /** Construtor */
    public SimCard()
    {
        this.DoInit();
    }
    
    /**
     * Construtor
     * @param imsi Número de série do chip
     */
    public SimCard(String imsi)
    {
        this.DoInit();
        this.imsi = imsi;
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
    
    /** Cliente dono do chip de telefonia */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente", nullable = false)
    Client client;
    /** GET para o cliente dono do chip de telefonia */
    public Client getClient() { return client; }
    /** SET para o cliente dono do chip de telefonia */
    public void setClient(Client client) { this.client = client; }
    
    /** Operadora de telefonia do chip */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Operadora", nullable = false)
    PhoneCompany phoneCompany;
    /** GET para a operadora de telefonia do chip */
    public PhoneCompany getPhoneCompany() { return phoneCompany; }
    /** SET para a operadora de telefonia do chio */
    public void setPhoneCompany(PhoneCompany pCompany) { this.phoneCompany = pCompany; }
    
    /**
     * Número de série do chip.
     * 
     * IMSI = International Mobile Subscriber Identity
     */
    @Column(name = "IMSI", nullable = false, length = 30)
    String imsi;
    /** GET para o número de série do chip */
    public String getImsi() { return imsi; }
    /** SET para o número de série do chip */
    public void setImsi(String imsi) { this.imsi = imsi; }
    
    /** Dados do telefone associado ao chip (DDI, DDD, número, etc) */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Telefone", nullable = false)
    Telephone telephone;
    /** GET para os dados do telefone associado ao chip */
    public Telephone getTelephone() { return telephone; }
    /** SET para os dados do telefone associados do chip */
    public void setTelephone(Telephone phone) { this.telephone = phone; }
    
    /** Comentários e/ou observações pertinentes */
    @Column(name = "Comentarios", length = 3000, nullable = true)
    String comments;
    /** GET para os comentários e/ou observações pertinentes */
    public String getComments() { return comments; }
    /** SET para os comentários e/ou observações pertinentes */
    public void setComments(String comments) { this.comments = comments; }
    
    /** Data e hora da criação do registro no banco */
    @Column(name = "DataHoraRegistro")
    @Temporal(TemporalType.TIMESTAMP)
    Date registerDateTime;
    /** GET para a data e hora da criação do registro no banco */
    public Date getRegisterDateTime() { return registerDateTime; }
    /** SET para a data e hora da criação do registro no banco */
    public void setRegisterDateTime(Date dateTime) { this.registerDateTime = dateTime; }
    
    /** Histórico de uso deste chip em enquetes */
    @OneToMany(cascade = CascadeType.ALL,
               fetch = FetchType.LAZY,
               mappedBy = "simCard")
    List<OutForPollData> usageHistory;
    /** GET para o histórico de uso deste chip em enquetes */
    public List<OutForPollData> getUsageHistory() { return this.usageHistory; }
    /** SET para o histórico de uso deste chip em enquetes */
    public void setUsageHistory(List<OutForPollData> history) { this.usageHistory = history; }
}
