package vn.chapp.nitiny.ui.detail;

import vn.chapp.nitiny.base.MvpPresenter;


public interface DetailNewsFrMvpPresent<V extends DetailNewsFrMvpView> extends MvpPresenter<V> {

    void getNewsDetail(String id);

}
