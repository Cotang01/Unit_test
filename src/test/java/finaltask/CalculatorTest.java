package finaltask;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;


/**
 * Класс для тестирования класса Калькулятор.
 */
class CalculatorTest {
    /**
     * Первый список.
     */
    private List<Double> list1;
    /**
     * Второй список.
     */
    private List<Double> list2;
    /**
     * Считывание вывода из консоли в виде массива букв.
     */
    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    /**
     * Переключатель системы в режим считывания вывода консоли.
     */
    private PrintStream printStream = new PrintStream(output);
    /**
     * Значение для тестов, взятое за малое.
     */
    private static final double LOW_VALUE = 10.0;
    /**
     * Значение для тестов, взятое за середину между малым и большим.
     */
    private static final double AVERAGE_VALUE = 20.0;
    /**
     * Значение для тестов, взятое за большое.
     */
    private static final double BIG_VALUE = 30.0;

    /**
     * Тест для проверки поведения, если среднее значение первого списка
     * окажется больше второго.
     */
    @Test
    void testFirstListAvgBigger() {
        list1 = Arrays.asList(LOW_VALUE, AVERAGE_VALUE, BIG_VALUE);
        list2 = Arrays.asList(LOW_VALUE, LOW_VALUE, LOW_VALUE);
        System.setOut(printStream);
        Calculator.compareAverage(list1, list2);
        String consoleOutput = output.toString().trim();
        assertEquals(
                "Первый список имеет большее среднее значение", consoleOutput);
        System.setOut(System.out);
    }

    /**
     * Тест для проверки поведения, если среднее значение второго списка
     * окажется больше первого.
     */
    @Test
    void testSecondListAvgBigger() {
        list1 = Arrays.asList(LOW_VALUE, LOW_VALUE, LOW_VALUE);
        list2 = Arrays.asList(LOW_VALUE, AVERAGE_VALUE, BIG_VALUE);
        System.setOut(printStream);
        Calculator.compareAverage(list1, list2);
        String consoleOutput = output.toString().trim();
        assertEquals(
                "Второй список имеет большее среднее значение", consoleOutput);
        System.setOut(System.out);
    }

    /**
     * Тест для проверки поведения, если среднее значение обоих списков
     * окажется одинаковым.
     */
    @Test
    void testBothAvgEqual() {
        list1 = Arrays.asList(LOW_VALUE, LOW_VALUE, LOW_VALUE);
        list2 = Arrays.asList(LOW_VALUE, LOW_VALUE, LOW_VALUE);
        System.setOut(printStream);
        Calculator.compareAverage(list1, list2);
        String consoleOutput = output.toString().trim();
        assertEquals("Средние значения равны", consoleOutput);
        System.setOut(System.out);
    }

}
