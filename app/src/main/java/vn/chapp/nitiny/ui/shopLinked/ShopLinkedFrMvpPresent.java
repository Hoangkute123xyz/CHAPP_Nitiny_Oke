package vn.chapp.nitiny.ui.shopLinked;

import vn.chapp.nitiny.base.MvpPresenter;


public interface ShopLinkedFrMvpPresent<V extends ShopLinkedFrMvpView> extends MvpPresenter<V> {
    void doGetShopLinked(int serviceId, int type);
    void doUnLink(String shopId);
}
