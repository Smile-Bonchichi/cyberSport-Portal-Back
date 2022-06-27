package kg.kstu.cyberSportPortal.repository;

import kg.kstu.cyberSportPortal.entity.Game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM games t WHERE t.game_name = :name")
    Game getByGameName(@Param("name") String name);
}
