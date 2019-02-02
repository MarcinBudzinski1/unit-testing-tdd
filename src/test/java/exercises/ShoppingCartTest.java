package exercises;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class AdvancedCalculatorTest {

    AdvancedCalculator advancedCalculator;
    @Before
    public void SetUp() {
        advancedCalculator = new AdvancedCalculator();
    }


    @Parameters({
            "1, 1",
            "1, 0",
            "4790101600, 12",
    })

    @Test
    public void testFactorialPositiveScenarios(int expectedValue, int x) {
        int result = advancedCalculator.silnia(x);
        assertEquals(expectedValue, result);

    }
    @Test
    public void testFactorialForExceptionWhenArgumentLowerThanZero(){
        try {
            advancedCalculator.silnia(-1);
            fail();
        } catch (IllegalArgumentException ex) {
            assertEquals("Silnia jest policzalna tylko dla liczb dodatnich", ex.getMessage());
        } catch (Exception ex) {
            fail();
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFactorialForExceptionWhenArgumentLowerThanZero2(){
        advancedCalculator.silnia(-1);
    }

    @Test
    public void testPowerFor22(){
        double result = advancedCalculator.power(2, 2);
        assertEquals(4, result, 0.01);

    }

    @Test
    public void testPowerNegativeValues(){
        double result = advancedCalculator.power(-2, 3);
        assertEquals(-8, result, 0.01);

    }


}