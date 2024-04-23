package fr.espi.backmspr.backmspr.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class UserEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String user;
    private String mdp;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)

    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles = new ArrayList<>();


    @OneToMany(mappedBy="userEntity")
    private Set<FlowerEntity> flowers;

    public UserEntity(Long id,String user,String mdp){
        this.id = id;
        this.user = user;
        this.mdp = mdp;
    }

    public UserEntity(){
    }

    public UserEntity(String user,String mdp){
        setMdp(mdp);
        setUser(user);
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

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public void setId(Long id) {
        this.id = id;
    }

}
