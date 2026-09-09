package com.example.Veterinaria.Service;

import com.example.Veterinaria.Emtity.Historia_clinica;
import jakarta.persistence.Id;

import java.util.List;

public interface HistoriaClinicaservice {

   List<Historia_clinica> listarTodos();

   Historia_clinica buscarPorId(Long id);

   Historia_clinica crear (Historia_clinica historia, Long mascotaId);

   Historia_clinica actualizar(Long id, Historia_clinica historia);

   void  eliminar(Long id);
}
