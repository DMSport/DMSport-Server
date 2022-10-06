package com.project.dmsport.domain.user.domain.repository;

import com.project.dmsport.domain.user.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);

    @Query("select u from User u order by u.id desc")
    List<User> findAllOrderByIdDesc();
}