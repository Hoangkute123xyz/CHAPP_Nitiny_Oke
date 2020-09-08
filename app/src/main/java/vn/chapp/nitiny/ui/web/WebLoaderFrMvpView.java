package vn.chapp.nitiny.ui.web;


import vn.chapp.nitiny.base.MvpView;
import vn.chapp.nitiny.models.guide.GuideResponse;

public interface WebLoaderFrMvpView extends MvpView {
    void parseContent(GuideResponse content);
}
