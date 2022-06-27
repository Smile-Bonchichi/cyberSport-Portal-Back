package kg.kstu.cyberSportPortal.entity;

import kg.kstu.cyberSportPortal.entity.base.BaseEntity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "descriptions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Description extends BaseEntity {
    @Column(name = "description", nullable = false, length = 500)
    String description;
}
