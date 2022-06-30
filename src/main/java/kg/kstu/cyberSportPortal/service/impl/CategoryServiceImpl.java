package kg.kstu.cyberSportPortal.service.impl;

import kg.kstu.cyberSportPortal.dto.request.category.CategoryDtoRequest;
import kg.kstu.cyberSportPortal.dto.response.category.CategoryDtoResponse;
import kg.kstu.cyberSportPortal.entity.Category;
import kg.kstu.cyberSportPortal.enums.CategoryType;
import kg.kstu.cyberSportPortal.exception.CategoryNotFoundException;
import kg.kstu.cyberSportPortal.mapper.CategoryMapper;
import kg.kstu.cyberSportPortal.service.CategoryService;
import kg.kstu.cyberSportPortal.service.database.CategoryDataBaseService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryServiceImpl implements CategoryService {
    final CategoryDataBaseService categoryDataBaseService;

    @Autowired
    public CategoryServiceImpl(CategoryDataBaseService categoryDataBaseService) {
        this.categoryDataBaseService = categoryDataBaseService;
    }

    @Override
    public List<CategoryDtoResponse> getAllCategoryNameByType(String type) {
        try {
            return CategoryMapper.INSTANCE.toCategoriesDto(
                    categoryDataBaseService.findAllByType(CategoryType.valueOf(type).name())
            );
        } catch (Exception e) {
            throw new CategoryNotFoundException("Такого типа категории нет", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public CategoryDtoResponse createUpdateCategory(CategoryDtoRequest categoryDtoRequest) {
        try {
            Category category = categoryDataBaseService.findAllByType(categoryDtoRequest.getCategoryType().name())
                    .stream()
                    .filter(x -> x.getName().equals(categoryDtoRequest.getName()))
                    .findAny()
                    .orElse(null);

            if (category == null) {
                return CategoryMapper.INSTANCE.toCategoryDto(
                        categoryDataBaseService.saveOrUpdate(
                                Category.builder()
                                        .name(categoryDtoRequest.getName())
                                        .categoryType(categoryDtoRequest.getCategoryType())
                                        .build()
                        )
                );
            } else {
                category.setName(categoryDtoRequest.getNewName());

                return CategoryMapper.INSTANCE.toCategoryDto(categoryDataBaseService.saveOrUpdate(category));
            }
        } catch (Exception e) {
            throw new CategoryNotFoundException("Такого типа категории нет", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public CategoryDtoResponse deleteCategory(CategoryDtoRequest categoryDtoRequest) {
        try {
            Category category = categoryDataBaseService.findAllByType(categoryDtoRequest.getCategoryType().name())
                    .stream()
                    .filter(x -> x.getName().equals(categoryDtoRequest.getName()))
                    .findAny()
                    .orElse(null);

            if (category == null) {
                throw new CategoryNotFoundException("Такой категории нет", HttpStatus.BAD_REQUEST);
            }

            return CategoryMapper.INSTANCE.toCategoryDto(categoryDataBaseService.delete(category.getId()));
        } catch (Exception e) {
            throw new CategoryNotFoundException("Такого типа категории нет", HttpStatus.BAD_REQUEST);
        }
    }
}
