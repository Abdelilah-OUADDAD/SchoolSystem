package com.System.Scolaire.Mapper;

import org.springframework.stereotype.Component;

import com.System.Scolaire.model.Dto.SubjectDto;
import com.System.Scolaire.model.entity.Subject;

import lombok.*;
import lombok.Builder;

@Component
@Data
@Builder
@AllArgsConstructor

public class SubjectComponent {

    public Subject toEntity(SubjectDto dto) {
        Subject entity = new Subject();
        entity.setSubjectID(dto.getSubjectID());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setDepartment_id(dto.getDepartment_id());
        entity.setCreated_at(dto.getCreated_at());
        return entity;
    }

    public SubjectDto toDto(Subject entity) {
        return SubjectDto.builder().subjectID(entity.getSubjectID())
                .name(entity.getName())
                .description(entity.getDescription())
                .department_id(entity.getDepartment_id())
                .created_at(entity.getCreated_at())
                .build();
    }

}
