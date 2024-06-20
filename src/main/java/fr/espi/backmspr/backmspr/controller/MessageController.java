package fr.espi.backmspr.backmspr.controller;

import fr.espi.backmspr.backmspr.entity.MessageEntity;
import fr.espi.backmspr.backmspr.entity.dto.ConversationPostDTO;
import fr.espi.backmspr.backmspr.entity.dto.MessagePostDTO;
import fr.espi.backmspr.backmspr.service.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("message")
public class MessageController {

    MessageService messageService;
    public MessageController(MessageService messageService){
        this.messageService = messageService;
    }

    @GetMapping("")
    public List<MessageEntity> getAll(){
        return messageService.getAll();
    }

    @PostMapping("")
    public String makeConv(@RequestBody MessagePostDTO messagePostDTO){
        messageService.save(messagePostDTO);
        return "message envoyer";
    }



}