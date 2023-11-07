package home_work_3.runners;

import home_work_3.calcs.CalculatorStringExpression;

public class CalculatorStringExpressionMain {
    public static void main(String[] args) {
        String expr = args[0];
        CalculatorStringExpression calc = new CalculatorStringExpression(expr);
        double value = calc.calculate();
        System.out.println(expr + " = " + value);
    }
}
