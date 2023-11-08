package sem_3.coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runners.Parameterized.Parameter;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SomeServiceTest {
   // 3.1.
    
    SomeService someService;
    
    @BeforeEach
    void setup() {
        someService = new SomeService();
    }
    
    @Test
    void multipleThreeNotFiveReturnsFizz() {
        assertEquals("Fizz", SomeService.fizzBuzz(3));
    }
    
    @Test
    void multipleFiveNotThreeReturnsBuzz() {
        assertEquals("Buzz", SomeService.fizzBuzz(5));
    }
    
    @Test
    void multipleFiveAndThreeReturnsFizzBuzz() {
        assertEquals("FizzBuzz", SomeService.fizzBuzz(15));
    }
    
    @ParameterizedTest
    @ValueSource(ints = {4, 7, 8, 11, 17})
    void multipleNotFiveNotThreeReturnsFizzBuzz(int i) {
        assertEquals(Integer.toString(i), SomeService.fizzBuzz(i));
    }
    
    @Test
    void testFirstOrLastIs6() {
        assertTrue(someService.firstLast6(new int[]{6, 2, 2, 3}));
        assertTrue(someService.firstLast6(new int[]{2, 2, 3, 6}));
        assertFalse(someService.firstLast6(new int[]{2, 2, 3}));
    }
    
    @ParameterizedTest
    @CsvSource({
        "2000.0,50,1000",
        "2000.0,100,0",
        "2000.0,0,2000.0"
        })
    void testCorrectCalculation(double p, int d, double r) {
    assertThat(someService.calculatingDiscount(p, d))
            .isEqualTo(r); // обычная скидка
    assertThat(someService.calculatingDiscount(p, d))
            .isEqualTo(r); // обычная скидка
    assertThat(someService.calculatingDiscount(p, d))
            .isEqualTo(r); // обычная скидка
    }
    
    @ParameterizedTest
    @CsvSource({"2000.0,101"})
    void testOverDiscount(double p, int d) {
        assertThatThrownBy(() ->
                someService.calculatingDiscount(p, d))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%"); // процент скидки больше 100%
    }
    
    @ParameterizedTest
    @CsvSource({"2000.0,-10"})
    void testUnderDiscount(double p, int d) {
        assertThatThrownBy(() ->
                someService.calculatingDiscount(p, d))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%"); // процент скидки меньше 0
    }
    
    /*
     * Разработайте метод luckySum и напишите для него тесты. Этот метод 
     * принимает на вход три числа и возвращает их сумму. Однако, если одно 
     * из чисел равно 13, то оно не учитывается при подсчете суммы. Так, 
     * например, если b равно 13, то считается сумма только a и c.
     */
    
    
//    @CsvSource({"13,13,13","12,12,11","13,1,13"})
    
    @Test
    void correctLuckySum() {
        assertThat(someService.luckySum(1,4,8)).isEqualTo(13);
    }

    @Test
    void correctLuckySumA() {
        assertThat(someService.luckySum(13,4,8)).isEqualTo(12);
    }

    @Test
    void correctLuckySumB() {
        assertThat(someService.luckySum(8,13,8)).isEqualTo(16);
    }

    @Test
    void correctLuckySumC() {
        assertThat(someService.luckySum(8,4,13)).isEqualTo(12);
    }
    
}