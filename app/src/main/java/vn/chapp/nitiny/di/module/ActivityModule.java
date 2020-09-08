package vn.chapp.nitiny.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
import vn.chapp.nitiny.di.ActivityContext;
import vn.chapp.nitiny.di.PerActivity;
import vn.chapp.nitiny.models.FragmentController;
import vn.chapp.nitiny.ui.accumulatepoint.PointHistoryAdapter;
import vn.chapp.nitiny.ui.addCode.AddCodeFragment;
import vn.chapp.nitiny.ui.addCode.ShopLinkedAdapter;
import vn.chapp.nitiny.ui.auth.AuthMvpPresenter;
import vn.chapp.nitiny.ui.auth.AuthMvpView;
import vn.chapp.nitiny.ui.auth.AuthPresenter;
import vn.chapp.nitiny.ui.auth.ChangePasswordFrMvpPresent;
import vn.chapp.nitiny.ui.auth.ChangePasswordFrMvpView;
import vn.chapp.nitiny.ui.auth.ChangePasswordFrPresenter;
import vn.chapp.nitiny.ui.auth.forgot.ForgotPasswordFrMvpPresent;
import vn.chapp.nitiny.ui.auth.forgot.ForgotPasswordFrMvpView;
import vn.chapp.nitiny.ui.auth.forgot.ForgotPasswordFrPresenter;
import vn.chapp.nitiny.ui.auth.login.LoginFrMvpPresent;
import vn.chapp.nitiny.ui.auth.login.LoginFrMvpView;
import vn.chapp.nitiny.ui.auth.login.LoginFrPresenter;
import vn.chapp.nitiny.ui.auth.login.LoginFragment;
import vn.chapp.nitiny.ui.auth.login.RefCodeDialogMvpPresenter;
import vn.chapp.nitiny.ui.auth.login.RefCodeDialogMvpView;
import vn.chapp.nitiny.ui.auth.login.RefCodeDialogPresenter;
import vn.chapp.nitiny.ui.auth.register.RegisterFrMvpPresent;
import vn.chapp.nitiny.ui.auth.register.RegisterFrMvpView;
import vn.chapp.nitiny.ui.auth.register.RegisterFrPresenter;
import vn.chapp.nitiny.ui.auth.register.RegisterFragment;
import vn.chapp.nitiny.ui.booking.BookingAdapter;
import vn.chapp.nitiny.ui.booking.BookingFragment;
import vn.chapp.nitiny.ui.cart.CartAdapter;
import vn.chapp.nitiny.ui.cart.CartFrMvpPresent;
import vn.chapp.nitiny.ui.cart.CartFrMvpView;
import vn.chapp.nitiny.ui.cart.CartFrPresenter;
import vn.chapp.nitiny.ui.cart.CartSectionAdapter;
import vn.chapp.nitiny.ui.chat.ChatAdapter;
import vn.chapp.nitiny.ui.chat.ChatBoxAdapter;
import vn.chapp.nitiny.ui.chat.ChatFragment;
import vn.chapp.nitiny.ui.chat.ChatMvpPresenter;
import vn.chapp.nitiny.ui.chat.ChatMvpView;
import vn.chapp.nitiny.ui.chat.ChatPresenter;
import vn.chapp.nitiny.ui.chat.ChatRoomFrMvpPresent;
import vn.chapp.nitiny.ui.chat.ChatRoomFrMvpView;
import vn.chapp.nitiny.ui.chat.ChatRoomFrPresenter;
import vn.chapp.nitiny.ui.chat.ChatRoomFragment;
import vn.chapp.nitiny.ui.chat.CustomerOnlineAdapter;
import vn.chapp.nitiny.ui.common.CommonPickCategoryAdapter;
import vn.chapp.nitiny.ui.customer.CustomerFrMvpPresent;
import vn.chapp.nitiny.ui.customer.CustomerFrMvpView;
import vn.chapp.nitiny.ui.customer.CustomerFrPresenter;
import vn.chapp.nitiny.ui.customer.CustomerFragment;
import vn.chapp.nitiny.ui.customer.CustomerLinkAdapter;
import vn.chapp.nitiny.ui.detail.DetailMvpPresenter;
import vn.chapp.nitiny.ui.detail.DetailMvpView;
import vn.chapp.nitiny.ui.detail.DetailNewsFrMvpPresent;
import vn.chapp.nitiny.ui.detail.DetailNewsFrMvpView;
import vn.chapp.nitiny.ui.detail.DetailNewsFrPresenter;
import vn.chapp.nitiny.ui.detail.DetailPresenter;
import vn.chapp.nitiny.ui.detail.DetailPromotionFrMvpPresent;
import vn.chapp.nitiny.ui.detail.DetailPromotionFrMvpView;
import vn.chapp.nitiny.ui.detail.DetailPromotionFrPresenter;
import vn.chapp.nitiny.ui.detailBooking.DetailBookingAdapter;
import vn.chapp.nitiny.ui.detailHistory.DetailHistoryFragment;
import vn.chapp.nitiny.ui.history.HistoryAdapter;
import vn.chapp.nitiny.ui.history.HistoryFrMvpPresent;
import vn.chapp.nitiny.ui.history.HistoryFrMvpView;
import vn.chapp.nitiny.ui.history.HistoryFrPresenter;
import vn.chapp.nitiny.ui.history.HistoryFragment;
import vn.chapp.nitiny.ui.location.ChooseLocationMvpPresent;
import vn.chapp.nitiny.ui.location.ChooseLocationMvpView;
import vn.chapp.nitiny.ui.location.ChooseLocationPresenter;
import vn.chapp.nitiny.ui.location.SearchPlaceAdapter;
import vn.chapp.nitiny.ui.location.locationsearch.LocationSearchMvpPresent;
import vn.chapp.nitiny.ui.location.locationsearch.LocationSearchMvpView;
import vn.chapp.nitiny.ui.location.locationsearch.LocationSearchPresenter;
import vn.chapp.nitiny.ui.main.BackableMvpPresenter;
import vn.chapp.nitiny.ui.main.BackableMvpView;
import vn.chapp.nitiny.ui.main.BackablePresenter;
import vn.chapp.nitiny.ui.main.MainMvpPresenter;
import vn.chapp.nitiny.ui.main.MainMvpView;
import vn.chapp.nitiny.ui.main.MainPresenter;
import vn.chapp.nitiny.ui.noti.NotificationAdapter;
import vn.chapp.nitiny.ui.noti.NotificationFrMvpPresent;
import vn.chapp.nitiny.ui.noti.NotificationFrMvpView;
import vn.chapp.nitiny.ui.noti.NotificationFrPresenter;
import vn.chapp.nitiny.ui.noti.NotificationFragment;
import vn.chapp.nitiny.ui.profile.ProfileDetailFrMvpPresent;
import vn.chapp.nitiny.ui.profile.ProfileDetailFrMvpView;
import vn.chapp.nitiny.ui.profile.ProfileDetailFrPresenter;
import vn.chapp.nitiny.ui.profile.ProfileFrMvpPresent;
import vn.chapp.nitiny.ui.profile.ProfileFrMvpView;
import vn.chapp.nitiny.ui.profile.ProfileFrPresenter;
import vn.chapp.nitiny.ui.profile.ProfileFragment;
import vn.chapp.nitiny.ui.rating.RatingFragment;
import vn.chapp.nitiny.ui.rating.ShopSlideFrMvpView;
import vn.chapp.nitiny.ui.rating.ShopSlideMvpPresent;
import vn.chapp.nitiny.ui.rating.ShopSlidePresenter;
import vn.chapp.nitiny.ui.sample.SampleFrMvpPresent;
import vn.chapp.nitiny.ui.sample.SampleFrMvpView;
import vn.chapp.nitiny.ui.sample.SampleFrPresenter;
import vn.chapp.nitiny.ui.sample.SampleMvpPresenter;
import vn.chapp.nitiny.ui.sample.SampleMvpView;
import vn.chapp.nitiny.ui.sample.SamplePresenter;
import vn.chapp.nitiny.ui.scheduled.ConfirmAdapter;
import vn.chapp.nitiny.ui.scheduled.ScheduledAdapter;
import vn.chapp.nitiny.ui.scheduledProduct.ConfirmProductAdapter;
import vn.chapp.nitiny.ui.scheduledProduct.ScheduleProductAdapter;
import vn.chapp.nitiny.ui.services.ConfirmLinkingDialogMvpPresenter;
import vn.chapp.nitiny.ui.services.ConfirmLinkingDialogMvpView;
import vn.chapp.nitiny.ui.services.ConfirmLinkingDialogPresenter;
import vn.chapp.nitiny.ui.services.LinkServiceFrMvpPresent;
import vn.chapp.nitiny.ui.services.LinkServiceFrMvpView;
import vn.chapp.nitiny.ui.services.LinkServiceFrPresenter;
import vn.chapp.nitiny.ui.services.LinkServiceFragment;
import vn.chapp.nitiny.ui.services.SearchShopAdapter;
import vn.chapp.nitiny.ui.services.SearchShopFrMvpPresent;
import vn.chapp.nitiny.ui.services.SearchShopFrMvpView;
import vn.chapp.nitiny.ui.services.SearchShopFrPresenter;
import vn.chapp.nitiny.ui.services.ServicesAdapter;
import vn.chapp.nitiny.ui.services.UpdateInfoServiceFrMvpPresent;
import vn.chapp.nitiny.ui.services.UpdateInfoServiceFrMvpView;
import vn.chapp.nitiny.ui.services.UpdateInfoServiceFrPresenter;
import vn.chapp.nitiny.ui.shop.ListNewsAdapter;
import vn.chapp.nitiny.ui.shop.ListNewsDetailAdapter;
import vn.chapp.nitiny.ui.shop.ListProductAdapter;
import vn.chapp.nitiny.ui.shop.ListProductFrMvpPresent;
import vn.chapp.nitiny.ui.shop.ListProductFrMvpView;
import vn.chapp.nitiny.ui.shop.ListProductFrPresenter;
import vn.chapp.nitiny.ui.shop.MyServiceViewPagerAdapter;
import vn.chapp.nitiny.ui.shop.ShopDetailFrMvpPresent;
import vn.chapp.nitiny.ui.shop.ShopDetailFrMvpView;
import vn.chapp.nitiny.ui.shop.ShopDetailFrPresenter;
import vn.chapp.nitiny.ui.shop.ShopDetailFragment;
import vn.chapp.nitiny.ui.shop.ShopDetailServiceAdapter;
import vn.chapp.nitiny.ui.shopLinked.ListShopLinkedAdapter;
import vn.chapp.nitiny.ui.shopLinked.ShopLinkedFrMvpPresent;
import vn.chapp.nitiny.ui.shopLinked.ShopLinkedFrMvpView;
import vn.chapp.nitiny.ui.shopLinked.ShopLinkedFrPresenter;
import vn.chapp.nitiny.ui.splash.SplashMvpPresenter;
import vn.chapp.nitiny.ui.splash.SplashMvpView;
import vn.chapp.nitiny.ui.splash.SplashPresenter;
import vn.chapp.nitiny.ui.starter.StarterMvpPresenter;
import vn.chapp.nitiny.ui.starter.StarterMvpView;
import vn.chapp.nitiny.ui.starter.StarterPresenter;
import vn.chapp.nitiny.ui.tichDiem.TichDiemAdapter;
import vn.chapp.nitiny.ui.tichDiem.TichDiemFragment;
import vn.chapp.nitiny.ui.wallet.WalletAdapter;
import vn.chapp.nitiny.ui.wallet.WalletFragment;
import vn.chapp.nitiny.ui.web.WebLoaderFrMvpPresent;
import vn.chapp.nitiny.ui.web.WebLoaderFrMvpView;
import vn.chapp.nitiny.ui.web.WebLoaderFrPresenter;

