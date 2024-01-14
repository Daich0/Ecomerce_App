package com.ecomerce.fis.controllers;


import com.ecomerce.fis.repository.RepoProduct;
import com.ecomerce.fis.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ControllerProducto {

    @Autowired
    private RepoProduct repo;

    @GetMapping("productos")
    public List<Producto> getProductos() {
        return repo.findAll();
    }

    @GetMapping("productos/{id}/imagen")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        Producto producto = repo.findById(id).orElse(null);
        if (producto != null && producto.getImagen() != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG); // Cambia el tipo MIME según el tipo de imagen que estás almacenando
            return new ResponseEntity<>(producto.getImagen(), headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("productos/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Long id) {
        Producto producto = repo.findById(id).orElse(null);
        if (producto != null) {
            return new ResponseEntity<>(producto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("productos")
    public String post(@RequestParam("imagen") MultipartFile file,
                       @RequestParam("producto") String productoJson,
                       @RequestParam("marca") String marca,
                       @RequestParam("modelo") String modelo,
                       @RequestParam("alto") String alto,
                       @RequestParam("ancho") String ancho,
                       @RequestParam("garantia") String garantia,
                       @RequestParam("color") String color,
                       @RequestParam("peso") String peso,
                       @RequestParam("precio") String precio) {
        try {
            byte[] imagenData = file.getBytes(); // Obtener los bytes de la imagen
            Producto producto = new Producto();
            producto.setProducto(productoJson);
            producto.setMarca(marca);
            producto.setModelo(modelo);
            producto.setAlto(alto);
            producto.setAncho(ancho);
            producto.setGarantia(garantia);
            producto.setColor(color);
            producto.setPeso(peso);
            producto.setPrecio(precio);
            producto.setImagen(imagenData); // Establecer los bytes de la imagen en el producto

            repo.save(producto);
            return "Grabado";
        } catch (IOException e) {
            System.out.println("Error processing image or product data"+ e);
            return "Error al procesar la imagen o los datos del producto";
        }
    }
    @PutMapping("productos/{id}")
    public String updateProducto(@PathVariable Long id,
                                 @RequestParam(value = "imagen", required = false) MultipartFile file,
                                 @RequestParam(value ="producto", required = false) String producto,
                                 @RequestParam(value ="marca", required = false) String marca,
                                 @RequestParam(value ="modelo", required = false) String modelo,
                                 @RequestParam(value ="alto", required = false) String alto,
                                 @RequestParam(value ="ancho", required = false) String ancho,
                                 @RequestParam(value ="garantia", required = false) String garantia,
                                 @RequestParam(value ="color", required = false) String color,
                                 @RequestParam(value ="peso", required = false) String peso,
                                 @RequestParam(value ="precio", required = false) String precio) {
        try {
            Producto productoToUpdate = repo.findById(id).orElse(null);
            if (productoToUpdate != null) {
                productoToUpdate.setProducto(producto);
                productoToUpdate.setMarca(marca);
                productoToUpdate.setModelo(modelo);
                productoToUpdate.setAlto(alto);
                productoToUpdate.setAncho(ancho);
                productoToUpdate.setGarantia(garantia);
                productoToUpdate.setColor(color);
                productoToUpdate.setPeso(peso);
                productoToUpdate.setPrecio(precio);

                if (file != null  && !file.isEmpty()) {
                    byte[] imagenData = file.getBytes();
                    productoToUpdate.setImagen(imagenData); // Actualizar la imagen si se proporciona
                }

                repo.save(productoToUpdate);
                return "Producto actualizado correctamente";
            } else {
                return "Producto no encontrado";
            }
        } catch (IOException e) {
            return "Error al procesar la imagen o los datos del producto";
        }
    }
    @DeleteMapping("productos/{id}")
    public String delete(@PathVariable Long id){
        Producto deleteProducto =repo.findById(id).get();
        repo.delete(deleteProducto);
        return "Eliminado";
    }




}
