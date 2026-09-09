package com.example.Veterinaria.Repository;

import com.example.Veterinaria.Emtity.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface mascotaRepository extends JpaRepository<Mascota, Long> {

    List<Mascota> findByNombreContainingIgnoreCase(String nombre);

    List<Mascota> findByEspecieIgnoreCase (String especie);

    List<Mascota> findByPropietarioId(Long propietarioId);


}
