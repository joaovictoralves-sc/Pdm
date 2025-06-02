package com.ifsc.contaclicks;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ExibeNotas extends AppCompatActivity {

    EditText editText;
    Button buttonSalvar, buttonCancelar, buttonExcluir;
    SQLiteDatabase db;
    int notaId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibe_notas);

        editText = findViewById(R.id.editTextNota);
        buttonSalvar = findViewById(R.id.button5);
        buttonCancelar = findViewById(R.id.button4);
        buttonExcluir = findViewById(R.id.button6);

        db = openOrCreateDatabase("banco", MODE_PRIVATE, null);

        Intent intent = getIntent();
        notaId = intent.getIntExtra("id", -1);
        String texto = intent.getStringExtra("texto");
        editText.setText(texto);

        buttonSalvar.setOnClickListener(v -> {
            String novoTexto = editText.getText().toString();
            ContentValues cv = new ContentValues();
            cv.put("txt", novoTexto);
            db.update("notas", cv, "id = ?", new String[]{String.valueOf(notaId)});
            finish();
        });

        buttonExcluir.setOnClickListener(v -> {
            db.delete("notas", "id = ?", new String[]{String.valueOf(notaId)});
            finish();
        });

        buttonCancelar.setOnClickListener(v -> finish());
    }
}
