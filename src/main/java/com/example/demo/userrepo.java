package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface userrepo extends JpaRepository<users,String> {
    Optional<users> findByUsername(String username);
    Optional<users> findByFlname(String flname);
}
