package integrartion.unit.test.Service;

import integrartion.unit.test.Cart;

public class CartService {
    private Cart cart;
    private PaymentService paymentService;

    public CartService(Cart cart, PaymentService paymentService) {
        this.cart = cart;
        this.paymentService = paymentService;
    }

    public boolean checkout() {
        double total = cart.getTotal();
        return paymentService.processPayment(total);
    }
}
