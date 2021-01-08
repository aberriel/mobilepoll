package mobilepoll.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Classe persistente do hibernate pasa associações entre dispositivos móveis e notas de compra.
 * É aqui que o dispositivo móvel é atrelado à sua nota de compra correspondente
 * 
 * @author anselmoberriel
 */
@Entity
@Table(name = "DispositivoMovel_NotaFiscal")
public class MobileDeviceInvoice
{
    /** Construtor */
    public MobileDeviceInvoice() { }
    
    /**
     * Construtor
     * @param mobileDevice Dispositivo móvel pertencente à nota.
     */
    public MobileDeviceInvoice(MobileDevice mobileDevice)
    {
        this.mobileDevice = mobileDevice;
    }
    
    /**
     * Construtor
     * @param mobileDevice Dispositivo Móvel que pertence à nota.
     * @param invoice Fornecedor que emitiu a nota
     */
    public MobileDeviceInvoice(MobileDevice mobileDevice, Invoice invoice)
    {
        this.mobileDevice = mobileDevice;
        this.invoice = invoice;
    }
    
    /**
     * Construtor
     * @param quantity Quantidade de ítens adquiridos
     * @param unitValue Valor por ítem
     */
    public MobileDeviceInvoice(double quantity, double unitValue)
    {
        this.quantity = quantity;
        this.unitValue = unitValue;
    }
    
    /**
     * Construtor
     * @param mobileDevice Dispositivo móvel adquirido
     * @param invoice Fornecedor (o que emitiu a nota)
     * @param quantity Total de ítens adquiridos
     * @param unitValue Valor por ítem
     */
    public MobileDeviceInvoice(MobileDevice mobileDevice, Invoice invoice, double quantity, double unitValue)
    {
        this.mobileDevice = mobileDevice;
        this.invoice = invoice;
        this.quantity = quantity;
        this.unitValue = unitValue;
    }
    
    /** Identificador único do registro no banco */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    long id;
    /** GET para o identificador único do registro no banco */
    public long getId() { return id; }
    /** SET para o identificador único do registro no banco */
    public void setId(long id) { this.id = id; }
    
