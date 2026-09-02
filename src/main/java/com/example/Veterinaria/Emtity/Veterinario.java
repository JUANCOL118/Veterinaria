package com.example.Veterinaria.Emtity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Veterinario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es Obligatorio")
    @Column(nullable = false)
    private String nombre;

    @NotBlank(message = "La tarjeta profesional es obligatoria")
    @Column(nullable = false, unique = true)
    private String tarjeta_profecional;

    @NotBlank(message = "este campo no puede estar vacio")
    @Column(nullable = false)
    private String especialidad;

    @NotBlank(message = "El nombre es Obligatorio")
    @Email(message = "El correo electronico debe ser valido ")
    @Column(nullable = false, unique = false)
    private  String correo;

    @ManyToMany(mappedBy = "veterinarios")
    @JsonIgnoreProperties("veterinarios")
    private List<Mascota> mascotas = new ArrayList<>();
}
