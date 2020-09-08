package vn.chapp.nitiny.ui.tichDiem;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;
import butterknife.ButterKnife;
import vn.chapp.nitiny.R;
import vn.chapp.nitiny.base.BaseFragment;
import vn.chapp.nitiny.base.BaseRecyclerView;
import vn.chapp.nitiny.base.OnItemClickListener;
import vn.chapp.nitiny.di.component.ActivityComponent;
import vn.chapp.nitiny.models.point.PointResponse;
import vn.chapp.nitiny.ui.main.BackableActivity;

public class TichDiemFragment extends BaseFragment implements TichDiemMvpView, OnItemClickListener,
        SwipeRefreshLayout.OnRefreshListener {
    public static final String TAG = TichDiemFragment.class.getCanonicalName();

    @Inject
    TichDiemPresenter<TichDiemMvpView> presenter;

    @BindView(R.id.rcTichDiem)
    BaseRecyclerView rcTichDiem;
    @BindView(R.id.txtLabel)
    TextView txtLabel;

    @Inject
    TichDiemAdapter tichDiemAdapter;

    @Inject
    @Named("vertical")
    LinearLayoutManager linearLayoutManager;

    private List<PointResponse> pointResponses = new ArrayList<>();

    public static TichDiemFragment newInstance() {
        TichDiemFragment fragment = new TichDiemFragment();
        return fragment;
    }

    @Override
    protected int configView() {
        return R.layout.fragment_tich_diem;
    }

    @Override
    protected void init(View v) {
        rcTichDiem.setHasFixedSize(true);
        rcTichDiem.setLayoutManager(linearLayoutManager);
        tichDiemAdapter.setOnItemClickListener(this);
        rcTichDiem.setAdapter(tichDiemAdapter);
        rcTichDiem.setOnRefreshListener(this);
        presenter.getPointHistory();
    }



    @Override
    protected void initCreatedView(View v) {
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnbinder(ButterKnife.bind(this, v));
            presenter.onAttach(this);
        }
    }

    @Override
    public void parsePointHistory(List<PointResponse> pointResponses) {
        tichDiemAdapter.replaceData(pointResponses);
        txtLabel.setText("Danh mục điểm "+pointResponses.size()+" shop đã liên kết");

        getBaseActivity().runOnUiThread(new Runnable() {
            public void run() {
                rcTichDiem.setRefresh(false);
            }
        });

        this.pointResponses.removeAll(pointResponses);
        this.pointResponses.addAll(pointResponses);
    }

    @Override
    public void onClick(int position) {
        startActivity(BackableActivity.newInstancePointDetail(
                getContext(), BackableActivity.NAVIGATOR_POINT_DETAIL, pointResponses.get(position)
        ));
    }

    @Override
    public void onRefresh() {
        presenter.getPointHistory();
    }
}
