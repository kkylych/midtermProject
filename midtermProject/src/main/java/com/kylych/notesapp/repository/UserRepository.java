package com.kylych.notesapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kylych.notesapp.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    boolean existsByUsername(String username);
}
