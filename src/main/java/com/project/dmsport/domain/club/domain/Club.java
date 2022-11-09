package com.project.dmsport.domain.club.domain;

import com.project.dmsport.domain.club.domain.enums.ActivityPlace;
import com.project.dmsport.domain.club.domain.enums.ClubType;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Club {
    @Id
    @Enumerated(EnumType.STRING)
    @Column(name = "club_type", nullable = false, length = 10)
    private ClubType id;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ActivityPlace place;

    @Column(nullable = true)
    private LocalDate banPeriod;

    @Column(nullable = false)
    private Boolean ban;

    @Column(nullable = false)
    private Boolean hope;

    @Column(columnDefinition = "TINYINT", nullable = false)
    private Integer maxPeople;

    @Builder
    public Club(ClubType clubType) {
        this.id = clubType;
        this.ban = false;
        this.hope = false;
    }

    public void ban(LocalDate banPeriod) {
        this.ban = true;
        this.banPeriod = banPeriod;
    }

    public Club checkAndRestoreBan() {
        if (banPeriod.isBefore(LocalDate.now())) this.ban = false;
        return this;
    }

    public void toggleHope() {
        this.hope = !this.hope;
    }

}