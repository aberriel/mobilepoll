package mobilepoll.data.model.enums;

/**
 * Tipo de pessoa
 * @author alira
 */
public enum PersonType_Tp
{
    /** A ser setado quando o tipo de pessoa não é definido */
    None
    {
        @Override
        public int getValue() { return 0; }
        
        @Override
        public String getName() { return "Nenhum"; }
        
        @Override
        public String getSimpleName() { return "Nenhum"; }
        
        @Override
        public String getDescription()
        {
            return "Nenhum tipo definido ou selecionado para a pessoa.";
        }
    },
    
    /** Pessoa jurídica (empresas, ongs, etc) */
    JuridicalPerson
    {
        @Override
        public int getValue() { return 1; }
        
        @Override
        public String getName() { return "Pessoa Jurídica"; }
        
        @Override
        public String getSimpleName() { return "PessoaJuridica"; }
        
        @Override
        public String getDescription()
        {
            return "Pessoa jurídica, isto é, empresas e/ou organizações.";
        }
    },
    
    /** Pessoa física */
    PhysicalPerson
    {
        @Override
        public int getValue() { return 2; }
        
        @Override
        public String getName() { return "Pessoa Física"; }
        
        @Override
        public String getSimpleName() { return "PessoaFisica"; }
        
        @Override
        public String getDescription()
        {
            return "Pessoa física, isto é, indivíduos.";
        }
    };
    
    /** Obtem valor numérico do tipo enumerado. */
    public abstract int getValue();
    
    /** Obtem nome do tipo enumerado */
    public abstract String getName();
    
    /** Obtem nome simplificado do tipo enumerado */
    public abstract String getSimpleName();
    
    /** Retorna descritivo ou explicativo do ítem. */
    public abstract String getDescription();
}
