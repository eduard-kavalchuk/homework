package home_work_3.calcs.additional;

import home_work_3.calcs.CalculatorWithMathExtends;

public class CalculatorWithCounterAutoSuper extends CalculatorWithMathExtends {
    private long operationsCounter;

    public long getCountOperation() {
        return operationsCounter;
    }

    public double plus(double a, double b)
    {
        ++operationsCounter;
        return super.plus(a, b);
    }

    public double minus(double a, double b) {
        ++operationsCounter;
        return super.minus(a, b);
    }

    public double multiply(double a, double b) {
        ++operationsCounter;
        return super.multiply(a, b);
    }

    public double divide(double a, double b) {
        ++operationsCounter;
        return super.divide(a, b);
    }

    public double power(double a, int b) {
        ++operationsCounter;
        return super.power(a, b);
    }

    public double abs(double a) {
        ++operationsCounter;
        return super.abs(a);
    }

    public double sqrt(double a) {
        ++operationsCounter;
        return super.sqrt(a);
    }
}
