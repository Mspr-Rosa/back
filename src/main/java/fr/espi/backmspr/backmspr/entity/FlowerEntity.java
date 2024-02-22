package fr.espi.backmspr.backmspr.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

@Entity
@Table(name = "flower")
public class FlowerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;
    private String flower;

    private String description;
    @ManyToOne()
    @JsonIgnore
    private UserEntity userEntity;

    public long getId() {
        return id;
    }

    public String getFlower() {
        return flower;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFlower(String flower) {
        this.flower = flower;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
