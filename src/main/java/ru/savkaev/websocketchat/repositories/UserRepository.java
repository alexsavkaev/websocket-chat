package ru.savkaev.websocketchat.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.savkaev.websocketchat.domain.user.Status;
import ru.savkaev.websocketchat.domain.user.User;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findAllByStatus(Status status);
}
