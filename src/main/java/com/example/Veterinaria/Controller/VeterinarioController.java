package com.example.Veterinaria.Controller;

import com.example.Veterinaria.Emtity.Veterinario;
import com.example.Veterinaria.Service.VeterinarioService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veterinarios")
@RequiredArgsConstructor

public class VeterinarioController {
    private final VeterinarioService veterinarioService;

    @GetMapping("/listar")
    public ResponseEntity<List<Veterinario>> listarTodos() {
        return ResponseEntity.ok(veterinarioService.listarTodos());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Veterinario> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(veterinarioService.buscarPorId(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<Veterinario> crear(@RequestBody Veterinario veterinario) {
        return new ResponseEntity<>(veterinarioService.crear(veterinario), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Veterinario> actualizar(@PathVariable Long id, @RequestBody Veterinario datos) {
        return ResponseEntity.ok(veterinarioService.actualizar(id, datos));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        veterinarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}