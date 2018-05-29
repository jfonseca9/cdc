package com.example.android.computadores;

import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorComputadores extends AppCompatActivity {

    private ArrayList<Computador> computador;
        private OnComputadorClickListener clickListener;

        public AdaptadorPersona(ArrayList<Computador> computador, OnComputadorClickListener clickListener){
            this.computador=computador;
            this.clickListener = clickListener;
        }

        @Override
        public PersonaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.item_computador,parent,false);
            return new PersonaViewHolder(v);
        }

        @Override
        public void onBindViewHolder(PersonaViewHolder holder, int position) {
            final Computador p = computador.get(position);
            holder.foto.setImageResource(p.getFoto());
            holder.Tipo.setText(p.getTipo());
            holder.Marca.setText(p.getMarca());
            holder.Color.setText(p.getColor());
            holder.Soperativo.setText(p.getSoperativo());

            holder.v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.onPersonaClick(p);
                }
            });
        }

        @Override
        public int getItemCount() {
            return computador.size();
        }

        public static class PersonaViewHolder extends RecyclerView.ViewHolder{
            private ImageView foto;
            private TextView tipo;
            private TextView marca;
            private TextView color;
            private TextView Soperativo;
            private View v;

            public PersonaViewHolder(View itemView){
                super(itemView);
                v = itemView;
                foto = v.findViewById(R.id.imgFoto);
                marca = v.findViewById(R.id.lblMarca);
                color = v.findViewById(R.id.lblColor);
                Soperativo = v.findViewById(R.id.Soperativo);
            }

        }

        public interface OnComputadorClickListener {
            void onPersonaClick(Computador p);
        }
}
