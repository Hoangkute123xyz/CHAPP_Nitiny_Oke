package vn.chapp.nitiny.ui.history;

import java.util.List;

import vn.chapp.nitiny.base.MvpView;
import vn.chapp.nitiny.models.service.HistoryResponse;
import vn.chapp.nitiny.models.service.ServiceResponse;
import vn.chapp.nitiny.models.service.Shop;

public interface HistoryFrMvpView extends MvpView {
    void didGetShopLinked(List<Shop> shops);
    void gotServices(List<ServiceResponse> serviceResponses);
    void gotHistory(List<HistoryResponse> historyResponses);
}
