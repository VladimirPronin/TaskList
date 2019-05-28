package com.pronin.MyTaskList.controllers;


import java.util.*;

import javax.validation.*;

import com.pronin.MyTaskList.repository.model.*;
import com.pronin.MyTaskList.service.*;
import lombok.extern.slf4j.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/tasks")
@Slf4j
public class TaskEntityApi {

    private final TaskService taskService;

    public TaskEntityApi(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<TaskEntity>> findAll() {
        return ResponseEntity.ok(taskService.findAll());
    }

    @PostMapping
    public ResponseEntity save(@Valid @RequestBody TaskEntity entity) {
        entity = taskService.save(entity);
        return ResponseEntity.ok(taskService.findById(entity.getId()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskEntity> getById(@PathVariable Long id) {
        Optional<TaskEntity> taskEntity = taskService.findById(id);
        if (!taskEntity.isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(taskEntity.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskEntity> update(@PathVariable Long id, @Valid @RequestBody TaskEntity entity) {
        if (!taskService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(taskService.save(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!taskService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        taskService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/attach")
    public ResponseEntity attachGeoPoint(@RequestParam Long taskId, @RequestParam Long geoPointId) {
        try {
            taskService.attach(taskId, geoPointId);
            return ResponseEntity.ok().build();
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
}
