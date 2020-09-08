package vn.chapp.nitiny.ui.noti;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import vn.chapp.nitiny.R;
import vn.chapp.nitiny.base.BaseAdapter;
import vn.chapp.nitiny.base.BaseViewHolder;
import vn.chapp.nitiny.models.noti.Notify;
import vn.chapp.nitiny.utils.CommonUtils;

public class NotificationAdapter extends BaseAdapter<Notify> {

    private OnClickNotifiListener onClickNotifiListener;

    public NotificationAdapter(List<Notify> collection) {
        super(collection);
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new HistoryViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_notification, viewGroup, false));
    }


    class HistoryViewHolder extends BaseViewHolder {

        @BindView(R.id.imgIcon)
        ImageView imgIcon;
        @BindView(R.id.tvTitle)
        TextView tvTitle;
        @BindView(R.id.tvContent)
        TextView tvContent;
        @BindView(R.id.tvDateTime)
        TextView tvDateTime;

        public HistoryViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void onBind(int position) {
            super.onBind(position);

            Notify notify = getCollection().get(position);

//            if (!TextUtils.isEmpty(notify.getShopAvatar()))
//                NetworkUtils.loadImage(itemView.getContext(),historyResponse.getShopAvatar(),civAvatar);

            if (!TextUtils.isEmpty(notify.getTitle())) {
                tvTitle.setText(notify.getTitle());
                tvTitle.setTypeface(null, Typeface.BOLD);
            } else {
                tvTitle.setText("Chưa có tiêu đề");
                tvTitle.setTypeface(null, Typeface.BOLD);
            }

            if (!TextUtils.isEmpty(notify.getContent()))
                tvContent.setText(notify.getContent());
            else tvContent.setText("Chưa có nội dung");

            if (!TextUtils.isEmpty(notify.getDate()))
                tvDateTime.setText(CommonUtils.formatDateServerToViewWallet(notify.getDate()));
            else tvDateTime.setText("Chưa rõ thời gian");

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onClickNotifiListener != null)
                        onClickNotifiListener.onClickViewDetail(position, notify);
                }
            });

        }
    }

    public interface OnClickNotifiListener {
        void onClickViewDetail(int position, Notify notify);
    }

    public void setOnClickNotifiListener(OnClickNotifiListener onClickNotifiListener) {
        this.onClickNotifiListener = onClickNotifiListener;
    }
}