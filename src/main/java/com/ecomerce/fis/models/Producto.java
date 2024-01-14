package com.ecomerce.fis.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @Getter
    @Setter
    private long id;

    @Column (name ="producto")
    @Getter
    @Setter
    private String producto;

    @Column (name ="marca")
    @Getter
    @Setter
    private String marca;

    @Column (name ="modelo")
    @Getter
    @Setter
    private String modelo;

    @Column (name ="alto")
    @Getter
    @Setter
    private String alto;

    @Column (name ="ancho")
    @Getter
    @Setter
    private String ancho;

    @Column (name ="garantia")
    @Getter
    @Setter
    private String garantia;

    @Column (name ="color")
    @Getter
    @Setter
    private String color;

    @Column (name ="peso")
    @Getter
    @Setter
    private String peso;

    @Column (name ="precio")
    @Getter
    @Setter
    private String precio;

    @Lob
    @Column(name = "imagen", columnDefinition = "LONGBLOB")
    @Getter
    @Setter
    private byte[] imagen;



}


