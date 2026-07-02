package com.miguelsolano.appavaliaai.view;

import static com.miguelsolano.appavaliaai.BancoFake.listaEventos;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.miguelsolano.appavaliaai.BancoFake;
import com.miguelsolano.appavaliaai.R;

public class ProcurarEventosActivity extends AppCompatActivity {
    private RecyclerView recyclerEventos;
    private LinearLayout layoutEstadoVazio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_procurar_eventos);
        layoutEstadoVazio = findViewById(R.id.layoutEstadoVazio);
        recyclerEventos = findViewById(R.id.recyclerEventos);
        recyclerEventos.setLayoutManager(new LinearLayoutManager(this));

        EventoAdapter adapter = new EventoAdapter(BancoFake.listaEventos);
        recyclerEventos.setAdapter(adapter);
        Button btnAcao = findViewById(R.id.btnAcao);
        if(listaEventos.isEmpty()){
            recyclerEventos.setVisibility(View.GONE);
            layoutEstadoVazio.setVisibility(View.VISIBLE);
            btnAcao.setOnClickListener( v -> {
                Intent intent = new Intent(this, CriarEventosActivity.class);
                startActivity(intent);
            });
        }else{
            recyclerEventos.setVisibility(View.VISIBLE);
            layoutEstadoVazio.setVisibility(View.GONE);
        }

        //Botão de Voltar
        ImageButton btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(v -> {
            finish();
        });

        Button btnHoje = findViewById(R.id.btnHoje);
        Button btnSemana = findViewById(R.id.btnSemana);
        Button btnPresencial = findViewById(R.id.btnPresencial);
        Button btnOnline = findViewById(R.id.btnOnline);
        Button btnHibrido = findViewById(R.id.btnHibrido);
        Button btnAtivo = findViewById(R.id.btnAtivo);

        //Botão Hoje
        btnHoje.setOnClickListener(v -> {
            if(btnHoje.isSelected() && btnHoje.getBackgroundTintList().equals(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.VerdeDosBotões)))){
                btnHoje.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
                btnHoje.setTextColor(ContextCompat.getColor(this, R.color.TextoIcones));
                btnHoje.setSelected(false);
            }else{
                btnHoje.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.VerdeDosBotões)));
                btnHoje.setTextColor(Color.WHITE);
                btnHoje.setSelected(true);
            }
        });

        //Botão Semana
        btnSemana.setOnClickListener(v -> {
            if(btnSemana.isSelected() && btnSemana.getBackgroundTintList().equals(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.VerdeDosBotões)))){
                btnSemana.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
                btnSemana.setTextColor(ContextCompat.getColor(this, R.color.TextoIcones));
                btnSemana.setSelected(false);
            }else{
                btnSemana.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.VerdeDosBotões)));
                btnSemana.setTextColor(Color.WHITE);
                btnSemana.setSelected(true);
            }
        });

        //Botão Presencial
        btnPresencial.setOnClickListener(v -> {
            if(btnPresencial.isSelected() && btnPresencial.getBackgroundTintList().equals(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.VerdeDosBotões)))){
                btnPresencial.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
                btnPresencial.setTextColor(ContextCompat.getColor(this, R.color.TextoIcones));
                btnPresencial.setSelected(false);
            }else{
                btnPresencial.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.VerdeDosBotões)));
                btnPresencial.setTextColor(Color.WHITE);
                btnPresencial.setSelected(true);
            }
        });

        //Botão Online
        btnOnline.setOnClickListener(v -> {
            if(btnOnline.isSelected() && btnOnline.getBackgroundTintList().equals(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.VerdeDosBotões)))){
                btnOnline.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
                btnOnline.setTextColor(ContextCompat.getColor(this, R.color.TextoIcones));
                btnOnline.setSelected(false);
            }else{
                btnOnline.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.VerdeDosBotões)));
                btnOnline.setTextColor(Color.WHITE);
                btnOnline.setSelected(true);
            }
        });

        //Botão Hibrido
        btnHibrido.setOnClickListener(v -> {
            if(btnHibrido.isSelected() && btnHibrido.getBackgroundTintList().equals(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.VerdeDosBotões)))){
                btnHibrido.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
                btnHibrido.setTextColor(ContextCompat.getColor(this, R.color.TextoIcones));
                btnHibrido.setSelected(false);
            }else{
                btnHibrido.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.VerdeDosBotões)));
                btnHibrido.setTextColor(Color.WHITE);
                btnHibrido.setSelected(true);
            }
        });

        //Botão Ativo
        btnAtivo.setOnClickListener(v -> {
            if(btnAtivo.isSelected() && btnAtivo.getBackgroundTintList().equals(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.VerdeDosBotões)))){
                btnAtivo.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
                btnAtivo.setTextColor(ContextCompat.getColor(this, R.color.TextoIcones));
                btnAtivo.setSelected(false);
            }else{
                btnAtivo.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.VerdeDosBotões)));
                btnAtivo.setTextColor(Color.WHITE);
                btnAtivo.setSelected(true);
            }
        });
    }
}