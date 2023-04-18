package com.namrata2.mapper;


import com.namrata2.entity.ScheduleEntity;
import com.namrata2.model.ScheduleModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
@Mapper(componentModel="spring")
public interface ScheduleMapper {
    public List<ScheduleEntity> mapScheduleModelsToScheduleEntities(final List<ScheduleModel> schedules);
    ScheduleEntity mapScheduleModelToScheduleEntity(final ScheduleModel scheduleModel);

    public List<ScheduleModel> mapScheduleEntitiesToScheduleModels(final List<ScheduleEntity> schedules);
    ScheduleModel mapScheduleEntitieToScheduleModel(final ScheduleEntity scheduleEntity);

}
