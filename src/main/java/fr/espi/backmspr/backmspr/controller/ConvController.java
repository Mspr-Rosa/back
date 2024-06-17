package fr.espi.backmspr.backmspr.controller;

import fr.espi.backmspr.backmspr.entity.ConvEntity;
import fr.espi.backmspr.backmspr.service.ConvService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("conv")
public class ConvController {

    ConvService convService;
    public ConvController(ConvService convService){
        this.convService = convService;
    }

    @GetMapping("")
    public List<ConvEntity> getAll(){
        return convService.getAll();
    }
}
