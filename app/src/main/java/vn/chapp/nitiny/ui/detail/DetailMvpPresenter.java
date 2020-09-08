package vn.chapp.nitiny.ui.detail;

import vn.chapp.nitiny.base.MvpPresenter;
import vn.chapp.nitiny.di.PerActivity;

@PerActivity
public interface DetailMvpPresenter<V extends DetailMvpView> extends MvpPresenter<V> {
}
