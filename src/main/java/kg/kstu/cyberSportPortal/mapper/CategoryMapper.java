package kg.kstu.cyberSportPortal.mapper;

import kg.kstu.cyberSportPortal.dto.response.category.CategoryDtoResponse;
import kg.kstu.cyberSportPortal.entity.Category;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDtoResponse toCategoryDto(Category category);

    @Mappings({@Mapping(target="id", source="id")})
    List<CategoryDtoResponse> toCategoriesDto(List<Category> categories);
}
