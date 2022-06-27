package kg.kstu.cyberSportPortal.entity;

import kg.kstu.cyberSportPortal.entity.base.BaseEntity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teams")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Team extends BaseEntity {
    @Column(name = "team_name", nullable = false, unique = true)
    String name;

    @Column(name = "rating", nullable = false, length = 5)
    Long rating;

    @OneToOne
    @JoinColumn(name = "description_id", nullable = false, unique = true)
    Description description;

    @ManyToMany
    @JoinColumn(name = "team_category_id", nullable = false, unique = true)
    List<Category> categories;

    @ManyToMany
    @JoinColumn(name = "game_id", nullable = false)
    List<Game> games;

    @ManyToMany
    @JoinColumn(name = "user_id", nullable = false)
    List<User> users;
}
