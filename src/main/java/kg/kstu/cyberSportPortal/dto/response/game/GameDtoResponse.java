package kg.kstu.cyberSportPortal.dto.response.game;

import kg.kstu.cyberSportPortal.dto.response.category.CategoryDtoResponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GameDtoResponse {
    String gameName;

    String description;

    Long rating;

    List<String> imagesUrl;

    List<CategoryDtoResponse> categories;
}
