package com.example.Veterinaria.Repository;

import com.example.Veterinaria.Emtity.Historia_clinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface historiaclinicaRepository extends JpaRepository<Historia_clinica, Long > {
    Optional<historiaclinicaRepository> findByMascotaId(Long mascotaId);

}