@Module
public class ActivityModule {
    
    private AppCompatActivity activity;
    
    public ActivityModule(AppCompatActivity activity) {
        this.activity = activity;
    }
    
    @Provides
    @ActivityContext
    Context provideContext() {
        return activity;
    }
    
    @Provides
    AppCompatActivity provideActivity() {
        return activity;
    }
    
    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }
    
    @Provides
    Calendar provideCalendar() {
        return Calendar.getInstance();
    }
    
    @Provides
    @PerActivity
    SampleMvpPresenter<SampleMvpView> provideSampleMvpPresenter(SamplePresenter<SampleMvpView> presenter) {
        return presenter;
    }
    
    @Provides
    SampleFrMvpPresent<SampleFrMvpView> provideSampleFrMvpPresent(SampleFrPresenter<SampleFrMvpView> presenter) {
        return presenter;
    }
    
    @Provides
    SplashMvpPresenter<SplashMvpView> provideSplashActivityMvpPresent(SplashPresenter<SplashMvpView> presenter) {
        return presenter;
    }
    
    @Provides
    StarterMvpPresenter<StarterMvpView> provideStarterActivityMvpPresent(StarterPresenter<StarterMvpView> presenter) {
        return presenter;
    }
    
    @Provides
    MainMvpPresenter<MainMvpView> provideMainMvpPresenter(MainPresenter<MainMvpView> presenter) {
        return presenter;
    }
    
    @Provides
    ShopDetailFrMvpPresent<ShopDetailFrMvpView> provideHomeFrMvpPresent(ShopDetailFrPresenter<ShopDetailFrMvpView> presenter) {
        return presenter;
    }
    
    
    @Provides
    @PerActivity
    AuthMvpPresenter<AuthMvpView> provideAuthActivityMvpPresent(AuthPresenter<AuthMvpView> presenter) {
        return presenter;
    }
    
    @Provides
    RegisterFrMvpPresent<RegisterFrMvpView> provideRegisterFrMvpPresent(RegisterFrPresenter<RegisterFrMvpView> presenter) {
        return presenter;
    }
    
    @Provides
    LoginFrMvpPresent<LoginFrMvpView> provideLoginFrMvpPresent(LoginFrPresenter<LoginFrMvpView> presenter) {
        return presenter;
    }
    
    @Provides
    RegisterFragment provideRegisterFragment() {
        return RegisterFragment.newInstance();
    }
    
    @Provides
    LoginFragment provideLoginFragment() {
        return LoginFragment.newInstance();
    }
    
    @Provides
    ShopDetailFragment provideShopDetailFragment() {
        return ShopDetailFragment.newInstance();
    }
    
    @Provides
    ChatFragment provideChatFragment() {
        return ChatFragment.newInstance();
    }
    
    @Provides
    List<FragmentController> provideListFragmentControlers() {
        return new ArrayList<>();
    }
    
    @Provides
    List<TextView> provideTextViewTitleAuth() {
        return new ArrayList<>();
    }
    
    @Provides
    @PerActivity
    BackableMvpPresenter<BackableMvpView> provideBackableActivityMvpPresent(BackablePresenter<BackableMvpView> presenter) {
        return presenter;
    }
    
    @Provides
    ForgotPasswordFrMvpPresent<ForgotPasswordFrMvpView> provideForgotPasswordFrMvpPresent(ForgotPasswordFrPresenter<ForgotPasswordFrMvpView> presenter) {
        return presenter;
    }
    
    @Provides
    ChatRoomFrMvpPresent<ChatRoomFrMvpView> provideChatRoomFrMvpPresent(ChatRoomFrPresenter<ChatRoomFrMvpView> presenter) {
        return presenter;
    }
    
    @Provides
    HistoryFrMvpPresent<HistoryFrMvpView> provideHistoryFrMvpPresent(HistoryFrPresenter<HistoryFrMvpView> presenter) {
        return presenter;
    }
    
    @Provides
    CustomerFrMvpPresent<CustomerFrMvpView> provideCustomerFrMvpPresent(CustomerFrPresenter<CustomerFrMvpView> presenter) {
        return presenter;
    }
    
    @Provides
    ProfileFrMvpPresent<ProfileFrMvpView> provideProfileFrMvpPresent(ProfileFrPresenter<ProfileFrMvpView> presenter) {
        return presenter;
    }
    
    @Provides
    ChatRoomFragment provideChatRoomFragment() {
        return ChatRoomFragment.newInstance();
    }
    
    @Provides
    HistoryFragment provideHistoryFragment() {
        return HistoryFragment.newInstance();
    }
    
    @Provides
    CustomerFragment provideCustomerFragment() {
        return CustomerFragment.newInstance();
    }
    
    @Provides
    ProfileFragment provideProfileFragment() {
        return ProfileFragment.newInstance();
    }
    
    @Provides
    LinkServiceFrMvpPresent<LinkServiceFrMvpView> provideLinkServicesFrMvpPresent(LinkServiceFrPresenter<LinkServiceFrMvpView> presenter) {
        return presenter;
    }
    
    @Provides
    @Named("2Columns")
    GridLayoutManager provideGridTwoLayoutManager() {
        return new GridLayoutManager(activity, 2);
    }
    
    @Provides
    @Named("3Columns")
    GridLayoutManager provideGridThreeLayoutManager() {
        return new GridLayoutManager(activity, 3);
    }
    
    @Provides
    @Named("4Columns")
    GridLayoutManager provideFourGridLayoutManager() {
        return new GridLayoutManager(activity, 4);
    }
    
    @Provides
    ServicesAdapter provideServiceAdapter() {
        return new ServicesAdapter(null);
    }
    
    @Provides
    UpdateInfoServiceFrMvpPresent<UpdateInfoServiceFrMvpView> provideUpdateInfoServiceFrMvpPresent(UpdateInfoServiceFrPresenter<UpdateInfoServiceFrMvpView> presenter) {
        return presenter;
    }
    
    @Provides
    ConfirmLinkingDialogMvpPresenter<ConfirmLinkingDialogMvpView> provideConfirmLinkingDialogMvpPresent(ConfirmLinkingDialogPresenter<ConfirmLinkingDialogMvpView> presenter) {
        return presenter;
    }
    
    @Provides
    @Named("vertical")
    LinearLayoutManager provideLinearLayoutManager() {
        return new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false);
    }
    
    @Provides
    HistoryAdapter provideHistoryAdapter() {
        return new HistoryAdapter(null);
    }
    
    @Provides
    ProfileDetailFrMvpPresent<ProfileDetailFrMvpView> provideProfileDetailFrMvpViewProfileDetailFrMvpPresent(ProfileDetailFrPresenter<ProfileDetailFrMvpView> presenter) {
        return presenter;
    }
    
    @Provides
    @Named("horizontal")
    LinearLayoutManager linearLayoutManagerHorizontal() {
        return new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false);
    }
    
    @Provides
    @Named("vertReverse")
    LinearLayoutManager linearLayoutManagerVertReverse() {
        return new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, true);
    }
    
    @Provides
    CustomerOnlineAdapter provideCustomerOnlineAdapter() {
        return new CustomerOnlineAdapter(null);
    }
    
    @Provides
    ChatBoxAdapter provideChatBoxAdapter() {
        return new ChatBoxAdapter(null);
    }
    
    @Provides
    @PerActivity
    ChatMvpPresenter<ChatMvpView> provideChatMvpPresent(ChatPresenter<ChatMvpView> presenter) {
        return presenter;
    }
    
    @Provides
    ChatAdapter provideChatAdapter() {
        return new ChatAdapter(null);
    }
    
    @Provides
    AddCodeFragment addCodeFragment() {
        return AddCodeFragment.newInstance();
    }
    
    @Provides
    ShopLinkedAdapter shopLinkedAdapter() {
        return new ShopLinkedAdapter(null);
    }
    
    @Provides
    @PerActivity
    DetailMvpPresenter<DetailMvpView> provideDetailMvpPresent(DetailPresenter<DetailMvpView> presenter) {
        return presenter;
    }
    
    @Provides
    ShopDetailServiceAdapter provideMyServiceAdapter() {
        return new ShopDetailServiceAdapter(null);
    }
    
    @Provides
    RatingFragment ratingFragment() {
        return RatingFragment.newInstance();
    }
    
    @Provides
    LinkServiceFragment linkServiceFragment() {
        return LinkServiceFragment.newInstance();
    }
    
    @Provides
    ScheduledAdapter scheduledAdapter() {
        return new ScheduledAdapter(null);
    }
    
    @Provides
    ConfirmAdapter confirmAdapter() {
        return new ConfirmAdapter(null);
    }
    
    @Provides
    ShopSlideMvpPresent<ShopSlideFrMvpView> provideShopSlideFrPresent(ShopSlidePresenter<ShopSlideFrMvpView> presenter) {
        return presenter;
    }
    
    @Provides
    ChangePasswordFrMvpPresent<ChangePasswordFrMvpView> provideChangePasswordPresent(ChangePasswordFrPresenter<ChangePasswordFrMvpView> presenter) {
        return presenter;
    }
    
    @Provides
    BookingFragment bookingFragment() {
        return BookingFragment.newInstance();
    }
    
    @Provides
    BookingAdapter bookingAdapter() {
        return new BookingAdapter(null);
    }
    
    @Provides
    DetailBookingAdapter detailBookingAdapter() {
        return new DetailBookingAdapter(null);
    }
    
    @Provides
    ListProductFrMvpPresent<ListProductFrMvpView> provideListProductFrMvpPresent(ListProductFrPresenter<ListProductFrMvpView> presenter) {
        return presenter;
    }
    
    @Provides
    MyServiceViewPagerAdapter provideMyServiceViewPagerAdapter() {
        return new MyServiceViewPagerAdapter(activity.getSupportFragmentManager());
    }
    
    @Provides
    ListProductAdapter provideListProductAdapter() {
        return new ListProductAdapter(null);
    }
    
    @Provides
    ListNewsAdapter provideListNewsAdapter() {
        return new ListNewsAdapter(null);
    }

    @Provides
    ListNewsDetailAdapter provideListNewsDetailAdapter(){
        return new ListNewsDetailAdapter(null);
    }
    
    @Provides
    DetailHistoryFragment detailHistoryFragment() {
        return DetailHistoryFragment.newInstance(null);
    }
    
    @Provides
    DetailNewsFrMvpPresent<DetailNewsFrMvpView> provideDetailNewsFrMvpPresent(DetailNewsFrPresenter<DetailNewsFrMvpView> presenter) {
        return presenter;
    }
    
    @Provides
    DetailPromotionFrMvpPresent<DetailPromotionFrMvpView> provideDetailPromotionMvpPresent(DetailPromotionFrPresenter<DetailPromotionFrMvpView> presenter) {
        return presenter;
    }
    
    @Provides
    WebLoaderFrMvpPresent<WebLoaderFrMvpView> provideWebLoaderFrMvpPresent(WebLoaderFrPresenter<WebLoaderFrMvpView> presenter) {
        return presenter;
    }
    
    @Provides
    WalletFragment walletFragment() {
        return WalletFragment.newInstance();
    }
    
    @Provides
    WalletAdapter walletAdapter() {
        return new WalletAdapter(null);
    }
    
    @Provides
    @PerActivity
    ChooseLocationMvpPresent<ChooseLocationMvpView> provideChooseLocationMvpPresent(ChooseLocationPresenter<ChooseLocationMvpView> presenter) {
        return presenter;
    }
    
    @Provides
    @PerActivity
    LocationSearchMvpPresent<LocationSearchMvpView> provideLocationSearchMvpPresent(LocationSearchPresenter<LocationSearchMvpView> presenter) {
        return presenter;
    }
    
    @Provides
    SearchPlaceAdapter provideSearchPlaceAdapter() {
        return new SearchPlaceAdapter(null);
    }
    
    @Provides
    Timer provideTimer() {
        return new Timer();
    }
    
    @Provides
    SearchShopFrMvpPresent<SearchShopFrMvpView> provideSearchShopFrMvpPresent(SearchShopFrPresenter<SearchShopFrMvpView> presenter) {
        return presenter;
    }
    
    @Provides
    SearchShopAdapter provideSearchShopAdapter() {
        return new SearchShopAdapter(null);
    }
    
    @Provides
    FusedLocationProviderClient provideFusedLocationProviderClient() {
        return LocationServices.getFusedLocationProviderClient(activity);
    }
    
    @Provides
    ListShopLinkedAdapter listShopLinkedAdapter() {
        return new ListShopLinkedAdapter(null);
    }
    
    @Provides
    ShopLinkedFrMvpPresent<ShopLinkedFrMvpView> shopLinkedFrMvpPresent(ShopLinkedFrPresenter<ShopLinkedFrMvpView> presenter) {
        return presenter;
    }
    
    @Provides
    CustomerLinkAdapter customerLinkAdapter() {
        return new CustomerLinkAdapter(null);
    }
    
    @Provides
    CartFrMvpPresent<CartFrMvpView> provideCartFrMvpViewCartFrMvpPresent(CartFrPresenter<CartFrMvpView> presenter) {
        return presenter;
    }
    
    @Provides
    CartAdapter provideCartAdapter() {
        return new CartAdapter(null);
    }
    
    @Provides
    PointHistoryAdapter providePointHistoryAdapter() {
        return new PointHistoryAdapter(null);
    }

