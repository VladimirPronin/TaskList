package com.pronin.MyTaskList.repository.model;


import java.util.*;

import javax.persistence.*;
import lombok.*;

@Entity
@Data

public class TaskEntity extends BaseEntity {

    private String task;
    private Date dueDate;

    @ManyToOne(fetch = FetchType.EAGER)
    private GeoPointEntity geoPointEntity;

    public TaskEntity() {
    }
}
