package com.pronin.MyTaskList.service;

import java.util.*;

import com.pronin.MyTaskList.repository.*;
import com.pronin.MyTaskList.repository.model.*;
import lombok.*;
import org.springframework.stereotype.*;

@Service
@RequiredArgsConstructor
public class GeoPointService {

    private final GeoPointRepository geoPointRepository;

    public List<GeoPointEntity> findAll () {
        return geoPointRepository.findAll();
    }

    public Optional<GeoPointEntity> findById (Long id) {
        return geoPointRepository.findById(id);
    }

    public GeoPointEntity save (GeoPointEntity entity) {
        return geoPointRepository.save(entity);
    }

    public void deleteById (Long id) {
        geoPointRepository.deleteById(id);
    }
}
