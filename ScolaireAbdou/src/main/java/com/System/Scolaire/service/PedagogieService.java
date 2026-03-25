package com.System.Scolaire.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.System.Scolaire.Mapper.PedagogieComponent;
import com.System.Scolaire.model.Dto.PedagogieDto;
import com.System.Scolaire.model.entity.Pedagogie;
import com.System.Scolaire.repository.PedagogieRepo;

import lombok.*;

@Service

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PedagogieService {

    @Autowired
    private PedagogieRepo pedagogieRepo;
    @Autowired
    private PedagogieComponent pedagogieComponent;

    public List<PedagogieDto> GetAllPedagogie() {
        return pedagogieRepo.findAll().stream()
                .map(pedagogieComponent::toDto)
                .collect(Collectors.toList());
    }

    public PedagogieDto GetPedagogieID(int ID) {
        Optional<Pedagogie> pedagogie = pedagogieRepo.findById(ID);
        if (pedagogie.isPresent())
            return pedagogieComponent.toDto(pedagogie.get());
        else
            return null;

    }

    public PedagogieDto GetPedagogieWithTitle(String title) {
        Pedagogie pedagogie = pedagogieRepo.findByTitle(title);
        if (pedagogie != null)
            return pedagogieComponent.toDto(pedagogie);
        else
            return null;

    }

    public PedagogieDto SavePedagogie(PedagogieDto dto) {
        Pedagogie pedagogie = pedagogieRepo.save(pedagogieComponent.toEntity(dto));
        return pedagogieComponent.toDto(pedagogie);
    }

    public void DeletePedagogie(int ID) {
        pedagogieRepo.deleteById(ID);
    }
}
