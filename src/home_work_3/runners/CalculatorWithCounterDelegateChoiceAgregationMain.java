package home_work_3.runners;

import home_work_3.calcs.CalculatorWithCounterAutoChoiceAggregation;
import home_work_3.calcs.CalculatorWithMathCopy;
import home_work_3.calcs.CalculatorWithMathExtends;
import home_work_3.calcs.CalculatorWithOperator;

public class CalculatorWithCounterDelegateChoiceAgregationMain {
    public static void main(String[] args) {
        double result;
        CalculatorWithOperator calculatorWithOperator = new CalculatorWithOperator();
        CalculatorWithMathCopy calculatorWithMathCopy = new CalculatorWithMathCopy();
        CalculatorWithMathExtends calculatorWithMathExtends = new CalculatorWithMathExtends();

        CalculatorWithCounterAutoChoiceAggregation calcAG = new CalculatorWithCounterAutoChoiceAggregation(calculatorWithOperator);
        result = calcAG.divide(28, 5);
        result = calcAG.power(result, 2);
        result = calcAG.plus(calcAG.multiply(15, 7), result);
        result = calcAG.plus(4.1, result);
        System.out.println("Result for calculatorWithOperator: " + result + " (should be 140.46)");
        System.out.println("Counter for calculatorWithOperator: " + calcAG.getCountOperation());

        calcAG = new CalculatorWithCounterAutoChoiceAggregation(calculatorWithMathCopy);
        result = calcAG.divide(28, 5);
        result = calcAG.power(result, 2);
        result = calcAG.plus(calcAG.multiply(15, 7), result);
        result = calcAG.plus(4.1, result);
        System.out.println("Result for calculatorWithMathCopy: " + result + " (should be 140.46)");
        System.out.println("Counter for calculatorWithMathCopy: " + calcAG.getCountOperation());

        calcAG = new CalculatorWithCounterAutoChoiceAggregation(calculatorWithMathExtends);
        result = calcAG.divide(28, 5);
        result = calcAG.power(result, 2);
        result = calcAG.plus(calcAG.multiply(15, 7), result);
        result = calcAG.plus(4.1, result);
        System.out.println("Result for calculatorWithMathExtends: " + result + " (should be 140.46)");
        System.out.println("Counter for calculatorWithMathExtends: " + calcAG.getCountOperation());
    }
}
