package fr.espi.backmspr.backmspr.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "flower_type")
public class FlowerTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;
    private String name;
    private String description;

    public FlowerTypeEntity(){

    }
    public FlowerTypeEntity(String name, String description){

        this.description = description;
        this.name = name;

    }


    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}
