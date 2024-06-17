package fr.espi.backmspr.backmspr.service;

import fr.espi.backmspr.backmspr.entity.ConvEntity;
import fr.espi.backmspr.backmspr.repository.ConvRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConvService {

    ConvRepository ConvRepository;
    public ConvService(ConvRepository ConvRepository){
        this.ConvRepository = ConvRepository;
    }

    public List<ConvEntity> getAll(){
        return ConvRepository.findAll();
    }
}
