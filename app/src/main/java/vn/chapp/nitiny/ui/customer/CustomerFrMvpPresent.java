package vn.chapp.nitiny.ui.customer;

import vn.chapp.nitiny.base.MvpPresenter;

public interface CustomerFrMvpPresent<V extends CustomerFrMvpView> extends MvpPresenter<V> {
    void doGetShopLinked();
}
