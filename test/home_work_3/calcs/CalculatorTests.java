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
    void plus(ICalculator shapeInstance){
        double sum = shapeInstance.plus(1, 2);
        assertEquals(3, sum);
    }

    private static Collection<Object[]> data() {
        ICalculator calculator = new CalculatorWithMathCopy();
        return Arrays.asList(new Object[][] {
                { new CalculatorWithCounterAutoSuper() },
                { new CalculatorWithCounterClassic() },
                { new CalculatorWithCounterAutoAggregation(calculator) },
                { new CalculatorWithCounterAutoAggregationInterface(calculator) },
                { new CalculatorWithCounterAutoChoiceAggregation((CalculatorWithMathCopy)calculator) },
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
