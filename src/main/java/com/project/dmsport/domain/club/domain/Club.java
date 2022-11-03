package com.project.dmsport.domain.club.domain;

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

    private LocalDate banPeriod;

    @Column(nullable = false)
    private boolean ban;

    @Column(nullable = false)
    private boolean hope;

    @Column(columnDefinition = "TINYINT", nullable = false)
    private Integer maxPeople;

    @OneToOne(mappedBy = "club")
    private ClubManager clubManager;

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

    public Club restoreBan() {
        this.ban = false;
        return this;
    }

    public void toggleHope() {
        this.hope = !this.hope;
    }

}
