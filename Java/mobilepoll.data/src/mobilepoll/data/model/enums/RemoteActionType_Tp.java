package mobilepoll.data.model.enums;

import java.io.Serializable;

/**
 * Tipos de requisição que o serviço pode receber
 * @author alira
 */
public enum RemoteActionType_Tp
{
    /**
     * Requisição de autenticação.
     * 
     * A autenticação em dispositivo móvel se dará localmente e no servidor.
     * No caso, o servidor remoto proverá uma chave de sessão para o usuário
     * no primeiro acesso deste no dispositivo. Para posteriores acessos e, no
     * caso de perda de sinal, o dispositivo salvará localmente as credenciais
     * do usuário.
     * 
     * Posteriormente, a aplicação web passará a operar também sobre o web service,
     * realizando a autenticação de seus usuário a partir do serviço também.
     */
    Authentication
    {
        @Override
        public int getValue() { return 0; }
        
        @Override
        public String getName() { return "Authentication"; }
        
        @Override
        public String getName_PtBr() { return "Autenticação"; }
        
        @Override
        public String getDescription()
        {
            return "Requisição de autenticação a partir de dispositivo remoto.";
        }
    },
    
    /** Requisição de consulta a dados */
    DataQuery
    {
        @Override
        public int getValue() { return 1; }
        
        @Override
        public String getName() { return "Query data"; }
        
        @Override
        public String getName_PtBr() { return "Consulta a dados"; }
        
        @Override
        public String getDescription()
        {
            return "Consulta a dados";
        }
    },
    
    /**
     * Requisição de envio de sinal de vida.
     * 
     * De tempos em tempos, o dispositivo móvel enviará requisição notificando
     * ainda estar ativo e a sua localização.
     */
    LifeSignal
    {
        @Override
        public int getValue() { return 2; }
        
        @Override
        public String getName() { return "Send life signal."; }
        
        @Override
        public String getName_PtBr() { return "Envio de sinal de vida"; }
        
        @Override
        public String getDescription()
        {
            return "Requisição de envio de sinal de vida.";
        }
    },
    
    /**
     * Requisição de sincronismo de dados de cliente, usuário e enquetes.
     */
    DataSync
    {
        @Override
        public int getValue() { return 3; }
        
        @Override
        public String getName() { return "Data synchronization"; }
        
        @Override
        public String getName_PtBr() { return "Sincronização de dados"; }
        
        @Override
        public String getDescription()
        {
            return "Requisição de sincronismo de dados de cliente, usuário e enquetes.";
        }
    },
    
    /**
     * Requisição de submissão de respostas de enquetes coletadas a partir de
     * dispositivo móvel.
     * 
     * O dispositivo móvel, de tempos em tempos, enviará as respostas coletadas.
     */
    AnswerSubmit
    {
        @Override
        public int getValue() { return 4; }
        
        @Override
        public String getName() { return "Submission of answers"; }
        
        @Override
        public String getName_PtBr() { return "Submissão de respostas"; }
        
        @Override
        public String getDescription()
        {
            return "Requisição de submissão de respostas de enquetes.";
        }
    },
    
    /**
     * Requisição de verificação de autenticação realizada em dispositivo remoto.
     * 
     * Para algumas atividades, é necessário verificar junto ao servidor a 
     * autenticidade de chave de sessão do usuário
     */
    AuthenticationValidation
    {
        @Override
        public int getValue() { return 5; }
        
        @Override
        public String getName() { return "Authentication check"; }
        
        @Override
        public String getName_PtBr() { return "Verificação de autenticação"; }
        
        @Override
        public String getDescription()
        {
            return "Requisição de validação de autenticação em dispositivo remoto.";
        }
    };
    
    /** Recupera valor numérico do tipo */
    public abstract int getValue();
    
    /** Recupera nome do tipo, para exibição na interface */
    public abstract String getName();
    
    /** Recupera nome do tipo em português brasileiro */
    public abstract String getName_PtBr();
    
    /** Recupera descritivo/explicativo do tipo */
    public abstract String getDescription();
}