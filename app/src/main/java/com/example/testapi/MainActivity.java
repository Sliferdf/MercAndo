package com.example.testapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.testapi.Interfaces.PeticionesApiLosPrecios;
import com.example.testapi.Models.Datos;
import com.example.testapi.Models.Items;
import com.example.testapi.Models.ItemsTiendas;
import com.example.testapi.Models.LosPreciosCatalogo;
import com.example.testapi.Models.Prueba;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "PRODUCTOS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://losprecios.co/tienda/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PeticionesApiLosPrecios service = retrofit.create(PeticionesApiLosPrecios.class);

        final Call <LosPreciosCatalogo> catalogo=  service.obtenerProductos();

        catalogo.enqueue(new Callback<LosPreciosCatalogo>() {
            @Override
            public void onResponse(Call<LosPreciosCatalogo> call, Response<LosPreciosCatalogo> response) {
                if (!response.isSuccessful()) {
                    Log.e(TAG, "ERROR:" + response.code());
                } else {
                    LosPreciosCatalogo catag = response.body();
                   String dato =catag.getResultado();
                   int error = catag.getErrorID();
                   JsonObject datos =catag.getDatos();
                   JsonArray datos0 = datos.getAsJsonArray("Ítems");
                   Gson gson = new Gson();
                   String jsonsito = gson.toJson(datos0);
                   ArrayList<Datos> datos1=  new ArrayList<Datos>();
                   Datos d = new Datos();

                    for(int i=0; i<datos0.size(); i++) {
                        d.setProducto( datos0.get(i));
                        d.setName( jsonArray.getJSONObject(i).getString("name") );
                        datos1.add(d);
                    }

                    Log.e(TAG, "datos  " + dato+ " " + error + jsonsito);
                }
            }
                    /*LosPreciosCatalogo  catag = response.body();
                    for (Datos d : catag.Datos){
                                Log.i(TAG, "nombre: " + d.Producto + "\n" + " Direccion: " + d.RutaImagen );
                            }
                        }
                        Log.i(TAG, " ------------");
                    }*/

            @Override
            public void onFailure(Call<LosPreciosCatalogo> call, Throwable t) {
                Log.e(TAG, "ERRROR: " + t.getMessage());
            }
        });
    }
}


