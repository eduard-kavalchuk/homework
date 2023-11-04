package home_work_3.runners;

import home_work_3.calcs.CalculatorWithCounterAutoAggregationInterface;
import home_work_3.calcs.CalculatorWithCounterAutoComposite;

public class CalculatorWithCounterAutoCompositeInterfaceMain {
    public static void main(String[] args) {
        CalculatorWithCounterAutoComposite c = new CalculatorWithCounterAutoComposite();
        CalculatorWithCounterAutoAggregationInterface calc = new CalculatorWithCounterAutoAggregationInterface(c);
        double result;

        result = calc.divide(28, 5);
        result = calc.power(result, 2);
        result = calc.plus(calc.multiply(15, 7), result);
        result = calc.plus(4.1, result);
        System.out.println("Result: " + result + " (should be 140.46)");
    }
}
