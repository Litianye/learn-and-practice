package DP23.Action.Mediator;
/**
 * Created by litianye on 2019-07-12
 */


import java.util.ArrayList;
import java.util.List;

/**
 * @program: spark
 *
 * @description:
 *
 * @author: litianye
 *
 * @create: 2019-07-12
 **/

public abstract class Mediator {
    protected List<Person> landlordList = new ArrayList<>();

    protected List<Person> renterList = new ArrayList<>();

    public void registerLandlord(Person landlord) {
        landlordList.add(landlord);
    }

    public void registerRenter(Person renter) {
        renterList.add(renter);
    }

    public abstract void operation(Person person, String message);
}
