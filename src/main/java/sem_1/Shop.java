package sem_1;

import java.util.Collections;
import java.util.List;

public class Shop {
    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * @return отсортированный по возрастанию и цене список продуктов
     */
    public List<Product> getSortedListProducts() {
        this.products.sort((p1, p2) -> 
        Integer.compare(p1.getCost(), p2.getCost()));
        return this.products;
    }

    /**
     * @return самый дорогой продукт
     */
    public Product getMostExpensiveProduct() {
        return Collections.max(this.products, (p1, p2) -> 
        Integer.compare(p1.getCost(), p2.getCost()));
    }
}