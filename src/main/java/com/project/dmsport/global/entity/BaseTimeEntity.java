package com.project.dmsport.global.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public abstract class BaseTimeEntity {
    @CreatedDate
    private LocalDateTime createdDate = LocalDateTime.now();
}
