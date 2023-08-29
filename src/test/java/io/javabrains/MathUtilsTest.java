package io.javabrains;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {
    
    MathUtils mathUtils;
    
    @BeforeEach
    void init() {
        mathUtils = new MathUtils();
        
    }
    
    @AfterEach
    void cleanup() {
        System.out.println("Cleaning up...");
    }

    @Test
    void test1() {
        System.out.println("This test runs");      
    }
    
    @Test
    void test3() {
        int expected = 2;
        int actual = mathUtils.add(1, 1);
        assertEquals(expected, actual);
    }

    @Test
    // happy path scenario
    void testComputeCircleRadius() {
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return right circle area");
    }

    @Test
    // bad path scenario
    void testDivide() {
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "Divide by zero should throw");
    }
    
    @Test
    public void testMultiplyFunction() {
    	//ARRANGE
        int a = 2;
        int b = 3;
        int expected = 6;

        int result = 0;
        //ACT
        for (int i = 0; i < b; i++) {
            result = mathUtils.add(result, a);
        }
        //ASSERT
        assertEquals(expected, result);
    }
    
  
    
//    @Test
//    public void testMultiply2() {
//    	//ARRANGE
//        int a = 2;
//        int b = 3;
//        int expected = 6;
//        MathUtils mathUtils = new MathUtils();
//        //ACT
//        int result = mathUtils.multiply(a, b);
//        //ASSERT
//        assertEquals(expected, result);
//    }
    
    @Test
    public void testMultiply() {
        // ARRANGE
        int a = 2;
        int b = 3;
        int expected = 6;

        Adder adderMock = mock(Adder.class);
        when(adderMock.add(anyInt(), anyInt())).thenReturn(a);
        MathUtils mathUtils = new MathUtils(adderMock);
        // ACT
        int result = mathUtils.multiply(a, b);

        // ASSERT
        verify(adderMock, times(b)).add(anyInt(), anyInt());
        assertEquals(expected, result);
    }
}












