package vn.chapp.nitiny.ui.shop;

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
import vn.chapp.nitiny.models.service.NewsResponse;
import vn.chapp.nitiny.utils.CommonUtils;
import vn.chapp.nitiny.utils.NetworkUtils;


public class ListNewsDetailAdapter extends BaseAdapter<NewsResponse> {

    public ListNewsDetailAdapter(List<NewsResponse> collection) {
        super(collection);
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ListProductViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_news_detail, viewGroup, false));
    }

    class ListProductViewHolder extends BaseViewHolder {

        @BindView(R.id.tvTitleDetailNews)
        TextView tvTitleDetailNews;
        @BindView(R.id.tvTimeDetailNews)
        TextView tvTimeDetailNews;
        @BindView(R.id.tvDesDetailNews)
        TextView tvDesDetailNews;
        @BindView(R.id.imgNewsDetail)
        ImageView imgNewsDetail;

        public ListProductViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void onBind(int position) {
            super.onBind(position);

            NewsResponse newsResponse = getCollection().get(position);
            if (!TextUtils.isEmpty(newsResponse.getTitle()))
                tvTitleDetailNews.setText(newsResponse.getTitle());
            if (!TextUtils.isEmpty(newsResponse.getContent()))
                tvDesDetailNews.setText(newsResponse.getContent());
            if (newsResponse.getType().equals("2")) {
                tvTimeDetailNews.setText(String.format("Áp dụng từ %s đến %s", CommonUtils.formatCalendarToDDMMYYYY(CommonUtils.formatYYYYMMDDToCalendar(newsResponse.getDateStart())), CommonUtils.formatCalendarToDDMMYYYY(CommonUtils.formatYYYYMMDDToCalendar(newsResponse.getDateEnd()))));
            } else if (newsResponse.getType().equals("1")) {
                tvTimeDetailNews.setText(CommonUtils.formatCalendarToYYYYMMddHHmmSlash(CommonUtils.formatYYYYMMDDHHmmssToCalendar(newsResponse.getDate())));
            }
            if (!TextUtils.isEmpty(newsResponse.getImg()))
                NetworkUtils.loadImage(itemView.getContext(),newsResponse.getImg(), imgNewsDetail);


        }
    }
}
