package ufrj.mobilepoll.model;

import java.util.Date;

/**
 * Classe do modelo de dados para os dados de registro e identificação do dispositivo móvel
 * Created by alira on 12/10/15.
 */
public class DeviceRegistration
{
    /** Construtor */
    public DeviceRegistration() { }

    /**
     * Construtor
     * @param imei Número de série do dispositivo
     */
    public DeviceRegistration(String imei)
    {
        this.imei = imei;
    }

    /** Identificador único do registro no banco */
    private long id;
    /** GET para o identificador único do registro no banco */
    public long getId() { return id; }
    /** SET para o identificador único do registro no banco */
    public void setId(long id) { this.id = id; }

    /** Identificador do dispositivo móvel no servidor */
    private long mobileDeviceId;
    /** GET para o identificador do dispositivo móvel no servidor */
    public long getMobileDeviceId() { return mobileDeviceId; }
    /** SET para o identificador do dispositivo móvel no servidor */
    public void setMobileDeviceId(long id) { this.mobileDeviceId = id; }

    /** Número de série do dispositivo móvel */
    private String imei;
    /** GET para o número de série do dispositivo móvel */
    public String getImei() { return imei; }
    /** SET para o número de série do dispositivo móvel */
    public void setImei(String imei) { this.imei = imei; }

    /** Identificador do cliente dono do dispositivo móvel no servidor */
    private long clientId;
    /** GET para o identificador do cliente dono do dispositivo móvel no servidor */
    public long getClientId() { return clientId; }
    /** SET para o identificador do cliente dono do dispositivo móvel no servidor */
    public void setClientId(long id) { this.id = id; }

    /** Nome fantasia do cliente dono do dispositivo móvel */
    private String tradeName;
    /** GET para o nome fantasia do cliente dono do dispositivo móvel */
    public String getTradeName() { return tradeName; }
    /** SET para o nome fantasia do cliente dono do dispositivo móvel */
    public void setTradeName(String name) { this.tradeName = name; }

    /** Razão social do cliente dono do dispositivo móvel */
    private String companyName;
    /** GET para a razão social do cliente dono do dispositivo móvel */
    public String getCompanyName() { return companyName; }
    /** SET para a razão social do cliente dono do dispositivo móvel */
    public void setCompanyName(String name) { this.companyName = name; }

    /** Número do documento identificador do cliente dono do dispositivo móvel */
    private String clientDocumentNumber;
    /** GET para o número do documento identificador do cliente dono do dispositivo móvel */
    public String getClientDocumentNumber() { return clientDocumentNumber; }
    /** SET para o número do documento identificador do cliente dono do dispositivo móvel */
    public void setClientDocumentNumber(String number) { this.clientDocumentNumber = number; }

    private String validationCode;
    public String getValidationCode() { return validationCode; }
    public void setValidationCode(String code) { this.validationCode = code; }

    /** Identificador do último usuário que autenticou com sucesso na aplicação. */
    private long lastAuthenticatedUserId;
    /** GET para o identificador do último usuário que autenticou com sucesso na aplicação. */
    public long getLastAuthenticatedUserId() { return lastAuthenticatedUserId; }
    /** SET para o identificador do último usuário que autenticou com sucesso na aplicação */
    public void setLastAuthenticatedUserId(long id) { this.lastAuthenticatedUserId = id; }

    /** Data e hora da última sincronização de dados com o servidor */
    private Date lastSyncDateTime;
    /** GET para a data e hora da última sincronização de dados com o servidor */
    public Date getLastSyncDateTime() { return lastSyncDateTime; }
    /** SET para a data e hora da última sincronização de dados com o servidor */
    public void setLastSyncDateTime(Date dateTime) { this.lastSyncDateTime = dateTime; }

    /** Tempo máximo que o usuário possui para concluir uma enquete */
    private Date toleranceToAnswerPoll;
    /** GET para o tempo máximo disponível para conclusão de enquete. */
    public Date getToleranceToAnswerPoll() { return toleranceToAnswerPoll; }
    /** SET para o tempo máximo disponível para conclusão de enquete */
    public void setToleranceToAnswerPoll(Date tolerance) { this.toleranceToAnswerPoll = tolerance; }

    /** Tempo máximo que o usuário poderá permanecer em uma enquete sem gerar ações */
    private Date toleranceWithoutActivity;
    /** GET para o tempo máximo de permanência em uma enquete sem gerar ações */
    public Date getToleranceWithoutActivity() { return toleranceWithoutActivity; }
    /** SET para o tempo máximo de permanência em uma enquete sem gerar ações. */
    public void setToleranceWithoutActivity(Date tolerance) { this.toleranceWithoutActivity = tolerance; }

    /** Tempo máximo de duração da sessão do usuário sem movimentação */
    private Date sessionTimeLimit;
    /** GET para o tempo máximo de duração da sessão do usuário sem movimentação */
    public Date getSessionTimeLimit() { return sessionTimeLimit; }
    /** SET para o tempo máximo de duração da sessão do usuário sem movimentação */
    public void setSessionTimeLimit(Date limit) { this.sessionTimeLimit = limit; }

    /** Chave pública identificadora do dispositivo móvel em específico e gerada nos ervidor. */
    private String mobileDeviceKey;
    /** GET para a chave pública identificadora do dispositivo móvel */
    public String getMobileDeviceKey() { return mobileDeviceKey; }
    /** SET para a chave pública identificadora do dispositivo móvel. */
    public void setMobileDeviceKey(String key) { this.mobileDeviceKey = key; }

    /**
     * Chave pública identificadora da aplicação (para comunicação com o servidor).
     * Esta chave é única para a aplicação e a mesma para todas as suas aplicações.
     * */
    private String applicationKey;
    /** GET para a chave pública identificadora da aplicação */
    public String getApplicationKey() { return applicationKey;}
    /** SET para a chave pública identificadora da aplicação */
    public void setApplicationKey(String key) { this.applicationKey = key; }
}