package com.company.myapplication;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokeViewModel extends AndroidViewModel {

    MutableLiveData<Poke.Respuesta> respuestaMutableLiveData = new MutableLiveData<>();


    public PokeViewModel(@NonNull Application application) {
        super(application);
    }


    void obtenerPokemons(){
        Poke.api.obtenerPokemons().enqueue(new Callback<Poke.Respuesta>() {
            @Override
            public void onResponse(Call<Poke.Respuesta> call, Response<Poke.Respuesta> response) {
                respuestaMutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Poke.Respuesta> call, Throwable t) {}
        });
    }
}
