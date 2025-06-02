package com.ifsc.contaclicks;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    Button buttonInsere;
    EditText editText;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = openOrCreateDatabase("banco", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS notas (id INTEGER PRIMARY KEY AUTOINCREMENT, txt VARCHAR)");

        buttonInsere = findViewById(R.id.Button);
        editText = findViewById(R.id.editTextText);
        listView = findViewById(R.id.listView);

        buttonInsere.setOnClickListener(v -> {
            String msg = editText.getText().toString();
            insereNota(msg);
            listagemNotas();
        });

        listagemNotas();
    }

    public void listagemNotas() {
        Cursor cursor = db.rawQuery("SELECT * FROM notas", null);
        cursor.moveToFirst();
        ArrayList<String> listaNotas = new ArrayList<>();

        while (!cursor.isAfterLast()) {
            int coluna = cursor.getColumnIndexOrThrow("txt");
            listaNotas.add(cursor.getString(coluna));
            cursor.moveToNext();
        }

        cursor.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaNotas);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Cursor c = db.rawQuery("SELECT * FROM notas", null);
            if (c.moveToPosition(position)) {
                int idxId = c.getColumnIndexOrThrow("id");
                int idxTxt = c.getColumnIndexOrThrow("txt");

                int notaId = c.getInt(idxId);
                String textoNota = c.getString(idxTxt);

                Intent intent = new Intent(MainActivity.this, ExibeNotas.class);
                intent.putExtra("id", notaId);
                intent.putExtra("texto", textoNota);
                startActivity(intent);
            }
            c.close();
        });

        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            Cursor c = db.rawQuery("SELECT * FROM notas", null);
            if (c.moveToPosition(position)) {
                int idxId = c.getColumnIndexOrThrow("id");
                int notaId = c.getInt(idxId);

                db.delete("notas", "id = ?", new String[]{String.valueOf(notaId)});
                listagemNotas();
            }
            c.close();
            return true;
        });
    }

    public void insereNota(String txt) {
        ContentValues cv = new ContentValues();
        cv.put("txt", txt);
        db.insert("notas", null, cv);
    }

    @Override
    protected void onResume() {
        super.onResume();
        listagemNotas();
    }
}
