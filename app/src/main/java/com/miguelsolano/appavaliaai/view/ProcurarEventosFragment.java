package com.miguelsolano.appavaliaai.view;

import static androidx.core.content.ContentProviderCompat.requireContext;
import static androidx.core.content.ContextCompat.startActivity;

import static java.security.AccessController.getContext;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.miguelsolano.appavaliaai.BancoFake;
import com.miguelsolano.appavaliaai.R;
import com.miguelsolano.appavaliaai.model.EventoAdapter;
import com.miguelsolano.appavaliaai.model.Eventos;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.miguelsolano.appavaliaai.BancoFake;
import com.miguelsolano.appavaliaai.R;
import com.miguelsolano.appavaliaai.model.EventoAdapter;
import com.miguelsolano.appavaliaai.model.Eventos;
import java.util.List;

public class ProcurarEventosFragment extends Fragment {
    private RecyclerView recyclerEventos;
    private LinearLayout layoutEstadoVazio;

    public ProcurarEventosFragment() {
        // obrigatório
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_criados, container, false);

        recyclerEventos = view.findViewById(R.id.recyclerEventos);
        layoutEstadoVazio = view.findViewById(R.id.layoutEstadoVazio);
        Button btnAcao = view.findViewById(R.id.btnAcao);
        // Layout da lista
        recyclerEventos.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Eventos> listaEventos = carregarEventos();

        if (listaEventos.isEmpty()) {
            layoutEstadoVazio.setVisibility(View.VISIBLE);
            recyclerEventos.setVisibility(View.GONE);

            btnAcao.setOnClickListener( v -> {
                Intent intent = new Intent(requireContext(), CriarEventosActivity.class);
                startActivity(intent);
            });

        } else {
            layoutEstadoVazio.setVisibility(View.GONE);
            recyclerEventos.setVisibility(View.VISIBLE);

            EventoAdapter adapter = new EventoAdapter(listaEventos);
            recyclerEventos.setAdapter(adapter);
        }

        return view;
    }

    private List<Eventos> carregarEventos() {
        return BancoFake.listaEventos;
    }
}
