package home_work_3.runners;

import home_work_3.calcs.CalculatorWithCounterAutoDecorator;
import home_work_3.calcs.CalculatorWithMathExtends;
import home_work_3.calcs.CalculatorWithMemoryDecorator;
import home_work_3.calcs.additional.CalculatorWithCounterClassic;
import home_work_3.calcs.api.ICalculator;

public class CalculatorDecoratorMain {
    public static void main(String[] args) {
        ICalculator calc = new CalculatorWithCounterAutoDecorator(
            new CalculatorWithMemoryDecorator(new CalculatorWithMathExtends()));
        double result;

        result = calc.divide(28, 5);
        result = calc.power(result, 2);
        result = calc.plus(calc.multiply(15, 7), result);
        result = calc.plus(4.1, result);
        System.out.println("Result: " + result + " (should be 140.46)");

        // 13.6
        System.out.println("Number of operations: " + ((CalculatorWithCounterAutoDecorator) calc).getCountOperation());

        // 13.7.1
        ICalculator c = ((CalculatorWithCounterAutoDecorator) calc).getCalculator();
        if (c instanceof CalculatorWithMemoryDecorator) {
            CalculatorWithMemoryDecorator calculator = (CalculatorWithMemoryDecorator) c;
            calculator.save();
            System.out.println(calculator.load());
        }

        // 13.7.2
        calc = new CalculatorWithCounterClassic();
        /*
         * Выполнение следующей инструкции ведёт к ошибке времени выполнения поскольку тип CalculatorWithCounterClassic 
         * нельзя привести к типу CalculatorWithCounterAutoDecorator поскольку эипы несопоставимы 
         * (у них разные интерфейсы):
         * c = ((CalculatorWithCounterAutoDecorator) calc).getCalculator();
         * Приведение к типу ICalculator ведёт в ошибке компиляции поскольку тип ICalculator 
         * не содержит метода getCalculator:
         * c = ((ICalculator) calc).getCalculator();
         * Поэтому правильным будет выполнить предварительную проверку, что переменная calc ссылается на объект
         * класса CalculatorWithCounterAutoDecorator:
         * if (calc instanceof CalculatorWithCounterAutoDecorator) {
            c = ((CalculatorWithCounterAutoDecorator) calc).getCalculator();
            }
         */
    }
}
