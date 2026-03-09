package com.miguelsolano.appavaliaai;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.miguelsolano.appavaliaai.model.EventoAdapter;
import com.miguelsolano.appavaliaai.model.Eventos;

import java.util.ArrayList;
import java.util.List;

public class ListaEventosFragment extends Fragment {
    RecyclerView recyclerEventos;
    List<Eventos> listaEventos;
    EventoAdapter adapter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListaEventosFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ListaEventosFragment newInstance(String param1, String param2) {
        ListaEventosFragment fragment = new ListaEventosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_eventos, container, false);
        recyclerEventos = view.findViewById(R.id.recyclerEventos);

        recyclerEventos.setLayoutManager(new LinearLayoutManager(getContext()));

        listaEventos = new ArrayList<>();

        listaEventos.add(new Eventos(
                "Futebol Beneficente",
                "03/02/2026 • 16h - 18h",
                "Encerrado",
                "Presencial",
                "Esportes",
                4.8
        ));
        listaEventos.add(new Eventos(
                "Show de Rock",
                "10/03/2026 • 21h",
                "Aberto",
                "Presencial",
                "Música",
                4.6
        ));
        adapter = new EventoAdapter(listaEventos);

        recyclerEventos.setAdapter(adapter);

        return view;
    }
}