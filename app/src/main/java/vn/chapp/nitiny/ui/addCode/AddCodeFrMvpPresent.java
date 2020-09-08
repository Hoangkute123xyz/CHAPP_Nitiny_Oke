package vn.chapp.nitiny.ui.addCode;

import vn.chapp.nitiny.base.MvpPresenter;


public interface AddCodeFrMvpPresent<V extends AddCodeFrMvpView> extends MvpPresenter<V> {
    void doAddService(String code);
    void doGetShopLinked();
    boolean isValidateAddService(String code);
}
