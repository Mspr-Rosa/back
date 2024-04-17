package fr.espi.backmspr.backmspr.repository;

import fr.espi.backmspr.backmspr.entity.FlowerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlowerRepository extends JpaRepository<FlowerEntity, Long> {
}
