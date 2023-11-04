package sem_1;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		assertConditionA();
		assertConditionB();
		System.out.println(sum(2147483646, 1));
		happyNY();
		checkingShoppingCart();
		expectedValue();
		String[] colors = {"aqua", "yellow", "blue", "orange",
				"green", "violet", "gold"};
		testingJavaCollectionsAssertJ(colors);
		checkingHero();
	}
	
	public static void assertConditionA() {
		
		String[] weekends = {"Суббота", "Воскресенье"};
		assert weekends.length == 2;
		System.out.println("В неделе " + weekends.length + " дня выходных");
		
	}
	
	public static void assertConditionB() {
		
		int x = 1;
		assert x >= 0;
		
	}
	
	public static int sum(int a, int b) {
		
		assert a + b > Integer.MIN_VALUE;
		assert a + b <= Integer.MAX_VALUE;
		return a + b;
				
	}
	
	public static void happyNY() {
		
		Calendar calendar = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String currentDatetime = dateFormat.format(calendar.getTime());
		
		Calendar newYear = Calendar.getInstance();
		newYear.set(2023, 0, 1);
		
		assert newYear.before(calendar) : "Ещё 23 год :(";
		System.out.println("С новым годом!");
		
	}
	
	public static void checkingShoppingCart() {
		ArrayList<String> productCategories = new ArrayList<>();
		productCategories.add("fruits");
		productCategories.add("vegetables");
		productCategories.add("bakery");
		productCategories.add("liquid");
		ArrayList<String> products = new ArrayList<>();
		products.add("apple");
		products.add("tomato");
		products.add("bread");
		products.add("water");
		for (String product : products) {
			if (product.equals("apple")) {
				System.out.println("category: " + productCategories.get(0));
			} else if (product.equals("tomato")) {
				System.out.println("category: " + productCategories.get(1));
			} else if (product.equals("bread")) {
				System.out.println("category: " + productCategories.get(2));
			} else if (product.equals("water")) {
				System.out.println("category: " + productCategories.get(3));
			} else {
				assert false : "Unknown category for the product " + product;
			}
		}
	}
	
	public static void expectedValue() {
		 assertThat(5).isEqualTo(sum(2, 3));
	}
	
	public static void testingJavaCollectionsAssertJ(String[] colors) {
		 assertThat(colors)
		 .isNotEmpty()
		 .hasSize(7)
		 .doesNotHaveDuplicates()
		 .contains("orange", "green", "violet")
		 .endsWith("gold")
		 .startsWith("aqua")
		 .containsSequence("yellow", "blue")
		 .doesNotContain("red", "black");
	}
	
	public static void checkingHero() {
		 List<String> heroBag = Arrays.asList("Bow", "Axe", "Gold");
		 Hero emmett = new Hero("Emmett", 50, "sword", heroBag, true);
		 assertThat(emmett.getName()).isEqualTo("Emmett");
		 assertThat(emmett.getArmor()).isEqualTo(50);
		 assertThat(emmett.getWeapon()).isEqualToIgnoringCase("sword");
		 assertThat(emmett.getInventory().size()).isEqualTo(3);
		 assertThat(emmett.getInventory()).containsAll(heroBag);
		 assertThat(emmett.isHuman()).isTrue();
	}

}
