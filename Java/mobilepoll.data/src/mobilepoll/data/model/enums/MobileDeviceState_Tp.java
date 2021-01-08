package mobilepoll.data.model.enums;

/**
 * Status do dispositivo móvel segundo o uso
 * @author alira
 */
public enum MobileDeviceState_Tp
{
    /** Estado não constante aqui */
    Other
    {
        @Override
        public int getValue() { return 0; }
        
        @Override
        public String getName() { return "Outro"; }
        
        @Override
        public String getDescription() { return "Nenhum ítem selecionado."; }
    },
    
    /** Dispositivo em processo de aquisição */
    Acquisition
    {
        @Override
        public int getValue() { return 1; }
        
        @Override
        public String getName() { return "Aquisição"; }
        
        @Override
        public String getDescription() { return "Dispositivo em processo de aquisição e inventariado."; }
    },
    
    /** Dispositivo retirado para a realização de enquete externa */
    ExternalPoll
    {
        @Override
        public int getValue() { return 2; }
        
        @Override
        public String getName() { return "Pesquisa Externa"; }
        
        @Override
        public String getDescription() { return "Dispositivo retirado para a realização de pesquisa na rua."; }
    },
    
    /** Dispositivo em auditoria */
    Audit
    {
        @Override
        public int getValue() { return 3; }
        
        @Override
        public String getName() { return "Auditoria"; }
        
        @Override
        public String getDescription() { return "Dispositivo retirado para análise e auditoria."; }
    },
    
    /** Dispositivo em manutenção */
    Maintenance
    {
        @Override
        public int getValue() { return 4; }
        
        @Override
        public String getName() { return "Manutenção"; }
        
        @Override
        public String getDescription() { return "Dispositivo retirado para manutenção e reparo."; }
    },
    
    /** Dispositivo desativado no sistema por descarte */
    Discart
    {
        @Override
        public int getValue() { return 5; }
        
        @Override
        public String getName() { return "Descarte"; }
        
        @Override
        public String getDescription() { return "Dispositivo removido para descarte."; }
    };
    
    /** Retorna valor numérico do ítem */
    public abstract int getValue();
    
    /** Retorna nome do ítem (para combos, etc) */
    public abstract String getName();
    
    /** Retorna descritivo/explicativo do ítem */
    public abstract String getDescription();
}