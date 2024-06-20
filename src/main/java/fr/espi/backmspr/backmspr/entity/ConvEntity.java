package fr.espi.backmspr.backmspr.entity;

import fr.espi.backmspr.backmspr.entity.dto.ConversationPostDTO;

import javax.persistence.*;

@Entity
@Table(name = "conversation")
public class ConvEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user1_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "user2_id")
    private UserEntity user2;

    public ConvEntity(){

    }

    public ConvEntity(UserEntity user, UserEntity user2){
        this.user = user;
        this.user2 = user2;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

}