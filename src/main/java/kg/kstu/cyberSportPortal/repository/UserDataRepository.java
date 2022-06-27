package kg.kstu.cyberSportPortal.repository;

import kg.kstu.cyberSportPortal.entity.UserData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM users_data t WHERE t.user_id = :userId")
    UserData getByUserId(Long userId);
}
