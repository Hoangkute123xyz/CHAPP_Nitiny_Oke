package vn.chapp.nitiny.ui.addCode;

import android.text.TextUtils;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import vn.chapp.nitiny.MainApp;
import vn.chapp.nitiny.R;
import vn.chapp.nitiny.base.BasePresenter;
import vn.chapp.nitiny.data.DataManager;
import vn.chapp.nitiny.data.network.models.Response;
import vn.chapp.nitiny.models.service.Shop;


public class AddCodeFrPresenter<V extends AddCodeFrMvpView> extends BasePresenter<V> implements AddCodeFrMvpPresent<V> {

    @Inject
    public AddCodeFrPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager,compositeDisposable);
    }

    @Override
    public void doAddService(String code) {
        if(isValidateAddService(code)) {
            getMvpView().hideKeyboard();
            doNetworkRequest(MainApp.newInstance().getNetworking().getAddShop(getDataManager().getUserDefault().getId(), code),
                    () -> getMvpView().showLoading(),
                    () -> getMvpView().hideLoading(),
                    new OnNetworkRequest<Response<Integer>>() {
                        @Override
                        public void onNetworkRequestSuccess(Response<Integer> response) {
                            if (response.isSuccessNonNull()) {
                                getMvpView().didAddShop(response.getData());
                            } else {
                                getMvpView().showMessage(response.getMessage());
                            }
                        }

                        @Override
                        public void onNetworkRequestError(Throwable throwable) {
                            getMvpView().showMessage(R.string.message_unknow_error);
                        }
                    });
        }
    }

    @Override
    public void doGetShopLinked() {
        doNetworkRequest(MainApp.newInstance().getNetworking().getListShopLinked(getDataManager().getUserDefault().getId(), null, "1"),
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
    public boolean isValidateAddService(String code) {
        if (TextUtils.isEmpty(code)) {
            getMvpView().showMessage(R.string.msg_error_empty_code);
            return false;
        }
        return true;
    }
}
