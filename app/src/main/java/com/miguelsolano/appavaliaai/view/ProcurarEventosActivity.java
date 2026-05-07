package com.miguelsolano.appavaliaai.view;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.miguelsolano.appavaliaai.R;

public class ProcurarEventosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_procurar_eventos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.ProcurarEventos), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Botão de Voltar
        ImageButton btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(v -> {
            finish();
        });

        Button btnHoje = findViewById(R.id.btnHoje);
        Button btnSemana = findViewById(R.id.btnSemana);
        Button btnPesencial = findViewById(R.id.btnPresencial);
        Button btnOnline = findViewById(R.id.btnOnline);

        //Botão Hoje
        btnHoje.setOnClickListener(v -> {
            btnHoje.setSelected(!btnHoje.isSelected());
            if(btnHoje.isSelected()){
                btnHoje.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
                btnHoje.setTextColor(ContextCompat.getColor(this, R.color.TextoIcones));
            }else{
                btnHoje.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.VerdeDosBotões)));
                btnHoje.setTextColor(Color.WHITE);
            }
        });

        //Botão Semana
        btnSemana.setOnClickListener(v -> {
            btnSemana.setSelected(!btnSemana.isSelected());
            if(btnSemana.isSelected()){
                btnSemana.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
                btnSemana.setTextColor(ContextCompat.getColor(this, R.color.TextoIcones));
            }else{
                btnSemana.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.VerdeDosBotões)));
                btnSemana.setTextColor(Color.WHITE);
            }
        });

        //Botão Presencial
        btnPesencial.setOnClickListener(v -> {
            btnPesencial.setSelected(!btnPesencial.isSelected());
            if(btnPesencial.isSelected()){
                btnPesencial.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
                btnPesencial.setTextColor(ContextCompat.getColor(this, R.color.TextoIcones));
            }else{
                btnPesencial.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.VerdeDosBotões)));
                btnPesencial.setTextColor(Color.WHITE);
            }
        });

        //Botão Online
        btnOnline.setOnClickListener(v -> {
            btnOnline.setSelected(!btnOnline.isSelected());
            if(btnOnline.isSelected()){
                btnOnline.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
                btnOnline.setTextColor(ContextCompat.getColor(this, R.color.TextoIcones));
            }else{
                btnOnline.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.VerdeDosBotões)));
                btnOnline.setTextColor(Color.WHITE);
            }
        });
    }
}