package fr.espi.backmspr.backmspr.service;

import fr.espi.backmspr.backmspr.entity.ConvEntity;
import fr.espi.backmspr.backmspr.entity.UserEntity;
import fr.espi.backmspr.backmspr.entity.dto.ConversationPostDTO;
import fr.espi.backmspr.backmspr.repository.ConvRepository;
import fr.espi.backmspr.backmspr.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConvService {

    ConvRepository convRepository;
    UserRepository userRepository;

    public ConvService(ConvRepository ConvRepository, UserRepository UserRepository){
        this.convRepository = ConvRepository;
        this.userRepository = UserRepository;
    }

    public List<ConvEntity> getAll(){
        return convRepository.findAll();
    }

    public void save(ConversationPostDTO conversationPostDTO){

        UserEntity user1 = userRepository.getReferenceById(conversationPostDTO.getUser_id1());
        UserEntity user2 = userRepository.getReferenceById(conversationPostDTO.getUser_id2());

        ConvEntity convEntity = new ConvEntity(user1,user2);

        convRepository.save(convEntity);
    }

}
