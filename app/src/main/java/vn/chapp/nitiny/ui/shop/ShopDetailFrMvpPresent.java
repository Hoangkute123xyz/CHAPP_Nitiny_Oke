package vn.chapp.nitiny.ui.shop;

import vn.chapp.nitiny.base.MvpPresenter;

public interface ShopDetailFrMvpPresent<V extends ShopDetailFrMvpView> extends MvpPresenter<V> {
    void doGetListShop(String idService, String type);
    void doGetShopDetail(String shopId);
    void getBanners();
}
