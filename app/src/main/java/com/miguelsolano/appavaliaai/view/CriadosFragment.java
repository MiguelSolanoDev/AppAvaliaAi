package com.miguelsolano.appavaliaai.view;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.miguelsolano.appavaliaai.BancoFake;
import com.miguelsolano.appavaliaai.R;
import com.miguelsolano.appavaliaai.model.EventoAdapter;
import com.miguelsolano.appavaliaai.model.Eventos;

import java.util.ArrayList;
import java.util.List;

public class CriadosFragment extends Fragment {

    private RecyclerView recyclerEventos;
    private LinearLayout layoutEstadoVazio;

    public CriadosFragment() {
        // obrigatório
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_criados, container, false);

        recyclerEventos = view.findViewById(R.id.recyclerEventos);
        layoutEstadoVazio = view.findViewById(R.id.layoutEstadoVazio);

        // Layout da lista
        recyclerEventos.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Eventos> listaEventos = carregarEventos();

        if (listaEventos.isEmpty()) {
            layoutEstadoVazio.setVisibility(View.VISIBLE);
            recyclerEventos.setVisibility(View.GONE);
        } else {
            layoutEstadoVazio.setVisibility(View.GONE);
            recyclerEventos.setVisibility(View.VISIBLE);

            EventoAdapter adapter = new EventoAdapter(listaEventos);
            recyclerEventos.setAdapter(adapter);
        }

        return view;
    }

    // 🔥 Simulação (depois você troca pelo banco)
    private List<Eventos> carregarEventos() {
        return BancoFake.listaEventos; // começa vazio
    }
}