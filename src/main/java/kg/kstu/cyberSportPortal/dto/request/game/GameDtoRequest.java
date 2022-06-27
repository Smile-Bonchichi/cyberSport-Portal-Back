package kg.kstu.cyberSportPortal.dto.request.game;

import lombok.*;
import lombok.experimental.FieldDefaults;

import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GameDtoRequest {
    @NotNull
    @NotEmpty
    @Size(min = 6, max = 30)
    String gameName;

    String description;

    @Range(min = 1, max = 5)
    Long rating;

    List<MultipartFile> images;

    List<Long> categoryIds;
}
