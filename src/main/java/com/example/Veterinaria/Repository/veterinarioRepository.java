package com.example.Veterinaria.Repository;

import com.example.Veterinaria.Emtity.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface veterinarioRepository extends JpaRepository<Veterinario, Long> {
}