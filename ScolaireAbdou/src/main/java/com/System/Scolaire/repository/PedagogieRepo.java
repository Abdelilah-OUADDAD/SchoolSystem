package com.System.Scolaire.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.System.Scolaire.model.entity.Pedagogie;

@Repository
public interface PedagogieRepo extends JpaRepository<Pedagogie, Integer> {
    Pedagogie findByTitle(String title);

    List<Pedagogie> findByAnneeAnneeId(Integer AnneeID);

    List<Pedagogie> findByTeacherTeacherId(Integer teacherId);

    List<Pedagogie> findBySubjectSubjectID(Integer subjectID);
}
