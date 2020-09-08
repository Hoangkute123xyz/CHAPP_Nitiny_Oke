package vn.chapp.nitiny.ui.scheduledProduct;

import vn.chapp.nitiny.base.MvpPresenter;
import vn.chapp.nitiny.models.sale.Scheduled;


public interface ScheduleProductFrMvpPresent<V extends ScheduleProductFrMvpView> extends MvpPresenter<V> {
    void validateData(Scheduled scheduled);
    void doGetProduct();
    void doDeleteCart(String productId);
    void doEditCart(String productId, String number);
    void doAddProductToCart(String productId);
}
