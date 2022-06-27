package kg.kstu.cyberSportPortal.service.database;

import kg.kstu.cyberSportPortal.entity.Category;
import kg.kstu.cyberSportPortal.service.base.CrudService;

import java.util.List;

public interface CategoryDataBaseService extends CrudService<Category> {
    Category findByName(String categoryName);

    List<Category> findAllByType(String categoryType);
}
