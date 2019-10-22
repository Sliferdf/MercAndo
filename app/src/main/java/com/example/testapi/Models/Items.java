package com.example.testapi.Models;

import java.util.List;

public class Items {
    public String Producto;
    public String RutaImagen;
    public List<ItemsTiendas> ÍtemsTiendas;

    public String getProducto() {
        return Producto;
    }

    public String getRutaImagen() {
        return RutaImagen;
    }

    public List<ItemsTiendas> getÍtemsTiendas() {
        return ÍtemsTiendas;
    }
}
