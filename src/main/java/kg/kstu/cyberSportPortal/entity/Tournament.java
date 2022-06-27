package kg.kstu.cyberSportPortal.entity;

import kg.kstu.cyberSportPortal.entity.base.BaseEntity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "tournaments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Tournament extends BaseEntity {
    @Column(name = "tournament_name", nullable = false, unique = true, length = 50)
    String name;

    @OneToOne
    @JoinColumn(name = "description_id", nullable = false, unique = true)
    Description description;

    @OneToOne
    @JoinColumn(name = "winner_team_id", unique = true)
    Team team;
}
