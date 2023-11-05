package home_work_3.calcs;

import home_work_3.calcs.api.ICalculator;

public class CalculatorWithOperator implements ICalculator {
    public double plus(double a, double b)
    {
        return a + b;
    }

    public double minus(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        return a / b;
    }

    public double power(double a, int b) {
        double result = a;
        for (int i = 1; i < b; i++ )
            result *= a;
        return result;
    }

    public double abs(double a) {
        return a > 0 ? a : -a;
    }

    public double sqrt(double a) {
        return Math.sqrt(a);
    }
}