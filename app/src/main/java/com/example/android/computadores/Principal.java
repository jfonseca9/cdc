package com.example.android.computadores;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
/**
 * Created by Android on 28/05/2018.
 */

    public class Principal extends AppCompatActivity implements AdaptadorComputadores.OnComputadorClickListener {
        private RecyclerView lstOpciones;
        private Intent i;
        private ArrayList<Computador> computador;
        private AdaptadorComputadores adapter;
        private LinearLayoutManager llm;
        private DatabaseReference databaseReference;
        private String bd = "Computador";


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_principal);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            lstOpciones = findViewById(R.id.lstOpciones);
            computador = new ArrayList<>();

            llm = new LinearLayoutManager(this);
            llm.setOrientation(LinearLayoutManager.VERTICAL);
            adapter = new AdaptadorComputadores(computador,this);

            lstOpciones.setLayoutManager(llm);
            lstOpciones.setAdapter(adapter);

            databaseReference = FirebaseDatabase.getInstance().getReference();
            databaseReference.child(bd).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    computador.clear();
                    if(dataSnapshot.exists()){
                        for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                            Computador p = snapshot.getValue(Persona.class);
                            computador.add(p);
                        }
                    }
                    adapter.notifyDataSetChanged();
                    Datos.setPersonas(computador);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        }

        public void crearComputador(View v){
            i = new Intent(Principal.this,CrearComputador.class);
            startActivity(i);


        }


        @Override
        public void onPersonaClick(Computador p) {
            Intent i = new Intent(Principal.this,DetallePersona.class);
            Bundle b = new Bundle();

            b.putString("tipo",p.getTipo());
            b.putString("marca",p.getMarca());
            b.putString("color",p.getColor());
            b.putInt("ram",p.getRam());
            b.putInt("foto",p.getFoto());
            b.putString("Sistema Operativo",p.getSoperativo());

            i.putExtra("datos",b);
            startActivity(i);

        }
}
