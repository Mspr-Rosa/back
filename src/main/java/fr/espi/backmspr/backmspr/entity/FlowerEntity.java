package fr.espi.backmspr.backmspr.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import java.util.Set;

@Entity
@Table(name = "flower")
public class FlowerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String flower;
    private String description;
    private Double longitude;
    private Double latitude;
    private String locationName;
    private String titre;


    @ManyToOne()
    @JsonIgnore
    private UserEntity userEntity;

    public FlowerEntity(){

    }

    public FlowerEntity(int id, String flower, String description, Double latitude, Double longitude, String locationName, String titre){
        this.flower = flower;
        this.description = description;
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.locationName = locationName;
        this.titre = titre;
    }

    public long getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getFlower() {
        return flower;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public String getDescription() {
        return description;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
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
