package com.example.Veterinaria.Emtity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es Obligatorio")
    @Column(nullable = false)
    private  String nombre;

    @NotBlank(message = "No puede estar vacio este campo")
    @Column(nullable = false)
    private String especie;

    @NotBlank(message = "No puede estar vacio este campo")
    @Column(nullable = false)
    private String raza;

    @NotNull(message = "El peso es obligatorio")
    @Min(value = 0, message = "La edad no puede ser negativa")
    @Column(nullable = false)
    private int edad;

    @NotNull(message = "El peso es obligatorio")
    @Positive(message = "el peso debe ser mayor a 0")
    @Column(nullable = false)
    private Double peso;

    @OneToOne(mappedBy = "mascota", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("mascota")
    private Historia_clinica historiaClinica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "propietario_id", nullable = false)
    @JsonIgnoreProperties({"mascotas", "hibernateLazyInitializer", "handler"})
    private Propietario propietario;

    @OneToOne(mappedBy = "mascota", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("mascota")
    private Historia_clinica historia_clinica;

    @ManyToMany
    @JoinTable(
            name = "mascota_veterinario",
            joinColumns = @JoinColumn(name = "mascota_id"),
            inverseJoinColumns = @JoinColumn(name = "veterinario_id")
    )
    @JsonIgnoreProperties({"mascotas", "hibernateLazyInitializer", "handler"})
    private List<Veterinario> veterinarios = new ArrayList<>();
}
