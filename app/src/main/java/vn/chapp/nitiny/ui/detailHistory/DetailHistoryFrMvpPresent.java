package vn.chapp.nitiny.ui.detailHistory;

import vn.chapp.nitiny.base.MvpPresenter;

public interface DetailHistoryFrMvpPresent<V extends DetailHistoryFrMvpView> extends MvpPresenter<V> {
    void doGetDetailBooking(int idBooking);
}