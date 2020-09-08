package vn.chapp.nitiny.ui.tichDiem;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import vn.chapp.nitiny.MainApp;
import vn.chapp.nitiny.base.BasePresenter;
import vn.chapp.nitiny.data.DataManager;
import vn.chapp.nitiny.data.network.models.Response;
import vn.chapp.nitiny.models.auth.UserDefault;
import vn.chapp.nitiny.models.point.PointResponse;

public class TichDiemPresenter<V extends TichDiemMvpView> extends BasePresenter<V> implements TichDiemMvpPresent<V> {

    @Inject
    public TichDiemPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void getPointHistory() {
        doNetworkRequest(MainApp.newInstance().getNetworking().getPoint(getDataManager().getUserDefault().getId()),
                () -> { },
                () -> { }, new OnNetworkRequest<Response<List<PointResponse>>>() {
                    @Override
                    public void onNetworkRequestSuccess(Response<List<PointResponse>> response) {
                        if (response.isSuccessNonNull()) {
                            getMvpView().parsePointHistory(response.getData());
                        }
                    }

                    @Override
                    public void onNetworkRequestError(Throwable throwable) {

                    }
                });
    }

    @Override
    public UserDefault getUserDefault() {
        return getDataManager().getUserDefault();
    }
}