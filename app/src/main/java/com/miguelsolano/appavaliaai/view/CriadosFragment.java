package com.miguelsolano.appavaliaai.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.miguelsolano.appavaliaai.R;
import com.miguelsolano.appavaliaai.model.Eventos;

import java.util.ArrayList;
import java.util.List;

public class CriadosFragment extends Fragment {

    private RecyclerView recyclerEventos;
    private LinearLayout layoutEstadoVazio;

    private EventoAdapter adapter;
    private FirebaseFirestore db;

    public CriadosFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_criados, container, false);

        recyclerEventos = view.findViewById(R.id.recyclerEventos);
        layoutEstadoVazio = view.findViewById(R.id.layoutEstadoVazio);
        Button btnAcao = view.findViewById(R.id.btnAcao);

        recyclerEventos.setLayoutManager(new LinearLayoutManager(getContext()));

        db = FirebaseFirestore.getInstance();

        carregarEventos();

        btnAcao.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), CriarEventosActivity.class);
            startActivity(intent);
        });

        return view;
    }

    private void carregarEventos() {

        db.collection("eventos")
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {

                    List<Eventos> listaEventos = new ArrayList<>();

                    for (DocumentSnapshot doc : queryDocumentSnapshots) {

                        Eventos evento = new Eventos();

                        evento.setTitulo(doc.getString("titulo"));
                        evento.setDescricao(doc.getString("descricao"));
                        evento.setData(doc.getString("data"));

                        listaEventos.add(evento);
                    }

                    atualizarUI(listaEventos);
                })
                .addOnFailureListener(e -> {
                    Log.e("FIRESTORE", "Erro ao carregar eventos", e);
                    atualizarUI(new ArrayList<>());
                });
    }

    private void atualizarUI(List<Eventos> listaEventos) {

        if (listaEventos.isEmpty()) {
            layoutEstadoVazio.setVisibility(View.VISIBLE);
            recyclerEventos.setVisibility(View.GONE);
        } else {
            layoutEstadoVazio.setVisibility(View.GONE);
            recyclerEventos.setVisibility(View.VISIBLE);

            adapter = new EventoAdapter(listaEventos);
            recyclerEventos.setAdapter(adapter);
        }
    }
}