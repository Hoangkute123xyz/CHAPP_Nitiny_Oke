package vn.chapp.nitiny.ui.web;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import vn.chapp.nitiny.MainApp;
import vn.chapp.nitiny.base.BasePresenter;
import vn.chapp.nitiny.data.DataManager;
import vn.chapp.nitiny.data.network.models.Response;
import vn.chapp.nitiny.models.guide.GuideResponse;


public class WebLoaderFrPresenter<V extends WebLoaderFrMvpView> extends BasePresenter<V> implements WebLoaderFrMvpPresent<V> {

    @Inject
    public WebLoaderFrPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager,compositeDisposable);
    }

    @Override
    public void getGuide() {
        doNetworkRequest(MainApp.newInstance().getNetworking().getGuide(),
                () -> getMvpView().showLoading(),
                () -> getMvpView().hideLoading(), new OnNetworkRequest<Response<GuideResponse>>() {
                    @Override
                    public void onNetworkRequestSuccess(Response<GuideResponse> response) {
                        if (response.isSuccessNonNull()) {
                            getMvpView().parseContent(response.getData());
                        }
                    }

                    @Override
                    public void onNetworkRequestError(Throwable throwable) {

                    }
                });
    }
}
