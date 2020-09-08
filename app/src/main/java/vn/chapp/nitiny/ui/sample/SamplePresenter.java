package vn.chapp.nitiny.ui.sample;

import vn.chapp.nitiny.base.BasePresenter;
import vn.chapp.nitiny.data.DataManager;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class SamplePresenter<V extends SampleMvpView> extends BasePresenter<V> implements SampleMvpPresenter<V> {

    @Inject
    public SamplePresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager,compositeDisposable);
    }
}
