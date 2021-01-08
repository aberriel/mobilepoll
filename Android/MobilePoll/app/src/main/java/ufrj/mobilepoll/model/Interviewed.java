package ufrj.mobilepoll.model;

/**
 * Classe do modelo de dados para entrevistados
 * Created by alira on 09/10/15.
 */
public class Interviewed extends Person
{
    /** Construtor */
    public Interviewed()
    {
        super();
    }

    /** Id da atividade profissional do entrevistado */
    private long businessId;
    /** GET para o id da atividade profissional do entrevistado */
    public long getBusinessId() { return businessId; }
    /** SET para o id da atividade profissional do entrevistado */
    public void setBusinessId(long id) { this.businessId = id; }

    /** Atividade profissional do entrevistado */
    private Business business;
    /** GET para a atividade profissional do entrevistado */
    public Business getBusiness() { return business; }
    /** SET para a atividade profissional do entrevistado */
    public void setBusiness(Business business) { this.business = business; }
}