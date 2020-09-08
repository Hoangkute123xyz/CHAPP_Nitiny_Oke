package vn.chapp.nitiny.ui.services;
import vn.chapp.nitiny.base.MvpPresenter;


public interface SearchShopFrMvpPresent<V extends SearchShopFrMvpView> extends MvpPresenter<V> {
    void getCurrentLocation(String serviceId);
    void searchShopNearBy(String serviceId);
    void cancelAsyncDistance();
    void doAddService(String code, int idService, int shopId);
}
