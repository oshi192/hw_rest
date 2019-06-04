package com.yurii.hw_rest.config;

import com.yurii.hw_rest.model.Asterism;
import com.yurii.hw_rest.model.Star;
import com.yurii.hw_rest.repository.AsterismRepository;
import com.yurii.hw_rest.repository.StarRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
@Slf4j
public class PreloadDB {
    private static final Logger log = LoggerFactory.getLogger(PreloadDB.class);

    @Bean
    CommandLineRunner initDatabase(StarRepository starRepository, AsterismRepository asterismRepository) {
        Asterism asterism = new Asterism("astreism name",123.34f);
        List<Star> stars = new ArrayList<>();
        stars.add(new Star("Sun2",-4,"K0","sdf35",asterism));
        stars.add(new Star("Sun",-24,"G3","sdf0",asterism));
        asterism.getStars().add(stars.get(0));
        asterism.getStars().add(stars.get(1));
        asterismRepository.save(asterism);
        return args -> {
            log.info("Preloading " );
        };
    }
}
