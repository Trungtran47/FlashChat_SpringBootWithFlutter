package com.example.lab6_flutter.service;

import com.example.lab6_flutter.entity.ChatRoom;

import java.util.List;

public interface ChatRoomService {
    List<ChatRoom> ShowListMessage();
    ChatRoom SendMessage(ChatRoom chatRoom);
}
