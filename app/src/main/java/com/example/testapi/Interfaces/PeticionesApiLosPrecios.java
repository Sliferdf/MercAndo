package com.example.testapi.Interfaces;

import com.example.testapi.Models.LosPreciosCatalogo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PeticionesApiLosPrecios {

    @GET("detalles?ID=1&MunicipioID=2&ClaveAPI=5s8I_CKqFt*AiLT6&Página=1")
    Call <LosPreciosCatalogo> obtenerProductos();

}
