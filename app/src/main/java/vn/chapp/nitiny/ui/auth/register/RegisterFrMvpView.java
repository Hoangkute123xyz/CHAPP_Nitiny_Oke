package vn.chapp.nitiny.ui.auth.register;


import vn.chapp.nitiny.base.MvpView;
import vn.chapp.nitiny.models.auth.UserDefault;

public interface RegisterFrMvpView extends MvpView {
    void didVerifyOTP(int code);
    void didRegister(UserDefault userDefault);
}
