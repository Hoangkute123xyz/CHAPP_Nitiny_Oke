package vn.chapp.nitiny.ui.chat;


import vn.chapp.nitiny.base.MvpPresenter;

public interface ChatRoomFrMvpPresent<V extends ChatRoomFrMvpView> extends MvpPresenter<V> {
    void getUserLinked();
    void getChatRoom();
}
