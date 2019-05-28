package com.pronin.MyTaskList.service;

import java.util.*;

import com.pronin.MyTaskList.repository.*;
import com.pronin.MyTaskList.repository.model.*;
import lombok.*;
import org.springframework.stereotype.*;

@Service
@RequiredArgsConstructor
public class NoteService {


   private final NoteRepository noteRepository;


    public List<NoteEntity> findAll () {
        return noteRepository.findAll();
    }

    public Optional<NoteEntity> findById (Long id) {
        return noteRepository.findById(id);
    }

    public NoteEntity save (NoteEntity entity) {
        return noteRepository.save(entity);
    }

    public void deleteById (Long id) {
        noteRepository.deleteById(id);
    }
}
