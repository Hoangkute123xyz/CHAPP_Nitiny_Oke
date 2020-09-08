package vn.chapp.nitiny.ui.detailHistory;

import vn.chapp.nitiny.base.MvpView;
import vn.chapp.nitiny.models.booking.DetailBooking;

public interface DetailHistoryFrMvpView extends MvpView {
    void didGetDetailBooking(DetailBooking detailBooking);
}