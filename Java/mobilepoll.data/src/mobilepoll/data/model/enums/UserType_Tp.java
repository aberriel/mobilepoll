package mobilepoll.data.model.enums;

/**
 * Tipos de usuário
 * @author alira
 */
public enum UserType_Tp
{
    /** A ser selecionado quando nenhum tipo estiver definido */
    None
    {
        @Override
        public int getValue() { return 0; }
        
        @Override
        public String getDatabaseValue() { return "Nenhum"; }
        
        @Override
        public String getName() { return "Nenhum"; }
    },
    
    /** Usuário administrador do sistema */
    System
    {
        @Override
        public int getValue() { return 1; }
        
        @Override
        public String getDatabaseValue() { return "TIUS_Sistema"; }
        
        @Override
        public String getName() { return "Sistema"; }
    },
    
    /** Usuário do cliente */
    Client
    {
        @Override
        public int getValue() { return 2; }
        
        @Override
        public String getDatabaseValue() { return "TIUS_Cliente"; }
        
        @Override
        public String getName() { return "Cliente"; }
    };
    
    /** Recupera valor inteiro do tipo */
    public abstract int getValue();
    
    /** Recupera valor armazenado no banco para este tipo */
    public abstract String getDatabaseValue();
    
    public abstract String getName();
}
