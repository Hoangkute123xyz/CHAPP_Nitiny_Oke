package vn.chapp.nitiny.ui.chat;

import java.util.List;

import vn.chapp.nitiny.base.MvpView;
import vn.chapp.nitiny.models.chat.ChatRoom;
import vn.chapp.nitiny.models.service.Shop;

public interface ChatRoomFrMvpView extends MvpView {
    void parseUserLinked(List<Shop> userLinkeds);
    void parseChatRoom(List<ChatRoom> chatRooms);
}
