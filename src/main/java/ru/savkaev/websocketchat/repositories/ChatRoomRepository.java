package ru.savkaev.websocketchat.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.savkaev.websocketchat.domain.chatroom.ChatRoom;

import java.util.Optional;

public interface ChatRoomRepository extends MongoRepository<ChatRoom, String> {
    Optional<ChatRoom> findBySenderIdAndRecipientId(String senderId, String recipientId);
}
