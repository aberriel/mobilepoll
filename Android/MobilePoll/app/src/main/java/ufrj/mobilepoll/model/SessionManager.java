package ufrj.mobilepoll.model;

import java.util.Date;

/**
 * Classe do modelo de dados do gerenciador de sessão da aplicação de enquete
 * Created by alira on 11/10/15.
 */
public class SessionManager
{
    /** Construtor */
    public SessionManager() { }

    /** Identificador único do registro no banco */
    private long id;
    /** GET para o identificador único do registro no banco */
    public long getId() { return id; }
    /** SET para o identificador único do registro no banco */
    public void setId(long id) { this.id = id; }

    /** Identificador, no banco, do usuário autenticado */
    private long idUser;
    /** GET para o identificador do usuário autenticado no banco */
    public long getIdUser() { return idUser; }
    /** SET para o identificador do usuário autenticado no banco */
    public void setIdUser(long id) { this.idUser = id; }

    /** Chave do usuário para esta sessão */
    private String userKey;
    /** GET para a chave do usuário para a sessão corrente */
    public String getUserKey() { return userKey; }
    /** SET para a chave do usuário para a sessão corrente */
    public void setUserKey(String key) { this.userKey = key; }

    /** Data e hora do início da sessão */
    private Date initDateTime;
    /** GET para a data e hora de início da sessão */
    public Date getInitDateTime() { return initDateTime; }
    /** SET para a data e hora de início da sessão */
    public void setInitDateTime(Date dateTime) { this.initDateTime = dateTime; }

    /** Data e hora da última atividade na aplicação */
    private Date lastActivityDateTime;
    /** GET para a data e hora da última atividade */
    public Date getLastActivityDateTime() { return lastActivityDateTime; }
    /** SET para a data e hora da última atividade na aplicação */
    public void setLastActivityDateTime(Date dateTime) { this.lastActivityDateTime = dateTime; }

    /** Data e hora do término da sessão */
    private Date finishDateTime;
    /** GET para a data e hora do término da sessão */
    public Date getFinishDateTime() { return finishDateTime; }
    /** SET para a data e hora do término da sessão */
    public void setFinishDateTime(Date dateTime) { this.finishDateTime = dateTime; }

    /** Causa do término da sessão */
    private String sessionFinishReason;
    /** GET para a causa do término da sessão */
    public String getSessionFinishReason() { return sessionFinishReason; }
    /** SET para a causa do término da sessão */
    public void setSessionFinishReason(String reason) { this.sessionFinishReason = reason; }
}