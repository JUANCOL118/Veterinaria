package com.example.Veterinaria.Service.Impl;

import com.example.Veterinaria.Emtity.Historia_clinica;
import com.example.Veterinaria.Emtity.Mascota;
import com.example.Veterinaria.Exception.ResourceNotFondException;
import com.example.Veterinaria.Repository.historiaclinicaRepository;
import com.example.Veterinaria.Repository.mascotaRepository;
import com.example.Veterinaria.Service.HistoriaClinicaservice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor

public class HistoriaclinicaImpl implements HistoriaClinicaservice {

    private final historiaclinicaRepository historiaclinicaRepository;
    private final mascotaRepository mascotaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Historia_clinica> listarTodos() {
        return historiaclinicaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Historia_clinica buscarPorId(Long id) {
        return historiaclinicaRepository.findById(id).orElseThrow(()->
                new ResourceNotFondException("No se Encontro la Historia Clinica "+id));
    }

    @Override
    public Historia_clinica crear(Historia_clinica historiaClinica, Long mascotaId) {
        Mascota mascota = mascotaRepository.findById(mascotaId).orElseThrow(()->
                new ResourceNotFondException("No se Encontro la mascota "+mascotaId));
        historiaClinica.setMascota(mascota);
        return historiaclinicaRepository.save(historiaClinica);
    }

    @Override
    @Transactional
    public Historia_clinica actualizar(Long id, Historia_clinica datos) {
        Historia_clinica actual = buscarPorId(id);

        actual.setFecha_apertura(datos.getFecha_apertura());
        actual.setAntecedentes(datos.getAntecedentes());
        actual.setObservaciones(datos.getObservaciones());


        return historiaclinicaRepository.save(actual);
    }

    @Override
    public void eliminar(Long id) {
        Historia_clinica historia_clinica = buscarPorId(id);
        historiaclinicaRepository.delete(historia_clinica);
    }
}
