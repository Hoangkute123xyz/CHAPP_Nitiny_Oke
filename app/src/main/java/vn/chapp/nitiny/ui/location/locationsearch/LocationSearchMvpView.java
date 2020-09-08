package vn.chapp.nitiny.ui.location.locationsearch;

import android.location.Location;

import java.util.List;

import vn.chapp.nitiny.base.MvpView;
import vn.chapp.nitiny.models.map.Address;
import vn.chapp.nitiny.models.map.PredictionsItem;

public interface LocationSearchMvpView extends MvpView {

    void onGotCurrentLocation(Location location);

    void onGotAddr(Address addr);

    void onFailGotAddr();

    void displayPlaces(List<PredictionsItem> places);

    void gotPlaceDetail(Address address);

    void clearSearch();

    void gotMarkAddress(Address address);

    void moveToCurrentLocation();

}
