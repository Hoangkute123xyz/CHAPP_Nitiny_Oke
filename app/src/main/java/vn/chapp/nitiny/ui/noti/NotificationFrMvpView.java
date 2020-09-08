package vn.chapp.nitiny.ui.noti;

import java.util.List;

import vn.chapp.nitiny.base.MvpView;
import vn.chapp.nitiny.models.noti.Notify;

public interface NotificationFrMvpView extends MvpView {
    void didGetNoti(List<Notify> notifies);
}
