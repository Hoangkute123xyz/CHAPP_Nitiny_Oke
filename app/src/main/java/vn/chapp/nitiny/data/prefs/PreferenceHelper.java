package vn.chapp.nitiny.data.prefs;


import vn.chapp.nitiny.models.auth.UserDefault;

public interface PreferenceHelper {
    void setUserDefault(UserDefault userDefault);
    UserDefault getUserDefault();

    void setIsLogin(boolean isLogin);
    boolean isLogin();

    void logout();

    void setTokenFirebase(String tokenFirebase);
    String getTokenFirebase();
}
