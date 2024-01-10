package com.ecomerce.fis.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @Getter
    @Setter
    private long id;

    @Column (name ="nombre")
    @Getter
    @Setter
    private String nombre;

    @Column (name ="telefono")
    @Getter
    @Setter
    private String telefono;
    @Column (name ="rol")
    @Getter
    @Setter
    private String rol;

    @Column (name ="username")
    @Getter
    @Setter
    private String username;

    @Column (name ="password")
    @Getter
    @Setter
    private String password;

}
