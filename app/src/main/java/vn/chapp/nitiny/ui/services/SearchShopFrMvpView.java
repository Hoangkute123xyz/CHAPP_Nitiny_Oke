package vn.chapp.nitiny.ui.services;


import java.util.List;

import vn.chapp.nitiny.base.MvpView;
import vn.chapp.nitiny.models.service.Shop;

public interface SearchShopFrMvpView extends MvpView {
    void didRefresh();
    void didSearchShop(List<Shop> shops);
    void didAddShop(int idService, int shopId);
}
