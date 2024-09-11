//unit testing the methods in cart class
package integrartion.unit.test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CartTest {
    private Cart cart;

    @Before
    public void setUp() {
        cart = new Cart();
    }

    @Test
    public void testAddProduct() {
        Product product = new Product("Apple", 1.5);
        cart.addProduct(product);

        assertEquals(1, cart.getProducts().size());
    }

    @Test
    public void testGetTotal() {
        cart.addProduct(new Product("Apple", 1.5));
        cart.addProduct(new Product("Banana", 2.0));

        assertEquals(3.5, cart.getTotal(), 0);
    }
}

