package vn.chapp.nitiny.ui.chat;


import java.util.List;

import vn.chapp.nitiny.base.MvpView;
import vn.chapp.nitiny.models.chat.ChatRoom;
import vn.chapp.nitiny.models.chat.ContentItem;

public interface ChatMvpView extends MvpView {
    void parseChat(List<ContentItem> msgs);
    void parseChatRoom(ChatRoom chatRoom);
}
