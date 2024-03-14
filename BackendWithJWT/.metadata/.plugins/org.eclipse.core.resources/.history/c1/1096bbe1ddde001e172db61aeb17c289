package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.UserInfo;

public interface UserRepository extends JpaRepository<UserInfo, Long> {

	Optional<UserInfo> findByEmail(String email);

}
