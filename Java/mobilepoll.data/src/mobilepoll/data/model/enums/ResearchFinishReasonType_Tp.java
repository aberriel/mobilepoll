package mobilepoll.data.model.enums;

/**
 * Tipos de causa de término de pesquisa
 * @author anselmo.lira
 */
public enum ResearchFinishReasonType_Tp
{
    /** Opção quando nenhum ítem for selecionado. */
    None
    {
        @Override
        public int getValue() { return 0; }
        
        @Override
        public String getName() { return "Nenhum"; }
        
        @Override
        public String getDescription() { return "Nenhum ítem selecionado."; }
    },
    
    /** Término da pesquisa por conclusão da mesma (todas as questões respondidas) */
    ResearchCompleted
    {
        @Override
        public int getValue() { return 1; }
        
        @Override
        public String getName() { return "Fim de Sessão"; }
        
        @Override
        public String getDescription() { return "Fim de sessão por término da pesquisa."; }
    },
    
    /** Término da pesquisa por cancelamento da mesma pelo usuário */
    Cancellation
    {
        @Override
        public int getValue() { return 2; }
        
        @Override
        public String getName() { return "Cancelamento"; }
        
        @Override
        public String getDescription() { return "Fim da enquete por cancelamento da mesma."; }
    },
    
    /** Término da enquete pelo fim da sessão */
    ExpiredSession
    {
        @Override
        public int getValue() { return 3; }
        
        @Override
        public String getName() { return "Sessão Expirada"; }
        
        @Override
        public String getDescription() { return "Fim de pesquisa pelo término da sessão."; }
    },
    
    /** Causa de fim de enquete não existente na lista */
    Other
    {
        @Override
        public int getValue() { return 4; }
        
        @Override
        public String getName() { return "Outro"; }
        
        @Override
        public String getDescription() { return "Causa de fim de enquete não presente na lista."; }
    };
    
    /** Retorna valor numérico do tipo de causa de fim de sessão */
    public abstract int getValue();
    
    /** Retorna nome do tipo de causa de fim de sessão */
    public abstract String getName();
    
    /** Retorna descritivo/explicativo do tipo de causa de fim de sessão */
    public abstract String getDescription();
}