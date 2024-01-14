package com.ecomerce.fis.models;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.Id;

@Entity
@Table(name="producto3")
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String alto;

    @Column
    private String color;

    @Column
    private String eficienciaEnergetica;

    @Column
    private String fotografia;

    @Column
    private String garantia;

    @Column
    private String marca;

    @Column
    private String modelo;

    @Column
    private String peso;

    @Column
    private String profundidad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlto() {
        return alto;
    }

    public void setAlto(String alto) {
        this.alto = alto;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEficienciaEnergetica() {
        return eficienciaEnergetica;
    }

    public void setEficienciaEnergetica(String eficienciaEnergetica) {
        this.eficienciaEnergetica = eficienciaEnergetica;
    }

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(String profundidad) {
        this.profundidad = profundidad;
    }

    public String getVoltaje() {
        return voltaje;
    }

    public void setVoltaje(String voltaje) {
        this.voltaje = voltaje;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column
    private String voltaje;

    @Column
    private String precio;

    @Column
    private String nombre;

}
