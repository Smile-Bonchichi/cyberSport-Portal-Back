package kg.kstu.cyberSportPortal.entity;

import kg.kstu.cyberSportPortal.entity.base.BaseEntity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "games")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Game extends BaseEntity {
    @Column(name = "game_name", unique = true, nullable = false, length = 30)
    String name;

    @ManyToOne
    @JoinColumn(name = "description_id", nullable = false, unique = true)
    Description description;

    @Column(name = "rating", nullable = false, length = 5)
    Long rating;

    @ManyToMany
    @JoinColumn(name = "image_id", unique = true)
    List<Image> image;

    @ManyToMany
    @JoinColumn(name = "game_category_id", nullable = false)
    List<Category> categories;
}
