package fr.espi.backmspr.backmspr.entity;

import javax.persistence.*;

@Entity
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

}
