package home_work_3.calcs;

import home_work_3.calcs.api.ICalculator;

public class CalculatorWithMemory implements ICalculator {
    private ICalculator calc;
    private double result;
    private double savedValue;

    public CalculatorWithMemory(ICalculator calc) {
        this.calc = calc;
    }

    public void save() {
        savedValue = result;
    }

    public double load() {
        double d = savedValue;
        savedValue = 0;
        return d;
    }

    public double plus(double a, double b)
    {
        return result = this.calc.plus(a, b);
    }

    public double minus(double a, double b) {
        return result = this.calc.minus(a, b);
    }

    public double multiply(double a, double b) {
        return result = this.calc.multiply(a, b);
    }

    public double divide(double a, double b) {
        return result = this.calc.divide(a, b);
    }

    public double power(double a, int b) {
        return result = this.calc.power(a, b);
    }

    public double abs(double a) {
        return result = this.calc.abs(a);
    }

    public double sqrt(double a) {
        return result = this.calc.sqrt(a);
    }
}
