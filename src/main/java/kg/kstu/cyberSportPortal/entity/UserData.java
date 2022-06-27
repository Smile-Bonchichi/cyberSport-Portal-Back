package kg.kstu.cyberSportPortal.entity;

import kg.kstu.cyberSportPortal.entity.base.BaseEntity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "users_data")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserData extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    User user;

    @OneToOne
    @JoinColumn(name = "description_id", nullable = false)
    Description description;

    @OneToOne
    @JoinColumn(name = "image_id", unique = true)
    Image image;

    @ManyToMany
    @JoinColumn(name = "user_category_id", nullable = false)
    List<Category> categories;
}
