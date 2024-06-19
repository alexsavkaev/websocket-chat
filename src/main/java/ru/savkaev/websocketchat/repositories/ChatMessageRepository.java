package ru.savkaev.websocketchat.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.savkaev.websocketchat.domain.ChatMessage;

import java.util.List;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {
    List<ChatMessage> findByChatId(String chatId);
}
