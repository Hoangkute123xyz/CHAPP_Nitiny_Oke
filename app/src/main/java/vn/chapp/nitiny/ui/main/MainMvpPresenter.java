package vn.chapp.nitiny.ui.main;

import vn.chapp.nitiny.base.MvpPresenter;
import vn.chapp.nitiny.di.PerActivity;
import vn.chapp.nitiny.models.auth.UserDefault;

@PerActivity
public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {
    void doLogout();
    UserDefault getUserDefault();
}
