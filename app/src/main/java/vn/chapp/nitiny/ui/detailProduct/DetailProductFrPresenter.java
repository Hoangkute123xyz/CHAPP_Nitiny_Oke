package vn.chapp.nitiny.ui.detailProduct;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import vn.chapp.nitiny.MainApp;
import vn.chapp.nitiny.base.BasePresenter;
import vn.chapp.nitiny.data.DataManager;
import vn.chapp.nitiny.data.network.models.Response;

public class DetailProductFrPresenter<V extends DetailProductFrMvpView> extends BasePresenter<V> implements DetailProductFrMvpPresent<V> {

    @Inject
    public DetailProductFrPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    /*@Override
    public void doGetDetailBooking(int idBooking) {
        doNetworkRequest(MainApp.newInstance().getNetworking().getDetailBooking(String.valueOf(idBooking)),
                () -> getMvpView().showLoading(),
                () -> getMvpView().hideLoading(), new OnNetworkRequest<Response<DetailBooking>>() {
                    @Override
                    public void onNetworkRequestSuccess(Response<DetailBooking> response) {
                        if (response.isSuccessNonNull()) {
                            getMvpView().didGetDetailBooking(response.getData());
                        } else {
                            getMvpView().showMessage(response.getMessage());
                        }
                    }

                    @Override
                    public void onNetworkRequestError(Throwable throwable) {
                    }
                });
    }*/
    @Override
    public void doAddProductToCart(String productId) {
        doNetworkRequest(MainApp.newInstance().getNetworking().addProtoCart(getDataManager().getUserDefault().getId(), productId),
                () -> getMvpView().showLoading(),
                () -> getMvpView().hideLoading(), new OnNetworkRequest<Response<Object>>() {
                    @Override
                    public void onNetworkRequestSuccess(Response<Object> response) {
                        if (response.isSuccess()) {
                            getMvpView().didAddProductToCart();
                        }
                    }

                    @Override
                    public void onNetworkRequestError(Throwable throwable) {
                    }
                });
    }
    //them va sua hàm (tham khảo từ các phần liên quan Cart)
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
    




}
