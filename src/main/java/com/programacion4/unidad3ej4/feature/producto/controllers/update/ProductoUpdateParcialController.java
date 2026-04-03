package com.programacion4.unidad3ej4.feature.producto.controllers.update;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programacion4.unidad3ej4.config.BaseResponse;
import com.programacion4.unidad3ej4.feature.producto.dtos.request.ProductoUpdateRequestDto;
import com.programacion4.unidad3ej4.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej4.feature.producto.services.interfaces.domain.IProductoUpdateService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/productos")
@AllArgsConstructor
public class ProductoUpdateParcialController {

    private final IProductoUpdateService service;

    @PatchMapping("/{id}")
    public ResponseEntity<BaseResponse<ProductoResponseDto>> updateProducto(
        @PathVariable Long id, 
        @Valid @RequestBody ProductoUpdateRequestDto dto){
        return ResponseEntity.status(200).body(
            BaseResponse.ok(
                service.updateProducto(id, dto),
                "Producto actualizado correctamente"
            )
        );
    }
}
