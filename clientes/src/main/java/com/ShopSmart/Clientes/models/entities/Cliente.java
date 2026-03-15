package com.ShopSmart.Clientes.models.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cliente;

    @NotBlank(message = "El primer nombre es obligatorio")
    @Column(nullable = false, length = 50)
    private String pnombre_cli;

    @Column(length = 50)
    private String snombre_cli;

    @NotBlank(message = "El apellido paterno es obligatorio")
    @Column(nullable = false, length = 50)
    private String apaterno_cli;

    @Column(length = 50)
    private String amaterno_cli;

    @NotBlank(message = "El RUN es obligatorio")
    @Pattern(regexp = "^[0-9]{7,8}-[0-9kK]$", message = "El RUN debe tener formato 12345678-9")
    @Column(nullable = false, unique = true, length = 10)
    private String run_cli;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email no tiene un formato válido")
    @Column(nullable = false, unique = true, length = 100)
    private String email_cli;

    @NotBlank(message = "El teléfono es obligatorio")
    @Pattern(regexp = "^[0-9]{9}$", message = "El teléfono debe tener 9 dígitos")
    @Column(nullable = false, length = 9)
    private String telefono_cli;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    @Column(nullable = false)
    private String contrasena;

}
