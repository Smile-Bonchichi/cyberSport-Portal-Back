package kg.kstu.cyberSportPortal.dto.request.userData;

import lombok.*;
import lombok.experimental.FieldDefaults;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDataDtoRequest {
    String description;

    MultipartFile image;

    List<Long> categoryId;
}
