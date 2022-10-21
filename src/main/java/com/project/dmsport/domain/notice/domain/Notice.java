package com.project.dmsport.domain.notice.domain;

import com.project.dmsport.domain.notice.domain.enums.NoticeType;
import com.project.dmsport.domain.user.domain.User;
import com.project.dmsport.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Notice extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notice_id")
    private Long id;

    @NotNull
    @Size(max = 20)
    private String title;

    @NotNull
    private String content;

    @Enumerated(EnumType.STRING)
    @NotNull
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

    public void modifyNotice(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
