package vn.chapp.nitiny.ui.scheduledProduct;


import vn.chapp.nitiny.base.MvpView;
import vn.chapp.nitiny.models.sale.Scheduled;
import vn.chapp.nitiny.models.service.ListProducts;

public interface ScheduleProductFrMvpView extends MvpView {
    void isValidateData(boolean isValidate, Scheduled scheduled);
    void didGetProduct(ListProducts products);
    void didDeleteCart();
    void didEditCart();
    void didAddProductToCart();
}
