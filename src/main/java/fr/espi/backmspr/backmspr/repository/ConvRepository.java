package fr.espi.backmspr.backmspr.repository;

import fr.espi.backmspr.backmspr.entity.ConvEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConvRepository extends JpaRepository<ConvEntity, Long> {
}
