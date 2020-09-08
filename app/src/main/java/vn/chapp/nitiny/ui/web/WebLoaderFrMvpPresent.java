package vn.chapp.nitiny.ui.web;


import vn.chapp.nitiny.base.MvpPresenter;

public interface WebLoaderFrMvpPresent<V extends WebLoaderFrMvpView> extends MvpPresenter<V> {
    void getGuide();
}
