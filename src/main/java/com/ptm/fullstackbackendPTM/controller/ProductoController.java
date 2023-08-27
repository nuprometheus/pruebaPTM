package com.ptm.fullstackbackendPTM.controller;

import com.ptm.fullstackbackendPTM.exception.ProductoNotFoundException;
import com.ptm.fullstackbackendPTM.model.Producto;
import com.ptm.fullstackbackendPTM.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;


    @PostMapping("/producto")
    Producto newProducto(@RequestBody Producto newProducto) {
        return productoRepository.save(newProducto);
    }

    @GetMapping("/productos")
    List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    @GetMapping("/producto/{id}")
    Producto getProductoById(@PathVariable Long id) {
        return productoRepository.findById(id).orElseThrow(() -> new ProductoNotFoundException(id));
    }

    @PutMapping("/producto/{id}")
    Producto updateProducto(@RequestBody Producto newProducto, @PathVariable Long id) {
        return productoRepository.findById(id).map(producto -> {
            producto.setNombre(newProducto.getNombre());
            producto.setDescripcion(newProducto.getDescripcion());
            producto.setPrecio(newProducto.getPrecio());
            producto.setCantidadStock(newProducto.getCantidadStock());
            return productoRepository.save(producto);

        }).orElseThrow(() -> new ProductoNotFoundException(id));
    }

    @DeleteMapping("/producto/{id}")
    String deleteProducto(@PathVariable Long id) {
        if (!productoRepository.existsById(id)) {
            throw new ProductoNotFoundException(id);
        }
        productoRepository.deleteById(id);
        return "Producto con id " + id + " ha sido eliminado satisfactoriamente";
    }
}
