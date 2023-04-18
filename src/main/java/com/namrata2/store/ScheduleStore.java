package com.namrata2.store;


import java.util.List;

import com.namrata.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import com.namrata2.entity.ScheduleEntity;
import org.springframework.data.repository.CrudRepository;

public interface ScheduleStore extends CrudRepository<ScheduleEntity, Integer>{


    List<ScheduleEntity> findByLine(final String line);

}

