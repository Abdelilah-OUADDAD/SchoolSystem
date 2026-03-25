package com.System.Scolaire.model.Dto;

import java.time.LocalDateTime;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SubjectDto {

    Integer subjectID;
    String name;
    String description;
    Integer department_id;
    LocalDateTime created_at;
}
