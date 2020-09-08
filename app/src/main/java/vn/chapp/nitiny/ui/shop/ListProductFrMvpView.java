package vn.chapp.nitiny.ui.shop;


import java.util.List;

import vn.chapp.nitiny.base.MvpView;
import vn.chapp.nitiny.models.service.CategoryAdd;
import vn.chapp.nitiny.models.service.ProductResponse;

public interface ListProductFrMvpView extends MvpView {
    void didGetCategory(List<CategoryAdd> categories);
    void gotProducts(List<ProductResponse> productResponseList);
    void didAddProductToCart();
}
