package vn.chapp.nitiny.ui.booking;

import vn.chapp.nitiny.base.MvpPresenter;
import vn.chapp.nitiny.models.booking.Booking;

public interface BookingFrMvpPresent<V extends BookingFrMvpView> extends MvpPresenter<V> {
    void getListBooking(String active);
    void updateStatusBooking(int position, Booking booking, int active);
}
