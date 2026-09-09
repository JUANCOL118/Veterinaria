package com.example.Veterinaria.Service.Impl;

import com.example.Veterinaria.Emtity.Veterinario;
import com.example.Veterinaria.Exception.ResourceNotFondException;
import com.example.Veterinaria.Repository.veterinarioRepository;
import com.example.Veterinaria.Service.VeterinarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VeterinarioImpl implements VeterinarioService {
    private final veterinarioRepository veterinarioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Veterinario> listarTodos() {
        return veterinarioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Veterinario buscarPorId(Long id) {
        return veterinarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFondException("No se encontró el veterinario  " + id));
    }

    @Override
    @Transactional
    public Veterinario crear(Veterinario veterinario) {
        return veterinarioRepository.save(veterinario);
    }

    @Override
    @Transactional
    public Veterinario actualizar(Long id, Veterinario datos) {
        Veterinario actual = buscarPorId(id);

        actual.setNombre(datos.getNombre());
        actual.setTarjeta_profecional(datos.getTarjeta_profecional());
        actual.setEspecialidad(datos.getEspecialidad());
        actual.setCorreo(datos.getCorreo());
        actual.setMascotas(datos.getMascotas());

        return veterinarioRepository.save(actual);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        Veterinario veterinario = buscarPorId(id);
        veterinarioRepository.delete(veterinario);
    }
}