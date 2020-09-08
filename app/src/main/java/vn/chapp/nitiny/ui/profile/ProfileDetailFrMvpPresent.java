package vn.chapp.nitiny.ui.profile;
import vn.chapp.nitiny.base.MvpPresenter;
import vn.chapp.nitiny.models.map.Address;


public interface ProfileDetailFrMvpPresent<V extends ProfileDetailFrMvpView> extends MvpPresenter<V> {
    void getUserDefault();
    void doUploadAvatar(String path);
    void getUserDetail();
    void doUpdateProfile(Address address, String email, String name, String phone);
    void startSearchPlace(String s);
    void getDetailPlace(String placeId);
}
