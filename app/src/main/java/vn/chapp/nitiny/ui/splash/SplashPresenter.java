package vn.chapp.nitiny.ui.splash;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import vn.chapp.nitiny.base.BasePresenter;
import vn.chapp.nitiny.data.DataManager;

public class SplashPresenter<V extends SplashMvpView> extends BasePresenter<V> implements SplashMvpPresenter<V> {

    @Inject
    public SplashPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager,compositeDisposable);
    }

    @Override
    public boolean isLoggedIn() {
        return getDataManager().isLogin();
    }
}
