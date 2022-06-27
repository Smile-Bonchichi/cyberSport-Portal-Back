package kg.kstu.cyberSportPortal.dto.response.userData;

import kg.kstu.cyberSportPortal.dto.response.category.CategoryDtoResponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDataDtoResponse {
    String newDescription;

    String newImageUrl;

    List<CategoryDtoResponse> categories;
}
