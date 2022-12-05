package com.project.dmsport.domain.club.domain.repository;

import com.project.dmsport.domain.club.domain.Club;
import com.project.dmsport.domain.club.domain.ClubManager;
import com.project.dmsport.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import javax.swing.text.StyledEditorKit;
import java.util.Optional;

public interface ClubManagerRepository extends CrudRepository<ClubManager, Long> {

    Optional<ClubManager> findByClub(Club club);

    Boolean existsByUser(User user);

}
