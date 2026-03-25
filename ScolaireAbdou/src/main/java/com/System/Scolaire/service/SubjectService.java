package com.System.Scolaire.service;

import com.System.Scolaire.Mapper.SubjectComponent;
import com.System.Scolaire.model.Dto.SubjectDto;
import com.System.Scolaire.model.entity.Subject;
import com.System.Scolaire.repository.SubjectRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.*;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SubjectService {

    @Autowired
    private SubjectRepo subjectRepo;
    @Autowired
    private SubjectComponent subjectComponent;

    public List<SubjectDto> GetAllSubject() {
        return subjectRepo.findAll().stream()
                .map(subjectComponent::toDto)
                .collect(Collectors.toList());
    }

    public SubjectDto GetSubjectID(int ID) {
        Optional<Subject> subject = subjectRepo.findById(ID);
        if (subject.isPresent())
            return subjectComponent.toDto(subject.get());
        else
            return null;

    }

    public SubjectDto SaveSubject(SubjectDto dto) {
        Subject subject = subjectRepo.save(subjectComponent.toEntity(dto));
        return subjectComponent.toDto(subject);
    }

    public void DeleteSubject(int ID) {
        subjectRepo.deleteById(ID);
    }
}
