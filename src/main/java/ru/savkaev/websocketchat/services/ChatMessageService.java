package ru.savkaev.websocketchat.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.savkaev.websocketchat.domain.ChatMessage;
import ru.savkaev.websocketchat.repositories.ChatMessageRepository;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatMessageService {
    private final ChatMessageRepository repository;
    private ChatRoomService chatRoomService;

    public ChatMessage save (ChatMessage chatMessage){
        var chatId = chatRoomService.getChatRoomId(
                chatMessage.getSenderId(),
                chatMessage.getRecipientId(),
                true
        ).orElseThrow();
        chatMessage.setChatId(chatId);
        return repository.save(chatMessage);
    }

    public List<ChatMessage> findChatMessages  (String senderId, String recipientId)   {
        var chatId = chatRoomService.getChatRoomId(
                senderId,
                recipientId,
                false
        );
        return chatId.map(repository::findByChatId).orElse(new ArrayList<>());
    }
}
