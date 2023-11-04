package home_work_3.calcs;

public class CalculatorWithMathExtends extends CalculatorWithOperator {
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
