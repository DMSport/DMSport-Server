package com.project.dmsport.domain.notice.domain;

import com.project.dmsport.domain.notice.domain.type.NoticeType;
import com.project.dmsport.domain.user.domain.User;
import com.project.dmsport.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Getter
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Notice extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notice_id")
    private Long id;

    @Column(nullable = false, length = 20)
    private String title;

    @Column(nullable = false)
    private String content;

    @Enumerated
    @Column(nullable = false, length = 10)
    private NoticeType noticeType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Builder
    public Notice(String title, String content, NoticeType noticeType, User user) {
        this.title = title;
        this.content = content;
        this.noticeType = noticeType;
        this.user = user;
    }
}
