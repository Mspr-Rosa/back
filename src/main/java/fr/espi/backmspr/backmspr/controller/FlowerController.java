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
    public ResponseEntity<FlowerDTO> makeFlower(@RequestBody FlowerDTO flowerDTO){

        FlowerEntity flowerEntity = convertToEntity(flowerDTO);
        FlowerEntity createdflower = flowerService.makeFlower(flowerEntity);
        FlowerDTO createdFlower = convertToDTO(createdflower);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdFlower);
    }



    // Méthode pour convertir FlowerDTO en Flower
    private FlowerEntity convertToEntity(FlowerDTO flowerDTO) {
        FlowerEntity flower = new FlowerEntity();
        flower.setFlower(flowerDTO.getFlower());
        flower.setDescription(flowerDTO.getDescription());
        flower.setUserid(flowerDTO.getUserId());
        return flower;
    }

    // Méthode pour convertir Flower en FlowerDTO
    private FlowerDTO convertToDTO(FlowerEntity flower) {
        FlowerDTO flowerDTO = new FlowerDTO();
        flowerDTO.setFlower(flower.getFlower());
        flowerDTO.setDescription(flower.getDescription());
        flowerDTO.setUserId(flower.getUserid()); // Si vous avez besoin de l'ID de l'utilisateur
        return flowerDTO;
    }


}
