package ufrj.mobilepoll.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Classe do modelo de dados para unidades federativas.
 * Created by alira on 09/10/15.
 */
public class FederalUnity
{
    private void InitializeFields()
    {
        this.cityList = new ArrayList<City>();
    }

    /** Construtor */
    public FederalUnity()
    {
        InitializeFields();
    }

    /**
     * Nome
     * @param name Nome da unidade federativa
     */
    public FederalUnity(String name)
    {
        InitializeFields();
        this.name = name;
    }

    /**
     * Construtor
     * @param name Nome da unidade federativa
     * @param abbreviation Sigla da unidade federativa
     */
    public FederalUnity(String name, String abbreviation)
    {
        InitializeFields();
        this.name = name;
        this.abbreviation = abbreviation;
    }

    /** Identificador único do registro no banco */
    private long id;
    /** GET para o id do registro no banco */
    public long getId() { return id; }
    /** SET para o id do registro no banco */
    public void setId(long id) { this.id = id; }

    /** Nome da unidade federativa */
    private String name;
    /** GET para o nome da unidade federativa */
    public String getName() { return name; }
    /** SET para o nome da unidade federativa */
    public void setName(String name) { this.name = name; }

    /** Sigla da unidade federativa */
    private String abbreviation;
    /** GET para a sigla da unidade federativa */
    public String getAbbreviation() { return abbreviation; }
    /** SET para a sigla da unidade federativa */
    public void setAbbreviation(String abbreviation) { this.abbreviation = abbreviation; }

    /** Cidades pertencentes à unidade federativa */
    List<City> cityList;
    /** GET para a lista de cidades pertencentes à unidade federativa */
    public List<City> getCityList() { return cityList; }
    /** SET para a lista de cidades pertencentes à unidade federativa */
    public void setCityList(List<City> cityList) { this.cityList = cityList; }

    /**
     * Adiciona cidade à lista de cidades da unidade federativa
     * @param city Cidade a ser adicionada à unidade federativa
     */
    public void addCityToList(City city)
    {
        cityList.add(city);
    }
}