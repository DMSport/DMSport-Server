package com.project.dmsport.domain.club.domain.repository;

import com.project.dmsport.domain.club.domain.ClubManager;
import com.project.dmsport.domain.club.domain.enums.ClubType;
import org.springframework.data.repository.CrudRepository;

public interface ClubManagerRepository extends CrudRepository<ClubManager, ClubType> {
}
