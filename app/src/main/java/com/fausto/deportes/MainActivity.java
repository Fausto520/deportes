package com.fausto.deportes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Deporte>deportes;
    private RecyclerView recycler;
    private DeportesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.floatingActionButtonReset);
        deportes = new ArrayList<Deporte>();



          inicializarDatos();

        recycler = findViewById(R.id.recyclerView);
        adapter = new DeportesAdapter(deportes,this);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        int grindColumCount = getResources().getInteger(R.integer.grind_colum_count);

        recycler.setLayoutManager(new GridLayoutManager(this, grindColumCount));


        int swipeDirs;
        if(grindColumCount>1){
        swipeDirs=0;
        }else {

            swipeDirs = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        }

        ItemTouchHelper help = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback( ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.DOWN | ItemTouchHelper.UP, swipeDirs ) {

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
               int from = viewHolder.getAdapterPosition();
               int  to =  target.getAdapterPosition();
                Collections.swap(deportes,from, to );
                adapter.notifyItemMoved(from,to);
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
              deportes.remove(viewHolder.getAdapterPosition());
              adapter.notifyItemRemoved(viewHolder.getAdapterPosition());

            }
        });

       help.attachToRecyclerView(recycler);
    }

    public void inicializarDatos(){


        deportes.add(new Deporte("Badminton ","El bádminton es un deporte de raqueta ",(R.drawable.img_badminton)));
        deportes.add(new Deporte("Baseball","Es un deporte de equipo jugado entre dos equipos de nueve jugadores cada uno",(R.drawable.img_baseball)));
        deportes.add(new Deporte("Basketball", "Es un deporte con 5 jugadores en cada equipo con el objetivo de encesatar una pelota en el aro",(R.drawable.img_basketball)));
        deportes.add(new Deporte("Bowling","Es un deporte de salón que consiste en derribar un conjunto de piezas de madera llamados bolos",(R.drawable.img_bowling)));
        deportes.add(new Deporte("Cycling","Es un deporte en la que se utilizan distintos tipos de bicicletas",(R.drawable.img_cycling)));
        deportes.add(new Deporte("Golf","Es un deporte cuyo objetivo es introducir una bola en los hoyos que están distribuidos en el campo con el menor número de golpes",(R.drawable.img_golf)));
        deportes.add(new Deporte("Running","Se refiere a la carrera continua, es el acto por el que alternativamente los pies tocan el suelo a una velocidad mayor que al andar",(R.drawable.img_running)));
        deportes.add(new Deporte("Futbol","Es un deporte de equipo jugado entre dos conjuntos de once jugadores cada uno y algunos árbitros que se ocupan de que las normas se cumplan correctamente",(R.drawable.img_soccer)));
        deportes.add(new Deporte("Natación", "Es un deporte que consiste en el desplazamiento de una persona en el agua, sin que esta toque el suelo",(R.drawable.img_swimming)));
        deportes.add(new Deporte("Tenis de mesa","Es un deporte de raqueta que se disputa entre dos jugadores o dos parejas",(R.drawable.img_tabletennis)));
        deportes.add(new Deporte("Tenis", "es un deporte de raqueta practicado sobre una pista rectangular, delimitada por líneas y dividida por una red.",(R.drawable.img_tennis)));



    }


    public void reset(View view) {
        deportes.clear();
       inicializarDatos();
       adapter.notifyDataSetChanged();

    }
}