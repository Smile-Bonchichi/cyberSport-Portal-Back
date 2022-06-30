package kg.kstu.cyberSportPortal.dto.request.category;

import kg.kstu.cyberSportPortal.enums.CategoryType;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryDtoRequest {
    @NotNull
    @NotEmpty
    @Size(min = 5, max = 50)
    String name;

    @Size(min = 5, max = 50)
    String newName;

    @NotNull
    CategoryType categoryType;
}
