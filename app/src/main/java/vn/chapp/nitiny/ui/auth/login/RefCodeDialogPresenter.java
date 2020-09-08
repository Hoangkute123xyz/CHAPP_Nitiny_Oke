

package vn.chapp.nitiny.ui.auth.login;


import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import vn.chapp.nitiny.base.BasePresenter;
import vn.chapp.nitiny.data.DataManager;

public class RefCodeDialogPresenter<V extends RefCodeDialogMvpView> extends BasePresenter<V> implements RefCodeDialogMvpPresenter<V> {


    @Inject
    public RefCodeDialogPresenter(DataManager dataManager,
                                  CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }
}
