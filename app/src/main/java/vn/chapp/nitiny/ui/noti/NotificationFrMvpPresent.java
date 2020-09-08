package vn.chapp.nitiny.ui.noti;

import vn.chapp.nitiny.base.MvpPresenter;

public interface NotificationFrMvpPresent<V extends NotificationFrMvpView> extends MvpPresenter<V> {
    void doGetNoti();
}
