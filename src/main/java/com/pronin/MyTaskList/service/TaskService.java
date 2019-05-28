package com.pronin.MyTaskList.service;

import java.util.*;

import com.pronin.MyTaskList.repository.TaskRepository;
import com.pronin.MyTaskList.repository.model.*;
import lombok.*;
import org.springframework.stereotype.*;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository repository;
    private final GeoPointService geoPointService;


    public List<TaskEntity> findAll () {
        return repository.findAll();
    }

    public Optional<TaskEntity> findById(Long id) {
        return repository.findById(id);
    }

    public TaskEntity save (TaskEntity entity){
        return repository.save(entity);
    }

    public void deleteById (Long id) {
        repository.deleteById(id);
    }


    public void attach(Long taskId, Long geoPointId) throws Exception {
        Optional<TaskEntity> taskEntity = repository.findById(taskId);
        Optional<GeoPointEntity> geoPoint = geoPointService.findById(geoPointId);
        TaskEntity entity = taskEntity.orElseThrow(() -> new Exception("Task not found"));
        entity.setGeoPointEntity(geoPoint.orElseThrow(() -> new Exception("Geo Point not found")));
        repository.save(entity);

    }
}
