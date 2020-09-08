package vn.chapp.nitiny.ui.shopLinked;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import vn.chapp.nitiny.MainApp;
import vn.chapp.nitiny.base.BasePresenter;
import vn.chapp.nitiny.data.DataManager;
import vn.chapp.nitiny.data.network.models.Response;
import vn.chapp.nitiny.models.service.Shop;


public class ShopLinkedFrPresenter<V extends ShopLinkedFrMvpView> extends BasePresenter<V> implements ShopLinkedFrMvpPresent<V> {

    @Inject
    public ShopLinkedFrPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager,compositeDisposable);
    }

    @Override
    public void doGetShopLinked(int serviceId, int type) {
        doNetworkRequest(MainApp.newInstance().getNetworking().getListShopLinked(getDataManager().getUserDefault().getId(), String.valueOf(serviceId), String.valueOf(type)),
                () -> getMvpView().showLoading(),
                () -> {
                    getMvpView().setRefresh(false);
                    getMvpView().hideLoading();
                }, new OnNetworkRequest<Response<List<Shop>>>() {
                    @Override
                    public void onNetworkRequestSuccess(Response<List<Shop>> response) {
                        if (response.isSuccessNonNull()) {
                            getMvpView().didGetShopLinked(response.getData());
                        } else {
                            getMvpView().showMessage(response.getMessage());
                        }
                    }

                    @Override
                    public void onNetworkRequestError(Throwable throwable) {
                    }
                });
    }

    @Override
    public void doUnLink(String shopId) {
        doNetworkRequest(MainApp.newInstance().getNetworking().unLinkShop(getDataManager().getUserDefault().getId(), shopId),
                () -> getMvpView().showLoading(),
                () -> {
                    getMvpView().setRefresh(false);
                    getMvpView().hideLoading();
                }, new OnNetworkRequest<Response<Object>>() {
                    @Override
                    public void onNetworkRequestSuccess(Response<Object> response) {
                        if (response.isSuccess()) {
                            getMvpView().didUnLink();
                        } else {
                            getMvpView().showMessage(response.getMessage());
                        }
                    }

                    @Override
                    public void onNetworkRequestError(Throwable throwable) {
                    }
                });
    }

}
