package vn.chapp.nitiny.ui.services;


import java.util.List;

import vn.chapp.nitiny.base.MvpView;
import vn.chapp.nitiny.models.banner.BannerResponse;
import vn.chapp.nitiny.models.service.Service;

public interface LinkServiceFrMvpView extends MvpView {
    void didGetListService(List<Service> listService);
    void gotBanners(List<BannerResponse> bannerResponses);
    void didGetListServiceLinked(List<Service> listService);
}
