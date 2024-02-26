package fr.espi.backmspr.backmspr.service;

import fr.espi.backmspr.backmspr.entity.FlowerEntity;
import fr.espi.backmspr.backmspr.entity.UserEntity;
import fr.espi.backmspr.backmspr.entity.dto.FlowerDTO;
import fr.espi.backmspr.backmspr.entity.dto.UserDTO;
import fr.espi.backmspr.backmspr.repository.UserRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.concurrent.Flow;

@Component
public class UserService {

    UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    public UserEntity makeUser(UserDTO userDTO){

        UserEntity user = new UserEntity(userDTO.getUser(),userDTO.getMdp());

        return userRepository.save(user);
    }

    public UserEntity login(String user, String mdp){
        return userRepository.login(user, mdp);
    }

}
