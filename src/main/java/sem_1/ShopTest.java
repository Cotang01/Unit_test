package sem_1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShopTest {

    /*
     * 1. Проверить, что магазин хранит верный список продуктов (количество
     * продуктов, состав корзины) 2. Проверить, что магазин возвращает верный самый
     * дорого продукт getMostExpensiveProduct 3. Проверить, что магазин возвращает
     * верный отсортированный по цене список продуктов
     */

    private Shop shop;
    private List<Product> products;

    // Данный метод будет выполняться перед каждым тестом
    @Before
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
    public void testShopContaintment() {

        Assert.assertEquals("Список продуктов отличается от списка корзины", 
                products, shop.getProducts());
        Assert.assertTrue("Размер списка продуктов не совпадает", 
                products.size() == 3);
        Assert.assertTrue("Размер списка продуктов магазина не совпадает", 
                shop.getProducts().size() == 3);

    }

    // 2.
    @Test
    public void testGetMostExpensiveProduct() {
        Product expect = Collections.max(products, (p1, p2) -> 
        Integer.compare(p1.getCost(), p2.getCost()));

        Assert.assertEquals("Самые дорогие продукты не совпадают", 
                expect, shop.getMostExpensiveProduct());
    }

    // 3.
    @Test
    public void testGetSortedProductList() {
        List<Product> expect = new ArrayList<>(products);
        expect.sort((p1, p2) -> Integer.compare(p1.getCost(), p2.getCost()));

        Assert.assertEquals("Отсортированные списки продуктов не совпадают", 
                expect, shop.getSortedListProducts());
    }
}
