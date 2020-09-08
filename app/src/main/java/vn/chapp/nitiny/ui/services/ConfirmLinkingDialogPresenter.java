

package vn.chapp.nitiny.ui.services;


import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import vn.chapp.nitiny.base.BasePresenter;
import vn.chapp.nitiny.data.DataManager;

public class ConfirmLinkingDialogPresenter<V extends ConfirmLinkingDialogMvpView> extends BasePresenter<V> implements ConfirmLinkingDialogMvpPresenter<V> {


    @Inject
    public ConfirmLinkingDialogPresenter(DataManager dataManager,
                                         CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }
}
