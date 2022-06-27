package kg.kstu.cyberSportPortal.dto.request.user;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDtoRequest {
    @NotNull
    @NotEmpty
    @Size(min = 5, max = 15)
    String login;

    @NotNull
    @NotEmpty
    @Size(min = 5, max = 50)
    String password;

    @NotEmpty
    @Email
    @Size(min = 5)
    String email;
}
