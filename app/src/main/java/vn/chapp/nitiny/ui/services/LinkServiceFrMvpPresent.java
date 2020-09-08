package vn.chapp.nitiny.ui.services;

import vn.chapp.nitiny.base.MvpPresenter;


public interface LinkServiceFrMvpPresent<V extends LinkServiceFrMvpView> extends MvpPresenter<V> {
    void loadService(int type);
    void loadServiceLinked(int type);
    void getBanners();
    void getWallet();
}
