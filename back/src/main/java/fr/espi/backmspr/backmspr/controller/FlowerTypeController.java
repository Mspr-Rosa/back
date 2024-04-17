package fr.espi.backmspr.backmspr.controller;

import fr.espi.backmspr.backmspr.entity.FlowerTypeEntity;
import fr.espi.backmspr.backmspr.service.FlowerTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("flowerType")
public class FlowerTypeController {

    FlowerTypeService flowerTypeService;
    public FlowerTypeController(FlowerTypeService flowerTypeService){
        this.flowerTypeService = flowerTypeService;
    }

    @GetMapping("")
    public List<FlowerTypeEntity> getAll(){
        return flowerTypeService.getAll();
    }

    @PostMapping("make")
    public ResponseEntity<FlowerTypeEntity> make(@RequestBody FlowerTypeEntity flowerTypeEntity){

        FlowerTypeEntity flower = flowerTypeService.make(flowerTypeEntity);

        return ResponseEntity.status(HttpStatus.CREATED).body(flower);
    }

}
