package com.miguelsolano.appavaliaai;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.miguelsolano.appavaliaai.api.IbgeService;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.miguelsolano.appavaliaai.api.RetrofitClient;
import com.miguelsolano.appavaliaai.model.Cidade;
import com.miguelsolano.appavaliaai.model.Estado;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CriarEventosActivity extends AppCompatActivity {
    private List<Estado> listaEstados;
    AutoCompleteTextView actTipoEvento;
    AutoCompleteTextView actModalidade;
    ConstraintLayout layoutEndereco;
    ConstraintLayout layoutOnline;
    TextInputLayout tilMaximoPart;
    TextInputLayout tilLinkEvento;
    TextInputLayout tilPais;
    TextInputLayout tilEndereco;
    TextInputLayout tilCidade;
    TextInputLayout tilEstado;
    TextInputLayout tilMinimoPart;
    TextInputLayout tilHoraFinal;
    TextInputLayout tilHoraInicial;
    TextInputLayout tilNomeEvento;
    TextInputLayout tilDataEvento;
    TextInputLayout tilModalidade;
    TextInputLayout tilTipoEvento;
    TextInputEditText edtMinPart;
    TextInputEditText edtEndereco;
    AutoCompleteTextView actCidade;
    TextInputEditText edtLinkEvento;
    AutoCompleteTextView actEstado;
    AutoCompleteTextView actPais;
    TextInputEditText edtMaxPart;
    TextInputEditText edtHoraInicial;
    TextInputEditText edtHoraFinal;
    TextInputEditText edtNomeEvento;
    TextInputEditText edtDataEvento;
    RadioGroup radioGroupVisibilidade;
    TextView txtErroVisibilidade;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_criar_eventos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.CriarEventos), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Definição dos componentes da tela
        actTipoEvento = findViewById(R.id.actTipoEvento);
        actModalidade = findViewById(R.id.actModalidade);
        tilModalidade = findViewById(R.id.tilModalidade);
        tilTipoEvento = findViewById(R.id.tilTipoEvento);
        layoutEndereco = findViewById((R.id.layoutEndereco));
        tilEndereco = findViewById(R.id.tilEndereco);
        tilCidade = findViewById(R.id.tilCidade);
        tilEstado = findViewById(R.id.tilEstado);
        tilPais = findViewById(R.id.tilPais);
        edtEndereco = findViewById(R.id.etEndereco);
        actCidade = findViewById(R.id.actCidade);
        actEstado = findViewById(R.id.actEstado);
        actPais = findViewById(R.id.actPais);
        layoutOnline = findViewById(R.id.layoutOnline);
        Button btnConfirmar = findViewById(R.id.btnConfirmar);
        Button btnCancelar = findViewById(R.id.btnCancelar);
        tilMaximoPart = findViewById(R.id.tilMaximo);
        tilMinimoPart = findViewById(R.id.tilMinimo);
        edtMaxPart = findViewById(R.id.edtMaximo);
        edtMinPart = findViewById(R.id.edtMinimo);
        edtHoraInicial = findViewById(R.id.etHorarioInicial);
        edtHoraFinal = findViewById(R.id.etHorarioFinal);
        tilHoraFinal = findViewById(R.id.tilHorarioFinal);
        tilHoraInicial = findViewById(R.id.tilHorarioInicial);
        tilNomeEvento = findViewById(R.id.tilNomeEvento);
        edtNomeEvento = findViewById((R.id.etNomeEvento));
        tilDataEvento = findViewById(R.id.tilDataEvento);
        edtDataEvento = findViewById(R.id.etDataEvento);
        tilLinkEvento = findViewById(R.id.tilLinkEvento);
        edtLinkEvento = findViewById(R.id.etLinkEvento);
        txtErroVisibilidade = findViewById(R.id.txtErroVisibilidade);
        radioGroupVisibilidade = findViewById(R.id.radioGroupVisibilidade);
        actPais.setEnabled(false);
        actPais.setText("Brasil");

        //Abrir os Estados e Cidades no Presencial
        actEstado.setThreshold(1);
        actCidade.setThreshold(1);
        actCidade.setEnabled(false);
        carregarEstados();
        actEstado.setOnClickListener(v -> actEstado.showDropDown());
        actEstado.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                actEstado.showDropDown();
            }
        });
        actCidade.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                actCidade.showDropDown();
            }
        });
        actCidade.setOnClickListener((v) -> {
            actCidade.showDropDown();
        });
        //Botão de Voltar
        ImageButton btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(v -> {
            finish();
        });

        //Escolhes de tipo de evento
        String[] tiposEvento = {
                "Palestra",
                "Workshop",
                "Congresso",
                "Meetup",
                "Seminário",
                "Esportivo",
                "Automotivo",
                "Culinário",
                "Tecnologia",
                "Lazer"
        };
        ArrayAdapter<String> adaptadoTipoEvento = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                tiposEvento
        );
        actTipoEvento.setAdapter(adaptadoTipoEvento);


        //Escolhes de Modalidade
        String[] modalidades = {"Presencial", "Online", "Híbrido"};
        ArrayAdapter<String> adaptadoModalidade = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                modalidades
        );
        actModalidade.setAdapter(adaptadoModalidade);
        if(actModalidade.getText().toString().trim().isEmpty()){
            layoutEndereco.setVisibility(View.GONE);
            layoutOnline.setVisibility(View.GONE);
        }
        actModalidade.setOnItemClickListener((parent, view, position, id) -> {
            String selecionado = parent.getItemAtPosition(position).toString();
            tilModalidade.setError(null);
            if (selecionado.equals("Presencial")) {
                layoutEndereco.setVisibility(View.VISIBLE);
                layoutOnline.setVisibility(View.GONE);
            } else if (selecionado.equals("Online")) {
                layoutEndereco.setVisibility(View.GONE);
                layoutOnline.setVisibility(View.VISIBLE);
            } else if (selecionado.equals("Híbrido")) {
                layoutEndereco.setVisibility(View.VISIBLE);
                layoutOnline.setVisibility(View.VISIBLE);
            }
        });


        //Botão Final - Confirmar
        btnConfirmar.setOnClickListener(v -> {
            if (verificaTodos()) {
                AlertDialog dialog = new AlertDialog.Builder(this)
                        .setTitle("Erro")
                        .setMessage("Há algum campo preenchido incorretamente!!!")
                        .setPositiveButton("OK", null)
                        .create();
                dialog.show();
            } else {
                Toast.makeText(this, "Evento criado com sucesso!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        //Botão FInal - Cancelar
        btnCancelar.setOnClickListener(v -> {
            finish();
        });

        //Campo de texto da data do evento -------------
        TextInputEditText edtDataEvento = findViewById(R.id.etDataEvento);
        edtDataEvento.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int ano = calendar.get(Calendar.YEAR);
            int mes = calendar.get(Calendar.MONTH);
            int dia = calendar.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePicker = new DatePickerDialog(this, R.style.CustomDatePickerDialog,
                    (view, year, month, dayOfMonth) -> {
                        String dataSelecionada = String.format("%02d/%02d/%d", dayOfMonth, (month + 1), year);
                        edtDataEvento.setText(dataSelecionada);
                    },
                    ano, mes, dia
            );
            datePicker.show();
        });

        //Seletor de hora - Horario Inicial -------------
        TextInputEditText etHoraInicial = findViewById(R.id.etHorarioInicial);
        etHoraInicial.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int hora = calendar.get(Calendar.HOUR_OF_DAY);
            int minuto = calendar.get(Calendar.MINUTE);
            TimePickerDialog timePicker = new TimePickerDialog(this, R.style.CustomDatePickerDialog,
                    (view, hourOfDay, minute) -> {
                        String horaFormatada = String.format("%02d:%02d", hourOfDay, minute);
                        etHoraInicial.setText(horaFormatada);
                    }, hora, minuto,
                    true // true = formato 24h | false = 12h
            );
            validarHorario();
            timePicker.show();
        });

        //Seletor de hora - Horario Final -------------
        TextInputEditText etHoraFinal = findViewById(R.id.etHorarioFinal);
        etHoraFinal.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int hora = calendar.get(Calendar.HOUR_OF_DAY);
            int minuto = calendar.get(Calendar.MINUTE);
            TimePickerDialog timePicker = new TimePickerDialog(this, R.style.CustomDatePickerDialog,
                    (view, hourOfDay, minute) -> {
                        String horaFormatada = String.format("%02d:%02d", hourOfDay, minute);
                        etHoraFinal.setText(horaFormatada);
                        tilHoraFinal = findViewById(R.id.tilHorarioFinal);
                        validarHorario();
                    }, hora, minuto,
                    true // true = formato 24h | false = 12h
            );
            validarHorario();
            timePicker.show();
        });

        //Remove erros -
        actTipoEvento.setOnItemClickListener((parent, view, position, id) -> {tilTipoEvento.setError(null);});
        actCidade.setOnItemClickListener((p,v,pos,id) -> tilCidade.setError(null));
        actEstado.setOnItemClickListener((p,v,pos,id) -> tilEstado.setError(null));
        actPais.setOnItemClickListener((p,v,pos,id) -> tilPais.setError(null));
        limparErroAoDigitar(edtNomeEvento, tilNomeEvento);
        limparErroAoDigitar(edtDataEvento, tilDataEvento);
        limparErroAoDigitar(edtEndereco, tilEndereco);
        limparErroAoDigitar(edtLinkEvento, tilLinkEvento);
        limparErroAoDigitar(edtHoraInicial, tilHoraInicial);
        limparErroAutoComplete(actCidade, tilCidade);
        limparErroAutoComplete(actEstado, tilEstado);
        limparErroAutoComplete(actPais, tilPais);
        // Erros removidos até aqui -
        edtMaxPart.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validarParticipantes();}
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        radioGroupVisibilidade.setOnCheckedChangeListener((group, checkedId) -> {
            txtErroVisibilidade.setVisibility(View.GONE);
        });
    }
    private void limparErroAutoComplete(AutoCompleteTextView campo, TextInputLayout layout) {
        campo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    layout.setError(null);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private boolean validarParticipantes() {
        String minP = edtMinPart.getText().toString().trim();
        String maxP = edtMaxPart.getText().toString().trim();

        if (!minP.isEmpty() && !maxP.isEmpty()) {
            int Pmin = Integer.parseInt(minP);
            int Pmax = Integer.parseInt(maxP);
            if (Pmin > Pmax) {
                tilMaximoPart.setError("O máximo deve ser maior que o mínimo.");
                return true;
            } else {
                tilMaximoPart.setError(null);
                return false;
            }
        }
        return false;
    }

    private int converterHoraParaMinutos(String hora) {
        String[] partes = hora.split(":");
        int h = Integer.parseInt(partes[0]);
        int m = Integer.parseInt(partes[1]);
        return h * 60 + m;
    }

    private boolean validarHorario() {
        String horaInicialStr = edtHoraInicial.getText().toString().trim();
        String horaFinalStr = edtHoraFinal.getText().toString().trim();
        if (!horaInicialStr.isEmpty() && !horaFinalStr.isEmpty()) {
            int horaInicial = converterHoraParaMinutos(horaInicialStr);
            int horaFinal = converterHoraParaMinutos(horaFinalStr);
            if (horaFinal <= horaInicial) {
                tilHoraFinal.setError("O horário final deve ser maior que o inicial");
                return true;
            } else {
                tilHoraFinal.setError(null);
                return false;
            }
        } else if (horaInicialStr.isEmpty()) {
            tilHoraInicial.setError("O horário Inicial não pode ser vazio!");
            return true;
        }else {
            return false;
        }
    }

    private boolean verificaDropDowns() {
        if(actModalidade.getText().toString().trim().isEmpty() && actTipoEvento.getText().toString().trim().isEmpty()){
            tilModalidade.setError("A Modalidade não pode ser vazia!");
            tilTipoEvento.setError("O Tipo de Evento não pode ser vazio!");
            return true;
        } else if (actModalidade.getText().toString().trim().isEmpty()) {
            tilModalidade.setError("A Modalidade não pode ser vazia!");
            return true;
        } else if (actTipoEvento.getText().toString().trim().isEmpty()) {
            tilTipoEvento.setError("O Tipo de Evento não pode ser vazio!");
            return true;
        } else if (actModalidade.getText().toString().trim().equals("Presencial")) {
            tilModalidade.setError(null);
            tilTipoEvento.setError(null);
            if (edtEndereco.getText().toString().trim().isEmpty() && actCidade.getText().toString().trim().isEmpty() &&
                    actEstado.getText().toString().trim().isEmpty() && actPais.getText().toString().trim().isEmpty()) {
                tilEndereco.setError("O Endereço não pode ser vazio!");
                tilCidade.setError("O Cidade não pode ser vazia!");
                tilEstado.setError("O Estado não pode ser vazio!");
                tilPais.setError("O País não pode ser vazio!");
                return true;
            } else if (edtEndereco.getText().toString().trim().isEmpty()) {
                tilEndereco.setError("O Endereço não pode ser vazio!");
                return true;
            } else if (actCidade.getText().toString().trim().isEmpty()) {
                tilCidade.setError("O Cidade não pode ser vazia!");
                return true;
            } else if (actEstado.getText().toString().trim().isEmpty()) {
                tilEstado.setError("O Estado não pode ser vazio!");
                return true;
            } else if (actPais.getText().toString().trim().isEmpty()) {
                tilPais.setError("O País não pode ser vazio!");
                return true;
            }else{
                return false;
            }
        } else if (actModalidade.getText().toString().trim().equals("Online")) {
            if(edtLinkEvento.getText().toString().trim().isEmpty()){
                tilLinkEvento.setError("Links e/ou Plataformas não pode estar vazio");
                return true;
            }else{
                return false;
            }
        } else {
            if (edtEndereco.getText().toString().trim().isEmpty() && actCidade.getText().toString().trim().isEmpty() &&
                    actEstado.getText().toString().trim().isEmpty() && actPais.getText().toString().trim().isEmpty() &&
                    edtLinkEvento.getText().toString().trim().isEmpty()) {
                tilEndereco.setError("O Endereço não pode ser vazio!");
                tilCidade.setError("O Cidade não pode ser vazia!");
                tilEstado.setError("O Estado não pode ser vazio!");
                tilPais.setError("O País não pode ser vazio!");
                tilLinkEvento.setError("Links e/ou Plataformas não pode estar vazio");
                return true;
            } else if (edtEndereco.getText().toString().trim().isEmpty()) {
                tilEndereco.setError("O Endereço não pode ser vazio!");
                return true;
            } else if (actCidade.getText().toString().trim().isEmpty()) {
                tilCidade.setError("O Cidade não pode ser vazia!");
                return true;
            } else if (actEstado.getText().toString().trim().isEmpty()) {
                tilEstado.setError("O Estado não pode ser vazio!");
                return true;
            } else if (actPais.getText().toString().trim().isEmpty()) {
                tilPais.setError("O País não pode ser vazio!");
                return true;
            } else if(edtLinkEvento.getText().toString().trim().isEmpty()){
                tilLinkEvento.setError("Links e/ou Plataformas não pode estar vazio");
                return true;
            }else{
                tilModalidade.setError(null);
                tilTipoEvento.setError(null);
                tilEndereco.setError(null);
                tilCidade.setError(null);
                tilEstado.setError(null);
                tilPais.setError(null);
                tilLinkEvento.setError(null);
                return false;
            }
        }
    }
    private boolean validarVisibilidade() {
        if (radioGroupVisibilidade.getCheckedRadioButtonId() == -1) {
            txtErroVisibilidade.setVisibility(View.VISIBLE);
            return true;
        } else {
            txtErroVisibilidade.setVisibility(View.GONE);
            return false;
        }
    }
    private boolean verificaTodos() {
        boolean vH = validarHorario();
        boolean vP = validarParticipantes();
        boolean vD = verificaDropDowns();
        boolean vV = validarVisibilidade();
        if(edtNomeEvento.getText().toString().trim().isEmpty() && edtDataEvento.getText().toString().trim().isEmpty()){
            tilNomeEvento.setError("O Nome não pode ser vazio!");
            tilDataEvento.setError("A data não pode ser vazia!");
            return true;
        }else if (edtNomeEvento.getText().toString().trim().isEmpty()) {
            tilDataEvento.setError(null);
            tilNomeEvento.setError("O Nome não pode ser vazio!");
            return true;
        } else if (edtDataEvento.getText().toString().trim().isEmpty()) {
            tilNomeEvento.setError(null);
            tilDataEvento.setError("A data não pode ser vazia!");
            return true;
        } else if (vH || vP || vD || vV) {
            tilNomeEvento.setError(null);
            tilDataEvento.setError(null);
            return true;
        } else {
            tilNomeEvento.setError(null);
            tilDataEvento.setError(null);
            return false;
        }
    }
    private void limparErroAoDigitar(TextInputEditText editText, TextInputLayout layout) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    layout.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }
    private void carregarEstados() {
        IbgeService service = RetrofitClient
                .getInstance()
                .create(IbgeService.class);

        Call<List<Estado>> call = service.listarEstados();

        call.enqueue(new Callback<List<Estado>>() {
            @Override
            public void onResponse(Call<List<Estado>> call,
                                   Response<List<Estado>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    listaEstados = response.body();
                    List<String> nomesEstados = new ArrayList<>();
                    for (Estado e : listaEstados) {
                        nomesEstados.add(e.getNome());
                    }
                    ArrayAdapter<String> adapter =
                            new ArrayAdapter<>(
                                    CriarEventosActivity.this,
                                    android.R.layout.simple_list_item_1,
                                    nomesEstados
                            );

                    actEstado.setAdapter(adapter);
                    actEstado.setOnItemClickListener((parent, view, position, id) -> {

                        Estado estadoSelecionado = listaEstados.get(position);

                        carregarCidades(estadoSelecionado.getId());
                        actCidade.setEnabled(true);

                    });
                }
            }
            @Override
            public void onFailure(Call<List<Estado>> call, Throwable t) {
                Log.e("API_ERRO", t.getMessage());
                Toast.makeText(
                        CriarEventosActivity.this,
                        "Erro ao carregar estados",
                        Toast.LENGTH_LONG
                ).show();
            }
        });
    }
    private void carregarCidades(int estadoId) {

        IbgeService service = RetrofitClient
                .getInstance()
                .create(IbgeService.class);

        Call<List<Cidade>> call = service.listarCidades(estadoId);
        call.enqueue(new Callback<List<Cidade>>() {

            @Override
            public void onResponse(Call<List<Cidade>> call,
                                   Response<List<Cidade>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Cidade> cidades = response.body();
                    List<String> nomesCidades = new ArrayList<>();

                    for (Cidade c : cidades) {
                        nomesCidades.add(c.getNome());
                    }
                    ArrayAdapter<String> adapter =
                            new ArrayAdapter<>(
                                    CriarEventosActivity.this,
                                    android.R.layout.simple_list_item_1,
                                    nomesCidades
                            );
                    actCidade.setAdapter(adapter);
                    actCidade.setText(""); // limpa campo anterior
                }
            }
            @Override
            public void onFailure(Call<List<Cidade>> call, Throwable t) {

                Toast.makeText(
                        CriarEventosActivity.this,
                        "Erro ao carregar cidades",
                        Toast.LENGTH_LONG
                ).show();
            }
        });
    }

}
