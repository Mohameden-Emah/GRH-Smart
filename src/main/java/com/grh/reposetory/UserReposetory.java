package com.grh.reposetory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grh.entites.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReposetory extends JpaRepository<User, Long> {

}
