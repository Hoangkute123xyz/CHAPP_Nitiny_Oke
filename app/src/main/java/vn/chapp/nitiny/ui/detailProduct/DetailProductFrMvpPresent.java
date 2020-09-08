package vn.chapp.nitiny.ui.detailProduct;

import vn.chapp.nitiny.base.MvpPresenter;

public interface DetailProductFrMvpPresent<V extends DetailProductFrMvpView> extends MvpPresenter<V> {
    void doAddProductToCart(String productId);
    
    //them
    void doEditCart(String productId, String number);
}