    /** Nota fiscal à qual estes dados de compra pertencem */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "NotaFiscal", nullable = false)
    Invoice invoice;
    /** GET para a nota fiscal à qual estes dados de compra pertencem */
    public Invoice getInvoice() { return invoice; }
    /** SET para a nota fiscal à qual estes dados de compra pertencem */
    public void setInvoice(Invoice invoice) { this.invoice = invoice; }
    
    /** Dispositivo móvel ao qual os dados de compra pertencem */
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DispositivoMovel", nullable = false)
    MobileDevice mobileDevice;
    /** GET para o dispositivo móvel ao qual os dados de compra pertencem */
    public MobileDevice getMobileDevice() { return mobileDevice; }
    /** SET para o dispositivo móvel ao qual os dados de compra pertencem */
    public void setMobileDevice(MobileDevice mobileDevice) { this.mobileDevice = mobileDevice; }
    
    /** Garantia assegurada por lei na nota */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Garantia", nullable = true)
    MobileDeviceWarranty warranty;
    /** GET para a garantia assegurada por lei na nota */
    public MobileDeviceWarranty getWarranty() { return warranty; }
    /** SET para a garantia assegurada por lei na nota */
    public void setMobileDeviceWarranty(MobileDeviceWarranty warranty) { this.warranty = warranty; }
    
    /** Unidade de medida da quantidade do produto usada */
    @Column(name = "MedidaUnidade", length = 30, nullable = true)
    String measurementUnit;
    /** GET para a unidade de medida da quantidade do produto usada */
    public String getMeasurementUnit() { return measurementUnit; }
    /** SET para a unidade de medida da quantidade do produto usada */
    public void setMeasurementUnit(String unit) { this.measurementUnit = unit; }
    
    /** Valor unitário do dispositivo móvel */
    @Column(name = "ValorUnitario", columnDefinition = "decimal(15,2)", nullable = true)
    Double unitValue;
    /** GET para o valor unitário do dispositivo móvel */
    public Double getUnitValue() { return unitValue; }
    /** SET para o valor unitário do dispositivo móvel */
    public void setUnitValue(Double value) { this.unitValue = value; }
    
    /** Código identificador do dispositivo móvel no fornecedor */
    @Column(name = "CodigoProduto", length = 40, nullable = true)
    String productCode;
    /** GET para o código identificador do dispositivo móvel no fornecedor */
    public String getProductCode() { return productCode; }
    /** SET para o código identificador do dispositivo móvel no fornecedor */
    public void setProductCode(String code) { this.productCode = code; }
    
    /** Total de dispositivos móveis adquiridos */
    @Column(name = "Quantidade", columnDefinition = "decimal(12,6) default 0.0", nullable = false)
    double quantity;
    /** GET para o total de dispositivos móveis adquiridos */
    public double getQuantity() { return quantity; }
    /** SET para o total de dispositivos móveis adquiridos */
    public void setQuantity(double quantity) { this.quantity = quantity; }
    
    /** Percentual aplicado sobre a base de cálculo para determinação do IPI a ser pago */
    @Column(name = "AliquotaIpi", columnDefinition = "decimal(4,3)", nullable = true)
    Double ipiAliquot;
    /** GET para o percentual aplicado sobre a base de cálculo para determinação do IPI a ser pago */
    public Double getIpiAliquot() { return ipiAliquot; }
    /** SET para o percentual aplicado sobre a base de cálculo para determinação do IPI a ser pago */
    public void setIpiAliquot(Double aliquot) { this.ipiAliquot = aliquot; }
    
    /** Valor do IPI (Imposto sobre Produto Industrializado) a ser pago */
    @Column(name = "ValorIpi", columnDefinition = "decimal(15,2)", nullable = true)
    Double ipiValue;
    /** GET para o valor do IPI (Imposto sobre Produto Industrializado) a ser pago */
    public Double getIpiValue() { return ipiValue; }
    /** SET para o valor do IPI (Imposto sobre Produto Industrializado) a ser pago */
    public void setIpiValue(Double value) { this.ipiValue = value; }
    
    /** Percentual aplicado sobre a base de cálculo para determinação do ICMS a ser pago. */
    @Column(name = "AliquotaIcms", columnDefinition = "decimal(4,3)", nullable = true)
    Double icmsAliquot;
    /** GET para o percentual aplicado sobre a base de cálculo para determinação do ICMS a ser pago */
    public Double getIcmsAliquot() { return icmsAliquot; }
    /** SET para o percentual aplicado sobre a base de cálculo para determinalão do ICMS a ser pago */
    public void setIcmsAliquot(Double aliquot) { this.icmsAliquot = aliquot; }
    
    /** Base de cálculo do ICMS */
    @Column(name = "BaseCalculoIcms", columnDefinition = "decimal(15,2)", nullable = true)
    Double icmsCalculationBasis;
    /** GET para a base de cálculo do ICMS */
    public Double getIcmsCalculationBasis() { return icmsCalculationBasis; }
    /** SET para a base de cálculo do ICMS */
    public void setIcmsCalculationBasis(Double basisValue) { this.icmsCalculationBasis = basisValue; }
    
    /** Valor do ICMS pago pelo dispositivo */
    @Column(name = "ValorIcms", columnDefinition = "decimal(15,2)", nullable = true)
    Double icmsValue;
    /** GET para o valor do ICMS pago pelo dispositivo */
    public Double getIcmsValue() { return icmsValue; }
    /** SET para o valor do ICMS pago pelo dispositivo */
    public void setIcmsValue(Double value) { this.icmsValue = value; }
    
    /**
     * Código Fiscal de Operações e Prestações.
     * 
     * Identifica a natureza da circulação da mercadoria ou a prestação de serviços
     * de transporte. É composto de 4 dígitos.
     * 
     * O CFOP identifica, por exemplo, se é entrada ou saída
     */
    @Column(name = "CFOP", length = 4, nullable = true)
    String cfop;
    /** GET para o Código Fiscal de Operações e Prestações (CFOP) */
    public String getCfop() { return cfop; }
    /** SET para o Código Fiscal de Operações e Prestações (CFOP) */
    public void setCfop(String cfop) { this.cfop = cfop; }
    
    /**
     * Nomenclatura Comum do Mercosul.
     * 
     * Código de 8 dígitos cujo fim é identificar a natureza da mercadoria.
     * Por exemplo, o NCM 0102.10.10 nos permite determinar que se trata de:
     * 
     *      01       - Animais vivos
     *      0102     - Animais vivos da espécie bovina
     *      010210   - Reprodutores de raça pura
     *      01021010 - Prenhes ou com cria ao pé
     */
    @Column(name = "NCM", length = 8, nullable = true)
    String ncm;
    /** GET para o código de Nomenclatura Comum do Mercosul(NCM) do dispositivo móvel */
    public String getNcm() { return ncm; }
    /** SET para o código de Nomenclatura Comum do Mercosul (NCM) do dispositivo móvel */
    public void setNcm(String ncm) { this.ncm = ncm; }
    
    /**
     * Código da Situação Tributária.
     * 
     * Código de 3 dígitos, cujo fim é identificar a origem da mercadoria e o regime
     * de tributação a que está sujeita na operação praticada.
     * 
     * Tabela A: Tipos de origem e código
     * 
     *      0 - Nacional
     *      1 - Estrangeira por importação direta
     *      2 - Estrangeira adquirida no mercado interno
     * 
     * 
     * Tabela B: Tributação pelo ICMS
     * 
     *      00 - Tributada integralmente
     *      10 - Tributada e com cobrança do ICMS por substituição tributária
     *      20 - Com redução de base de cálculo
     *      30 - Isenta ou não tributada e com cobrança do ICMS por substituição tributária
     *      40 - Isenta
     *      41 - Não Tributada
     *      50 - Suspensão
     *      51 - Deferimento
     *      60 - ICMS cobrado anteriormente por substituição tributária
     *      70 - Com redução de base de cálculo e cobrança do ICMS por substituição tributária
     *      90 - Outras
     * 
     * O CST é composto pela combinação dos códigos das 2 tabelas.
     * 
     * Por exemplo, se o CST é 141, corresponde a um produto importado diretamente
     * e isento de impostos.
     */
    @Column(name = "CST", length = 3, nullable = true)
    String cst;
    /** GET para o Código de Situação Tributária (CST) do dispositivo móvel */
    public String getCst() { return cst; }
    /** SET para o Código de Situação Tributária (CST) do dispositivo móvel. */
    public void setCst(String cst) { this.cst = cst; }
}