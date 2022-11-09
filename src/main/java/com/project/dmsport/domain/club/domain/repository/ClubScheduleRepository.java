package com.project.dmsport.domain.club.domain.repository;


import com.project.dmsport.domain.club.domain.ClubSchedule;
import com.project.dmsport.domain.club.domain.enums.ActivityPlace;
import com.project.dmsport.domain.vote.domain.enums.VoteType;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import java.time.DayOfWeek;
import java.util.List;

public interface ClubScheduleRepository extends CrudRepository<ClubSchedule, Long> {

    boolean existsByActivityPlaceAndDayOfWeekAndVoteType(ActivityPlace activityPlace, DayOfWeek dayOfWeek, VoteType voteType);

    List<ClubSchedule> findByDayOfWeek(DayOfWeek dayOfWeek);

}