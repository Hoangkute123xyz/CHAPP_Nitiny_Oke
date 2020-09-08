package vn.chapp.nitiny.ui.noti;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import vn.chapp.nitiny.R;
import vn.chapp.nitiny.base.BaseFragment;
import vn.chapp.nitiny.di.component.ActivityComponent;
import vn.chapp.nitiny.models.noti.Notify;
import vn.chapp.nitiny.utils.CommonUtils;

public class NotificationDetailFragment extends BaseFragment {

    public static final String TAG = NotificationDetailFragment.class.getCanonicalName();

    public static final String ARG_NOTIFICATION_DETAIL = "ARG_NOTIFICATION_DETAIL";

    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.tvDateTime)
    TextView tvDateTime;
    @BindView(R.id.tvContent)
    TextView tvContent;

    private Notify notify;

    public static NotificationDetailFragment newInstance(Notify notify) {
        NotificationDetailFragment fragment = new NotificationDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_NOTIFICATION_DETAIL, notify);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int configView() {
        return R.layout.fragment_notification_detail;
    }

    @Override
    protected void init(View v) {

        notify = getArguments().getParcelable(ARG_NOTIFICATION_DETAIL);
        if (notify != null) {
            if (!TextUtils.isEmpty(notify.getTitle())){
                tvTitle.setText(notify.getTitle());
                tvTitle.setTypeface(null, Typeface.BOLD);
            }
            else {
                tvTitle.setText("Chưa có tiêu đề");
                tvTitle.setTypeface(null, Typeface.BOLD);
            }

            if (!TextUtils.isEmpty(notify.getContent()))
                tvContent.setText(notify.getContent());
            else tvContent.setText("Chưa có nội dung");

            if (!TextUtils.isEmpty(notify.getDate()))
                tvDateTime.setText(CommonUtils.formatDateServerToViewWallet(notify.getDate()));
            else tvDateTime.setText("Chưa rõ thời gian");

            Log.d(" noti: title: ", notify.getTitle());
            Log.d(" noti:content: ", notify.getContent());
            Log.d(" noti: date: ", notify.getDate());
        }

    }

    @Override
    protected void initCreatedView(View v) {
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnbinder(ButterKnife.bind(this, v));
        }

    }

}
