package com.example.lab6_flutter.repository;

import com.example.lab6_flutter.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatroomRepository extends JpaRepository<ChatRoom, Long> {

}
