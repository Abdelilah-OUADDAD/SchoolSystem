package com.System.Scolaire.model.Dto;

import java.time.LocalDateTime;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PedagogieDto {

    Integer pedagogieID;
    String title;
    String description;
    Integer teacher_id;
    Integer subject_id;
    Integer annee_id;
    String objective;
    LocalDateTime created_at;
}
