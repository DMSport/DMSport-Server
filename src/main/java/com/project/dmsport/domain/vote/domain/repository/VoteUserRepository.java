package com.project.dmsport.domain.vote.domain.repository;

import com.project.dmsport.domain.vote.domain.VoteUser;
import com.project.dmsport.domain.vote.domain.VoteUserId;
import org.springframework.data.repository.CrudRepository;

public interface VoteUserRepository extends CrudRepository<VoteUser, VoteUserId> {
}
