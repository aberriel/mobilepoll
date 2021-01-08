package mobilepoll.data.model.enums;

/**
 * Tipos de cobertura possíveis por seguro para o dispositivo móvel
 * @author anselmo.lira
 */
public enum ClaimCoveredType_Tp
{
    /** Nenhum tipo definido */
    None
    {
        @Override
        public int getValue() { return 0; }
        
        @Override
        public String getName() { return "Nenhum"; }
        
        @Override
        public String getDescription() { return "Nenhum ítem selecionado."; }
    },
    
    /** O seguro cobre a perda do aparelho */
    Loss
    {
        @Override
        public int getValue() { return 1; }
        
        @Override
        public String getName() { return "Perda"; }
        
        @Override
        public String getDescription() { return "Cobre perda do dispositivo."; }
    },
    
    /** O seguro cobre o furto do aparelho */
    Theft
    {
        @Override
        public int getValue() { return 2; }
        
        @Override
        public String getName() { return "Furto"; }
        
        @Override
        public String getDescription() { return "Cobre furtos."; }
    },
    
    /** O seguro cobre roubo qualificado. */
    Robbery
    {
        @Override
        public int getValue() { return 3; }
        
        @Override
        public String getName() { return "Roubo"; }
        
        @Override
        public String getDescription() { return "Cobre roubo qualificado, isto é, com ameaça e agressão."; }
    },
    
    /** O seguro cobre avarias no aparelho por acidente */
    Incident
    {
        @Override
        public int getValue() { return 4; }
        
        @Override
        public String getName() { return "Acidente"; }
        
        @Override
        public String getDescription() { return "O seguro cobre avarias oriundas de acidentes, como quedas ou incidência de líquido sobre o aparelho."; }
    },
    
    /** O seguro cobre defeitos (como se fosse uma garantia) */
    Defect
    {
        @Override
        public int getValue() { return 5; }
        
        @Override
        public String getName() { return "Defeito"; }
        
        @Override
        public String getDescription() { return "O seguro cobre defeitos e falhas do dispositivo."; }
    },
    
    /** O seguro cobre perdas de dados */
    Data
    {
        @Override
        public int getValue() { return 6; }
        
        @Override
        public String getName() { return "Dados"; }
        
        @Override
        public String getDescription() { return "Perda ou adulteração dos dados, bem como perda do sistema."; }
    },
    
    Other
    {
        @Override
        public int getValue() { return 7; }
        
        @Override
        public String getName() { return "Outro"; }
        
        @Override
        public String getDescription() { return "Tipo de cobertura não definida."; }
    };
    
    /** GET para o valor numérico do tipo enumerado */
    public abstract int getValue();
    
    /** GET para o nome do tipo de cobertura do seguro */
    public abstract String getName();
    
    /** GET para o descritivo/explicativo do tipod e cobertura do seguro */
    public abstract String getDescription();
}