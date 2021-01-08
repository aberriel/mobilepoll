package mobilepoll.data.model;

/**
 * Motivos de encerramento de pesquisa
 * @author anselmoberriel
 */
public enum SurveyFinishReason
{
    /**
     * Tipo de causa de término de pesquisa não existente ou não constante na
     * lista (não mapeado ainda).
     */
    Other
    {
        @Override
        public int getValue() { return 0; }
        
        @Override
        public String getName() { return "Other"; }
        
        @Override
        public String getName_PtBr() { return "Outro"; }
        
        @Override
        public String getDescription()
        {
            return "Tipo não existente ou não constante na lista";
        }
    },
    
    /** Pesquisa encerrada por término da mesma pelo usuário. */
    SurveyCompleted
    {
        @Override
        public int getValue() { return 1; }
        
        @Override
        public String getName() { return "Survey completed"; }
        
        @Override
        public String getName_PtBr() { return "Pesquisa concluída"; }
        
        @Override
        public String getDescription()
        {
            return "Pesquisa concluída pelo usuário";
        }
    },
    
    /**
     * Pesquisa encerrada por iniciativa do próprio usuário, ao clicar no
     * botão de cancelamento de pesquisa.
     */
    Cancellation
    {
        @Override
        public int getValue() { return 2; }
        
        @Override
        public String getName() { return "Survey cancellation"; }
        
        @Override
        public String getName_PtBr() { return "Cancelamento de pesquisa"; }
        
        @Override
        public String getDescription()
        {
            return "Usuário cancelou a pesquisa antes de sua conclusão";
        }
    },
    
    /**
     * Pesquisa encerrada automaticamente pelo sistema por expiração da
     * sessão, por inatividade do usuário.
     */
    SessionExpired
    {
        @Override
        public int getValue() { return 3; }
        
        @Override
        public String getName() { return "Session expired"; }
        
        @Override
        public String getName_PtBr() { return "Sessão expirada"; }
        
        @Override
        public String getDescription()
        {
            return "Sessão expirou por inatividade";
        }
    };
    
    /** Recupera valor numérico do tipo */
    public abstract int getValue();
    
    /** Recupera nome original do tipo (em inglês) */
    public abstract String getName();
    
    public abstract String getName_PtBr();
    
    public abstract String getDescription();
}
