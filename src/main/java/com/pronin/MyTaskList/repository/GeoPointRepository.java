package com.pronin.MyTaskList.repository;

import com.pronin.MyTaskList.repository.model.*;
import org.springframework.data.jpa.repository.*;

public interface GeoPointRepository extends JpaRepository<GeoPointEntity, Long> {
}
