package fr.espi.backmspr.backmspr.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

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
