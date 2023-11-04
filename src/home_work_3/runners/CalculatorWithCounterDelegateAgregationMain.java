package home_work_3.runners;

import home_work_3.calcs.CalculatorWithCounterAutoAggregation;
import home_work_3.calcs.CalculatorWithMathCopy;

public class CalculatorWithCounterDelegateAgregationMain {
    public static void main(String[] args) {
        CalculatorWithMathCopy calc = new CalculatorWithMathCopy();
        CalculatorWithCounterAutoAggregation calcAG = new CalculatorWithCounterAutoAggregation(calc);
        double result;

        result = calcAG.divide(28, 5);
        result = calcAG.power(result, 2);
        result = calcAG.plus(calcAG.multiply(15, 7), result);
        result = calcAG.plus(4.1, result);
        System.out.println("Result: " + result + " (should be 140.46)");
        System.out.println("Counter: " + calcAG.getCountOperation());
    }
}
