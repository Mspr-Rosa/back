package fr.espi.backmspr.backmspr.repository;

import fr.espi.backmspr.backmspr.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
}
