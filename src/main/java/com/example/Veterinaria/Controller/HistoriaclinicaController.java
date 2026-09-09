package com.example.Veterinaria.Controller;

import com.example.Veterinaria.Emtity.Historia_clinica;
import com.example.Veterinaria.Service.HistoriaClinicaservice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historias-clinicas")
@RequiredArgsConstructor
public class HistoriaclinicaController {

    private final HistoriaClinicaservice historiaClinicaservice;

    @GetMapping("/listar")
    public ResponseEntity<List<Historia_clinica>> listarTodas() {
        return ResponseEntity.ok(historiaClinicaservice.listarTodos());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Historia_clinica> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(historiaClinicaservice.buscarPorId(id));
    }

    @PostMapping("/crear/{mascotaId}")
    public ResponseEntity<Historia_clinica> crear(@RequestBody Historia_clinica historiaClinica, @PathVariable Long mascotaId) {
        return new ResponseEntity<>(historiaClinicaservice.crear(historiaClinica, mascotaId), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Historia_clinica> actualizar(@PathVariable Long id, @RequestBody Historia_clinica datos) {
        return ResponseEntity.ok(historiaClinicaservice.actualizar(id, datos));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        historiaClinicaservice.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
