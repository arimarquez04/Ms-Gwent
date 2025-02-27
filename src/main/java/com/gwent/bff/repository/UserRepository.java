package com.gwent.bff.repository;

import com.gwent.bff.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
