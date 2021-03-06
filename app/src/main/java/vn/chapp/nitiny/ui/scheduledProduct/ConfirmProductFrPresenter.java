package vn.chapp.nitiny.ui.scheduledProduct;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import vn.chapp.nitiny.MainApp;
import vn.chapp.nitiny.base.BasePresenter;
import vn.chapp.nitiny.data.DataManager;
import vn.chapp.nitiny.data.network.models.Response;
import vn.chapp.nitiny.models.sale.Scheduled;

public class ConfirmProductFrPresenter<V extends ConfirmProductFrMvpView> extends BasePresenter<V> implements ConfirmProductFrMvpPresent<V> {

    @Inject
    public ConfirmProductFrPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void doBooking(Scheduled scheduled) {
        doNetworkRequest(MainApp.newInstance().getNetworking().postBooking(
                    getDataManager().getUserDefault().getId(),
                    scheduled.getShopId()+"",
                    MainApp.newInstance().getGson().toJson(scheduled.getListProduct()),
                    scheduled.getDateBooking(),
                    scheduled.getTimeBooking(),
                    scheduled.getNumber()+"",
                    scheduled.getTotalMoney()+"",
                    scheduled.getNote(),
                    scheduled.getAddress(),
                    scheduled.getIsReceive()+"",
                    scheduled.getType()+"",
                    String.valueOf(scheduled.getPayment()),
                    scheduled.getPhone()
                ),
                () -> getMvpView().showLoading(),
                () -> getMvpView().hideLoading(), new OnNetworkRequest<Response<Integer>>() {
                    @Override
                    public void onNetworkRequestSuccess(Response<Integer> response) {
                        if (response.isSuccessNonNull()) {
                            getMvpView().didBooking();
                        }
                    }

                    @Override
                    public void onNetworkRequestError(Throwable throwable) {
                    }
                });
    }
}
