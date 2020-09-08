package vn.chapp.nitiny.ui.wallet;

import vn.chapp.nitiny.base.MvpView;
import vn.chapp.nitiny.models.wallet.WalletHistory;

public interface WalletFrMvpView extends MvpView {
    void gotWallet(WalletHistory walletHistory);
    void setRefresh(boolean refreshed);
}
