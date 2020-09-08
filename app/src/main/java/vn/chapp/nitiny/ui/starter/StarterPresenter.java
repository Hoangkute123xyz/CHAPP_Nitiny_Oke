package vn.chapp.nitiny.ui.starter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import vn.chapp.nitiny.base.BasePresenter;
import vn.chapp.nitiny.data.DataManager;

public class StarterPresenter<V extends StarterMvpView> extends BasePresenter<V> implements StarterMvpPresenter<V> {

    @Inject
    public StarterPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager,compositeDisposable);
    }
}
