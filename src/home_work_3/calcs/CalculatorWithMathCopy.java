package home_work_3.calcs;

import home_work_3.calcs.api.ICalculator;

public class CalculatorWithMathCopy implements ICalculator {
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
        return Math.pow(a, b);
    }

    public double abs(double a) {
        return Math.abs(a);
    }

    public double sqrt(double a) {
        return Math.sqrt(a);
    }
}
