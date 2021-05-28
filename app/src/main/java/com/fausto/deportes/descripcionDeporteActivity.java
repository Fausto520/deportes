package com.fausto.deportes;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class descripcionDeporteActivity extends AppCompatActivity {
private TextView textDescripcion;
private TextView textViewTituloDeporte;
private ImageView imgDeporte;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_deporte);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());

        textDescripcion=findViewById(R.id.textDescripcion);
        imgDeporte = findViewById(R.id.imageDeporte);
        textViewTituloDeporte = findViewById(R.id.textViewTituloDeporte);

        Intent intent = getIntent();
        Deporte deporte = (Deporte) intent.getSerializableExtra("Item");

        textDescripcion.setText(deporte.getInfo());
        textViewTituloDeporte.setText(deporte.getNombre());
        imgDeporte.setImageResource(deporte.getImagen());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();


            }
        });
    }

    public void returnBoton(View view) {
        finish();
    }
}