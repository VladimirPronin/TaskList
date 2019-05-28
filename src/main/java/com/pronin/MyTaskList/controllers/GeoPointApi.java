package com.pronin.MyTaskList.controllers;


import java.util.*;

import javax.validation.*;

import com.pronin.MyTaskList.repository.model.*;
import com.pronin.MyTaskList.service.*;
import lombok.extern.slf4j.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/geo_points")
@Slf4j
public class GeoPointApi {

    private final GeoPointService geoPointService;

    public GeoPointApi(GeoPointService geoPointService) {
        this.geoPointService = geoPointService;
    }

    @GetMapping
    public ResponseEntity<List<GeoPointEntity>> findAll() {
        return ResponseEntity.ok(geoPointService.findAll());
    }

    @PostMapping
    public ResponseEntity save(@Valid @RequestBody GeoPointEntity entity) {
        return ResponseEntity.ok(geoPointService.save(entity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeoPointEntity> getById(@PathVariable Long id) {
        Optional<GeoPointEntity> geoPointEntity = geoPointService.findById(id);
        if (!geoPointEntity.isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(geoPointEntity.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeoPointEntity> update(@PathVariable Long id, @Valid @RequestBody GeoPointEntity entity) {
        if (!geoPointService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(geoPointService.save(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!geoPointService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        geoPointService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
