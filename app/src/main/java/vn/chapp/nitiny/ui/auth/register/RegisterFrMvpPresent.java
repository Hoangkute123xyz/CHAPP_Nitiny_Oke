package vn.chapp.nitiny.ui.auth.register;

import vn.chapp.nitiny.base.MvpPresenter;


public interface RegisterFrMvpPresent<V extends RegisterFrMvpView> extends MvpPresenter<V> {
    boolean isVerifyOTP(int otp, String inputOTP);
    boolean isVerifyRegisterInfo(String name, String phone, String password, String rePassword);
    void doRegisterInfo(int otp, String inputOTP, String name, String phone, String password, String rePassword, String refCode);
    void doSendOTP(String name, String phone, String password, String rePassword);
}
