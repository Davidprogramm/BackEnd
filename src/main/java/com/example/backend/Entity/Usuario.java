package com.example.backend.Entity;


import jakarta.persistence.*;

@Entity
@Table(name="usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @Column(nullable = false, length = 60)
    private String nombre;

    @Column(nullable = false, length = 70,unique = true)
    private String correo;

    @Column(nullable = false, length = 70)
    private String rol;

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Usuario(Long id_usuario, String nombre, String correo, String rol) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.correo = correo;
        this.rol = rol;
    }

    public Usuario() {
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
