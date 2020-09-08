package vn.chapp.nitiny.ui.detail;


import vn.chapp.nitiny.base.MvpView;
import vn.chapp.nitiny.models.service.NewsResponse;

public interface DetailNewsFrMvpView extends MvpView {
    void parseNewsResponse(NewsResponse news);
}
