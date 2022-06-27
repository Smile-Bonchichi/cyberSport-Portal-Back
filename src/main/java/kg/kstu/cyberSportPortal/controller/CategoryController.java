package kg.kstu.cyberSportPortal.controller;

import io.swagger.annotations.ApiOperation;
import kg.kstu.cyberSportPortal.dto.request.category.CategoryDtoRequest;
import kg.kstu.cyberSportPortal.dto.response.category.CategoryDtoResponse;
import kg.kstu.cyberSportPortal.service.CategoryService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/category/")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryController {
    final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("get-category")
    @ApiOperation("API для получения всех категорий по типу")
    public ResponseEntity<List<CategoryDtoResponse>> getCategoryByType(@RequestParam("type") String type) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(categoryService.getAllCategoryNameByType(type));
    }

    @PostMapping("create-update-category")
    @ApiOperation("API для создания новой или обновления старой категории")
    public ResponseEntity<CategoryDtoResponse> createUpdateCategory(@Valid @RequestBody CategoryDtoRequest categoryDtoRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(categoryService.createUpdateCategory(categoryDtoRequest));
    }

    @DeleteMapping("delete-category")
    @ApiOperation("API для удаления категории")
    public ResponseEntity<CategoryDtoResponse> deleteCategory(@Valid @RequestBody CategoryDtoRequest categoryDtoRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(categoryService.deleteCategory(categoryDtoRequest));
    }
}
