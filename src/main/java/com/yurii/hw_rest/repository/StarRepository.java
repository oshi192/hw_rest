package com.yurii.hw_rest.repository;

import com.yurii.hw_rest.model.Asterism;
import com.yurii.hw_rest.model.Star;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StarRepository  extends JpaRepository<Star, Long> {

}
