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


    @Column (name ="rol")
    @Getter
    @Setter
    private String rol;

    @Column (name ="email")
    @Getter
    @Setter
    private String email;

    @Column (name ="password")
    @Getter
    @Setter
    private String password;

}
