package vn.chapp.nitiny.ui.shop;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import vn.chapp.nitiny.MainApp;
import vn.chapp.nitiny.base.BasePresenter;
import vn.chapp.nitiny.data.DataManager;
import vn.chapp.nitiny.data.network.models.Response;
import vn.chapp.nitiny.models.service.ListProducts;
import vn.chapp.nitiny.models.service.Shop;

public class ShopDetailFrPresenter<V extends ShopDetailFrMvpView> extends BasePresenter<V> implements ShopDetailFrMvpPresent<V> {

    @Inject
    public ShopDetailFrPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void doGetListShop(String idService, String type) {
        doNetworkRequest(MainApp.newInstance().getNetworking().getListShopLinked(getDataManager().getUserDefault().getId(), idService, type),
                () -> getMvpView().showLoading(),
                () -> getMvpView().hideLoading(), new OnNetworkRequest<Response<List<Shop>>>() {
                    @Override
                    public void onNetworkRequestSuccess(Response<List<Shop>> response) {
                        if (response.isSuccessNonNull()) {
                            getMvpView().didGetListShop(response.getData());
                        }
                    }

                    @Override
                    public void onNetworkRequestError(Throwable throwable) {
                    }
                });
    }

    @Override
    public void doGetShopDetail(String shopId) {
        doNetworkRequest(MainApp.newInstance().getNetworking().getProducts(getDataManager().getUserDefault().getId()),
                () -> getMvpView().showLoading(),
                () -> getMvpView().hideLoading(), new OnNetworkRequest<Response<ListProducts>>() {
                    @Override
                    public void onNetworkRequestSuccess(Response<ListProducts> response) {
                        if (response.isSuccessNonNull()) {
                            getMvpView().didGetShopDetail(response.getData());
                        }
                    }

                    @Override
                    public void onNetworkRequestError(Throwable throwable) {
                    }
                });
    }

    @Override
    public void getBanners() {
        doNetworkRequest(MainApp.newInstance().getNetworking().getBanner(),
                () -> {},
                () -> {}, new OnNetworkRequest<Response<List<String>>>() {
                    @Override
                    public void onNetworkRequestSuccess(Response<List<String>> response) {
                        if (response.isSuccessNonNull()) {

                            getMvpView().gotBanners(response.getData());
                        }
                    }

                    @Override
                    public void onNetworkRequestError(Throwable throwable) {

                    }
                });
    }
}
