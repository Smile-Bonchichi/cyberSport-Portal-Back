package kg.kstu.cyberSportPortal.entity;

import kg.kstu.cyberSportPortal.entity.base.BaseEntity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "match_schedule")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MatchSchedule extends BaseEntity {
    @Column(name = "begin_of_the_game", nullable = false)
    LocalDateTime beginOfTheGame;

    @OneToOne
    @JoinColumn(name = "first_team_id", nullable = false)
    Team firstTeam;

    @OneToOne
    @JoinColumn(name = "second_team_id", nullable = false)
    Team secondTeam;

    @OneToOne
    @JoinColumn(name = "tournament_id", nullable = false, unique = true)
    Tournament tournament;
}
