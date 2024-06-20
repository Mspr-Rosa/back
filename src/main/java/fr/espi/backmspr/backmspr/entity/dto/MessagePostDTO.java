package fr.espi.backmspr.backmspr.entity.dto;

public class MessagePostDTO {

    private String message;
    private Long sender;
    private Long conversation;


    public MessagePostDTO(String message, Long sender, Long conversation) {
        this.message = message;
        this.sender = sender;
        this.conversation = conversation;
    }

    public Long getConversation() {
        return conversation;
    }

    public Long getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }
}
