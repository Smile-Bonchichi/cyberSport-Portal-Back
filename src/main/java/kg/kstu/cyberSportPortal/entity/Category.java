package kg.kstu.cyberSportPortal.entity;

import kg.kstu.cyberSportPortal.entity.base.BaseEntity;
import kg.kstu.cyberSportPortal.enums.CategoryType;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Category extends BaseEntity {
    @Column(name = "category_name", nullable = false, length = 50)
    String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "category_type", nullable = false)
    CategoryType categoryType;
}
