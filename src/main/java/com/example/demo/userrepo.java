package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface userrepo extends JpaRepository<users,String> {
    Optional<users> findByUsername(String username);
    Optional<users> findByFlname(String flname);
}
