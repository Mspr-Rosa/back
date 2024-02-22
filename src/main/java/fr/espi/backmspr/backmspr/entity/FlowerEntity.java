package fr.espi.backmspr.backmspr.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "flower")
public class FlowerEntity {

    @Id
    @GeneratedValue()
    @JsonIgnore
    private Integer id;
    private String flower;

    private String description;

    @JoinColumn(name = "userid")
    private Integer userid;

    public long getId() {
        return id;
    }

    public String getFlower() {
        return flower;
    }

    public Integer getUserid() {
        return userid;
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

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}
