package mobilepoll.data.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(Gender.class)
public class Gender_
{
    /** Identificador único do registro no banco */
    public static volatile SingularAttribute<Gender, Integer> id;
    /** Nome do gênero ou sexo */
    public static volatile SingularAttribute<Gender, String> name;
    /** Um descritivo do gênero ou sexo, caso necessário */
    public static volatile SingularAttribute<Gender, String> description;
}