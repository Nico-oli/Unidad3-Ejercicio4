package com.programacion4.unidad3ej4.feature.producto.controllers.get;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programacion4.unidad3ej4.config.BaseResponse;
import com.programacion4.unidad3ej4.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej4.feature.producto.services.interfaces.domain.IProductoGetService;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/productos")
@AllArgsConstructor
public class ProductoGetController {

    IProductoGetService productoGetService;

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<ProductoResponseDto>> getProductoById(
        @PathVariable long id){
        return ResponseEntity.status(200)
            .body(
                BaseResponse.ok(
                productoGetService.getProductoById(id),
                "Producto obtenido correctamente"));
    }

}
