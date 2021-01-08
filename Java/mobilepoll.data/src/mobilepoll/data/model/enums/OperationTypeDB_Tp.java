package mobilepoll.data.model.enums;

/**
 * Tipos de operações que podem ser realizadas em banco de dados
 * @author alira
 */
public enum OperationTypeDB_Tp
{
    /** Nenhum ítem selecionado */
    None
    {
        @Override
        public int getValue() { return 0; }
        
        @Override
        public String getName() { return "Nenhum"; }
        
        @Override
        public String getDescription() { return "Nenhum ítem selecionado."; }
    },
    
    /** Operação de consulta (SELECT) ao banco */
    Query
    {
        @Override
        public int getValue() { return 1; }
        
        @Override
        public String getName() { return "Consulta"; }
        
        @Override
        public String getDescription() { return "Operaçaõ de consulta (SELECT) ao banco."; }
    },
    
    /** Operação de criação de novo registro no banco */
    Create
    {
        @Override
        public int getValue() { return 2; }
        
        @Override
        public String getName() { return "Criar"; }
        
        @Override
        public String getDescription() { return "Operação de criação de novo registro no banco."; }
    },
    
    /** Operação de exclusão de registro do banco */
    Delete
    {
        @Override
        public int getValue() { return 3; }
        
        @Override
        public String getName() { return "Excluir"; }
        
        @Override
        public String getDescription() { return "Operação de exclusão de registro do banco."; }
    },
    
    /** Operação de exclusão de registro do banco */
    Update
    {
        @Override
        public int getValue() { return 4; }
        
        @Override
        public String getName() { return "Atualizar"; }
        
        @Override
        public String getDescription() { return "Operação de atualização de registro no banco."; }
    };
    
    /** Retorna valor numérico do tipo de operação que pode ser realizada no banco de dados */
    public abstract int getValue();
    
    /** Retorna o nome do tipo de operação do banco */
    public abstract String getName();
    
    /** Retorna descritivo/explicativo do tipo de operação do banco */
    public abstract String getDescription();
}
