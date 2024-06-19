package fr.espi.backmspr.backmspr.service;


import fr.espi.backmspr.backmspr.entity.MessageEntity;
import fr.espi.backmspr.backmspr.repository.MessageRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageService {

    MessageRepository MessageRepository;
    public MessageService(MessageRepository MessageRepository){
        this.MessageRepository = MessageRepository;
    }

    public List<MessageEntity> getAll(){
        return MessageRepository.findAll();
    }

}
