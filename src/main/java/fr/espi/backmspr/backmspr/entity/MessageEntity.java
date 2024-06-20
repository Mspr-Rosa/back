package fr.espi.backmspr.backmspr.entity;

import javax.persistence.*;

@Entity
@Table(name = "message")
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "conversation_id")
    private ConvEntity conversation;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private UserEntity sender;

    private String content;

    public MessageEntity(ConvEntity conversation, UserEntity sender, String content) {
        this.conversation = conversation;
        this.sender = sender;
        this.content = content;
    }


    public void setContent(String content) {
        this.content = content;
    }

    public void setConversation(ConvEntity conversation) {
        this.conversation = conversation;
    }

    public void setSender(UserEntity sender) {
        this.sender = sender;
    }

}
