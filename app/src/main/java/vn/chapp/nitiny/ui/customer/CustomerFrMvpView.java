package vn.chapp.nitiny.ui.customer;

import java.util.List;

import vn.chapp.nitiny.base.MvpView;
import vn.chapp.nitiny.models.service.Shop;

public interface CustomerFrMvpView extends MvpView {
    void didGetShopLinked(List<Shop> listShopLinked);
    void setRefresh(boolean refresh);
}
