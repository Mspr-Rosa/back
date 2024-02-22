package fr.espi.backmspr.backmspr.service;

import fr.espi.backmspr.backmspr.entity.UserEntity;
import fr.espi.backmspr.backmspr.repository.UserRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Component
public class UserService {

    UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    public UserEntity makeUser(UserEntity userEntity){
        return userRepository.save(userEntity);
    }

    public UserEntity login(String user, String mdp){
        return userRepository.login(user, mdp);
    }

}
