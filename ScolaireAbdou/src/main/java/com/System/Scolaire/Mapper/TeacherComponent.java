package com.System.Scolaire.Mapper;

import com.System.Scolaire.model.Dto.TeacherDto;
import com.System.Scolaire.model.entity.Teacher;
import com.System.Scolaire.model.entity.Department;
import com.System.Scolaire.repository.DepartmentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeacherComponent {

    @Autowired
    private DepartmentRepo departmentRepo;

    // ✅ Convert Entity -> DTO
    public TeacherDto toDto(Teacher teacher) {
        if (teacher == null) {
            return null;
        }

        TeacherDto dto = new TeacherDto();
        dto.setTeacherId(teacher.getTeacherId());
        dto.setNom(teacher.getNom());
        dto.setPrenom(teacher.getPrenom());
        dto.setAddress(teacher.getAddress());

        // ✅ Get info from Specialite relation
        if (teacher.getDepartment() != null) {
            dto.setDepartmentID(teacher.getDepartment().getDepartmentId());
            dto.setNomDepartment((teacher.getDepartment().getNomDepartment()));
            dto.setDepartmentDescription(teacher.getDepartment().getDescription());
        }

        return dto;
    }

    // ✅ Convert DTO -> Entity
    public Teacher toEntity(TeacherDto dto) {
        if (dto == null) {
            return null;
        }

        Teacher teacher = new Teacher();
        teacher.setTeacherId(dto.getTeacherId());
        teacher.setNom(dto.getNom());
        teacher.setPrenom(dto.getPrenom());
        teacher.setAddress(dto.getAddress());

        // ✅ Set Specialite relation from ID
        if (dto.getDepartmentID() != null) {
            Department department = departmentRepo.findById(dto.getDepartmentID()).orElse(null);
            teacher.setDepartment(department);
        }

        return teacher;
    }
}