package com.example.testapi.Models;

import java.util.List;

public class Datos {

    public String Producto;
    public  String RutaImagen;
    public List<ItemsTiendas> Ítems;

    public String getProducto() {
        return Producto;
    }

    public void setProducto(String producto) {
        Producto = producto;
    }

    public String getRutaImagen() {
        return RutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        RutaImagen = rutaImagen;
    }

    public List<ItemsTiendas> getÍtems() {
        return Ítems;
    }

    public void setÍtems(List<ItemsTiendas> ítems) {
        Ítems = ítems;
    }
}
