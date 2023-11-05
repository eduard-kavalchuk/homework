package home_work_3.calcs;

import home_work_3.calcs.api.ICalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import home_work_3.calcs.additional.*;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
public class CalculatorTests {
    @ParameterizedTest
    @DisplayName("Plus operation")
    @MethodSource("data")
    void plus(ICalculator calculator){
        double result = calculator.plus(1, 2);
        assertEquals(3, result);
    }

    @ParameterizedTest
    @DisplayName("Minus operation")
    @MethodSource("data")
    void minus(ICalculator calculator){
        double result = calculator.minus(1, 2);
        assertEquals(-1, result);
    }

    @ParameterizedTest
    @DisplayName("Multiply operation")
    @MethodSource("data")
    void multiply(ICalculator calculator){
        double result = calculator.multiply(3, 2);
        assertEquals(6, result);
    }

    @ParameterizedTest
    @DisplayName("Divide operation")
    @MethodSource("data")
    void divide(ICalculator calculator){
        double result = calculator.divide(3, 2);
        assertEquals(1.5, result);
    }

    @ParameterizedTest
    @DisplayName("Power operation")
    @MethodSource("data")
    void power(ICalculator calculator){
        double result = calculator.power(2, 3);
        assertEquals(8, result);
    }

    @ParameterizedTest
    @DisplayName("Abs operation")
    @MethodSource("data")
    void abs(ICalculator calculator){
        double result = calculator.abs(-7.4);
        assertEquals(7.4, result);
    }

    @ParameterizedTest
    @DisplayName("Sqrt operation")
    @MethodSource("data")
    void sqrt(ICalculator calculator){
        double result = calculator.sqrt(5);
        assertEquals(Math.sqrt(5), result, 1e-8);
    }

    private static Collection<Object[]> data() {
        CalculatorWithMathCopy calculator = new CalculatorWithMathCopy();
        return Arrays.asList(new Object[][] {
                { new CalculatorWithCounterAutoSuper() },
                { new CalculatorWithCounterClassic() },
                { new CalculatorWithCounterAutoAggregation(calculator) },
                { new CalculatorWithCounterAutoAggregationInterface(calculator) },
                { new CalculatorWithCounterAutoChoiceAggregation(calculator) },
                { new CalculatorWithCounterAutoComposite() },
                { new CalculatorWithCounterAutoDecorator(calculator) },
                { new CalculatorWithMathCopy() },
                { new CalculatorWithMathExtends() },
                { new CalculatorWithMemory(calculator) },
                { new CalculatorWithMemoryDecorator(calculator) },
                { new CalculatorWithOperator() },
        });
    }
}
