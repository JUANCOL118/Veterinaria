package com.example.Veterinaria.Emtity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Historia_clinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "LA fecha de apertura es olbigatoria")
    @Column(name="fecha de apertura", nullable = false)
    private LocalDate Fecha_apertura;

    @Column(columnDefinition = "TEXT")
    private String antecedentes;

    @Column(columnDefinition = "TEXT")
    private String observaciones;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mascota_id", nullable = false, unique = true)
    @JsonIgnoreProperties({"historiaClinica", "hibernateLazyInitializer", "handler"})
    private Mascota mascota;
}
