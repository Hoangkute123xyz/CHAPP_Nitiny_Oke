package vn.chapp.nitiny.ui.cart;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import vn.chapp.nitiny.MainApp;
import vn.chapp.nitiny.base.BasePresenter;
import vn.chapp.nitiny.data.DataManager;
import vn.chapp.nitiny.data.network.models.Response;
import vn.chapp.nitiny.models.cart.Cart;


public class CartFrPresenter<V extends CartFrMvpView> extends BasePresenter<V> implements CartFrMvpPresent<V> {

    @Inject
    public CartFrPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager,compositeDisposable);
    }

    @Override
    public void doGetCart() {
        doNetworkRequest(MainApp.newInstance().getNetworking().getCart(getDataManager().getUserDefault().getId()),
                () -> getMvpView().showLoading(),
                () -> getMvpView().hideLoading(), new OnNetworkRequest<Response<List<Cart>>>() {
                    @Override
                    public void onNetworkRequestSuccess(Response<List<Cart>> response) {
                        if (response.isSuccessNonNull()) {
                            getMvpView().didGetCart(response.getData());
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
    public void doDeleteCart(String productId) {
        doNetworkRequest(MainApp.newInstance().getNetworking().deleteProtoCart(getDataManager().getUserDefault().getId(), productId),
                () -> getMvpView().showLoading(),
                () -> getMvpView().hideLoading(), new OnNetworkRequest<Response<Object>>() {
                    @Override
                    public void onNetworkRequestSuccess(Response<Object> response) {
                        if (response.isSuccess()) {
                            getMvpView().didDeleteCart();
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
    public void doEditCart(String productId, String number) {
        doNetworkRequest(MainApp.newInstance().getNetworking().editProtoCart(getDataManager().getUserDefault().getId(), productId, number),
                () -> getMvpView().showLoading(),
                () -> getMvpView().hideLoading(), new OnNetworkRequest<Response<Object>>() {
                    @Override
                    public void onNetworkRequestSuccess(Response<Object> response) {
                        if (response.isSuccess()) {
                            getMvpView().didEditCart();
                        } else {
                            getMvpView().showMessage(response.getMessage());
                        }
                    }

                    @Override
                    public void onNetworkRequestError(Throwable throwable) {

                    }
                });
    }

    public void doPlusCart(String productId, String number) {
        doNetworkRequest(MainApp.newInstance().getNetworking().PlusProtoCart(getDataManager().getUserDefault().getId(), productId, number),
                () -> getMvpView().showLoading(),
                () -> getMvpView().hideLoading(), new OnNetworkRequest<Response<Object>>() {
                    @Override
                    public void onNetworkRequestSuccess(Response<Object> response) {
                        if (response.isSuccess()) {
                            getMvpView().didPlusCart();
                        } else {
                            getMvpView().showMessage(response.getMessage());
                        }
                    }

                    @Override
                    public void onNetworkRequestError(Throwable throwable) {

                    }
                });
    }

    public void doMinusCart(String productId, String number) {
        doNetworkRequest(MainApp.newInstance().getNetworking().MinusProtoCart(getDataManager().getUserDefault().getId(), productId, number),
                () -> getMvpView().showLoading(),
                () -> getMvpView().hideLoading(), new OnNetworkRequest<Response<Object>>() {
                    @Override
                    public void onNetworkRequestSuccess(Response<Object> response) {
                        if (response.isSuccess()) {
                            getMvpView().didMinusCart();
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