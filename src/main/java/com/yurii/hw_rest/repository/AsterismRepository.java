package com.yurii.hw_rest.repository;

import com.yurii.hw_rest.model.Asterism;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsterismRepository extends JpaRepository<Asterism, Long> {
}
