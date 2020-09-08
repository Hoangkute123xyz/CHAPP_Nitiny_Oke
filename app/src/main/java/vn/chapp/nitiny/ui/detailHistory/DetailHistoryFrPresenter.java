package vn.chapp.nitiny.ui.detailHistory;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import vn.chapp.nitiny.MainApp;
import vn.chapp.nitiny.base.BasePresenter;
import vn.chapp.nitiny.data.DataManager;
import vn.chapp.nitiny.data.network.models.Response;
import vn.chapp.nitiny.models.booking.DetailBooking;

public class DetailHistoryFrPresenter<V extends DetailHistoryFrMvpView> extends BasePresenter<V> implements DetailHistoryFrMvpPresent<V> {

    @Inject
    public DetailHistoryFrPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
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
    }
}