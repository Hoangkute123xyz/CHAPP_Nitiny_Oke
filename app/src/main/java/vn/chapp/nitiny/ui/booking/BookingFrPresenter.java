package vn.chapp.nitiny.ui.booking;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import vn.chapp.nitiny.MainApp;
import vn.chapp.nitiny.base.BasePresenter;
import vn.chapp.nitiny.data.DataManager;
import vn.chapp.nitiny.data.network.models.Response;
import vn.chapp.nitiny.models.booking.Booking;

public class BookingFrPresenter<V extends BookingFrMvpView> extends BasePresenter<V> implements BookingFrMvpPresent<V> {

    @Inject
    public BookingFrPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void getListBooking(String active) {
        if(active!=null && !active.isEmpty() && active!="0" && active!="null") {
            doNetworkRequest(MainApp.newInstance().getNetworking().getListBooking(getDataManager().getUserDefault().getId(),active),
                    () -> getMvpView().showLoading(),
                    () -> {
                        getMvpView().hideLoading();
                    }, new OnNetworkRequest<Response<List<Booking>>>() {
                        @Override
                        public void onNetworkRequestSuccess(Response<List<Booking>> response) {
                            if (response.isSuccessNonNull()) {
                                getMvpView().didGetListBooking(response.getData());
                            } else {
                                getMvpView().showMessage(response.getMessage());
                            }
                        }

                        @Override
                        public void onNetworkRequestError(Throwable throwable) {

                        }
                    });
        } else {
            doNetworkRequest(MainApp.newInstance().getNetworking().getListBooking(getDataManager().getUserDefault().getId()),
                    () -> getMvpView().showLoading(),
                    () -> {
                        getMvpView().hideLoading();
                    }, new OnNetworkRequest<Response<List<Booking>>>() {
                        @Override
                        public void onNetworkRequestSuccess(Response<List<Booking>> response) {
                            if (response.isSuccessNonNull()) {
                                getMvpView().didGetListBooking(response.getData());
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

    @Override
    public void updateStatusBooking(int position, Booking booking, int active) {
        doNetworkRequest(MainApp.newInstance().getNetworking().updateStatusBooking(getDataManager().getUserDefault().getId(),String.valueOf(booking.getId()),active),
                () -> getMvpView().showLoading(),
                () -> getMvpView().hideLoading(), new OnNetworkRequest<Response<Object>>() {
                    @Override
                    public void onNetworkRequestSuccess(Response<Object> response) {
                        if (response.isSuccessNonNull()) {
                            getMvpView().didUpdatedBooking(position, active);
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
