package vn.chapp.nitiny.ui.shop;

import java.util.List;

import vn.chapp.nitiny.base.MvpView;
import vn.chapp.nitiny.models.service.ListProducts;
import vn.chapp.nitiny.models.service.Shop;

public interface ShopDetailFrMvpView extends MvpView {
    void didGetListShop(List<Shop> listShop);
    void didGetShopDetail(ListProducts products);
    void gotBanners(List<String> bannerResponses);
}
