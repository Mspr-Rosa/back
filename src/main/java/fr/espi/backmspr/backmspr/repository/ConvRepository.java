package fr.espi.backmspr.backmspr.repository;

import fr.espi.backmspr.backmspr.entity.ConvEntity;
import fr.espi.backmspr.backmspr.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConvRepository extends JpaRepository<ConvEntity, Long> {

}
