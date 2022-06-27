package kg.kstu.cyberSportPortal.service;

import kg.kstu.cyberSportPortal.dto.request.category.CategoryDtoRequest;
import kg.kstu.cyberSportPortal.dto.response.category.CategoryDtoResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryDtoResponse> getAllCategoryNameByType(String type);

    CategoryDtoResponse createUpdateCategory(CategoryDtoRequest categoryDtoRequest);

    CategoryDtoResponse deleteCategory(CategoryDtoRequest categoryDtoRequest);
}
