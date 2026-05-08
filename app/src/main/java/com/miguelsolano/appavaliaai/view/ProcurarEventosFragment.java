package com.miguelsolano.appavaliaai.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
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
    private EventoAdapter adapter;
    public ProcurarEventosFragment() {
        // obrigatório
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_procurareventos,container,false);
        recyclerEventos = view.findViewById(R.id.recyclerEventos);
        layoutEstadoVazio = view.findViewById(R.id.layoutEstadoVazio);
        recyclerEventos.setLayoutManager(                new LinearLayoutManager(requireContext())
        );
        atualizarLista();
        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        atualizarLista();
    }
    private void atualizarLista() {
        List<Eventos> listaEventos = BancoFake.listaEventos;
        if (listaEventos == null || listaEventos.isEmpty()) {
            layoutEstadoVazio.setVisibility(View.VISIBLE);
            recyclerEventos.setVisibility(View.GONE);
        } else {
            layoutEstadoVazio.setVisibility(View.GONE);
            recyclerEventos.setVisibility(View.VISIBLE);

            adapter = new EventoAdapter(listaEventos);
            recyclerEventos.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
    }
}