package vn.chapp.nitiny.ui.main;

import vn.chapp.nitiny.base.MvpPresenter;
import vn.chapp.nitiny.di.PerActivity;

@PerActivity
public interface BackableMvpPresenter<V extends BackableMvpView> extends MvpPresenter<V> {
}
