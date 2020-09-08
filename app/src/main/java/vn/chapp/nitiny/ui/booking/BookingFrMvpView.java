package vn.chapp.nitiny.ui.booking;

import java.util.List;

import vn.chapp.nitiny.base.MvpView;
import vn.chapp.nitiny.models.booking.Booking;

public interface BookingFrMvpView extends MvpView {
    void didGetListBooking(List<Booking> bookingList);
    void didUpdatedBooking(int position, int active);
}
