package com.System.Scolaire.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Teacher")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacherID")
    private Integer teacherId;

    @Column(name = "nom", length = 100)
    private String nom;

    @Column(name = "prenom", length = 100)
    private String prenom;

    @Column(name = "Address", length = 255)
    private String Address;

    // ✅ RELATION ManyToOne with Department
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DepartmentID", foreignKey = @ForeignKey(name = "FK_Department3"))
    private Department department;

    // Full name method
    public String getNomComplet() {
        return prenom + " " + nom;
    }
}