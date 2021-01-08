package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(BallotTitle.class)
public class BallotTitle_
{
    public static volatile SingularAttribute<BallotTitle, Long> id;
    public static volatile SingularAttribute<BallotTitle, String> btNumber;
    public static volatile SingularAttribute<BallotTitle, String> electoralWard;
    public static volatile SingularAttribute<BallotTitle, String> pollingPlace;
    public static volatile SingularAttribute<BallotTitle, Date> dispatchDate;
    public static volatile SingularAttribute<BallotTitle, FederalUnity> dispatchState;
    public static volatile SingularAttribute<BallotTitle, Persona> persona;
    public static volatile SingularAttribute<BallotTitle, Date> registerDateTime;
}