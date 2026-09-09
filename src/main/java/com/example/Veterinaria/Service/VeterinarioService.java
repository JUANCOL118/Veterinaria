package com.example.Veterinaria.Service;

import com.example.Veterinaria.Emtity.Historia_clinica;
import com.example.Veterinaria.Emtity.Veterinario;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface VeterinarioService {
    List<Veterinario> listarTodos();

    Veterinario buscarPorId(Long id);

    Veterinario crear (Veterinario veterinario);

    Veterinario actualizar(Long id, Veterinario veterinario);

    void  eliminar(Long id);


}
