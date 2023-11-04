package home_work_3.calcs.additional;

import home_work_3.calcs.CalculatorWithMathExtends;

public class CalculatorWithCounterClassic extends CalculatorWithMathExtends{
    private long operationsCounter;

    public void incrementCountOperation() {
        ++operationsCounter;
    }

    public long getCountOperation() {
        return operationsCounter;
    }
}
