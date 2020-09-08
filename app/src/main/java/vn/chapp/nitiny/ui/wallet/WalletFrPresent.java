package vn.chapp.nitiny.ui.wallet;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import vn.chapp.nitiny.MainApp;
import vn.chapp.nitiny.base.BasePresenter;
import vn.chapp.nitiny.data.DataManager;
import vn.chapp.nitiny.data.network.models.Response;
import vn.chapp.nitiny.models.wallet.WalletHistory;
import vn.chapp.nitiny.utils.AppConstants;

public class WalletFrPresent <V extends WalletFrMvpView> extends BasePresenter<V> implements WalletFrMvpPresent<V> {

    @Inject
    public WalletFrPresent(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void getWallet() {
        doNetworkRequest(MainApp.newInstance().getNetworking().getWallet(getDataManager().getUserDefault().getId(), AppConstants.APP_TYPE),
                () -> getMvpView().showLoading(),
                () -> getMvpView().hideLoading(), new OnNetworkRequest<Response<WalletHistory>>() {
                    @Override
                    public void onNetworkRequestSuccess(Response<WalletHistory> response) {
                        if (response.isSuccessNonNull()) {
                            getMvpView().gotWallet(response.getData());
                            getMvpView().setRefresh(false);
                            MainApp.newInstance().setBalance(response.getData().getAccount());
                        }
                    }

                    @Override
                    public void onNetworkRequestError(Throwable throwable) {
                        getMvpView().showMessage("Có lỗi xảy ra");
                    }
                });
    }

}
