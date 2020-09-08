package vn.chapp.nitiny.ui.chat;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.List;

import butterknife.BindView;
import vn.chapp.nitiny.R;
import vn.chapp.nitiny.base.BaseAdapter;
import vn.chapp.nitiny.base.BaseViewHolder;
import vn.chapp.nitiny.models.service.Shop;
import vn.chapp.nitiny.utils.NetworkUtils;

public class CustomerOnlineAdapter extends BaseAdapter<Shop> {

    public CustomerOnlineAdapter(List<Shop> collection) {
        super(collection);
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new CustomerOnlineViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_chat_avatar, viewGroup, false));
    }

    class CustomerOnlineViewHolder extends BaseViewHolder {

        @BindView(R.id.civAvatar)
        CircularImageView civAvatar;
        @BindView(R.id.tvName)
        TextView tvName;

        public CustomerOnlineViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void onBind(int position) {
            super.onBind(position);

            Shop userLinked = getCollection().get(position);
            if (userLinked != null) {
                if (!TextUtils.isEmpty(userLinked.getAvatar()))
                    NetworkUtils.loadImage(itemView.getContext(),userLinked.getAvatar(),civAvatar,R.drawable.img_splash_logo,R.drawable.img_splash_logo);
                if (!TextUtils.isEmpty(userLinked.getName()))
                    tvName.setText(userLinked.getName());
            }
        }
    }
}
