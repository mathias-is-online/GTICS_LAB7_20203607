package com.example.lab720203607.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "technician")
public class Technician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="TechnicianID")
    private int TechnicianID;


    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    @NotNull
    @Column(name="FirstName")
    private String firstName;

    @Size(min = 3, max = 100, message = "El APELLIDO debe tener entre 3 y 100 caracteres")
    @NotNull
    private String lastName;

    @Size(min = 8, max = 8, message = "El dni debe tener 8 digitos")
    @NotNull
    private String dni;

    @Size(min = 9, max = 9, message = "El telefono debe tener 9 digitos")
    @NotNull
    private String phone;

    @NotNull
    @Min(value = 1,message = "el valor minimo es 1, debe ser positivo")
    @Column(name="Age")
    private Integer age;


}
