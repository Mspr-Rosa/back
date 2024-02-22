package fr.espi.backmspr.backmspr.service;

import fr.espi.backmspr.backmspr.entity.FlowerEntity;
import fr.espi.backmspr.backmspr.repository.FlowerRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Component
public class FlowerService {

    FlowerRepository flowerRepository;
    public FlowerService(FlowerRepository flowerRepository){
        this.flowerRepository = flowerRepository;
    }

    public List<FlowerEntity> getAll(){
        return flowerRepository.findAll();
    }

    public FlowerEntity makeFlower(FlowerEntity flower){
        return flowerRepository.save(flower);
    }

}
