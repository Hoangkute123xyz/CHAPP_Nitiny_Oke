package vn.chapp.nitiny.ui.shop;

import vn.chapp.nitiny.models.service.NewsResponse;
import vn.chapp.nitiny.models.service.ProductResponse;

public interface OnClickItemShopDetail {
    void onClickOrder(int position);

    void onClickScheduled(int position);

    void onClickViewDetail(int position, ProductResponse productResponse);

    void onClickViewDetailNewPaper(int position, NewsResponse newsResponse, String agr);
}
