package vn.chapp.nitiny.ui.profile;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import vn.chapp.nitiny.base.BasePresenter;
import vn.chapp.nitiny.data.DataManager;

public class ProfileFrPresenter<V extends ProfileFrMvpView> extends BasePresenter<V> implements ProfileFrMvpPresent<V> {

    @Inject
    public ProfileFrPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void getUserDefault() {
        getMvpView().parseUserDefault(getDataManager().getUserDefault());
    }

}
