package vn.chapp.nitiny.ui.auth;

import vn.chapp.nitiny.base.MvpPresenter;
import vn.chapp.nitiny.di.PerActivity;

@PerActivity
public interface AuthMvpPresenter<V extends AuthMvpView> extends MvpPresenter<V> {
}
