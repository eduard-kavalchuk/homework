package home_work_3.calcs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorStringExpressionTest {
    @Test
    @DisplayName("4.1 + 15 * 7 + (28 / 5) ^ 2")
    void sum1(){
        String expr = "4.1 + 15 * 7 + (28 / 5) ^ 2";
        CalculatorStringExpression calc = new CalculatorStringExpression(expr);
        double result = calc.calculate();
        assertEquals(140.46, result, 1e-6);
    }
}
