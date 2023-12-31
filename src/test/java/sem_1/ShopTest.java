package sem_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ShopTest {

    /*
     * 1. Проверить, что магазин хранит верный список продуктов (количество
     * продуктов, состав корзины) 
     * 2. Проверить, что магазин возвращает верный самый
     * дорого продукт getMostExpensiveProduct 
     * 3. Проверить, что магазин возвращает
     * верный отсортированный по цене список продуктов
     */

    private Shop shop;
    private List<Product> products;

    // Данный метод будет выполняться перед каждым тестом
    @BeforeEach
    public void setup() {
        // Создаём список продуктов
        products = new ArrayList<>();

        // Создаём продукты
        Product apple = new Product(20, "Яблоко");
        Product banana = new Product(12, "Банена");
        Product peach = new Product(18, "Персик");

        // Наполняем список данными
        products.add(apple);
        products.add(banana);
        products.add(peach);

        // Создаём магазин и передаём в него продукты
        shop = new Shop();
        shop.setProducts(products);
    }

    // 1.
    @Test
    void testShopContaintment() {
        
        assertAll("Содержимое магазина",
                () -> assertEquals(products, shop.getProducts(), 
                "Список продуктов отличается от списка корзины"),
                () -> assertTrue(products.size() == 3, 
                "Размер списка продуктов не совпадает"),
                () -> assertTrue(shop.getProducts().size() == 3, 
                "Размер списка продуктов магазина не совпадает"));

    }

    // 2.
    @Test
    void testGetMostExpensiveProduct() {
        Product expect = Collections.max(products, (p1, p2) -> 
        Integer.compare(p1.getCost(), p2.getCost()));
        assertEquals(expect, shop.getMostExpensiveProduct(), 
                "Самые дорогие продукты не совпадают");
    }

    // 3.
    @Test
    void testGetSortedProductList() {
        List<Product> expect = new ArrayList<>(products);
        expect.sort((p1, p2) -> Integer.compare(p1.getCost(), p2.getCost()));

        assertEquals(expect, shop.getSortedListProducts(), 
                "Отсортированные списки продуктов не совпадают");
    }
}
