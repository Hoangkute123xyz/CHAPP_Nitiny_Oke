package vn.chapp.nitiny.ui.sample;

import vn.chapp.nitiny.base.MvpPresenter;
import vn.chapp.nitiny.di.PerActivity;

@PerActivity
public interface SampleMvpPresenter<V extends SampleMvpView> extends MvpPresenter<V> {
}
