package DP23.Structure.Decorator;
/**
 * Created by litianye on 2019-07-10
 */


/**
 * @program: spark
 *
 * @description:
 *
 * @author: litianye
 *
 * @create: 2019-07-10
 **/

public class MilkDecorator extends CoffeeDecorator {
    private Berverage berverage;

    public MilkDecorator(Berverage berverage) {
        this.berverage = berverage;
    }

    @Override
    public String getDescription() {
        return "Milk " + berverage.getDescription();
    }

    @Override
    public double cost() {
        return berverage.cost() + 2;
    }
}
