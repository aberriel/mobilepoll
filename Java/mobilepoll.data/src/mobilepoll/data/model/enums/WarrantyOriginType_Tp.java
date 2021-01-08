package mobilepoll.data.model.enums;

/**
 * Tipos de garantia segundo a origem
 * @author alira
 */
public enum WarrantyOriginType_Tp
{
    /** Nenhuma garantia */
    None
    {
        @Override
        public int getValue() { return 0; }
        
        @Override
        public String getName() { return "None"; }
        
        @Override
        public String getName_PtBr() { return "Nenhum"; }
        
        @Override
        public String getDescription() { return "Nenhum tipo selecionado"; }
    },
    /** Garantia de origem diversa às aqui */
    Other
    {
        @Override
        public int getValue() { return 1; }
        
        @Override
        public String getName() { return "Other"; }
        
        @Override
        public String getName_PtBr() { return "Outro"; }
        
        @Override
        public String getDescription() { return "Garantia original em local não documentado"; }
    },
    /** Garantia de loja */
    Store
    {
        @Override
        public int getValue() { return 2; }
        
        @Override
        public String getName() { return "Store"; }
        
        @Override
        public String getName_PtBr() { return "Loja"; }
        
        @Override
        public String getDescription() { return "Garantia original de loja"; }
    },
    /**
     * Garantia extendida adquirida na loja
     * Válida a partir do término da garantia de fábrica
     */
    Store_Extended
    {
        @Override
        public int getValue() { return 3; }
        
        @Override
        public String getName() { return "Store Extended"; }
        
        @Override
        public String getName_PtBr() { return "Loja Estendido"; }
        
        @Override
        public String getDescription() { return "Garantia extendida da loja"; }
    },
    /** Garantia extendida do fabricante */
    Manufacturer_Extended
    {
        @Override
        public int getValue() { return 4; }
        
        @Override
        public String getName() { return "Manufactured Extended"; }
        
        @Override
        public String getName_PtBr() { return "Garantia de Fábrica Extendida"; }
        
        @Override
        public String getDescription() { return "Garantia extendida do fabricante"; }
    },
    /** Garantia adquirida via seguro */
    Insurance
    {
        @Override
        public int getValue() { return 5; }
        
        @Override
        public String getName() { return "Insurance"; }
        
        @Override
        public String getName_PtBr() { return "Seguro"; }
        
        @Override
        public String getDescription() { return "Garantia adquirida junto com seguro"; }
    };
    
    /** Recupera valor numérico do literal */
    public abstract int getValue();
    
    /** Recupera nome original do literal em inglês */
    public abstract String getName();
    
    /** Recupera nome do literal em português */
    public abstract String getName_PtBr();
    
    /** Recupera descritivo do literal */
    public abstract String getDescription();
}
