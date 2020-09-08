package vn.chapp.nitiny.ui.detail;

import vn.chapp.nitiny.base.MvpPresenter;


public interface DetailPromotionFrMvpPresent<V extends DetailPromotionFrMvpView> extends MvpPresenter<V> {

    void getNewsDetail(String id);

}
