package com.example.Veterinaria.Repository;

import com.example.Veterinaria.Emtity.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface propietarioRepository extends JpaRepository<Propietario, Long> {

    Optional<Propietario> findByDocumento(String documento);

    Optional<Propietario> findBycorreo(String correo);
}
