package com.company.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class PokemonsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pokemons, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        PokeViewModel pokeViewModel = new ViewModelProvider(this).get(PokeViewModel.class);

        pokeViewModel.obtenerPokemons();

        pokeViewModel.respuestaMutableLiveData.observe(getViewLifecycleOwner(), new Observer<Poke.Respuesta>() {
            @Override
            public void onChanged(Poke.Respuesta respuesta) {
                for(Poke.Pokemon p:respuesta.documents) {
                    Log.e("POKE", p.fields.nombre.stringValue
                    );
                }
            }
        });
    }
}