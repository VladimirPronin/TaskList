package com.pronin.MyTaskList.repository.model;

import java.util.*;

import javax.persistence.*;

import lombok.*;

@MappedSuperclass
@Data
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private final Date created = new Date();

}
