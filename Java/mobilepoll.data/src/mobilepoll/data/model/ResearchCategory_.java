package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(ResearchCategory.class)
public class ResearchCategory_
{
    public static volatile SingularAttribute<ResearchCategory, Long> id;
    public static volatile SingularAttribute<ResearchCategory, String> name;
    public static volatile SingularAttribute<ResearchCategory, String> description;
    public static volatile SingularAttribute<ResearchCategory, ResearchCategory> masterCategory;
    public static volatile SingularAttribute<ResearchCategory, Boolean> allowAddResearch;
    public static volatile SingularAttribute<ResearchCategory, Client> client;
    public static volatile SingularAttribute<ResearchCategory, Date> registerDateTime;
    public static volatile SingularAttribute<ResearchCategory, Date> lastUpdateDateTime;
    public static volatile SingularAttribute<ResearchCategory, Date> deleteDateTime;
    public static volatile SingularAttribute<ResearchCategory, String> deleteKey;
    public static volatile ListAttribute<ResearchCategory, ResearchCategory> nestedCategoryList;
    public static volatile ListAttribute<ResearchCategory, Research> researchList;
}
