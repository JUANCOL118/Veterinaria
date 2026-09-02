package com.example.Veterinaria.Emtity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Propietario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es Obligatorio")
    @Column(nullable = false)
    private String nombre;

    @NotBlank(message = "El Documento es obligatorio")
    @Column(nullable = false, unique = true)
    private String documento;

    @NotBlank(message = "El Telefono es Obligatorio")
    @Column(nullable = false)
    private  String telefono;

    @NotBlank(message = "El nombre es Obligatorio")
    @Email(message = "El correo electronico debe ser valido ")
    @Column(nullable = false, unique = false)
    private  String correo;

    @OneToMany(mappedBy = "propietario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("propietariio")
    private List<Mascota> mascotas = new ArrayList<>();
}
