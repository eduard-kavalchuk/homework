package home_work_3.calcs;

import home_work_3.calcs.api.ICalculator;

public class CalculatorWithCounterAutoAggregationInterface implements ICalculator {
    private ICalculator calc;
    private long operationsCounter;

    public long getCountOperation() {
        return operationsCounter;
    }

    public CalculatorWithCounterAutoAggregationInterface(ICalculator calc) {
        this.calc = calc;
    }

    public double plus(double a, double b)
    {
        ++operationsCounter;
        return calc.plus(a, b);
    }

    public double minus(double a, double b) {
        ++operationsCounter;
        return calc.minus(a, b);
    }

    public double multiply(double a, double b) {
        ++operationsCounter;
        return calc.multiply(a, b);
    }

    public double divide(double a, double b) {
        ++operationsCounter;
        return calc.divide(a, b);
    }

    public double power(double a, int b) {
        ++operationsCounter;
        return calc.power(a, b);
    }

    public double abs(double a) {
        ++operationsCounter;
        return calc.abs(a);
    }

    public double sqrt(double a) {
        ++operationsCounter;
        return calc.sqrt(a);
    }
}
