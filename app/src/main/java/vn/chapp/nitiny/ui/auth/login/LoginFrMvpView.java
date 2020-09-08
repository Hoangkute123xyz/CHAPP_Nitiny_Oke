package vn.chapp.nitiny.ui.auth.login;


import vn.chapp.nitiny.base.MvpView;
import vn.chapp.nitiny.models.auth.UserDefault;

public interface LoginFrMvpView extends MvpView {
    void didLogin(UserDefault userDefault);
    void didForgetPassword(String phone, int otp);
}
