package fr.espi.backmspr.backmspr.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue()
    @JsonIgnore
    private Integer id;
    private String user;
    private String mdp;

    public Integer getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getMdp() {
        return mdp;
    }

}
