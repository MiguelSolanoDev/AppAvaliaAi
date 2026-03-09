package com.miguelsolano.appavaliaai.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.miguelsolano.appavaliaai.R;
import com.miguelsolano.appavaliaai.model.Eventos;

import java.util.List;

public class EventoAdapter extends RecyclerView.Adapter<EventoAdapter.EventoViewHolder> {

    List<Eventos> listaEventos;

    public EventoAdapter(List<Eventos> listaEventos) {
        this.listaEventos = listaEventos;
    }

    @NonNull
    @Override
    public EventoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_evento, parent, false);

        return new EventoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventoViewHolder holder, int position) {

        Eventos evento = listaEventos.get(position);

        holder.titulo.setText(evento.getTitulo());
        holder.data.setText(evento.getData());
        holder.status.setText(evento.getStatus());
        holder.tipo.setText(evento.getTipo());
        holder.categoria.setText(evento.getCategoria());
        holder.avaliacao.setText("⭐ " + evento.getAvaliacao());
    }

    @Override
    public int getItemCount() {
        return listaEventos.size();
    }

    public static class EventoViewHolder extends RecyclerView.ViewHolder {

        TextView titulo;
        TextView data;
        TextView status;
        TextView tipo;
        TextView categoria;
        TextView avaliacao;

        ImageView imagem;

        public EventoViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.txtTitulo);
            data = itemView.findViewById(R.id.txtData);
            status = itemView.findViewById(R.id.tagStatus);
            tipo = itemView.findViewById(R.id.tagTipo);
            categoria = itemView.findViewById(R.id.tagCategoria);
            imagem = itemView.findViewById(R.id.imgEvento);
            avaliacao = itemView.findViewById(R.id.txtAvaliacao);
        }
    }
}