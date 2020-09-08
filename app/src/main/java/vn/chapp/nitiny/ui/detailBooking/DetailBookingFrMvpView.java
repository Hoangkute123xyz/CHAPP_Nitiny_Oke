package vn.chapp.nitiny.ui.detailBooking;

import vn.chapp.nitiny.base.MvpView;
import vn.chapp.nitiny.models.booking.DetailBooking;

public interface DetailBookingFrMvpView extends MvpView {
    void didGetDetailBooking(DetailBooking detailBooking);
}
