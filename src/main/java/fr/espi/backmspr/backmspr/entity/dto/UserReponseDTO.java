package fr.espi.backmspr.backmspr.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserReponseDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("username")
    private String username;

    public UserReponseDTO(long id, String username) {
        this.id = id;
        this.username = username;
    }

}
