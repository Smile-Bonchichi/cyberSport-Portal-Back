package kg.kstu.cyberSportPortal.mapper;

import kg.kstu.cyberSportPortal.dto.response.category.CategoryDtoResponse;
import kg.kstu.cyberSportPortal.entity.Category;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDtoResponse toCategoryDto(Category category);

    List<CategoryDtoResponse> toCategoriesDto(List<Category> categories);
}
