package vn.chapp.nitiny.ui.profile;

import vn.chapp.nitiny.base.MvpPresenter;

public interface ProfileFrMvpPresent<V extends ProfileFrMvpView> extends MvpPresenter<V> {
    void getUserDefault();
}
