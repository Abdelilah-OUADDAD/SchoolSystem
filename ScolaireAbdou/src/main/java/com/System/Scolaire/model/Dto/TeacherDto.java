package com.System.Scolaire.model.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDto {

    private Integer teacherId;

    @NotBlank(message = "Nom obligatoire!")
    private String nom;

    @NotBlank(message = "Prénom obligatoire!")
    private String prenom;

    @NotBlank(message = "Address obligatoire!")
    private String address;
    private Integer departmentID;

    // Info from Specialite relation
    private String NomDepartment;

    private String DepartmentDescription;

    // Full name method
    public String getNomComplet() {
        return prenom + " " + nom;
    }
}