package com.pronin.MyTaskList.controllers;


import java.util.*;

import javax.validation.*;

import com.pronin.MyTaskList.repository.model.*;
import com.pronin.MyTaskList.service.*;
import lombok.extern.slf4j.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/notes")
@Slf4j
public class NoteEntityApi {

    private final NoteService noteService;

    public NoteEntityApi(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public ResponseEntity<List<NoteEntity>> findAll () {
        return ResponseEntity.ok(noteService.findAll());
    }

    @PostMapping
    public ResponseEntity save (@Valid @RequestBody NoteEntity entity) {
        return ResponseEntity.ok(noteService.save(entity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoteEntity> getById (@PathVariable Long id){
        Optional<NoteEntity> noteEntity = noteService.findById(id);
        if (!noteEntity.isPresent()){
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(noteEntity.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<NoteEntity> update(@PathVariable Long id, @Valid @RequestBody NoteEntity entity ) {
        if(!noteService.findById(id).isPresent()){
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(noteService.save(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if(!noteService.findById(id).isPresent()){
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        noteService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
