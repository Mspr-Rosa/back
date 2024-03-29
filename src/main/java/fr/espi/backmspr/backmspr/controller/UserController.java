package fr.espi.backmspr.backmspr.controller;

import fr.espi.backmspr.backmspr.entity.UserEntity;
import fr.espi.backmspr.backmspr.entity.dto.UserDTO;
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
    public List<UserEntity> findAll(){
        return userService.findAll();
    }

    @PostMapping("make")
    public ResponseEntity<UserEntity> makeUser(@RequestBody UserDTO userDTO){

        UserEntity user = userService.makeUser(userDTO);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("login")
    public boolean login(String user, String mdp){

        if(userService.login(user, mdp) == null){
            return false;
        }else {
            return true;
        }

    }

}
