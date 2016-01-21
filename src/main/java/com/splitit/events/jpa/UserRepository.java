/*
 * *******************************************************************************
 *   Copyright 2015 Mercury Solutions.
 * *******************************************************************************
 */
package com.splitit.events.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import com.splitit.events.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByEmail(String email);

	public User findByNickname(String nickname);
}
