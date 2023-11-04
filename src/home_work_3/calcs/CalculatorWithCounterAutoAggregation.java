package home_work_3.calcs;

import home_work_3.calcs.api.ICalculator;

public class CalculatorWithCounterAutoAggregation implements ICalculator {
    private CalculatorWithMathCopy calc;
    private long operationsCounter;

    public long getCountOperation() {
        return operationsCounter;
    }

    public CalculatorWithCounterAutoAggregation(CalculatorWithMathCopy calc) {
        this.calc = calc;
    }

    public double plus(double a, double b)
    {
        ++operationsCounter;
        return this.calc.plus(a, b);
    }

    public double minus(double a, double b) {
        ++operationsCounter;
        return this.calc.minus(a, b);
    }

    public double multiply(double a, double b) {
        ++operationsCounter;
        return this.calc.multiply(a, b);
    }

    public double divide(double a, double b) {
        ++operationsCounter;
        return this.calc.divide(a, b);
    }

    public double power(double a, int b) {
        ++operationsCounter;
        return this.calc.power(a, b);
    }

    public double abs(double a) {
        ++operationsCounter;
        return this.calc.abs(a);
    }

    public double sqrt(double a) {
        ++operationsCounter;
        return this.calc.sqrt(a);
    }
}
