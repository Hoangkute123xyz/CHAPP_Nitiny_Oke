package vn.chapp.nitiny.ui.noti;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;
import butterknife.ButterKnife;
import vn.chapp.nitiny.R;
import vn.chapp.nitiny.base.BaseFragment;
import vn.chapp.nitiny.base.BaseRecyclerView;
import vn.chapp.nitiny.di.component.ActivityComponent;
import vn.chapp.nitiny.models.noti.Notify;
import vn.chapp.nitiny.ui.main.BackableActivity;

public class NotificationFragment extends BaseFragment implements NotificationFrMvpView,
        NotificationAdapter.OnClickNotifiListener, SwipeRefreshLayout.OnRefreshListener {

    public static final String TAG = NotificationFragment.class.getCanonicalName();

    @Inject
    NotificationFrPresenter<NotificationFrMvpView> presenter;

    @Inject
    @Named("vertical")
    LinearLayoutManager linearLayoutManager;
    @Inject
    NotificationAdapter notifyAdapter;

    @BindView(R.id.rcNotification)
    BaseRecyclerView rcNotification;

    private List<Notify> listNotifications;

    public static NotificationFragment newInstance() {
        NotificationFragment fragment = new NotificationFragment();
        return fragment;
    }

    @Override
    protected int configView() {
        return R.layout.fragment_notification;
    }

    @Override
    protected void init(View v) {
        rcNotification.setLayoutManager(linearLayoutManager);
        notifyAdapter.setOnClickNotifiListener(this);
        rcNotification.setAdapter(notifyAdapter);
        rcNotification.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
        rcNotification.setOnRefreshListener(this);

        presenter.doGetNoti();


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
    public void didGetNoti(List<Notify> listNotifications) {
        this.listNotifications = listNotifications;
        getBaseActivity().runOnUiThread(new Runnable() {
            public void run() {
                rcNotification.setRefresh(false);
            }
        });
        notifyAdapter.replaceData(listNotifications);
    }

    @Override
    public void onClickViewDetail(int position, Notify notify) {
        startActivity(BackableActivity.newInstanceNotificationDetail(getContext(), BackableActivity.NAVIGATOR_FNTDT, notify));
    }

    @Override
    public void onRefresh() {
        presenter.doGetNoti();
    }
}