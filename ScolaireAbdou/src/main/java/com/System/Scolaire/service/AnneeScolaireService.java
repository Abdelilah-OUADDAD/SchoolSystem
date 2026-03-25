package com.System.Scolaire.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.System.Scolaire.Mapper.AnneeScolaireComponent;
import com.System.Scolaire.model.Dto.AnneeScolaireDto;
import com.System.Scolaire.model.entity.AnneeScolaire;
import com.System.Scolaire.repository.AnneeScolaireRepo;

@Service
public class AnneeScolaireService {

    @Autowired
    private AnneeScolaireRepo anneeScolaireRepo;
    @Autowired
    private AnneeScolaireComponent anneeComponent;

    public Optional<AnneeScolaire> getAnneeScolaireByAnneeID(Integer anneeID) {
        return anneeScolaireRepo.findById(anneeID);
    }

    public List<AnneeScolaireDto> getAllAnneeScolaire() {
        return anneeScolaireRepo.findAll()
                .stream()
                .map(anneeComponent::toDto)
                .collect(Collectors.toList());
    }
}
