package integrartion.unit.test;
import integrartion.unit.test.Service.CartService;
import integrartion.unit.test.Service.PaymentService;
import org.junit.Before;
import org.junit.Test;
import integrartion.unit.test.Cart;
import static org.junit.Assert.*;

public class CartServiceIntegrationTest {
    private CartService cartService;
    private Cart cart;
    private PaymentService paymentService;

    @Before
    public void setUp() {
        cart = new Cart();
        paymentService = new PaymentService();
        cartService = new CartService(cart, paymentService);
    }

    @Test
    public void testCheckout_Integration() {
        cart.addProduct(new Product("TV", 400));
        cart.addProduct(new Product("Phone", 800));

        boolean result = cartService.checkout();
        assertTrue(result);
    }
}
/*
Unit tests focus on testing small units
like the Cart and CartService class in isolation.
Integration tests ensure that multiple
components work correctly together.
*/