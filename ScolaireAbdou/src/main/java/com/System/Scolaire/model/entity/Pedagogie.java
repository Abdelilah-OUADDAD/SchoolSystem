package com.System.Scolaire.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@Table(name = "Pedagogie")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pedagogie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer pedagogieID;
    String title;
    String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", foreignKey = @ForeignKey(name = "fk_teacher"))
    Teacher teacher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id", foreignKey = @ForeignKey(name = "fk_subject"))
    Subject subject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Annee_id", foreignKey = @ForeignKey(name = "fk_Anne4"))
    AnneeScolaire annee;

    String objective;
    LocalDateTime created_at;
}
