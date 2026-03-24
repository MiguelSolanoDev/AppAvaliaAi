package com.miguelsolano.appavaliaai.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import com.miguelsolano.appavaliaai.BancoFake;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.miguelsolano.appavaliaai.BancoFake;
import com.miguelsolano.appavaliaai.R;
import com.miguelsolano.appavaliaai.model.EventoAdapter;
import com.miguelsolano.appavaliaai.model.Eventos;

import java.util.ArrayList;
import java.util.List;

public class ListaEventosFragment extends Fragment {
    RecyclerView recyclerEventos;
    List<Eventos> listaEventos;
    EventoAdapter adapter;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public ListaEventosFragment() {
        // Required empty public constructor
    }

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

        listaEventos = BancoFake.listaEventos;

        adapter = new EventoAdapter(listaEventos);

        recyclerEventos.setAdapter(adapter);

        return view;
    }
}