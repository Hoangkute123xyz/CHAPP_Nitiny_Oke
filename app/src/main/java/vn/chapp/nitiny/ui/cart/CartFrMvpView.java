package vn.chapp.nitiny.ui.cart;


import java.util.List;

import vn.chapp.nitiny.base.MvpView;
import vn.chapp.nitiny.models.cart.Cart;

public interface CartFrMvpView extends MvpView {
    void didGetCart(List<Cart> carts);
    void didDeleteCart();
    void didPlusCart(); //them
    void didMinusCart(); //them
    void didEditCart();
}
