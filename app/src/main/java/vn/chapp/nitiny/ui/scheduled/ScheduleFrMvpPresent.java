package vn.chapp.nitiny.ui.scheduled;

import vn.chapp.nitiny.base.MvpPresenter;
import vn.chapp.nitiny.models.sale.Scheduled;


public interface ScheduleFrMvpPresent<V extends ScheduleFrMvpView> extends MvpPresenter<V> {
    void validateData(Scheduled scheduled);
}
