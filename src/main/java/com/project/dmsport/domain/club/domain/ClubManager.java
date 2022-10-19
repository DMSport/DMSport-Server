package com.project.dmsport.domain.club.domain;

import com.project.dmsport.domain.club.domain.enums.ClubType;
import com.project.dmsport.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class ClubManager {

    @Id
    @Column(name = "club_id")
    private ClubType id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "club_id", nullable = false)
    private Club club;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Builder
    public ClubManager(Club club, User user) {
        this.club = club;
        this.user = user;
    }

    public void changeClubManager(User user) {
        this.user = user;
    }

}
