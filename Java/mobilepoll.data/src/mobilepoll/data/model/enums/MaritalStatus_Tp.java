package mobilepoll.data.model.enums;

/**
 * Estado civil
 * @author alira
 */
public enum MaritalStatus_Tp
{
    /** A ser definido quando o estado civil não é fornecido */
    None
    {
        @Override
        public int getValue() { return 0; }
        
        @Override
        public String getName() { return "None"; }
        
        @Override
        public String getName_PtBr() { return "Nenhum."; }
        
        @Override
        public String getDescription() { return "Nenhum estado civil definido."; }
    },
    
    /** Estado civil solteiro */
    Unmarried
    {
        @Override
        public int getValue() { return 1; }
        
        @Override
        public String getName() { return "Unmarried"; }
        
        @Override
        public String getName_PtBr() { return "Solteiro"; }
        
        @Override
        public String getDescription() { return "Estado civil solteiro"; }
    },
    
    /** Estado civil casado */
    Married
    {
        @Override
        public int getValue() { return 2; }
        
        @Override
        public String getName() { return "Married"; }
        
        @Override
        public String getName_PtBr() { return "Casado"; }
        
        @Override
        public String getDescription() { return "Estado civil casado."; }
    },
    
    /** Estado civil divorciado */
    Divorced
    {
        @Override
        public int getValue() { return 3; }
        
        @Override
        public String getName() { return "Divorced"; }
        
        @Override
        public String getName_PtBr() { return "Divorciado"; }
        
        @Override
        public String getDescription()
        {
            return "Estado civil divorciado ou separado.";
        }
    },
    /** Viúvo */
    Widower
    {
        @Override
        public int getValue() { return 4; }
        
        @Override
        public String getName() { return "Widower"; }
        
        @Override
        public String getName_PtBr() { return "Viúvo"; }
        
        @Override
        public String getDescription() { return "Estado civil viúvo."; }
    },
    
    /** União estável */
    LawMarriage
    {
        @Override
        public int getValue() { return 5; }
        
        @Override
        public String getName() { return "Law Marriage"; }
        
        @Override
        public String getName_PtBr() { return "União Estável"; }
        
        @Override
        public String getDescription() { return "Em união estável"; }
    },
    
    /** Estado civil não descrito */
    Other
    {
        @Override
        public int getValue() { return 6; }
        
        @Override
        public String getName() { return "Other"; }
        
        @Override
        public String getName_PtBr() { return "Outro"; }
        
        @Override
        public String getDescription() { return "Estado civil não constante aqui."; }
    };
    
    /** Retorna inteiro correspondente ao estado civil */
    public abstract int getValue();
    
    /** Retorna nome do estado civil completo, por extenso. */
    public abstract String getName();
    
    /** Retorna nome do estado civil completo em português */
    public abstract String getName_PtBr();
    
    /** Retorna descritivo ou explicativo do ítem */
    public abstract String getDescription();
}