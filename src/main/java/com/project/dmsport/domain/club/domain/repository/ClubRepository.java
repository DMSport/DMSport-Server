package com.project.dmsport.domain.club.domain.repository;

import com.project.dmsport.domain.club.domain.Club;
import com.project.dmsport.domain.club.domain.enums.ClubType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ClubRepository extends CrudRepository<Club, Long> {

    Optional<Club> findByClubType(ClubType clubType);

    List<Club> findAll();

}
