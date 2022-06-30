package kg.kstu.cyberSportPortal.repository;

import kg.kstu.cyberSportPortal.entity.Image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}
