package fr.espi.backmspr.backmspr.service;

import fr.espi.backmspr.backmspr.entity.FlowerEntity;
import fr.espi.backmspr.backmspr.entity.FlowerTypeEntity;
import fr.espi.backmspr.backmspr.entity.dto.FlowerTypeDTO;
import fr.espi.backmspr.backmspr.repository.FlowerTypeRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlowerTypeService {

    FlowerTypeRepository flowerTypeRepository;
    public FlowerTypeService(FlowerTypeRepository flowerTypeRepository){
        this.flowerTypeRepository = flowerTypeRepository;
    }

    public List<FlowerTypeEntity> getAll(){
        return flowerTypeRepository.findAll();
    }

    public FlowerTypeEntity make(FlowerTypeDTO flower){

        FlowerTypeEntity flowertype = new FlowerTypeEntity(flower.getName(),flower.getDescription());

        return flowerTypeRepository.save(flowertype);
    }

}
