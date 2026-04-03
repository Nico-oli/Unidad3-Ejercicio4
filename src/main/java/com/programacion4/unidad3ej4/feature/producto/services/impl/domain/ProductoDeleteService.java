package com.programacion4.unidad3ej4.feature.producto.services.impl.domain;

import org.springframework.stereotype.Service;

import com.programacion4.unidad3ej4.config.exceptions.NotFoundException;
import com.programacion4.unidad3ej4.feature.producto.models.Producto;
import com.programacion4.unidad3ej4.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej4.feature.producto.services.interfaces.domain.IProductoDeleteService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductoDeleteService implements IProductoDeleteService{
    
    private final IProductoRepository repository;

    @Override
    public void deleteProducto(long id){

        Producto productoToDelete = repository.findById(id).orElseThrow(() -> new NotFoundException("Producto no encontrado"));

        productoToDelete.setEstaEliminado(true);

        repository.save(productoToDelete);
        
    }
}
