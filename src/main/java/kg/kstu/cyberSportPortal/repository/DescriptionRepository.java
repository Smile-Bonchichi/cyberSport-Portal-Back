package kg.kstu.cyberSportPortal.repository;

import kg.kstu.cyberSportPortal.entity.Description;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescriptionRepository extends JpaRepository<Description, Long> {
}
