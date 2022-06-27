package kg.kstu.cyberSportPortal.service.util.impl;

import kg.kstu.cyberSportPortal.entity.Category;
import kg.kstu.cyberSportPortal.service.database.CategoryDataBaseService;
import kg.kstu.cyberSportPortal.service.util.CategoryParserService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryParserServiceImpl implements CategoryParserService {
    final CategoryDataBaseService categoryDataBaseService;

    @Autowired
    public CategoryParserServiceImpl(CategoryDataBaseService categoryDataBaseService) {
        this.categoryDataBaseService = categoryDataBaseService;
    }

    @Override
    public List<Category> addUpdateCategory(List<Long> categoryIds) {
        List<Category> categories = new ArrayList<>();

        for (Long categoryId : categoryIds) {
            categories.add(categoryDataBaseService.getById(categoryId));
        }

        return categories;
    }
}
