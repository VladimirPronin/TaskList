package com.pronin.MyTaskList.repository.model;


import javax.persistence.*;

import lombok.*;

@Entity
@Data

public class GeoPointEntity extends BaseEntity{

    private Double attitude;
    private Double longitude;

    public GeoPointEntity() {
    }
}
