package ufrj.mobilepoll.repoitory;

import android.content.Context;

import ufrj.mobilepoll.database.helper.PersonDbHelper;
import ufrj.mobilepoll.database.helper.UserDbHelper;
import ufrj.mobilepoll.model.Person;
import ufrj.mobilepoll.model.User;

/**
 * Created by alira on 14/10/15.
 */
public class UserRepository
{
    PersonDbHelper personHelper;
    UserDbHelper userHelper;

    public UserRepository(Context context)
    {
        personHelper = new PersonDbHelper(context);
        userHelper = new UserDbHelper(context);
    }

    public User InsertUser(User user)
    {
    }

    public User GetUserById(long userId)
    {

    }

    /**
     * Mapeia os valores da pessoa para o usuário
     * @param source
     * @param destination
     * @return
     */
    public static User TransferPersonDataToUserData(Person source, User destination)
    {
        destination.setId(source.getId());
        destination.setName(source.getName());
        destination.setDescription(source.getDescription());

        destination.setPrimaryEmail(source.getPrimaryEmail());
        destination.setSecondaryEmail(source.getSecondaryEmail());
        destination.setPrimaryTelephone(source.getPrimaryTelephone());
        destination.setSecondaryTelephone(source.getSecondaryTelephone());

        destination.setStreet(source.getStreet());
        destination.setStreetNumber(source.getStreetNumber());
        destination.setNeighborhood(source.getNeighborhood());
        destination.setCityId(source.getCityId());
        destination.setPostalCode(source.getPostalCode());

        return destination;
    }
}