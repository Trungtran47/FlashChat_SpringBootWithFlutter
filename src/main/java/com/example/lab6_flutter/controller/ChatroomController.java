package com.example.lab6_flutter.controller;

import com.example.lab6_flutter.entity.ChatRoom;
import com.example.lab6_flutter.entity.User;
import com.example.lab6_flutter.service.ChatRoomService;
import com.example.lab6_flutter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class ChatroomController {
    @Autowired
    private ChatRoomService chatRoomService;
    @Autowired
    private UserService userService;
    // Lấy danh sách tin nhắn
    @GetMapping("/messager")
    public ResponseEntity<List<ChatRoom>> getUsers() {
        List<ChatRoom> chatRooms = chatRoomService.ShowListMessage();
        return new ResponseEntity<>(chatRooms, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody  User user) {
        try {
            userService.login(user);
            return new ResponseEntity<>("Đăng nhập thành công", HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>("Đăng nhập thất bại "+ e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }
    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody User user) {

        try {
            userService.register(user);
            return new ResponseEntity<>("Đăng ký thành công", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Đăng ký thất bại "+ e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }
    // Gửi tin nhắn
    @PostMapping("/send")
    public ResponseEntity<?> send(@RequestBody ChatRoom chatRoom) {
        try {
            chatRoom.setTime(LocalDateTime.now()); // Đặt thời gian hiện tại
            ChatRoom savedChatRoom = chatRoomService.SendMessage(chatRoom); // Đảm bảo phương thức tuân theo quy tắc camelCase
            return new ResponseEntity<>(savedChatRoom, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Gửi tin nhắn thất bại: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR); // Sử dụng mã trạng thái lỗi phù hợp
        }
    }

}
