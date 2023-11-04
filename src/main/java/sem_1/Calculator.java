package sem_1;

import static org.assertj.core.api.Assertions.assertThat;

public class Calculator {
	
	public static double calculateDiscount(double purchasePrice, int discount) {
		try {
			assertThat(discount).as(
					"Проверка на размер скидки: от 0 до 100").isBetween(0, 100);
		} catch (AssertionError ae) {
			throw new ArithmeticException(
					"Недопустимый размер скидки" + ae.getMessage());
		}
		return purchasePrice - (purchasePrice * (discount / 100.0));
	}
	
}
