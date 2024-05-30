package fr.espi.backmspr.backmspr.controller;

import fr.espi.backmspr.backmspr.entity.UserEntity;
import fr.espi.backmspr.backmspr.entity.dto.UserDTO;
import fr.espi.backmspr.backmspr.entity.dto.UserReponseDTO;
import fr.espi.backmspr.backmspr.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController()
@RequestMapping("users")
public class UserController {

    UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("")
    public List<UserReponseDTO> findAll(){
        return userService.findAll();
    }


}
