//Unit testing all methods in cart service
package integrartion.unit.test;

import integrartion.unit.test.Service.CartService;
import integrartion.unit.test.Service.PaymentService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.*;

public class CartServiceTest {
    private CartService cartService;
    private Cart cart;
    private PaymentService paymentService;

    @Before
    public void setUp() {
        cart = new Cart();
        paymentService = Mockito.mock(PaymentService.class);
        cartService = new CartService(cart, paymentService);
    }

    @Test
    public void testCheckout_SuccessfulPayment() {
        cart.addProduct(new Product("Laptop", 1200));
        Mockito.when(paymentService.processPayment(cart.getTotal())).thenReturn(true);

        boolean result = cartService.checkout();
        assertTrue(result);
    }

    @Test
    public void testCheckout_FailedPayment() {
        cart.addProduct(new Product("Laptop", 1200));
        Mockito.when(paymentService.processPayment(cart.getTotal())).thenReturn(false);

        boolean result = cartService.checkout();
        assertFalse(result);
    }
}
