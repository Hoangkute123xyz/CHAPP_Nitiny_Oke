package vn.chapp.nitiny.ui.wallet;

import vn.chapp.nitiny.base.MvpPresenter;

public interface WalletFrMvpPresent <V extends WalletFrMvpView> extends MvpPresenter<V> {
    void getWallet();
}