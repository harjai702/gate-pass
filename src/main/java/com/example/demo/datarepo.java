package com.example.demo;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface datarepo extends CrudRepository<data1,Integer>{
    List<data1> findByIddGreaterThan(int idd);
}