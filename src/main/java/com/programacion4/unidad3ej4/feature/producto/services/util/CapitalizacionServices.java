package com.programacion4.unidad3ej4.feature.producto.services.util;

import org.springframework.stereotype.Service;

import com.programacion4.unidad3ej4.feature.producto.services.interfaces.commons.ICapitalizacionServices;

@Service
public class CapitalizacionServices implements ICapitalizacionServices{

    @Override
    public String capitalizar(String texto) {

        if(texto == null || texto.isEmpty()){

            return texto;

        }
        
        return texto.substring(0,1).toUpperCase() + texto.substring(1).toLowerCase();

    }


}