//    @Provides
//    AccumulatePointMvpPresent<AccumulatePointMvpView> provideAccumulatePointMvpPresent(AccumulatePointPresenter<AccumulatePointMvpView> presenter) {
//        return presenter;
//    }
    
    @Provides
    TichDiemFragment tichDiemFragment() {
        return TichDiemFragment.newInstance();
    }
    
    @Provides
    TichDiemAdapter tichDiemAdapter() {
        return new TichDiemAdapter(null);
    }
    
    @Provides
    CartSectionAdapter cartSectionAdapter() {
        return new CartSectionAdapter(null);
    }
    
    @Provides
    ScheduleProductAdapter scheduleProductAdapter() {
        return new ScheduleProductAdapter(null);
    }
    
    @Provides
    ConfirmProductAdapter confirmProductAdapter() {
        return new ConfirmProductAdapter(null);
    }
    
    @Provides
    CommonPickCategoryAdapter commonPickCategoryAdapter() {
        return new CommonPickCategoryAdapter(null);
    }
    
    @Provides
    RefCodeDialogMvpPresenter<RefCodeDialogMvpView> provideRefCodeDialogPresenter(RefCodeDialogPresenter<RefCodeDialogMvpView> presenter) {
        return presenter;
    }
    
    
    @Provides
    NotificationFrMvpPresent<NotificationFrMvpView> provideNotificationFrMvpPresent(NotificationFrPresenter<NotificationFrMvpView> presenter) {
        return presenter;
    }
    
    @Provides
    NotificationFragment provideNotificationFragment() {
        return NotificationFragment.newInstance();
    }
    
    @Provides
    NotificationAdapter provideNotificationAdapter() {
        return new NotificationAdapter(null);
    }
}
