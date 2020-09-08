package vn.chapp.nitiny.ui.profile;

import vn.chapp.nitiny.base.MvpView;
import vn.chapp.nitiny.models.auth.UserDefault;

public interface ProfileFrMvpView extends MvpView {
    void parseUserDefault(UserDefault userDefault);
}
