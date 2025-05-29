package regresspack;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalculatorRegTest {

    private CalculatorReg calculator;

    @BeforeEach
    public void setUp() {
        calculator = new CalculatorReg();
    }

    @Test
    @Tag("regression") // Marked for regression testing
    public void testAddition() {
        assertEquals(2, calculator.add(1, 1));
    }

    @Test
    @Tag("regression")
    public void testSubtraction() {
        assertEquals(2, calculator.sub(5, 3));
    }

    @Test
    @Tag("regression")
    public void testMultiplication() {
        assertEquals(15, calculator.mul(5, 3));
    }

    @Test
    public void testDivision() {
        assertEquals(3, calculator.divide(6, 2));
    }

    @Test
    public void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(3, 0));
    }

    // Regression test for a previously fixed divide-by-zero issue
    @Test
    @Tag("regression")
    public void regressionTest_DivideByZeroShouldThrow() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
    }
}
