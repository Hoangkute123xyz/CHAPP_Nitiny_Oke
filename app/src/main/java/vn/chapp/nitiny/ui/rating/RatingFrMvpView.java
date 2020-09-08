package vn.chapp.nitiny.ui.rating;


import java.util.List;

import vn.chapp.nitiny.base.MvpView;
import vn.chapp.nitiny.models.service.Shop;

public interface RatingFrMvpView extends MvpView {
    void parseShopLinked(List<Shop> shops);
}
