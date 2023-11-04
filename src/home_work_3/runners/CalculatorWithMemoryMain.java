package home_work_3.runners;

import home_work_3.calcs.CalculatorWithMathCopy;
import home_work_3.calcs.CalculatorWithMemory;
import home_work_3.calcs.api.ICalculator;

public class CalculatorWithMemoryMain {
    public static void main(String[] args) {
        ICalculator c = new CalculatorWithMathCopy();
        CalculatorWithMemory calc = new CalculatorWithMemory(c);

        calc.divide(28, 5);
        calc.save();
        calc.power(calc.load(), 2);
        calc.save();
        calc.plus(calc.multiply(15, 7), calc.load());
        calc.save();
        calc.plus(4.1, calc.load());
        calc.save();
        System.out.println("Result: " + calc.load() + " (should be 140.46).");
    }
}
