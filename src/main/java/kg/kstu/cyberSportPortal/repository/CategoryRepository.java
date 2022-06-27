package kg.kstu.cyberSportPortal.repository;

import kg.kstu.cyberSportPortal.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM categories t WHERE t.category_name = :categoryName")
    Category findByName(@Param("categoryName") String categoryName);

    @Query(nativeQuery = true, value = "SELECT * FROM categories t WHERE t.category_type = :categoryType")
    List<Category> findAllByType(@Param("categoryType") String categoryType);
}
