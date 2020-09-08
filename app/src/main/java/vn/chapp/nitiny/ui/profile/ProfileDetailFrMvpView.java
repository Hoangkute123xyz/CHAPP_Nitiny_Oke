package vn.chapp.nitiny.ui.profile;


import java.util.List;

import vn.chapp.nitiny.base.MvpView;
import vn.chapp.nitiny.models.auth.UserDefault;
import vn.chapp.nitiny.models.map.Address;
import vn.chapp.nitiny.models.map.PredictionsItem;

public interface ProfileDetailFrMvpView extends MvpView {
    void parseUserDetail(UserDefault userDefault);
    void didUploadAvatar(String url);
    void didUpdateProfile(String address, String email, String name, String phone);
    void gotPlaces(List<PredictionsItem> predictionsItems, List<String> placeAddress);
    void gotPlaceDetail(Address address);
}
