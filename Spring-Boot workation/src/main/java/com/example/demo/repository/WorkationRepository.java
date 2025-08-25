package com.example.demo.repository;

import com.example.demo.entity.Workation;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface WorkationRepository extends Repository<Workation, Long> {

    void save(Workation workation);

    long count();

    List<com.example.demo.entity.Workation> findAll();
}