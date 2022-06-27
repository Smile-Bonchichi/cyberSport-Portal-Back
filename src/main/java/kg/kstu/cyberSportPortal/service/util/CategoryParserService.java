package kg.kstu.cyberSportPortal.service.util;

import kg.kstu.cyberSportPortal.entity.Category;

import java.util.List;

public interface CategoryParserService {
    List<Category> addUpdateCategory(List<Long> categoryIds);
}
