package kg.kstu.cyberSportPortal.entity;

import kg.kstu.cyberSportPortal.entity.base.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "news")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class News extends BaseEntity {
    @Column(name = "title", nullable = false, unique = true, length = 50)
    String title;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    User user;

    @ManyToMany
    @JoinColumn(name = "image_id", nullable = false, unique = true)
    List<Image> images;

    @OneToOne
    @JoinColumn(name = "description_id", nullable = false, unique = true)
    Description description;

    @ManyToMany
    @JoinColumn(name = "news_category_id", nullable = false, unique = true)
    List<Category> categories;
}
