package home_work_3.calcs;

import home_work_3.calcs.api.ICalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorWithCounterAutoAggregationTest {
    ICalculator calc = new CalculatorWithCounterAutoAggregation(new CalculatorWithMathCopy());
    @Test
    @DisplayName("Plus operation")
    public void plus() {
        double result = calc.plus(1, 2);
        assertEquals(3, result);
    }
}
