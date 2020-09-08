package vn.chapp.nitiny.ui.rating;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import vn.chapp.nitiny.base.BasePresenter;
import vn.chapp.nitiny.data.DataManager;


public class ShopSlidePresenter<V extends ShopSlideFrMvpView> extends BasePresenter<V> implements ShopSlideMvpPresent<V> {

    @Inject
    public ShopSlidePresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager,compositeDisposable);
    }
}
