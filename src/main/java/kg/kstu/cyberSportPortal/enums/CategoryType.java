package kg.kstu.cyberSportPortal.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum CategoryType {
    GAMER(1L),
    GAME(2L),
    NEWS(3L),
    TEAM(4L);

    final Long id;
}
