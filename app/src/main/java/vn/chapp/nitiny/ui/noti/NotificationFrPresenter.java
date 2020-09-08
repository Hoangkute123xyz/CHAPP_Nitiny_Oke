package vn.chapp.nitiny.ui.noti;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import vn.chapp.nitiny.MainApp;
import vn.chapp.nitiny.base.BasePresenter;
import vn.chapp.nitiny.data.DataManager;
import vn.chapp.nitiny.data.network.models.Response;
import vn.chapp.nitiny.models.noti.Notify;

public class NotificationFrPresenter<V extends NotificationFrMvpView> extends BasePresenter<V> implements NotificationFrMvpPresent<V> {

    @Inject
    public NotificationFrPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void doGetNoti() {
        doNetworkRequest(MainApp.newInstance().getNetworking().getNoti(getDataManager().getUserDefault().getId()),
                () -> getMvpView().showLoading(),
                () -> getMvpView().hideLoading(), new OnNetworkRequest<Response<List<Notify>>>() {
                    @Override
                    public void onNetworkRequestSuccess(Response<List<Notify>> response) {
                        if (response.isSuccessNonNull()) {
                            getMvpView().didGetNoti(response.getData());
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
