package kg.kstu.cyberSportPortal.repository;

import kg.kstu.cyberSportPortal.entity.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM roles t WHERE t.role_name = :roleName")
    Role getByRoleName(@Param("roleName") String roleName);
}
