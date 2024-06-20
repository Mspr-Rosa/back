package fr.espi.backmspr.backmspr.service;


import fr.espi.backmspr.backmspr.entity.ConvEntity;
import fr.espi.backmspr.backmspr.entity.MessageEntity;
import fr.espi.backmspr.backmspr.entity.UserEntity;
import fr.espi.backmspr.backmspr.entity.dto.MessagePostDTO;
import fr.espi.backmspr.backmspr.repository.ConvRepository;
import fr.espi.backmspr.backmspr.repository.MessageRepository;
import fr.espi.backmspr.backmspr.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageService {

    MessageRepository MessageRepository;
    UserRepository userRepository;
    ConvRepository convRepository;


    public MessageService(MessageRepository MessageRepository, UserRepository userRepository , ConvRepository convRepository){
        this.MessageRepository = MessageRepository;
        this.userRepository = userRepository;
        this.convRepository = convRepository;
    }

    public List<MessageEntity> getAll(){
        return MessageRepository.findAll();
    }

    public void save(MessagePostDTO message){

        System.out.println(message);
        ConvEntity convEntity = convRepository.getReferenceById(message.getConversation());
        UserEntity userEntity = userRepository.getReferenceById(message.getSender());

        MessageEntity messageEntity = new MessageEntity(convEntity,userEntity,message.getMessage());
        MessageRepository.save(messageEntity);

    }

}
