package vn.chapp.nitiny.ui.cart;

import vn.chapp.nitiny.base.MvpPresenter;


public interface CartFrMvpPresent<V extends CartFrMvpView> extends MvpPresenter<V> {
    void doGetCart();
    void doDeleteCart(String productId);
    void doEditCart(String productId, String number);
}