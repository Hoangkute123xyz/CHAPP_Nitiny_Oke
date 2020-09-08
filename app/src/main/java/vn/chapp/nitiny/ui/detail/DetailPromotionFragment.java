package vn.chapp.nitiny.ui.detail;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import vn.chapp.nitiny.R;
import vn.chapp.nitiny.base.BaseFragment;
import vn.chapp.nitiny.di.component.ActivityComponent;
import vn.chapp.nitiny.models.service.NewsResponse;
import vn.chapp.nitiny.ui.main.BackableActivity;
import vn.chapp.nitiny.ui.shop.ListNewsDetailAdapter;
import vn.chapp.nitiny.ui.shop.ShopDetailFragment;
import vn.chapp.nitiny.utils.CommonUtils;
import vn.chapp.nitiny.utils.NetworkUtils;

public class DetailPromotionFragment extends BaseFragment implements DetailPromotionFrMvpView {

    public static final String TAG = DetailPromotionFragment.class.getCanonicalName();
    public static final String ARG_NEWS = "ARG_NEWS";
    public static final String ARG_POS = "ARG_POS";

    @Inject
    DetailPromotionFrPresenter<DetailPromotionFrMvpView> presenter;

    @Inject
    ListNewsDetailAdapter listNewsDetailAdapter;

    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.tvDateApply)
    TextView tvDateApply;
    @BindView(R.id.tvDateExpried)
    TextView tvDateExpried;
    @BindView(R.id.tvContent)
    TextView tvContent;
    @BindView(R.id.ivNews)
    RoundedImageView ivNews;
    @BindView(R.id.rvPromotion)
    RecyclerView rvPromotion;

    private NewsResponse newsResponse;
    private int position;


    public static DetailPromotionFragment newInstance(int position, NewsResponse newsResponse) {
        DetailPromotionFragment fragment = new DetailPromotionFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_NEWS, newsResponse);
        args.putInt(ARG_POS, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int configView() {
        return R.layout.fragment_detail_promotion;
    }


    @Override
    protected void init(View v) {
        newsResponse = getArguments().getParcelable(ARG_NEWS);
        position = getArguments().getInt(ARG_POS);
        parseNewsResponse(newsResponse);
        presenter.getNewsDetail(newsResponse.getId());

        rvPromotion.setAdapter(listNewsDetailAdapter);
        rvPromotion.setLayoutManager(new LinearLayoutManager(getContext()));
        if (ShopDetailFragment.listProduct != null) {
            List<NewsResponse> backup = new ArrayList<>();
            for (NewsResponse news:ShopDetailFragment.listProduct.getPromotion()){
                if (!news.getTitle().equals(newsResponse.getTitle())){
                    backup.add(news);
                }
            }
            Collections.shuffle(backup);
            listNewsDetailAdapter.replaceData(backup);
        }
        listNewsDetailAdapter.setOnItemClickListener((position)->{
            onClickViewDetailNewPaper(position, listNewsDetailAdapter.getCollection().get(position), BackableActivity.NAVIGATOR_DETAIL_PROMOTION);
        });
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

    private void onClickViewDetailNewPaper(int position, NewsResponse newsResponse, String agr) {
        startActivity(BackableActivity.newInstanceBase(getActivity(), agr, newsResponse, position));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (getActivity() != null && getActivity() instanceof BackableActivity) {
            ((BackableActivity) getActivity()).restoreToolbar();
        }
    }

    @Override
    public void parseNewsResponse(NewsResponse news) {
        if (!TextUtils.isEmpty(newsResponse.getTitle()))
            tvTitle.setText(newsResponse.getTitle());
        if (!TextUtils.isEmpty(newsResponse.getContent()))
            tvContent.setText(newsResponse.getContent());
        if (newsResponse.getType().equals("2")) {
            tvDateApply.setText(CommonUtils.formatCalendarToDDMMYYYY(CommonUtils.formatYYYYMMDDToCalendar(newsResponse.getDateStart())));
            tvDateExpried.setText(CommonUtils.formatCalendarToDDMMYYYY(CommonUtils.formatYYYYMMDDToCalendar(newsResponse.getDateEnd())));
        } else if (newsResponse.getType().equals("1")) {
            tvDateApply.setText(CommonUtils.formatCalendarToYYYYMMddHHmmSlash(CommonUtils.formatYYYYMMDDHHmmssToCalendar(newsResponse.getDate())));
        }
        if (!TextUtils.isEmpty(newsResponse.getImg()))
            NetworkUtils.loadImage(getContext(), newsResponse.getImg(), ivNews);
    }

    public void getDetailNews(NewsResponse newsResponse) {
        presenter.getNewsDetail(newsResponse.getId());
    }
}
