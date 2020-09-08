package vn.chapp.nitiny.ui.splash;

import vn.chapp.nitiny.base.MvpPresenter;
import vn.chapp.nitiny.di.PerActivity;

@PerActivity
public interface SplashMvpPresenter<V extends SplashMvpView> extends MvpPresenter<V> {
    boolean isLoggedIn();
}
