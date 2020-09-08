package vn.chapp.nitiny.ui.main;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import vn.chapp.nitiny.base.BasePresenter;
import vn.chapp.nitiny.data.DataManager;

public class BackablePresenter<V extends BackableMvpView> extends BasePresenter<V> implements BackableMvpPresenter<V> {

    @Inject
    public BackablePresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager,compositeDisposable);
    }
}
