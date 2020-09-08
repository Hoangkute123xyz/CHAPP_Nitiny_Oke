package vn.chapp.nitiny.ui.tichDiem;

import java.util.List;

import vn.chapp.nitiny.base.MvpView;
import vn.chapp.nitiny.models.point.PointResponse;

public interface TichDiemMvpView extends MvpView {
    void parsePointHistory(List<PointResponse> pointResponses);
}
