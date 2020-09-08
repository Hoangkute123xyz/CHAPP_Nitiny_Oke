package vn.chapp.nitiny.ui.sample;

import vn.chapp.nitiny.base.BasePresenter;
import vn.chapp.nitiny.data.DataManager;
import javax.inject.Inject;
import io.reactivex.disposables.CompositeDisposable;


public class SampleFrPresenter<V extends SampleFrMvpView> extends BasePresenter<V> implements SampleFrMvpPresent<V> {

    @Inject
    public SampleFrPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager,compositeDisposable);
    }
}
