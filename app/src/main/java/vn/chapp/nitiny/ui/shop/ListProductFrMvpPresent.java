package vn.chapp.nitiny.ui.shop;

import vn.chapp.nitiny.base.MvpPresenter;
import vn.chapp.nitiny.models.service.CategoryAdd;


public interface ListProductFrMvpPresent<V extends ListProductFrMvpView> extends MvpPresenter<V> {
    void doGetCategory(String serviceId, String type);
    void getSearchProduct(CategoryAdd categoryAdd, String shopId, int type);
    void doAddProductToCart(String productId);
}
