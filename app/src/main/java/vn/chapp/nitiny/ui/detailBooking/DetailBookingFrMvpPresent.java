package vn.chapp.nitiny.ui.detailBooking;

import vn.chapp.nitiny.base.MvpPresenter;

public interface DetailBookingFrMvpPresent<V extends DetailBookingFrMvpView> extends MvpPresenter<V> {
    void doGetDetailBooking(int idBooking);
}
