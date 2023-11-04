package home_work_3.runners;

import home_work_3.calcs.additional.CalculatorWithCounterClassic;

public class CalculatorWithCounterClassicMain {
    public static void main(String[] args) {
        CalculatorWithCounterClassic calc = new CalculatorWithCounterClassic();
        double result, mul;

        result = calc.divide(28, 5);
        calc.incrementCountOperation();
        result = calc.power(result, 2);
        calc.incrementCountOperation();
        mul = calc.multiply(15, 7);
        calc.incrementCountOperation();
        result = calc.plus(mul, result);
        calc.incrementCountOperation();
        result = calc.plus(4.1, result);
        calc.incrementCountOperation();
        System.out.println("Result: " + result + " (should be 140.46)");
        System.out.println("Number of operations: " + calc.getCountOperation());
    }
}
