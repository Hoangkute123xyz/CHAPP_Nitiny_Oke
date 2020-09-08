package vn.chapp.nitiny.ui.tichDiem;

import vn.chapp.nitiny.base.MvpPresenter;
import vn.chapp.nitiny.models.auth.UserDefault;

public interface TichDiemMvpPresent<V extends TichDiemMvpView> extends MvpPresenter<V> {
    void getPointHistory();
    UserDefault getUserDefault();
}
