package vn.chapp.nitiny.ui.accumulatepoint;

import java.util.List;

import vn.chapp.nitiny.base.MvpView;
import vn.chapp.nitiny.models.point.PointDetailResponse;

public interface AccumulatePointMvpView extends MvpView {
    void parsePointHistory(List<PointDetailResponse> pointResponses);
}
