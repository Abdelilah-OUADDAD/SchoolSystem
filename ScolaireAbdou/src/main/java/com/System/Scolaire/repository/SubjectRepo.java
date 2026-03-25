package com.System.Scolaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.System.Scolaire.model.entity.Subject;

@Repository
public interface SubjectRepo extends JpaRepository<Subject, Integer> {

}
