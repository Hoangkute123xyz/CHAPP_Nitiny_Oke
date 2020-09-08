package vn.chapp.nitiny.ui.auth.login;

import vn.chapp.nitiny.base.MvpPresenter;


public interface LoginFrMvpPresent<V extends LoginFrMvpView> extends MvpPresenter<V> {
    boolean isValidateLogin(String phone, String password);
    void doLogin(String phone, String password);
    boolean isValidateLoginGoogle(String email, String ggid, String name);
    void doLoginGoogle(String email, String ggid, String name, String refCode);
    void doForgetPassword(String phone);
}
