package mobilepoll.data.model.enums;

/**
 * Tipos de permissão por tipo de dado que pode ser visto
 * @author alira
 */
public enum RightScope_Tp
{
    Nothing
    {
        @Override
        public int getValue() { return 0; }
        
        @Override
        public String getName() { return "Nenhum"; }
        
        @Override
        public String getSimpleName() { return "ESPE_NENHUM"; }
        
        @Override
        public String getDescription() { return "Nenhum ítem selecionado"; }
    },
    
    Public
    {
        @Override
        public int getValue() { return 1; }
        
        @Override
        public String getName() { return "Publico"; }
        
        @Override
        public String getSimpleName() { return "ESPE_PUBLICO"; }
        
        @Override
        public String getDescription() { return "Permissão de acesso a dados públicos"; }
    },
    
    Own
    {
        @Override
        public int getValue() { return 2; }
        
        @Override
        public String getName() { return "Proprios"; }
        
        @Override
        public String getSimpleName() { return "ESPE_PROPRIO"; }
        
        @Override
        public String getDescription() { return "Permissão de acesso aos dados próprios (criados pelo próprio usuário)"; }
    },
    
    System
    {
        @Override
        public int getValue() { return 3; }
        
        @Override
        public String getName() { return "Sstema"; }
        
        @Override
        public String getSimpleName() { return "ESPE_SISTEMA"; }
        
        @Override
        public String getDescription() { return "Permissão de acesso ao painel administrativo"; }
    },
    
    Client
    {
        @Override
        public int getValue() { return 4; }
        
        @Override
        public String getName() { return "Cliente"; }
        
        @Override
        public String getSimpleName() { return "ESPE_CLIENTE"; }
        
        @Override
        public String getDescription() { return "Permissão de acesso aos dados do cliente"; }
    };
    
    public abstract int getValue();
    
    public abstract String getName();
    
    public abstract String getSimpleName();
    
    public abstract String getDescription();
}