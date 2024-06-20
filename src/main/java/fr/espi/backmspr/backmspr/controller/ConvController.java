package fr.espi.backmspr.backmspr.controller;

import fr.espi.backmspr.backmspr.entity.ConvEntity;
import fr.espi.backmspr.backmspr.entity.dto.ConversationPostDTO;
import fr.espi.backmspr.backmspr.security.JWTGenerator;
import fr.espi.backmspr.backmspr.service.ConvService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("conv")
public class ConvController {

    ConvService convService;
    JWTGenerator jwtGenerator;

    public ConvController(ConvService convService , JWTGenerator jwtGenerator){
        this.convService = convService;
        this.jwtGenerator = jwtGenerator;
    }

    @GetMapping("")
    public List<ConvEntity> getAll(String token){
        return convService.getAll();
    }

    @PostMapping("")
    public String makeConv(@RequestBody ConversationPostDTO conversationPostDTO){
        convService.save(conversationPostDTO);
        return "conversation crée";
    }
}
