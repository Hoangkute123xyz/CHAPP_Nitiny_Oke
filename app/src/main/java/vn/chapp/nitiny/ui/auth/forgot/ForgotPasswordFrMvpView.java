package vn.chapp.nitiny.ui.auth.forgot;


import vn.chapp.nitiny.base.MvpView;
import vn.chapp.nitiny.models.auth.UserDefault;

public interface ForgotPasswordFrMvpView extends MvpView {
    void didGetOTP(int otp);
    void didLogin(UserDefault userDefault);
}
