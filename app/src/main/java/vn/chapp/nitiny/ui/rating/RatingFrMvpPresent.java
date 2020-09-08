package vn.chapp.nitiny.ui.rating;

import vn.chapp.nitiny.base.MvpPresenter;


public interface RatingFrMvpPresent<V extends RatingFrMvpView> extends MvpPresenter<V> {
    void doGetShopLinked();
    void ratingService(String serviceId, Float ratingShop, Float ratingStaff);
}
