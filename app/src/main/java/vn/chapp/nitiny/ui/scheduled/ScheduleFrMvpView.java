package vn.chapp.nitiny.ui.scheduled;


import vn.chapp.nitiny.base.MvpView;
import vn.chapp.nitiny.models.sale.Scheduled;

public interface ScheduleFrMvpView extends MvpView {
    void isValidateData(boolean isValidate, Scheduled scheduled);
}
