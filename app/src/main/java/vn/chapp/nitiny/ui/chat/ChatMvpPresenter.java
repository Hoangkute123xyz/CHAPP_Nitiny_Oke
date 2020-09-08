package vn.chapp.nitiny.ui.chat;

import vn.chapp.nitiny.base.MvpPresenter;
import vn.chapp.nitiny.di.PerActivity;
import vn.chapp.nitiny.models.auth.UserDefault;
import vn.chapp.nitiny.models.chat.ContentItem;

@PerActivity
public interface ChatMvpPresenter<V extends ChatMvpView> extends MvpPresenter<V> {

    UserDefault getUserDefault();
    void getContentChat(String userId);
    void postChat(ContentItem contentItem);
    void getChatRoom();
}
