package com.programacion4.unidad3ej4.feature.producto.controllers.get;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programacion4.unidad3ej4.config.BaseResponse;
import com.programacion4.unidad3ej4.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej4.feature.producto.services.interfaces.domain.IProductoGetService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/productos")
@AllArgsConstructor
public class ProductoGetAllController {

    IProductoGetService productoGetService;


    @GetMapping
    public ResponseEntity<BaseResponse<List<ProductoResponseDto>>> getAllProductos(){
        return ResponseEntity.status(200).body(
            BaseResponse.ok(
                productoGetService.getAllProductos(),
                "Productos obtenidos correctamente"
            )
        );
    }
}
