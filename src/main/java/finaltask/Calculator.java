package finaltask;

import java.util.List;


public final class Calculator {

    private Calculator() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Метод для сравнения средних значений списков.
     * @param list1
     * @param list2
     */
    public static void compareAverage(
            final List<Double> list1,
            final List<Double> list2) {
        double sum1 = 0.0;
        for (Double num : list1) {
            sum1 = sum1 + num;
        }
        double avg1 = sum1 / list1.size();

        double sum2 = 0.0;
        for (Double num : list2) {
            sum2 = sum2 + num;
        }
        double avg2 = sum2 / list2.size();

        if (avg1 > avg2) {
            System.out.println("Первый список имеет большее среднее значение");
        } else if (avg1 < avg2) {
            System.out.println("Второй список имеет большее среднее значение");
        } else {
            System.out.println("Средние значения равны");
        }

    }

}
