package mobilepoll.data.model;

import javax.persistence.*;

/**
 *
 * @author anselmolira
 */
@Entity
@Table(name = "StatusMensagemCorreio")
public class MailMessageStatus
{
    /** Construtor */
    public MailMessageStatus() { };
    
    /** Identificador único do registro no banco */
    @Id
    @Column(name = "Id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    /** GET para o identificador único do registro no banco */
    public int getId() { return this.id; }
    /** SET para o identificador único do registro no banco */
    public void setId(int id) { this.id = id; }
    
    /** Nome do tipo de status de mensagem de e-mail */
    @Column(name = "Nome", length = 200, nullable = false)
    String name;
    /** GET para o nome do tipo de status de mensagem de e-mail */
    public String getName() { return this.name; }
    /** SET para o nome do tipo de status de mensagem de e-mail */
    public void setName(String name) { this.name = name; }
    
    /** Descritivo do tipo de status de mensagem de e-mail */
    @Column(name = "Descricao", columnDefinition = "TEXT", nullable = true)
    String description;
    /** GET para o descritivo do tipo de status de mensagem de e-mail */
    public String getDescription() { return this.description; }
    /** SET para o descritivo do tipo de status de mensagem de e-mail */
    public void setDescription(String desc) { this.description = desc; }
}
