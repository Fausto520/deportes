package com.fausto.deportes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DeportesAdapter extends RecyclerView.Adapter<DeportesAdapter.DeportesHolder> {

    private Context context;
    private ArrayList<Deporte> deportes;
    private LayoutInflater inflater;


    public DeportesAdapter (ArrayList<Deporte> deportes,Context context){
    this.deportes = deportes;
    this.context = context;
    this.inflater = LayoutInflater.from(this.context);


}


    @Override
    public DeportesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = inflater.inflate(R.layout.deportes_item,parent,false);
        return new DeportesHolder(item);

    }

    @Override
    public void onBindViewHolder(DeportesAdapter.DeportesHolder holder, int position) {


        Deporte deporte = deportes.get(position);

        holder.txtTituloDeporte.setText(deporte.getNombre());

        Glide.with(context).load(deporte.getImagen()).into(holder.imageViewDeporte);
        //holder.imageViewDeporte.setImageResource(deporte.getImagen());


    }

    @Override
    public int getItemCount() {
        return deportes.size();
    }

    class DeportesHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView txtTituloDeporte;
        ImageView imageViewDeporte;

        public DeportesHolder(View itemView) {
            super(itemView);


            txtTituloDeporte = itemView.findViewById(R.id.txtTituloDeporte);
            imageViewDeporte = itemView.findViewById(R.id.imageViewDeporte);
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {

            int posicion = getLayoutPosition();


       Intent intent = new Intent(context, descripcionDeporteActivity.class);
       intent.putExtra("Item",(deportes.get(posicion)));
       context.startActivity(intent);

        }
    }

}
