package home_work_3.calcs;

import home_work_3.calcs.api.ICalculator;

public class CalculatorWithCounterAutoChoiceAgregation implements ICalculator {
    private CalculatorWithOperator calculatorWithOperator;
    private CalculatorWithMathCopy calculatorWithMathCopy;
    private CalculatorWithMathExtends calculatorWithMathExtends;
    private long operationsCounter;

    public long getCountOperation() {
        return operationsCounter;
    }

    public CalculatorWithCounterAutoChoiceAgregation(CalculatorWithOperator calc) {
        this.calculatorWithOperator = calc;
    }

    public CalculatorWithCounterAutoChoiceAgregation(CalculatorWithMathCopy calc) {
        this.calculatorWithMathCopy = calc;
    }

    public CalculatorWithCounterAutoChoiceAgregation(CalculatorWithMathExtends calc) {
        this.calculatorWithMathExtends = calc;
    }

    public double plus(double a, double b)
    {
        ++operationsCounter;
        if (calculatorWithOperator != null)
            return this.calculatorWithOperator.plus(a, b);
        else if (calculatorWithMathCopy != null)
            return this.calculatorWithMathCopy.plus(a, b);
        else return this.calculatorWithMathExtends.plus(a, b);
    }

    public double minus(double a, double b) {
        ++operationsCounter;
        if (calculatorWithOperator != null)
            return this.calculatorWithOperator.minus(a, b);
        else if (calculatorWithMathCopy != null)
            return this.calculatorWithMathCopy.minus(a, b);
        else return this.calculatorWithMathExtends.minus(a, b);
    }

    public double multiply(double a, double b) {
        ++operationsCounter;
        if (calculatorWithOperator != null)
            return this.calculatorWithOperator.multiply(a, b);
        else if (calculatorWithMathCopy != null)
            return this.calculatorWithMathCopy.multiply(a, b);
        else return this.calculatorWithMathExtends.multiply(a, b);
    }

    public double divide(double a, double b) {
        ++operationsCounter;
        if (calculatorWithOperator != null)
            return this.calculatorWithOperator.divide(a, b);
        else if (calculatorWithMathCopy != null)
            return this.calculatorWithMathCopy.divide(a, b);
        else return this.calculatorWithMathExtends.divide(a, b);
    }

    public double power(double a, int b) {
        ++operationsCounter;
        if (calculatorWithOperator != null)
            return this.calculatorWithOperator.power(a, b);
        else if (calculatorWithMathCopy != null)
            return this.calculatorWithMathCopy.power(a, b);
        else return this.calculatorWithMathExtends.power(a, b);
    }

    public double abs(double a) {
        ++operationsCounter;
        if (calculatorWithOperator != null)
            return this.calculatorWithOperator.abs(a);
        else if (calculatorWithMathCopy != null)
            return this.calculatorWithMathCopy.abs(a);
        else return this.calculatorWithMathExtends.abs(a);
    }

    public double sqrt(double a) {
        ++operationsCounter;
        if (calculatorWithOperator != null)
            return this.calculatorWithOperator.sqrt(a);
        else if (calculatorWithMathCopy != null)
            return this.calculatorWithMathCopy.sqrt(a);
        else return this.calculatorWithMathExtends.sqrt(a);
    }
}

