package TD1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test @BeforeEach
    void somme() {
        //Given
        Calculator calc = new Calculator();
        int a = 10;
        int b = 15;

        //When
        double result = calc.somme(a,b);

        //Then
        assertEquals(25,result);
    }
    @Test @BeforeEach
    void subtraction(){
        //Given
        Calculator calc = new Calculator();
        int a = 15;
        int b = 10;

        //When
        double result = calc.substraction(a,b);

        //Then
        assertEquals(5,result);
    }

}