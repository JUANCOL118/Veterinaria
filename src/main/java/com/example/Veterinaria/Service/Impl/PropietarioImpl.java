package com.example.Veterinaria.Service.Impl;


import com.example.Veterinaria.Emtity.Propietario;
import com.example.Veterinaria.Exception.ResourceNotFondException;
import com.example.Veterinaria.Repository.propietarioRepository;
import com.example.Veterinaria.Service.PropietarioService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class PropietarioImpl implements PropietarioService {

    private final propietarioRepository repository;

    @Override
    @Transactional (readOnly = true)
    public List<Propietario> listarTodos() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Propietario buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(()->
                new ResourceNotFondException("No se Encontro el prpietario "+id));

    }

    @Override
    @Transactional
    public Propietario crear(Propietario propietario) {
        return repository.save(propietario);
    }

    @Override
    @Transactional
    public Propietario actualizar(Long id, Propietario datos) {

        Propietario actual =buscarPorId(id);

        actual.setNombre(datos.getNombre());
        actual.setDocumento(datos.getDocumento());
        actual.setTelefono(datos.getCorreo());
        actual.setCorreo(datos.getCorreo());


        return repository.save(actual);
    }

    @Override
    public void eliminar(Long id) {
        Propietario propietario = buscarPorId(id);
        repository.delete(propietario);

    }
}
