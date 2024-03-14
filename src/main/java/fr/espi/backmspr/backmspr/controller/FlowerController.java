package fr.espi.backmspr.backmspr.controller;

import fr.espi.backmspr.backmspr.entity.UserEntity;
import fr.espi.backmspr.backmspr.entity.dto.FlowerDTO;
import fr.espi.backmspr.backmspr.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import fr.espi.backmspr.backmspr.entity.FlowerEntity;
import fr.espi.backmspr.backmspr.service.FlowerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@RequestMapping("flowers")
public class FlowerController {
    FlowerService flowerService;
    public FlowerController(FlowerService flowerService){
        this.flowerService = flowerService;
    }

    @GetMapping("")
    public List<FlowerEntity> getAll(){
        return flowerService.getAll();
    }

    @PostMapping("make")
    public ResponseEntity<FlowerEntity> makeFlower(@RequestBody FlowerDTO flowerDTO){
        FlowerEntity flower = flowerService.makeFlower(flowerDTO);
        return new ResponseEntity<>(flower, HttpStatus.CREATED);
    }


}
