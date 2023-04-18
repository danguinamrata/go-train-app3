package com.namrata2.store;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.namrata2.entity.ScheduleEntity;

public interface ScheduleStore extends JpaRepository<ScheduleEntity, Long> {
    List<ScheduleEntity> findByArrival(final String arrival);

    List<ScheduleEntity> findByLine(final String line);
}

