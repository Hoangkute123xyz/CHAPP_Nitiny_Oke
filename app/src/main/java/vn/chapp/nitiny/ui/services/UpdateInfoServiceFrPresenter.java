package vn.chapp.nitiny.ui.services;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import vn.chapp.nitiny.base.BasePresenter;
import vn.chapp.nitiny.data.DataManager;


public class UpdateInfoServiceFrPresenter<V extends UpdateInfoServiceFrMvpView> extends BasePresenter<V> implements UpdateInfoServiceFrMvpPresent<V> {

    @Inject
    public UpdateInfoServiceFrPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager,compositeDisposable);
    }
}
