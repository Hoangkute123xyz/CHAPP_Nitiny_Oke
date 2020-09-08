package vn.chapp.nitiny.ui.scheduledProduct;

import vn.chapp.nitiny.base.MvpPresenter;
import vn.chapp.nitiny.models.sale.Scheduled;

public interface ConfirmProductFrMvpPresent<V extends ConfirmProductFrMvpView> extends MvpPresenter<V> {
    void doBooking(Scheduled scheduled);
}
