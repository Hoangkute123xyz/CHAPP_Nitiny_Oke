package vn.chapp.nitiny.ui.addCode;


import java.util.List;

import vn.chapp.nitiny.base.MvpView;
import vn.chapp.nitiny.models.service.Shop;

public interface AddCodeFrMvpView extends MvpView {
    void didAddShop(Integer idService);
    void didGetShopLinked(List<Shop> listShopLinked);
    void setRefresh(boolean refresh);
}
