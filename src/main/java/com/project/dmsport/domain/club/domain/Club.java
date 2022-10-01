package com.project.dmsport.domain.club.domain;

import com.project.dmsport.domain.club.domain.enums.ClubType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Club {

    @Id
    @Column(name = "club_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private ClubType clubType;

    private LocalDate banPeriod;

    @Column(nullable = false)
    private boolean ban;

    @Column(nullable = false)
    private boolean hope;

    @Builder
    public Club(ClubType clubType) {
        this.clubType = clubType;
        this.ban = false;
        this.hope = false;
    }

}
