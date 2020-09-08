package vn.chapp.nitiny.ui.auth;

import vn.chapp.nitiny.base.MvpPresenter;


public interface ChangePasswordFrMvpPresent<V extends ChangePasswordFrMvpView> extends MvpPresenter<V> {

    boolean isValidate(String oldPassword, String newPassword, String rePassword);
    void doChangePassword(String oldPassword, String newPassword, String rePassword);


}
