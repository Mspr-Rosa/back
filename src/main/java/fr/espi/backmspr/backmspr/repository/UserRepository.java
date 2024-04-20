package fr.espi.backmspr.backmspr.repository;

import fr.espi.backmspr.backmspr.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {


    @Query(value = "SELECT * FROM USERS WHERE user = ?1 AND mdp = ?2", nativeQuery = true)
    Optional<UserEntity> findByUsername(String user);
    Boolean existsByUsername(String user);
    UserEntity login(String user, String mdp);

}
