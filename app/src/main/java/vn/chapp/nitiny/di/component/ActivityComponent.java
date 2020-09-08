package vn.chapp.nitiny.di.component;

import dagger.Component;
import vn.chapp.nitiny.di.PerActivity;
import vn.chapp.nitiny.di.module.ActivityModule;
import vn.chapp.nitiny.ui.accumulatepoint.AccumulatePointFragment;
import vn.chapp.nitiny.ui.addCode.AddCodeFragment;
import vn.chapp.nitiny.ui.auth.ChangePasswordFragment;
import vn.chapp.nitiny.ui.auth.login.RefCodeDialog;
import vn.chapp.nitiny.ui.booking.BookingFragment;
import vn.chapp.nitiny.ui.cart.CartFragment;
import vn.chapp.nitiny.ui.chat.ChatActivity;
import vn.chapp.nitiny.ui.chat.ChatFragment;
import vn.chapp.nitiny.ui.chat.ChatRoomFragment;
import vn.chapp.nitiny.ui.customer.CustomerFragment;
import vn.chapp.nitiny.ui.detail.DetailActivity;
import vn.chapp.nitiny.ui.detail.DetailNewsFragment;
import vn.chapp.nitiny.ui.detail.DetailPromotionFragment;
import vn.chapp.nitiny.ui.detailBooking.DetailBookingFragment;
import vn.chapp.nitiny.ui.detailHistory.DetailHistoryFragment;
import vn.chapp.nitiny.ui.detailProduct.DetailProductFragment;
import vn.chapp.nitiny.ui.history.HistoryFragment;
import vn.chapp.nitiny.ui.location.ChooseLocationActivity;
import vn.chapp.nitiny.ui.location.locationsearch.LocationSearchActivity;
import vn.chapp.nitiny.ui.noti.NotificationDetailFragment;
import vn.chapp.nitiny.ui.noti.NotificationFragment;
import vn.chapp.nitiny.ui.rating.ShopSlideFragment;
import vn.chapp.nitiny.ui.scheduledProduct.ConfirmProductFragment;
import vn.chapp.nitiny.ui.scheduledProduct.ScheduleProductFragment;
import vn.chapp.nitiny.ui.services.SearchShopFragment;
import vn.chapp.nitiny.ui.shop.ListProductFragment;
import vn.chapp.nitiny.ui.shop.ShopDetailFragment;
import vn.chapp.nitiny.ui.main.MainActivity;
import vn.chapp.nitiny.ui.auth.AuthActivity;
import vn.chapp.nitiny.ui.auth.forgot.ForgotPasswordFragment;
import vn.chapp.nitiny.ui.auth.login.LoginFragment;
import vn.chapp.nitiny.ui.auth.register.RegisterFragment;
import vn.chapp.nitiny.ui.main.BackableActivity;
import vn.chapp.nitiny.ui.profile.ProfileDetailFragment;
import vn.chapp.nitiny.ui.profile.ProfileFragment;
import vn.chapp.nitiny.ui.rating.RatingFragment;
import vn.chapp.nitiny.ui.sample.SampleActivity;
import vn.chapp.nitiny.ui.sample.SampleFragment;
import vn.chapp.nitiny.ui.scheduled.ConfirmFragment;
import vn.chapp.nitiny.ui.scheduled.ScheduleFragment;
import vn.chapp.nitiny.ui.services.ConfirmLinkingDialog;
import vn.chapp.nitiny.ui.services.LinkServiceFragment;
import vn.chapp.nitiny.ui.services.UpdateInfoServiceFragment;
import vn.chapp.nitiny.ui.shopLinked.ShopLinkedFragment;
import vn.chapp.nitiny.ui.splash.SplashActivity;
import vn.chapp.nitiny.ui.starter.StarterActivity;
import vn.chapp.nitiny.ui.tichDiem.TichDiemFragment;
import vn.chapp.nitiny.ui.wallet.WalletFragment;
import vn.chapp.nitiny.ui.web.WebLoaderFragment;


@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(SampleActivity sampleActivity);

    void inject(SampleFragment sampleFragment);

    void inject(SplashActivity splashActivity);

    void inject(StarterActivity starterActivity);

    void inject(MainActivity mainActivity);

    void inject(ShopDetailFragment homeFragment);

    void inject(AuthActivity authActivity);

    void inject(RegisterFragment registerFragment);

    void inject(LoginFragment loginFragment);

    void inject(BackableActivity backableActivity);

    void inject(ForgotPasswordFragment forgotPasswordFragment);

    void inject(ChatRoomFragment chatRoomFragment);

    void inject(HistoryFragment historyFragment);

    void inject(CustomerFragment customerFragment);

    void inject(ProfileFragment profileFragment);

    void inject(LinkServiceFragment linkServiceFragment);

    void inject(UpdateInfoServiceFragment updateInfoServiceFragment);

    void inject(ConfirmLinkingDialog confirmLinkingDialog);

    void inject(ProfileDetailFragment profileDetailFragment);

    void inject(ChatActivity chatActivity);

    void inject(AddCodeFragment addCodeFragment);

    void inject(DetailActivity detailActivity);

    void inject(ScheduleFragment scheduleFragment);

    void inject(ConfirmFragment confirmFragment);

    void inject(RatingFragment ratingFragment);

    void inject(ShopSlideFragment shopSlideFragment);

    void inject(ChangePasswordFragment changePasswordFragment);

    void inject(BookingFragment bookingFragment);

    void inject(DetailBookingFragment detailBookingFragment);

    void inject(DetailProductFragment detailProductFragment);

    void inject(ListProductFragment listProductFragment);

    void inject(DetailHistoryFragment detailHistoryFragment);

    void inject(DetailNewsFragment detailNewsFragment);

    void inject(DetailPromotionFragment detailPromotionFragment);

    void inject(WebLoaderFragment webLoaderFragment);

    void inject(WalletFragment walletFragment);

    void inject(LocationSearchActivity locationSearchActivity);

    void inject(ChooseLocationActivity chooseLocationActivity);

    void inject(SearchShopFragment searchShopFragment);

    void inject(ShopLinkedFragment shopLinkedFragment);

    void inject(ChatFragment chatFragment);

    void inject(AccumulatePointFragment accumulatePointFragment);

    void inject(CartFragment cartFragment);

    void inject(TichDiemFragment tichDiemFragment);

    void inject(ScheduleProductFragment scheduleProductFragment);

    void inject(ConfirmProductFragment confirmProductFragment);

    void inject(RefCodeDialog refCodeDialog);

    void inject(NotificationFragment notificationFragment);

    void inject(NotificationDetailFragment notificationDetailFragment);
    
}
