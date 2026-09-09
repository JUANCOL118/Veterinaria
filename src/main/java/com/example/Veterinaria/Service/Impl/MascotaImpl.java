package com.example.Veterinaria.Service.Impl;

import com.example.Veterinaria.Emtity.Mascota;
import com.example.Veterinaria.Emtity.Propietario;
import com.example.Veterinaria.Emtity.Veterinario;
import com.example.Veterinaria.Exception.ResourceNotFondException;
import com.example.Veterinaria.Repository.mascotaRepository;
import com.example.Veterinaria.Repository.propietarioRepository;
import com.example.Veterinaria.Repository.veterinarioRepository;
import com.example.Veterinaria.Service.MascotaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor

public class MascotaImpl implements MascotaService {

    private final mascotaRepository MascotaRepository;
    private final propietarioRepository PropietarioRepository;
    private final veterinarioRepository veterinarioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Mascota> listarTodas() {
        return MascotaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Mascota buscarPorId(Long id) {
        return MascotaRepository.findById(id).orElseThrow(()->
                new ResourceNotFondException("No se Encontro la mascota "+id));

    }

    @Override
    public Mascota crear(Mascota mascota, Long propietarioId) {
        Propietario propietario = PropietarioRepository.findById(propietarioId).orElseThrow(()->
                new ResourceNotFondException("No se Encontro la mascota "+propietarioId));
        mascota.setPropietario(propietario);
        return MascotaRepository.save(mascota);
    }

    @Override
    @Transactional
    public Mascota actualizar(Long id, Mascota datos) {
        Mascota actual = buscarPorId(id);

        actual.setId(datos.getId());
        actual.setNombre(datos.getNombre());
        actual.setEspecie(datos.getEspecie());
        actual.setRaza(datos.getRaza());
        actual.setEdad(datos.getEdad());
        actual.setPeso(datos.getPeso());
        actual.setHistoria_clinica(datos.getHistoria_clinica());
        actual.setVeterinarios(datos.getVeterinarios());

        return MascotaRepository.save(actual);
    }

    @Override
    public void eliminar(Long id) {
        Mascota mascota = buscarPorId(id);
        MascotaRepository.delete(mascota);

    }

    @Override
    @Transactional(readOnly = true)
    public List<Mascota> buscarPorPropietario(Long propietarioId) {
        return MascotaRepository.findByPropietarioId(propietarioId);
    }

    @Override
    @Transactional
    public Mascota asignarveterinario(Long mascotaId, Long veterinarioId) {
        Mascota mascota = buscarPorId(mascotaId);
        Veterinario veterinario = veterinarioRepository.findById(veterinarioId)
                .orElseThrow(() -> new ResourceNotFondException("No se encontró el veterinario con ID: " + veterinarioId));

        mascota.getVeterinarios().add(veterinario);
        return MascotaRepository.save(mascota);
    }

}
