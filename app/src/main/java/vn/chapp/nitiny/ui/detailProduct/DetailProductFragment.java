package vn.chapp.nitiny.ui.detailProduct;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.BottomSheetDialog;
import android.text.Html;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import vn.chapp.nitiny.R;
import vn.chapp.nitiny.base.BaseFragment;
import vn.chapp.nitiny.di.component.ActivityComponent;
import vn.chapp.nitiny.models.service.ListProducts;
import vn.chapp.nitiny.models.service.ProductResponse;
import vn.chapp.nitiny.ui.cart.CartFrMvpView;
import vn.chapp.nitiny.ui.cart.CartFrPresenter;
import vn.chapp.nitiny.ui.chat.ChatRoomFragment;
import vn.chapp.nitiny.ui.main.BackableActivity;
import vn.chapp.nitiny.utils.AppConstants;
import vn.chapp.nitiny.utils.AppUtils;
import vn.chapp.nitiny.utils.CommonUtils;
import vn.chapp.nitiny.utils.NetworkUtils;

public class DetailProductFragment extends BaseFragment implements DetailProductFrMvpView {
    
    public static final String TAG = DetailProductFragment.class.getCanonicalName();
    
    public static final String ARG_PRODUCT = "ARG_PRODUCT";
    public static final String ARG_LIST_PRODUCT = "ARG_LIST_PRODUCT";
    public static final String ARG_SHOP_NAME = "ARG_SHOP_NAME";
    public static final String ARG_SHOP_ADDRESS = "ARG_SHOP_ADDRESS";
    public static final String ARG_SHOP_PHONE = "ARG_SHOP_PHONE";
    
    private ProductResponse productResponse;
    private ListProducts listProduct;
    private String shopNameSelected;
    private String shopAddressSelected;
    private String shopPhoneSelected;
    
    @Inject
    DetailProductFrPresenter<DetailProductFrMvpView> presenter;
    
    @Inject
    CartFrPresenter<CartFrMvpView> cartFrPresenter;
    
