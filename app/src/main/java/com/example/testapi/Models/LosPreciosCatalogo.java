package com.example.testapi.Models;

import android.telecom.Call;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;



public class LosPreciosCatalogo {

    public String Resultado;

    public int ErrorID;

    public JsonObject Datos;



    public JsonObject getDatos() {
        return Datos;
    }

    public String getResultado() {
        return Resultado;
    }

    public int getErrorID() {
        return ErrorID;
    }
}