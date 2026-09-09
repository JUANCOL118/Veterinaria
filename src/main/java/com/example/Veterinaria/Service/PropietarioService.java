package com.example.Veterinaria.Service;

import com.example.Veterinaria.Emtity.Historia_clinica;
import com.example.Veterinaria.Emtity.Propietario;

import java.util.List;

public interface PropietarioService {

    List<Propietario> listarTodos();

    Propietario buscarPorId(Long id);

    Propietario crear (Propietario propietario);

    Propietario actualizar(Long id,Propietario propietario );

    void  eliminar(Long id);
}
