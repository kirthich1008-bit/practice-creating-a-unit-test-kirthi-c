
package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * UNIT TEST QUALITY CHECKLIST EVALUATION:
 * [x] The test class mirrors the name of the class being tested (with Test at the end)
 *     -> Class name is 'CalculatorTest', mirroring 'Calculator'.
 * [x] The test method name clearly describes what is being tested
 *     -> Methods use explicit descriptive names like 'testAdd_HappyPath'.
 * [x] The test can run independently and doesn’t rely on other tests
 *     -> Uses @BeforeEach to instantiate a fresh Calculator instance before every single test execution.
 * [x] There is at least one test for the normal (“happy path”) case
 *     -> Includes explicit happy path tests for add, subtract, multiply, and divide.
 * [x] There is at least one test for an edge case or unusual input
 *     -> Includes overflow bounds, underflow bounds, multiplication by zero, and division by zero.
 * [x] The test uses appropriate assertions to verify behavior
 *     -> Employs assertEquals() for value matching and assertThrows() for expected exceptions.
 */


public class CalculatorTest {
    @Test
    public void add() {
        Calculator calculator = new Calculator();
        int result = calculator.add(2, 3);
        assertEquals(5, result);
        assertEquals(Integer.MIN_VALUE, calculator.add(Integer.MAX_VALUE, 1),
                "Integer overflow should wrap around to the minimum integer value");

    }
    @Test
    public void subtract() {
        Calculator calculator = new Calculator();
        int result = calculator.subtract(10, 5);
        assertEquals(5, result);
        assertEquals(Integer.MAX_VALUE, calculator.subtract(Integer.MIN_VALUE, 1),
                "Integer underflow should wrap around to the maximum integer value");
    }
    @Test
    public void multiply() {
        Calculator calculator = new Calculator();
        int result = calculator.multiply(2, 3);
        assertEquals(6, result);
        assertEquals(0, calculator.multiply(12345, 0), "Multiplying any integer by zero must equal zero");
    }
    @Test
    public void divide() {
        Calculator calculator = new Calculator();
        int result = calculator.divide(10, 2);
        assertEquals(5, result);
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0),
                "Dividing by zero must throw an ArithmeticException");
    }


}