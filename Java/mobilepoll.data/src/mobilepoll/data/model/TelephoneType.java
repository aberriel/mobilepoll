package mobilepoll.data.model;

import java.util.*;
import javax.persistence.*;

/**
 * Classe persistente para tipos de telefone
 * @author alira
 */
@Entity
@Table(name = "TipoTelefone")
public class TelephoneType
{
    private void DoInit()
    {
        if(this.telephones == null)
        {
            this.telephones = new ArrayList<Telephone>();
        }
    }
    
    /** Construtor */
    public TelephoneType()
    {
        this.DoInit();
    }
    
    /**
     * Construtor
     * @param name Nome do tipo de telefone 
     */
    public TelephoneType(String name)
    {
        this.DoInit();
        this.name = name;
    }
    
    /**
     * Construtor
     * @param name Nome do tipo de telefone
     * @param fullIconPath Caminho completo para arquivo de ícone representativo do tipo de telefone
     * @param comments Comentários e/ou observações pertinentes
     */
    public TelephoneType(String name, String fullIconPath, String comments)
    {
        this.DoInit();
        
        this.name = name;
        this.fullIconPath = fullIconPath;
        this.comments = comments;
    }
    
    /** Identificador único do tipo de telefone no sistema */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique  = true, nullable = false)
    long id;
    /** GET para o identificador único do registro no sistema */
    public long getId() { return id; }
    /** SET para o identificador único do registro no sistema */
    public void setId(long id) { this.id = id; }
    
    /** Nome do tipo de telefone */
    @Column(name = "Nome", length = 200, unique = true, nullable = false)
    String name;
    /** GET para o nome do tipo de telefone */
    public String getName() { return name; }
    /** SET para o nome do tipo de telefone */
    public void setName(String name) { this.name = name; }
    
    /** Comentários e/ou observaçòes pertinentes */
    @Column(name = "Comentarios", columnDefinition = "TEXT", nullable = true)
    String comments;
    /** GET para os comentários e/ou observaçòes pertinentes */
    public String getComments() { return comments; }
    /** SET para os comentários e/ou observaçòes pertinentes */
    public void setComments(String comments) { this.comments = comments; }
    
    /** Caminho completo no sistema de arquivos para arquivo de ícone representativo do tipo de telefone */
    @Column(name = "CaminhoCompletoIcone", length = 300, nullable = true)
    String fullIconPath;
    /** GET para o caminho completo no sistema de arquivos para ícone representativo do tipo de telefone */
    public String getFullIconPath() { return fullIconPath; }
    /** SET para o caminho completo no sistema de arquivos para ícone representativo do tipo de telefone */
    public void setFullIconPath(String path) { this.fullIconPath = path; }
    
    /** Data e hora da criação do registro no banco */
    @Column(name = "DataHoraRegistro", columnDefinition = "datetime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date registerDateTime;
    /** GET para a data e hora da criação do registro no banco */
    public Date getRegisterDateTime() { return this.registerDateTime; }
    /** SET para a data e hora da criação do registro no banco */
    public void setRegisterDateTime(Date dt) { this.registerDateTime = dt; }
    
    /** Telefones pertencentes a este tipo */
    @OneToMany(cascade = CascadeType.ALL,
               mappedBy = "type",
               targetEntity = Telephone.class,
               fetch = FetchType.LAZY)
    List<Telephone> telephones;
    /** GET para a listagem de telefones pertencentes a este tipo */
    public List<Telephone> getTelephones() { return telephones; }
    /** SET para a listagem de telefones pertencentes a este tipo */
    public void setTelephones(List<Telephone> telephoneList) { this.telephones = telephoneList; }
    
    @PrePersist
    private void onSave()
    {
        if(this.registerDateTime == null)
        {
            this.registerDateTime = new Date();
        }
    }
}
