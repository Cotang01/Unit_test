package sem_1;

import java.util.ArrayList;
import java.util.List;

public class Homework {
	
	public static void main(String[] args) {
		System.out.println(Calculator.calculateDiscount(800, 10));
		Shop myShop = new Shop();
		Product apple1 = new Product(20, "Яблоко");
		Product apple2 = new Product(40, "Ещё яблоко");
		Product banana1 = new Product(12, "Банена");
		Product banana2 = new Product(60, "Банена По-больше");
		List<Product> products = new ArrayList<>();
		products.add(apple1);
		products.add(apple2);
		products.add(banana1);
		products.add(banana2);
		myShop.setProducts(products);
		System.out.println(myShop.getProducts());
		System.out.println(myShop.getSortedListProducts());
		System.out.println(myShop.getMostExpensiveProduct());
	}

}
