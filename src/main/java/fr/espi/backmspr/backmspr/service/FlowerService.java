package fr.espi.backmspr.backmspr.service;

import fr.espi.backmspr.backmspr.entity.FlowerEntity;
import fr.espi.backmspr.backmspr.entity.UserEntity;
import fr.espi.backmspr.backmspr.entity.dto.FlowerDTO;
import fr.espi.backmspr.backmspr.repository.FlowerRepository;
import fr.espi.backmspr.backmspr.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Component
public class FlowerService {

    FlowerRepository flowerRepository;
    UserRepository userRepository;
    public FlowerService(FlowerRepository flowerRepository, UserRepository userRepository){
        this.flowerRepository = flowerRepository;
        this.userRepository = userRepository;
    }

    public List<FlowerEntity> getAll(){
        return flowerRepository.findAll();
    }

    public FlowerEntity makeFlower(FlowerDTO flower){

        FlowerEntity flowerEntity = new FlowerEntity();
        UserEntity user = userRepository.getReferenceById(flower.getUserId());

        flowerEntity.setDescription(flower.getDescription());
        flowerEntity.setUserEntity(user);
        flowerEntity.setFlower(flower.getFlower());

        return flowerRepository.save(flowerEntity);
    }

}
