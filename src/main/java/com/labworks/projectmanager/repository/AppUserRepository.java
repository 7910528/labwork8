package com.labworks.projectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.labworks.projectmanager.entity.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
