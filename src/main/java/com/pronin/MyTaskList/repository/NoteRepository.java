package com.pronin.MyTaskList.repository;

import com.pronin.MyTaskList.repository.model.*;
import org.springframework.data.jpa.repository.*;

public interface NoteRepository extends JpaRepository<NoteEntity, Long> {
}
