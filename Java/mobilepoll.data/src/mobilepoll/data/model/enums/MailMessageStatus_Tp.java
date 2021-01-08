package mobilepoll.data.model.enums;

/**
 * Status de mensagem trocada entre cliente (empresa) e entrevistador (funcionário)
 * @author anselmo.lira
 */
public enum MailMessageStatus_Tp
{
    /** Estado de mensagem não fornecido */
    None
    {
        @Override
        public int getValue() { return 0; }
        
        @Override
        public String getName() { return "Nenhum definido"; }
    },
    
    /** Mensagem aguardando ser enviada */
    WaitSend
    {
        @Override
        public int getValue() { return 1; }
        
        @Override
        public String getName() { return "Aguardando envio" ; }
    },
    
    /** Mensagem aguardando processamento e geração da resposta */
    WaitReply
    {
        @Override
        public int getValue() { return 2; }
        
        @Override
        public String getName() { return "Aguardando processamento e envio da resposta"; }
    },
    
    /** Mensagem enviada e aguardando retorno do host remoto */
    WaitFeedback
    {
        @Override
        public int getValue() { return 3; }
        
        @Override
        public String getName() { return "Aguardando retorno"; }
    },
    
    /** Mensagem enviada com sucesso */
    Sent
    {
        @Override
        public int getValue() { return 4; }
        
        @Override
        public String getName() { return "Enviada"; }
    },
    
    /** Mensagem recebida (para mensagens no sentido <Dispositivo Móvel> => <Servidor>  */
    Received
    {
        @Override
        public int getValue() { return 5; }
        
        @Override
        public String getName() { return "Recebida"; }
    },
    
    /** Mensagem recebida e respondida */
    Replied
    {
        @Override
        public int getValue() { return 6; }
        
        @Override
        public String getName() { return "Respondida"; }
    };
    
    /** GET para o valor numérico correspondente ao tipo enumerado */
    public abstract int getValue();
    
    /** GET para o nome do tipo enumerado, a ser exibido na interface */
    public abstract String getName();
}