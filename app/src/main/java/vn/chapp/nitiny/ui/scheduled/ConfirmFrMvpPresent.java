package vn.chapp.nitiny.ui.scheduled;

import vn.chapp.nitiny.base.MvpPresenter;
import vn.chapp.nitiny.models.sale.Scheduled;

public interface ConfirmFrMvpPresent<V extends ConfirmFrMvpView> extends MvpPresenter<V> {
    void doBooking(Scheduled scheduled);
}
