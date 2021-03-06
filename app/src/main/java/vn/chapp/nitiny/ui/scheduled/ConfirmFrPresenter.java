package vn.chapp.nitiny.ui.scheduled;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import vn.chapp.nitiny.MainApp;
import vn.chapp.nitiny.base.BasePresenter;
import vn.chapp.nitiny.data.DataManager;
import vn.chapp.nitiny.data.network.models.Response;
import vn.chapp.nitiny.models.sale.Scheduled;

public class ConfirmFrPresenter<V extends ConfirmFrMvpView> extends BasePresenter<V> implements ConfirmFrMvpPresent<V> {

    @Inject
    public ConfirmFrPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void doBooking(Scheduled scheduled) {
        doNetworkRequest(MainApp.newInstance().getNetworking().postBookingService(
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
                    String.valueOf(scheduled.getListProduct().get(0).getProductId()),
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
