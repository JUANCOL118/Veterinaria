package com.example.Veterinaria.Controller;


import com.example.Veterinaria.Emtity.Mascota;
import com.example.Veterinaria.Emtity.Propietario;
import com.example.Veterinaria.Emtity.Veterinario;
import com.example.Veterinaria.Exception.ResourceNotFondException;
import com.example.Veterinaria.Service.MascotaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascotas")
@RequiredArgsConstructor

public class MascotasController {
    private final MascotaService mascotaService;

    @GetMapping("/listar/")

    public ResponseEntity<List<Mascota>> listarTodas() {
        return ResponseEntity.ok(mascotaService.listarTodas());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity <Mascota> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(mascotaService.buscarPorId(id));
    }
    @PostMapping("/crear/{propietarioId}")
    public ResponseEntity<Mascota> crear(@RequestBody Mascota mascota, @PathVariable Long propietarioId) {
        return ResponseEntity.ok(mascotaService.crear(mascota, propietarioId));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Mascota> actualizar(@PathVariable Long id,@RequestBody Mascota datos) {
        return ResponseEntity.ok(mascotaService.actualizar(id,datos));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
       mascotaService.eliminar(id);
        return ResponseEntity.noContent().build();

    }

    @PostMapping("/{mascotaId}/asignar-veterinario/{veterinarioId}")
    public ResponseEntity<Mascota> AsignarVeterinario(@PathVariable Long mascotaId,@PathVariable Long veterinarioId){
        return ResponseEntity.ok(mascotaService.asignarveterinario(mascotaId,veterinarioId));

    }
}

