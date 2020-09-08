package vn.chapp.nitiny.ui.services;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import vn.chapp.nitiny.MainApp;
import vn.chapp.nitiny.R;
import vn.chapp.nitiny.base.BasePresenter;
import vn.chapp.nitiny.data.DataManager;
import vn.chapp.nitiny.data.network.models.Response;
import vn.chapp.nitiny.models.banner.BannerResponse;
import vn.chapp.nitiny.models.service.Service;
import vn.chapp.nitiny.models.wallet.WalletHistory;
import vn.chapp.nitiny.utils.AppConstants;


public class LinkServiceFrPresenter<V extends LinkServiceFrMvpView> extends BasePresenter<V> implements LinkServiceFrMvpPresent<V> {

    @Inject
    public LinkServiceFrPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager,compositeDisposable);
    }

    @Override
    public void loadService(int type) {
        getMvpView().hideKeyboard();
        doNetworkRequest(MainApp.newInstance().getNetworking().getListService(getDataManager().getUserDefault().getId(), type),
                () -> getMvpView().showLoading(),
                () -> getMvpView().hideLoading(),
                new OnNetworkRequest<Response<List<Service>>>() {
                    @Override
                    public void onNetworkRequestSuccess(Response<List<Service>> response) {
                        if(response.isSuccessNonNull()) {
                            getMvpView().didGetListService(response.getData());
                        }
                    }

                    @Override
                    public void onNetworkRequestError(Throwable throwable) {
                        getMvpView().showMessage(R.string.message_unknow_error);
                    }
                });
    }

    @Override
    public void loadServiceLinked(int type) {
        getMvpView().hideKeyboard();
        doNetworkRequest(MainApp.newInstance().getNetworking().getListService(getDataManager().getUserDefault().getId(), type),
                () -> getMvpView().showLoading(),
                () -> getMvpView().hideLoading(),
                new OnNetworkRequest<Response<List<Service>>>() {
                    @Override
                    public void onNetworkRequestSuccess(Response<List<Service>> response) {
                        if(response.isSuccessNonNull()) {
                            getMvpView().didGetListServiceLinked(response.getData());
                        }
                    }

                    @Override
                    public void onNetworkRequestError(Throwable throwable) {
                        getMvpView().showMessage(R.string.message_unknow_error);
                    }
                });
    }

    @Override
    public void getBanners() {
        doNetworkRequest(MainApp.newInstance().getNetworking().getBanners(),
                () -> {},
                () -> {}, new OnNetworkRequest<Response<List<BannerResponse>>>() {
                    @Override
                    public void onNetworkRequestSuccess(Response<List<BannerResponse>> response) {
                        if (response.isSuccessNonNull()) {
                            getMvpView().gotBanners(response.getData());
                        }
                    }

                    @Override
                    public void onNetworkRequestError(Throwable throwable) {

                    }
                });
    }

    @Override
    public void getWallet() {
        doNetworkRequest(MainApp.newInstance().getNetworking().getWallet(getDataManager().getUserDefault().getId(), AppConstants.APP_TYPE),
                () -> getMvpView().showLoading(),
                () -> getMvpView().hideLoading(), new OnNetworkRequest<Response<WalletHistory>>() {
                    @Override
                    public void onNetworkRequestSuccess(Response<WalletHistory> response) {
                        if (response.isSuccessNonNull()) {
                            MainApp.newInstance().setBalance(response.getData().getAccount());
                        }
                    }

                    @Override
                    public void onNetworkRequestError(Throwable throwable) {

                    }
                });
    }


}
