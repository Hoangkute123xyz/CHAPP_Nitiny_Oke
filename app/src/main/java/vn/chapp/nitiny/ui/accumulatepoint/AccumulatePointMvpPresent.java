package vn.chapp.nitiny.ui.accumulatepoint;

import vn.chapp.nitiny.base.MvpPresenter;
import vn.chapp.nitiny.models.auth.UserDefault;

public interface AccumulatePointMvpPresent<V extends AccumulatePointMvpView> extends MvpPresenter<V> {
    void getPointHistory(String shopId, String month, String year);
    UserDefault getUserDefault();
}
