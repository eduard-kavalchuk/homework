package home_work_3.runners;

import home_work_3.calcs.additional.CalculatorWithCounterAutoSuper;

public class CalculatorWithCounterAutoSuperMain {
    public static void main(String[] args) {
        double result;
        CalculatorWithCounterAutoSuper calc = new CalculatorWithCounterAutoSuper();

        result = calc.divide(28, 5);
        result = calc.power(result, 2);
        result = calc.plus(calc.multiply(15, 7), result);
        result = calc.plus(4.1, result);
        System.out.println("Result: " + result + " (should be 140.46)");
        System.out.println("Number of operations: " + calc.getCountOperation());
    }
}
