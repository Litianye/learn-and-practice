package DP23.Action.Mediator;
/**
 * Created by litianye on 2019-07-12
 */


/**
 * @program: spark
 *
 * @description:
 *
 * @author: litianye
 *
 * @create: 2019-07-12
 **/

public class HouseMediator extends Mediator {
    @Override
    public void operation(Person person, String message) {
        if (person instanceof Renter) {

        }else if (person instanceof Landlord) {

        }
    }
}
