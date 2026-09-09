package com.example.Veterinaria.Controller;

import com.example.Veterinaria.Emtity.Propietario;
import com.example.Veterinaria.Exception.ResourceNotFondException;
import com.example.Veterinaria.Service.PropietarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/propietario")
@AllArgsConstructor

public class PropietarioController {
    private final PropietarioService propietarioService;

    @GetMapping("/listar/")
    public ResponseEntity<List<Propietario>> listarTodos() {
        return ResponseEntity.ok(propietarioService.listarTodos());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Propietario> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(propietarioService.buscarPorId(id));
    }

    @PostMapping("/crear/")
    @Transactional
    public ResponseEntity<Propietario> crear(@RequestBody Propietario propietario) {
        return ResponseEntity.ok(propietarioService.crear(propietario));
    }

    @PutMapping("/actualizar/{id}")

    public ResponseEntity<Propietario> actualizar(@PathVariable Long id, @RequestBody Propietario propietario) {
        Propietario propietario1 = propietarioService.actualizar(id, propietario);
        return ResponseEntity.ok(propietario1);

    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        propietarioService.eliminar(id);
        return ResponseEntity.noContent().build();

    }
}