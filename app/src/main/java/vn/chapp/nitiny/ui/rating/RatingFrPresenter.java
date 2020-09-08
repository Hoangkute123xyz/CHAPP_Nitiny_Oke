package vn.chapp.nitiny.ui.rating;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import vn.chapp.nitiny.MainApp;
import vn.chapp.nitiny.R;
import vn.chapp.nitiny.base.BasePresenter;
import vn.chapp.nitiny.data.DataManager;
import vn.chapp.nitiny.data.network.models.Response;
import vn.chapp.nitiny.models.service.Shop;


public class RatingFrPresenter<V extends RatingFrMvpView> extends BasePresenter<V> implements RatingFrMvpPresent<V> {

    @Inject
    public RatingFrPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager,compositeDisposable);
    }

    @Override
    public void doGetShopLinked() {
        doNetworkRequest(MainApp.newInstance().getNetworking().getListShopLinked(getDataManager().getUserDefault().getId(), null, "1"),
                () -> getMvpView().showLoading(),
                () -> getMvpView().hideLoading(), new OnNetworkRequest<Response<List<Shop>>>() {
                    @Override
                    public void onNetworkRequestSuccess(Response<List<Shop>> response) {
                        if (response.isSuccessNonNull()) {
                            getMvpView().parseShopLinked(response.getData());
                        }
                    }

                    @Override
                    public void onNetworkRequestError(Throwable throwable) {
                    }
                });
    }

    @Override
    public void ratingService(String serviceId, Float ratingShop, Float ratingStaff) {
        doNetworkRequest(MainApp.newInstance().getNetworking().postRating(getDataManager().getUserDefault().getId(), serviceId, ratingShop, ratingStaff),
                () -> getMvpView().showLoading(),
                () -> getMvpView().hideLoading(), new OnNetworkRequest<Response<Object>>() {
                    @Override
                    public void onNetworkRequestSuccess(Response<Object> response) {
                        if (response.isSuccess()) {
                            getMvpView().showMessage("Bạn đã gửi đánh giá thành công. Đóng góp của bạn sẽ giúp chúng tôi cải thiện dịch vụ tốt hơn.");
                        } else {
                            getMvpView().showMessage(R.string.message_unknow_error);
                        }
                    }

                    @Override
                    public void onNetworkRequestError(Throwable throwable) {
                        getMvpView().showMessage(R.string.message_unknow_error);
                    }
                });
    }
}
