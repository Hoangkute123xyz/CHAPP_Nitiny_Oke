package vn.chapp.nitiny.ui.location;

import android.content.Context;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.model.LatLng;

import vn.chapp.nitiny.base.MvpPresenter;


public interface ChooseLocationMvpPresent<V extends ChooseLocationMvpView> extends MvpPresenter<V> {

    void startSearchPlace(String s);
    void getCurrentLocation(FusedLocationProviderClient fusedLocationProviderClient);
    void onStartMoveMapCamera();
    void onCameraMapIdle(Context context, LatLng latLng);
    void getDetailPlace(String placeId);
    void removeDisposable();
    void getMarkAddress(String address);
    void getDetailMarkPlace(String placeId);
    void getDetailBestPlace(String latlng);
}