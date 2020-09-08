package vn.chapp.nitiny.ui.auth;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import vn.chapp.nitiny.base.BasePresenter;
import vn.chapp.nitiny.data.DataManager;

public class AuthPresenter<V extends AuthMvpView> extends BasePresenter<V> implements AuthMvpPresenter<V> {

    @Inject
    public AuthPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager,compositeDisposable);
    }
}