    @BindView(R.id.sliderProduct)
    SliderLayout sliderProduct;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.tvOtherProduct)
    TextView tvOtherProduct;
    @BindView(R.id.tvType)
    TextView tvType;
    @BindView(R.id.tvPriceReal)
    TextView tvPriceReal;
    @BindView(R.id.tvPriceSale)
    TextView tvPriceSale;
    @BindView(R.id.txtOrder)
    TextView txtOrder;
    @BindView(R.id.tvNote)
    TextView tvNote;
    @BindView(R.id.ivAddProduct)
    ImageView ivAddProduct;
    @BindView(R.id.imgChat)
    ImageView imgChat;
    @BindView(R.id.btnAddProduct)
    Button btnAddProduct;
    @BindView(R.id.tvLableType)
    TextView tvLableType;
    @BindView(R.id.llMadeFrom)
    LinearLayout llMadeFrom;
    //    @BindView(R.id.tvTotalNumber)
    //    TextView tvTotalNumber;
    @BindView(R.id.tvMadeFrom)
    TextView tvMadeFrom;
    
    @BindView(R.id.lnPriceSale)
    LinearLayout lnPriceSale;
    
    Handler setDelay;
    Runnable startDelay;
    
    
    public static DetailProductFragment newInstance(ProductResponse productResponse, ListProducts listProduct,
                                                    String shopNameSelected, String shopAddressSelected, String shopPhoneSelected) {
        DetailProductFragment fragment = new DetailProductFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PRODUCT, productResponse);
        args.putParcelable(ARG_LIST_PRODUCT, listProduct);
        args.putString(ARG_SHOP_NAME, shopNameSelected);
        args.putString(ARG_SHOP_ADDRESS, shopAddressSelected);
        args.putString(ARG_SHOP_PHONE, shopPhoneSelected);
        fragment.setArguments(args);
        return fragment;
    }
    
    @Override
    protected int configView() {
        return R.layout.fragment_product_detail;
    }
    
    @Override
    protected void init(View v) {
        productResponse = getArguments().getParcelable(ARG_PRODUCT);
        listProduct = getArguments().getParcelable(ARG_LIST_PRODUCT);
        shopNameSelected = getArguments().getString(ARG_SHOP_NAME, "");
        shopAddressSelected = getArguments().getString(ARG_SHOP_ADDRESS, "");
        shopPhoneSelected = getArguments().getString(ARG_SHOP_PHONE, "");
        
        if (productResponse != null && listProduct != null) {
            if (productResponse.getImgs() != null && productResponse.getImgs().size() > 0) {
                for (String image : productResponse.getImgs()) {
                    TextSliderView textSliderView = new TextSliderView(getContext());
                    textSliderView
                            .image(image)
                            .setScaleType(BaseSliderView.ScaleType.CenterCrop);
                    sliderProduct.addSlider(textSliderView);
                }
            } else if (!TextUtils.isEmpty(productResponse.getImg())) {
                TextSliderView textSliderView = new TextSliderView(getContext());
                textSliderView
                        .image(productResponse.getImg())
                        .setScaleType(BaseSliderView.ScaleType.CenterCrop);
                sliderProduct.addSlider(textSliderView);
            }
            if (!TextUtils.isEmpty(productResponse.getName()))
                tvTitle.setText(productResponse.getName());
            Typeface boldTypeface = Typeface.defaultFromStyle(Typeface.BOLD);
            tvTitle.setTypeface(boldTypeface);
            tvOtherProduct.setTypeface(boldTypeface);
            
            if (!TextUtils.isEmpty(productResponse.getCategoryName()))
                tvType.setText(productResponse.getCategoryName());

//            if (!TextUtils.isEmpty(productResponse.getNumber()))
//                tvTotalNumber.setText(productResponse.getNumber());
//            else tvTitle.setText("Chưa rõ");
            
            //getMadeFrom thì chưa có dữ liệu từ API
            if (!TextUtils.isEmpty(productResponse.getMadeFrom())) //chờ API mới
                tvMadeFrom.setText(productResponse.getMadeFrom());
            else tvMadeFrom.setText("Chưa rõ");
            
            
            // sản phẩm mới filter theo giá đại lý
            if (productResponse.getType().equals("2")) {
                if (!TextUtils.isEmpty(productResponse.getPriceDiscount()))
                    tvPriceSale.setText(String.format("%sđ", CommonUtils.parseMoney(productResponse.getPriceDiscount())));
                
                if (!TextUtils.isEmpty(productResponse.getPrice()))
                    tvPriceReal.setText(String.format("%sđ", CommonUtils.parseMoney(productResponse.getPrice())));
            } else {
                if (productResponse.getTypeUser() == null) {
                    if (!TextUtils.isEmpty(productResponse.getPriceDiscount()))
                        tvPriceSale.setText(String.format("%sđ", CommonUtils.parseMoney(productResponse.getPriceDiscount())));
                    if (!TextUtils.isEmpty(productResponse.getPrice())) {
                        tvPriceReal.setText(String.format("%sđ", CommonUtils.parseMoney(productResponse.getPrice())));
                    }
                } else if (productResponse.getTypeUser().equals("3")) {
                    tvPriceReal.setVisibility(View.VISIBLE);
                    if (!TextUtils.isEmpty(productResponse.getPriceDiscount()))
                        tvPriceSale.setText(String.format("%sđ", CommonUtils.parseMoney(productResponse.getPriceDiscount())));
                    if (!TextUtils.isEmpty(productResponse.getPrice())) {
                        tvPriceReal.setText(String.format("%sđ", CommonUtils.parseMoney(productResponse.getPrice())));
                    }
                } else {
                    lnPriceSale.setVisibility(View.GONE);
                    switch (productResponse.getTypeUser()) {
                        case "1":
                            if (!TextUtils.isEmpty(productResponse.getPrice1())) {
                                tvPriceReal.setText(String.format("%sđ", CommonUtils.parseMoney(productResponse.getPrice1())));
                            }
                            break;
                        case "2":
                            if (!TextUtils.isEmpty(productResponse.getPrice2())) {
                                tvPriceReal.setText(String.format("%sđ", CommonUtils.parseMoney(productResponse.getPrice2())));
                            }
                            break;
                        case "4":
                            if (!TextUtils.isEmpty(productResponse.getPrice3())) {
                                tvPriceReal.setText(String.format("%sđ", CommonUtils.parseMoney(productResponse.getPrice3())));
                            }
                            break;
                    }
                }
            }
            
            String desc = "";
            if (productResponse.getType().equals(AppConstants.TYPE_PRODUCT + "")) {
                llMadeFrom.setVisibility(View.VISIBLE);
                ivAddProduct.setVisibility(View.GONE);
//                btnAddProduct.setVisibility(View.GONE); //them
                txtOrder.setText(getString(R.string.title_order));
                tvLableType.setText(getString(R.string.str_category));
                desc = getString(R.string.str_descrip);
            } else {
                txtOrder.setText(getString(R.string.title_schedule));
                ivAddProduct.setVisibility(View.GONE);
//                btnAddProduct.setVisibility(View.GONE); //them
                btnAddProduct.setText("Đặt quà");
                tvLableType.setText(getString(R.string.str_type));
                llMadeFrom.setVisibility(View.GONE);
                desc = getString(R.string.str_note);
            }
            
            if (!TextUtils.isEmpty(productResponse.getNote()))
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    tvNote.setText(desc + " " + Html.fromHtml(productResponse.getNote(), Html.FROM_HTML_MODE_COMPACT));
                } else {
                    tvNote.setText(desc + " " + Html.fromHtml(productResponse.getNote()));
                }
            else tvNote.setText("Chưa có thông tin.");
            
            setDelay = new Handler();
        }
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
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity() != null && getActivity() instanceof BackableActivity) {
            ((BackableActivity) getActivity()).setToolbarState(true, getString(R.string.title_detail_product));
        }
    }
    
    
    @OnClick({R.id.txtOrder})
    public void onClickBooking(View v) {
        int shopId = 0;
        int productId = 0;
        int type = 0;
        try {
            shopId = Integer.parseInt(productResponse.getShopId());
//            productId = Integer.parseInt(productResponse.getServiceId());
            productId = Integer.parseInt(productResponse.getId());
            type = Integer.parseInt(productResponse.getType());
        } catch (NumberFormatException n) {
        
        } catch (NullPointerException e) {
        
        }
        startActivity(BackableActivity.newInstanceSchedule(
                getContext(), productResponse, BackableActivity.NAVIGATOR_FSCHEDULED, shopId, productId, type, listProduct, shopNameSelected, shopAddressSelected, shopPhoneSelected, productResponse.getImg()
        ));
    }
    
    @OnClick({R.id.ivAddProduct})
    public void onAddProduct(View v) {
        presenter.doAddProductToCart(productResponse.getId());
    }
    
    //imgChat
    @OnClick({R.id.imgChat})
    public void onGoToChat(View v) {
        AppUtils.replaceFragmentToActivity(getBaseActivity().getSupportFragmentManager(),
                ChatRoomFragment.newInstance(),
                R.id.frBackable, false, ChatRoomFragment.TAG);
        if (getActivity() != null && getActivity() instanceof BackableActivity) {
            ((BackableActivity) getActivity()).setToolbarState(true, getString(R.string.title_favourite));
        }
    }
    
    
    //them
    //add trực tiếp vào giở hàng, chưa có chọn số lượng...
