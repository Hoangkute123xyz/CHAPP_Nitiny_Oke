package vn.chapp.nitiny.ui.starter;

import vn.chapp.nitiny.base.MvpPresenter;
import vn.chapp.nitiny.di.PerActivity;

@PerActivity
public interface StarterMvpPresenter<V extends StarterMvpView> extends MvpPresenter<V> {
}
