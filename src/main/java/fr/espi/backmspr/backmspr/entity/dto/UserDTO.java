package fr.espi.backmspr.backmspr.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDTO {

    @JsonIgnore
    private Long id;
    private String user;
    private String mdp;

    public UserDTO(String user,String mdp){
        setMdp(mdp);
        setUser(user);
    }
    public UserDTO(){

    }

    public Long getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getMdp() {
        return mdp;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
