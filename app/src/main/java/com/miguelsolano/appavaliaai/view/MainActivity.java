package com.miguelsolano.appavaliaai.view;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.card.MaterialCardView;
import com.miguelsolano.appavaliaai.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.CriarEventos), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        MaterialCardView btnCriar = findViewById(R.id.btnCriarEventos);
        MaterialCardView btnMeus = findViewById(R.id.btnMeusEventos);
        MaterialCardView btnProcurar = findViewById(R.id.btnProcurarEventos);

        btnCriar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CriarEventosActivity.class);
            startActivity(intent);
        });
        btnMeus.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MeusEventosActivity.class);
            startActivity(intent);
        });
        btnProcurar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ProcurarEventosActivity.class);
            startActivity(intent);
        });
    }




}