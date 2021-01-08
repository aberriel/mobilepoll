package mobilepoll.data.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Classe persistente do hibernate para registros de entrevistados
 * @author alira
 */
@Entity
@Table(name = "Entrevistado")
@PrimaryKeyJoinColumn(name = "Id")
public class Interviewee extends Persona
{
    private void initFields()
    {
        if(this.pollList == null)
        {
            this.pollList = new ArrayList<Poll>();
        }
    }
    
    /** Construtor */
    public Interviewee()
    {
        super();
        this.initFields();
    }
    
    /**
     * Construtor
     * @param activity Atividade profissional exercida pelo entrevistado
     */
    public Interviewee(Activity activity)
    {
        super();
        this.initFields();
        this.activity = activity;
    }
    
    /** Atividade profissional exercida pelo entrevistado */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Atividade", nullable = true)
    Activity activity;
    /** GET para a atividade profissional exercida pelo entrevistado */
    public Activity getActivity() { return activity; }
    /** SET para a atividade profissional exercida pelo entrevistado */
    public void setActivity(Activity activity) { this.activity = activity; }
    
    /** Usuário do sistema, para entrevistados pela web */
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "Usuario", nullable = true)
    User user;
    /** GET para o usuário do sistema, para entrevistados pela web */
    public User getUser() { return user; }
    /** SET para o usuário do sistema, para entrevistados pela web */
    public void setUser(User user) { this.user = user; }
    
    /** Enquetes respondidas pelo entrevistado */
    @OneToMany(fetch = FetchType.LAZY,
               cascade = CascadeType.ALL,
               mappedBy = "interviewee")
    List<Poll> pollList;
    /** GET para a lista de enquetes respondidas pelo entrevistado */
    public List<Poll> getPollList() { return this.pollList; }
    /** SET para a lista de enquetes respondidas pelo entrevistado */
    public void setPollList(List<Poll> pList) { this.pollList = pList; }
}
