package com.example.Veterinaria.Service;

import com.example.Veterinaria.Emtity.Historia_clinica;
import com.example.Veterinaria.Emtity.Mascota;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MascotaService {
    List<Mascota> listarTodas();

    Mascota buscarPorId(Long id);

    Mascota crear(Mascota mascota, Long propietarioId);

    Mascota actualizar(Long id, Mascota mascota);

    void eliminar(Long id);

    List<Mascota> buscarPorPropietario(Long propietarioId);

    Mascota asignarveterinario(Long mascotaId, Long veterinarioId);

}
