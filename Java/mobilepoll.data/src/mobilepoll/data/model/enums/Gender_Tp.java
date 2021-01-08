package mobilepoll.data.model.enums;

/**
 * Sexo
 * @author alira
 */
public enum Gender_Tp
{
    /** A ser setado quando o sexo não é definido */
    NONE
    {
        @Override
        public int getValue() { return 0; }
        
        @Override
        public String getDescription() { return "Sexo não fornecido."; }
        
        @Override
        public String getName() { return "Nenhum"; }
    },
    
    /** Sexo masculino */
    MALE
    {
        @Override
        public int getValue() { return 1; }
        
        @Override
        public String getDescription() { return "Sexo Masculino."; }
        
        @Override
        public String getName() { return "Masculino"; }
    },
    
    /** Sexo feminino */
    FEMALE
    {
        @Override
        public int getValue() { return 2; }
        
        @Override
        public String getDescription() { return "Sexo Feminino."; }
        
        @Override
        public String getName() { return "Feminino"; }
    },
    
    /** Sexo não constante na lista (transsexual, etc) */
    OTHER
    {
        @Override
        public int getValue() { return 3; }
        
        @Override
        public String getDescription() { return "Sexo desconhecido ou não constante na listagem."; }
        
        @Override
        public String getName() { return "Outro"; }
    };
    
    /** Recupera valor inteiro correspondente ao sexo */
    public abstract int getValue();
    
    /** Recupera descritivo */
    public abstract String getDescription();
    
    /** Recupera nome do ítem */
    public abstract String getName();
}