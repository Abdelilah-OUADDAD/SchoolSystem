package com.System.Scolaire.Mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.System.Scolaire.model.Dto.PedagogieDto;
import com.System.Scolaire.model.entity.Pedagogie;
import com.System.Scolaire.repository.AnneeScolaireRepo;
import com.System.Scolaire.repository.SubjectRepo;
import com.System.Scolaire.repository.TeacherRepo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PedagogieComponent {

    @Autowired
    private TeacherRepo teacherRepo;
    @Autowired
    private SubjectRepo subjectRepo;
    @Autowired
    private AnneeScolaireRepo anneeRepo;

    public Pedagogie toEntity(PedagogieDto dto) {

        Pedagogie ped = new Pedagogie();
        ped.setPedagogieID(dto.getPedagogieID());
        ped.setTitle(dto.getTitle());
        ped.setDescription(dto.getDescription());
        if (dto.getTeacher_id() != null) {
            ped.setTeacher(teacherRepo.findById(dto.getTeacher_id()).orElse(null));
        }
        if (dto.getSubject_id() != null) {
            ped.setSubject(subjectRepo.findById(dto.getSubject_id()).orElse(null));
        }
        if (dto.getAnnee_id() != null) {
            ped.setAnnee(anneeRepo.findById(dto.getAnnee_id()).orElse(null));
        }
        ped.setObjective(dto.getObjective());
        ped.setCreated_at(dto.getCreated_at());

        return ped;
    }

    public PedagogieDto toDto(Pedagogie entity) {

        return PedagogieDto.builder()
                .pedagogieID(entity.getPedagogieID())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .teacher_id(entity.getTeacher().getTeacherId())
                .subject_id(entity.getSubject().getSubjectID())
                .annee_id(entity.getAnnee().getAnneeId())
                .objective(entity.getObjective())
                .created_at(entity.getCreated_at())
                .build();

    }
}
