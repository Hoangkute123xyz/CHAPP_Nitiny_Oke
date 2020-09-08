package vn.chapp.nitiny.ui.scheduled;

import android.text.TextUtils;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import vn.chapp.nitiny.base.BasePresenter;
import vn.chapp.nitiny.data.DataManager;
import vn.chapp.nitiny.models.sale.Scheduled;


public class ScheduleFrPresenter<V extends ScheduleFrMvpView> extends BasePresenter<V> implements ScheduleFrMvpPresent<V> {

    @Inject
    public ScheduleFrPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager,compositeDisposable);
    }

    @Override
    public void validateData(Scheduled scheduled) {
        getMvpView().isValidateData(!TextUtils.isEmpty(scheduled.getAddress()), scheduled);
    }
}