//    @OnClick({R.id.btnAddProduct})
//    public void onAddProductToCart(View v) {
//        presenter.doAddProductToCart(productResponse.getId());
//    }
    
    //Bang: code thẳng vào đây cho chất
    @OnClick({R.id.btnAddProduct})
    public void doShowBottomDialog(View v) {
        
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getContext(), R.style.BottomSheetDialogTheme);
        View bottomSheetView = LayoutInflater.from(getBaseActivity().getApplicationContext())
                .inflate(R.layout.layout_bottom_sheet, (LinearLayout) v.findViewById(R.id.bottomSheetContainer));
        
        ImageView imgPhotoDialog = bottomSheetView.findViewById(R.id.imgPhotoDialog);
        EditText edtQuantityDialog = bottomSheetView.findViewById(R.id.edtQuantityDialog);
        TextView tvMinusDialog = bottomSheetView.findViewById(R.id.tvMinusDialog);
        TextView tvPlusDialog = bottomSheetView.findViewById(R.id.tvPlusDialog);
        TextView tvPriceDialog = bottomSheetView.findViewById(R.id.tvPriceDialog);
        Button btnAddProductDialog = bottomSheetView.findViewById(R.id.btnAddProductDialog);
        
        
        int startPrice = 0;
        
        //set ảnh và set giá vào dialog
        if (!TextUtils.isEmpty(productResponse.getImg()))
            NetworkUtils.loadImage(getContext(), productResponse.getImg(), imgPhotoDialog);
        
        if (productResponse.getType().equals("2")) {
            if (!TextUtils.isEmpty(productResponse.getPrice()))
                tvPriceDialog.setText(String.format("%sđ", CommonUtils.parseMoney(productResponse.getPrice())));
            startPrice = Integer.parseInt(productResponse.getPrice());
        } else {
            if (productResponse.getTypeUser() == null) {
                if (!TextUtils.isEmpty(productResponse.getPrice())) {
                    tvPriceDialog.setText(String.format("%sđ", CommonUtils.parseMoney(productResponse.getPrice())));
                    startPrice = Integer.parseInt(productResponse.getPrice());
                }
            } else if (productResponse.getTypeUser().equals("3")) {
                tvPriceDialog.setVisibility(View.VISIBLE);
                if (!TextUtils.isEmpty(productResponse.getPrice())) {
                    tvPriceDialog.setText(String.format("%sđ", CommonUtils.parseMoney(productResponse.getPrice())));
                    startPrice = Integer.parseInt(productResponse.getPrice());
                }
            } else {
                switch (productResponse.getTypeUser()) {
                    case "1":
                        if (!TextUtils.isEmpty(productResponse.getPrice1())) {
                            tvPriceDialog.setText(String.format("%sđ", CommonUtils.parseMoney(productResponse.getPrice1())));
                            startPrice = Integer.parseInt(productResponse.getPrice1());
                        }
                        break;
                    case "2":
                        if (!TextUtils.isEmpty(productResponse.getPrice2())) {
                            tvPriceDialog.setText(String.format("%sđ", CommonUtils.parseMoney(productResponse.getPrice2())));
                            startPrice = Integer.parseInt(productResponse.getPrice2());
                        }
                        break;
                    case "4":
                        if (!TextUtils.isEmpty(productResponse.getPrice3())) {
                            tvPriceDialog.setText(String.format("%sđ", CommonUtils.parseMoney(productResponse.getPrice3())));
                            startPrice = Integer.parseInt(productResponse.getPrice3());
                        }
                        break;
                }
            }
        }
        
        int finalStartPrice = startPrice;
        
        //tvMinus
        tvMinusDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtQuantityDialog.clearFocus();
                InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(v.getContext().INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                
                if (edtQuantityDialog.getText().toString().equals("") ||
                        edtQuantityDialog.getText().toString().equals("0")) {
                    edtQuantityDialog.setText("1");
                    Toast.makeText(getContext(), "Số lượng không được dưới 1.", Toast.LENGTH_SHORT).show();
                    return;
                }
                
                if (Integer.parseInt(edtQuantityDialog.getText().toString()) > 1) {
                    int newQuantityDialog = Integer.parseInt(edtQuantityDialog.getText().toString()) - 1;
                    edtQuantityDialog.setText(String.valueOf(newQuantityDialog));
                    
                    int newPriceDialog = newQuantityDialog * finalStartPrice;
                    tvPriceDialog.setText(String.format("%sđ", CommonUtils.parseMoney(String.valueOf(newPriceDialog))));
                } else {
                    Toast.makeText(getContext(), "Số lượng không được dưới 1.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        
        //tvPlus
        tvPlusDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtQuantityDialog.clearFocus();
                InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(v.getContext().INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                
                if (edtQuantityDialog.getText().toString().equals("") ||
                        edtQuantityDialog.getText().toString().equals("0")) {
                    int newQuantityDialog = 1;
                    edtQuantityDialog.setText(String.valueOf(newQuantityDialog));
                    
                    int newPriceDialog = newQuantityDialog * finalStartPrice;
                    tvPriceDialog.setText(String.format("%sđ", CommonUtils.parseMoney(String.valueOf(newPriceDialog))));
                } else {
                    int newQuantityDialog = Integer.parseInt(edtQuantityDialog.getText().toString()) + 1;
                    edtQuantityDialog.setText(String.valueOf(newQuantityDialog));
                    
                    int newPriceDialog = newQuantityDialog * finalStartPrice;
                    tvPriceDialog.setText(String.format("%sđ", CommonUtils.parseMoney(String.valueOf(newPriceDialog))));
                }
            }
        });
        
        //edtQuantityDialog
        edtQuantityDialog.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    
                    if (!edtQuantityDialog.getText().toString().equals("") &&
                            !edtQuantityDialog.getText().toString().equals("0")) {
                        int newQuantityDialog = Integer.parseInt(edtQuantityDialog.getText().toString());
                        edtQuantityDialog.setText(String.valueOf(newQuantityDialog));
                        
                        int newPriceDialog = newQuantityDialog * finalStartPrice;
                        tvPriceDialog.setText(String.format("%sđ", CommonUtils.parseMoney(String.valueOf(newPriceDialog))));
                        
                        edtQuantityDialog.clearFocus();
                        InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(v.getContext().INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    } else {
                        Toast.makeText(getContext(), "Số lượng không được dưới 1.", Toast.LENGTH_SHORT).show();
                        edtQuantityDialog.setText("1");
                        
                        edtQuantityDialog.clearFocus();
                        InputMethodManager imm = (InputMethodManager) getContext().getSystemService(getContext().INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    }
                    
                }
                return false;
            }
        });
        
        //btnAddProductToCart
        btnAddProductDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //thêm vào giỏ với số lượng là 1
                presenter.doAddProductToCart(productResponse.getId());
                
                //chỉnh số lượng trong card
                if (edtQuantityDialog.getText().toString().equals("") ||
                        edtQuantityDialog.getText().toString().equals("0")) {
                    Toast.makeText(getContext(), "Số lượng không được dưới 1.", Toast.LENGTH_SHORT).show();
                    return;
                }
                
                startDelay = new Runnable() {
                    @Override
                    public void run() {
    
                        //sửa giỏ hàng thành số lượng đã chỉnh
                        presenter.doEditCart(productResponse.getId(), edtQuantityDialog.getText().toString());
                        startActivity(BackableActivity.newInstance(getContext(), BackableActivity.NAVIGATOR_CART));
                        bottomSheetDialog.dismiss();
                    }
                };
                setDelay.postDelayed(startDelay, 1000);
            }
        });
        
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
        
    }
    
    @Override
    public void didEditCart() {
        cartFrPresenter.doGetCart();
    }
    
    @Override
    public void didAddProductToCart() {
        Toast.makeText(getContext(), "Thêm sản phẩm vào giỏ hàng thành công", Toast.LENGTH_SHORT).show();
    }

//    @Override
//    public void onDetach() {
//        super.onDetach();
//        if(getActivity() != null && getActivity() instanceof BackableActivity) {
//            ((BackableActivity)getActivity()).restoreToolbar();
//        }
//    }
}
