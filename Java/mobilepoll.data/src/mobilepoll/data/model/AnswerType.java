package mobilepoll.data.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Type;

/**
 * Classe persistente do hibernate para tipos de resposta que podem ser dadas
 * às questões das pesquisas.
 * 
 * Os tipos de resposta tem por fim permitir a criação das enquetes na interface em tempo
 * de execução. Cada tipo terá um objeto HTML para o qual será traduzido na montagem
 * da tela.
 * 
 * @author anselmo.lira
 */
@Entity
@Table(name = "TipoResposta")
public class AnswerType
{
    private void DoInit()
    {
        this.allowMultipleAnswers = false;
        
        if(this.registerDateTime == null)
        {
            this.registerDateTime = new Date();
        }
    }
    
    /** Construtor */
    public AnswerType()
    {
        this.DoInit();
    }
    
    /**
     * Construtor
     * @param name Nome do tipo de resposta
     */
    public AnswerType(String name)
    {
        this.DoInit();
        this.name = name;
    }
    
    /**
     * Construtor
     * @param name Nome do tipo de resposta
     * @param allowMultipleAnswers Flag indicador da possibilidade de se dar mais de
     *                             uma resposta para este tipo de resposta
     */
    public AnswerType(String name, boolean allowMultipleAnswers)
    {
        this.DoInit();
        this.name = name;
        this.allowMultipleAnswers = allowMultipleAnswers;
    }
    
    /**
     * Construtor
     * @param name Nome do tipo de resposta
     * @param htmlObject Objeto html a ser utilizado para renderizar
     *                   a questão com este tipo de resposta na tela
     */
    public AnswerType(String name, String htmlObject)
    {
        this.DoInit();
        this.name = name;
        this.htmlObject = htmlObject;
    }
    
    public AnswerType(String name, String htmlObject, boolean allowMultipleAnswers)
    {
        this.DoInit();
        this.name = name;
        this.htmlObject = htmlObject;
        this.allowMultipleAnswers = allowMultipleAnswers;
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
    
    /** Nome do tipo de resposta */
    @Column(name = "Nome", length = 200, nullable = false)
    String name;
    /** GET para o nome do tipo de resposta */
    public String getName() { return name; }
    /** SET para o nome do tipo de resposta */
    public void setName(String name) { this.name = name; }
    
    /** Comentários e/ou observações pertinentes */
    @Column(name = "Comentarios", columnDefinition = "TEXT", nullable = true)
    String comments;
    /** GET para os comentários e/ou observações pertinentes */
    public String getComments() { return comments; }
    /** SET para os comentários e/ou observações pertinentes */
    public void setComments(String comments) { this.comments = comments; }
    
    /**
     * Flag indicador da possibilidade de se dar múltiplas respostas
     * (como por exemplo, uma questão de múltipla escolha)
     */
    @Column(name = "PermiteMultiplasRespostas", columnDefinition = "TINYINT", length = 1, nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    boolean allowMultipleAnswers;
    /** GET para o flag indicador da possibilidade de se dar múltiplas respostas */
    public boolean IsAllowMultipleAnswers() { return allowMultipleAnswers; }
    /** SET para o flag indicador da possibilidade de se dar múltiplas respostas */
    public void setAllowMultipleAnswers(boolean allow) { this.allowMultipleAnswers = allow; }
    
    /** Objeto HTML a ser utilizado para renderizar a questão com este tipo de resposta na tela */
    @Column(name = "ObjetoHtml", length = 25, nullable = true)
    String htmlObject;
    /** GET para o objeto HTML a ser usado para renderizar a questão com este tipo de resposta na tela */
    public String getHtmlObject() { return htmlObject; }
    /** SET para o objeto HTML a ser usado para renderizar a questão com este tipo de resposta na tela */
    public void setHtmlObject(String objectType) { this.htmlObject = objectType; }
    
    /** Data e hora da criação do registro no banco */
    @Column(name = "DataHoraRegistro", nullable = false, columnDefinition = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    Date registerDateTime;
    /** GET para a data e hora da criação do registro no banco */
    public Date getRegisterDateTime() { return registerDateTime; }
    /** SET para a data e hora da criação do registro no banco */
    public void setRegisterDateTime(Date dateTime) { this.registerDateTime = dateTime; }
    
    /** Evento de persistência do objeto para o banco */
    @PrePersist
    private void onSave()
    {
        if(this.registerDateTime == null)
        {
            this.registerDateTime = new Date();
        }
    }
}
