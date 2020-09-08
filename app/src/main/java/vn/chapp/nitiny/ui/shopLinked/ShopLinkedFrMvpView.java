package vn.chapp.nitiny.ui.shopLinked;


import java.util.List;

import vn.chapp.nitiny.base.MvpView;
import vn.chapp.nitiny.models.service.Shop;

public interface ShopLinkedFrMvpView extends MvpView {
    void didGetShopLinked(List<Shop> listShopLinked);
    void setRefresh(boolean refresh);
    void didUnLink();
}
