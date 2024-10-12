package com.example.lab6_flutter.serviceIpm;

import com.example.lab6_flutter.entity.ChatRoom;
import com.example.lab6_flutter.entity.User;
import com.example.lab6_flutter.repository.ChatroomRepository;
import com.example.lab6_flutter.repository.UserRepository;
import com.example.lab6_flutter.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatroomServiceIpm implements ChatRoomService {
    @Autowired
    private ChatroomRepository chatroomRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<ChatRoom> ShowListMessage() {
        return chatroomRepository.findAll();
    }

    @Override
    public ChatRoom SendMessage(ChatRoom chatRoom) {
        User user = userRepository.findByEmail(chatRoom.getUser().getEmail());
        // Thiết lập User cho ChatRoom

        chatRoom.setUser(user);
         return chatroomRepository.save(chatRoom);
    }


}
