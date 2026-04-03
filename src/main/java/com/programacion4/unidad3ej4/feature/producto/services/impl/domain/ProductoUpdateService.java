package com.programacion4.unidad3ej4.feature.producto.services.impl.domain;

import org.springframework.stereotype.Service;

import com.programacion4.unidad3ej4.config.exceptions.NotFoundException;
import com.programacion4.unidad3ej4.feature.producto.dtos.request.ProductoUpdateAllRequestDto;
import com.programacion4.unidad3ej4.feature.producto.dtos.request.ProductoUpdateRequestDto;
import com.programacion4.unidad3ej4.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej4.feature.producto.mappers.ProductoMapper;
import com.programacion4.unidad3ej4.feature.producto.models.Producto;
import com.programacion4.unidad3ej4.feature.producto.repositories.ICategoriaRepository;
import com.programacion4.unidad3ej4.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej4.feature.producto.services.interfaces.domain.IProductoUpdateService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductoUpdateService implements IProductoUpdateService{

    private final IProductoRepository repository;

    private final ICategoriaRepository Crepository;

    @Override
    public ProductoResponseDto updateAllProducto(long id, ProductoUpdateAllRequestDto producto){
        
        Producto productoToUpdate = repository
        .findById(id)
        .orElseThrow(
            () -> new NotFoundException("Elemento no encontrado")
        );

        productoToUpdate.setNombre(producto.getNombre());
        productoToUpdate.setCodigo(producto.getCodigo());
        productoToUpdate.setDescripcion(producto.getDescripcion());
        productoToUpdate.setPrecio(producto.getPrecio());
        productoToUpdate.setStock(producto.getStock());
        productoToUpdate.setCategoria(Crepository.findById(producto.getCategoriaId()).orElseThrow(() -> new NotFoundException("Categoria no encontrada")));

        repository.save(productoToUpdate);

        return ProductoMapper.toResponseDto(productoToUpdate);
    }

    @Override
    public ProductoResponseDto updateProducto(Long id, ProductoUpdateRequestDto dto){
        
        Producto productoToUpdate = repository.findById(id).orElseThrow(() -> new NotFoundException("Producto no encontrado"));

        if(dto.getNombre() != null){
            productoToUpdate.setNombre(dto.getNombre());
        }

        if(dto.getCodigo() != null){
            productoToUpdate.setCodigo(dto.getCodigo());
        }

        if(dto.getDescripcion() != null){
            productoToUpdate.setDescripcion(dto.getDescripcion());
        }

        if(dto.getPrecio() != null){
            productoToUpdate.setPrecio(dto.getPrecio());
        }

        if(dto.getStock() != null){
            productoToUpdate.setStock(dto.getStock());
        }

        if(dto.getCategoriaId() != null){
            productoToUpdate.setCategoria(Crepository.findById(dto.getCategoriaId()).orElseThrow(() -> new NotFoundException("No se encontro la categoria ingresada")));
        }

        repository.save(productoToUpdate);

        return ProductoMapper.toResponseDto(productoToUpdate);
    }
}
