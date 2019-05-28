package com.pronin.MyTaskList.repository.model;

import javax.persistence.*;
import lombok.*;


@Entity
@Data
public class NoteEntity extends BaseEntity {

    private String note;

    public NoteEntity() {
    }

}
