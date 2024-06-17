package fr.espi.backmspr.backmspr.entity;

import javax.persistence.*;

@Entity
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

}