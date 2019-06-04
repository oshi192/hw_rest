package com.yurii.hw_rest.controller;

import com.yurii.hw_rest.exception.AstersmNotFoundException;
import com.yurii.hw_rest.model.Asterism;
import com.yurii.hw_rest.model.Star;
import com.yurii.hw_rest.repository.AsterismRepository;
import com.yurii.hw_rest.repository.StarRepository;
import com.yurii.hw_rest.service.StarService;
import com.yurii.hw_rest.service.AsterismService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping(value = "/asterism")
public class AsterismController {

    private AsterismRepository asterismRepository;
    private StarRepository starRepository;

    public AsterismController(AsterismRepository asterismRepository, StarRepository starRepository) {
        this.asterismRepository = asterismRepository;
        this.starRepository = starRepository;
    }

    @ApiOperation(value = "save asterism")
    @PostMapping()
    public ResponseEntity<Asterism> getAsterisms(@RequestBody Asterism asterism) {
        return new ResponseEntity<>(asterismRepository.save(asterism), HttpStatus.OK);
    }

    @ApiOperation(value = "get all asterisms")
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Asterism>> newAsterism() {
        List<Asterism> asterisms = asterismRepository.findAll();
        if (asterisms == null || asterisms.isEmpty()) {
            return new ResponseEntity<List<Asterism>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Asterism>>(asterisms, HttpStatus.OK);
    }

    @ApiOperation(value = "get asterism by id}")
    @GetMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Asterism one(@PathVariable Long id) {
        return asterismRepository.findById(id).orElseThrow(() -> new AstersmNotFoundException(id));
    }

    ////
    @ApiOperation(value = "get all stars in as  asterism")
    @GetMapping(path = "/{id}/stars", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Star>> asterismStars(@PathVariable Long id) {
        List<Star> stars = asterismRepository.findById(id).orElse(new Asterism()).getStars();
        if(stars == null){
            return new ResponseEntity<List<Star>>(HttpStatus.NO_CONTENT);
        }
            return new ResponseEntity<List<Star>>(stars,HttpStatus.OK);
    }

    @ApiOperation(value = "get star by id")
    @GetMapping(path = "/{id}/stars/{idStar}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Star> asterismStar(@PathVariable long id, @PathVariable long idStar) {
        Star star = starRepository.findById(idStar).orElseThrow(() -> new AstersmNotFoundException(id));
        if(star == null){
            return new ResponseEntity<Star>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Star>(star, HttpStatus.OK);
    }
    @ApiOperation(value = "get star by id")
    @PostMapping(path = "/{id}/stars/{idStar}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Star> addStar(@PathVariable long id, @PathVariable long idStar,@RequestBody Star star) {
        Asterism astreism = asterismRepository.findById(id).get();
        if(astreism!=null && star!=null){
            astreism.getStars().add(star);
            star.setAsterism(astreism);
            asterismRepository.save(astreism);
            return new ResponseEntity<Star>(star, HttpStatus.OK);
        }
        return new ResponseEntity<Star>(HttpStatus.NO_CONTENT);
    }

}
