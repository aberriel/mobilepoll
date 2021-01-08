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

/**
 * Classe persistente do hibernate para assuntos de mensagem que podem ser enviadas pelo usuário
 * @author alira
 */
@Entity
@Table(name = "AssuntoMensagem")
public class MessageSubject
{
    /** Construtor */
    public MessageSubject() { }
    
    /**
     * Construtor
     * @param name Nome do assunto de mensagem de e-mail 
     */
    public MessageSubject(String name)
    {
        this.setName(name);
    }
    
    /** Identificador único do registro na tabela */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    long id;
    /** GET para o id do registro na tabela */
    public long getId() { return id; }
    /** SET para o id do registro na tabela */
    public void setId(long id) { this.id = id; }
    
    /** Nome do assunto de mensagem */
    @Column(name = "Nome", length = 200, unique = true)
    String name;
    /** GET para o nome do assunto de mensagem */
    public String getName() { return name; }
    /** SET para o nome do assunto de mensagem */
    public void setName(String name) { this.name = name; }
    
    /**Explicativo (descritivo) */
    @Column(name = "Descricao", columnDefinition = "TEXT", nullable = true)
    String description;
    /** GET para o explicativo acerca do assunto de mensagem de e-mail */
    public String getDescription() { return description; }
    /** SET para o explicativo acerca do assunto de mensagem de e-mail */
    public void setDescription(String description) { this.description = description; }
    
    /** Data e hora da inserção do registro no banco */
    @Column(name = "DataHoraRegistro", columnDefinition = "datetime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date registerDateTime;
    /** GET para a data e hora da explosão */
    public Date getRegisterDateTime() { return registerDateTime; }
    /** SET para a data e hora da explosão */
    public void setRegisterDateTime(Date date) { this.registerDateTime = date; }
    
    /** Evento de salvamento do objeto para o banco */
    @PrePersist
    private void onSave()
    {
        if(this.registerDateTime == null)
        {
            this.registerDateTime = new Date();
        }
    }
}
