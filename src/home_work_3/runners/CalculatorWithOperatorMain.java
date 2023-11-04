package home_work_3.runners;

import home_work_3.calcs.*;

public class CalculatorWithOperatorMain {
    public static void main(String[] args) {
        CalculatorWithOperator calc = new CalculatorWithOperator();
        double result;

        result = calc.divide(28, 5);
        result = calc.power(result, 2);
        result = calc.plus(calc.multiply(15, 7), result);
        result = calc.plus(4.1, result);

        System.out.println("Result: " + result + " (should be 140.46)");
    }
}
