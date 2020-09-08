package vn.chapp.nitiny.ui.history;

import vn.chapp.nitiny.base.MvpPresenter;

public interface HistoryFrMvpPresent<V extends HistoryFrMvpView> extends MvpPresenter<V> {
    void doGetShopLinked();
    void getServices();
    void getUserHistory(String serviceId);
}
