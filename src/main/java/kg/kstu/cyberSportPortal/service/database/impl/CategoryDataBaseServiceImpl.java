package kg.kstu.cyberSportPortal.service.database.impl;

import kg.kstu.cyberSportPortal.entity.Category;
import kg.kstu.cyberSportPortal.repository.CategoryRepository;
import kg.kstu.cyberSportPortal.service.base.impl.CrudServiceImpl;
import kg.kstu.cyberSportPortal.service.database.CategoryDataBaseService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryDataBaseServiceImpl extends CrudServiceImpl<Category> implements CategoryDataBaseService {
    final CategoryRepository categoryRepository;

    @Autowired
    public CategoryDataBaseServiceImpl(CategoryRepository categoryRepository) {
        super(categoryRepository);
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findByName(String categoryName) {
        return categoryRepository.findByName(categoryName);
    }

    @Override
    public List<Category> findAllByType(String categoryType) {
        return categoryRepository.findAllByType(categoryType);
    }
}
